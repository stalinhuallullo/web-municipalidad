var api = "https://www.munisantanita.gob.pe/api/preregistro/taller.php?";

var elementTipoStep = "lista";
var categorioTaller = "";
$(function() {
    $("#wizard").steps({
        headerTag: "h4",
        bodyTag: "section",
        transitionEffect: "fade",
        enableAllSteps: true,
        transitionEffectSpeed: 500,
        start: function() { return methods.setStep(0); },
        onStepChanging: function(event, currentIndex, newIndex) {
            var retrn = false;

            if (newIndex === 0) return true;
            if (newIndex === 1) retrn = validarStep1();
            if (newIndex === 2) retrn = (validarStep2().length > 0) ? false : true;
            if (newIndex === 3) {
                var validate = validarStep3().length;
                if (validate <= 0) mostrarInformacion();
                retrn = (validate > 0) ? false : true;
            }

            if (retrn) $('.steps ul').removeClass().addClass('step-' + (newIndex + 1));

            return retrn;
        },
        onFinishing: function(event, currentIndex) {
            console.log("Finalizado");
            guardarCupo();
        },
        onFinished: function(event, currentIndex) {
            console.log("Submitted!");
        },
        labels: {
            finish: "Guardar",
            next: "Siguiente",
            previous: "Anterior"
        }
    });

    // Custom Steps Jquery Steps
    $('.wizard > .steps li a').click(function() {
        $(this).parent().addClass('checked');
        $(this).parent().prevAll().addClass('checked');
        $(this).parent().nextAll().removeClass('checked');
    });

    // Custom Button Jquery Steps
    $('.forward').click(function() {
        $("#wizard").steps('next');
    })
    $('.backward').click(function() {
            $("#wizard").steps('previous');
        })
        // Checkbox
    $('.checkbox-circle label').click(function() {
        $('.checkbox-circle label').removeClass('active');
        $(this).addClass('active');
    })
});


function mostrarInformacion() {

    $(".txt-nom_alumno").text($("#nom_alumno").val());
    $(".txt-ape_alumno").text($("#ape_alumno").val());
    $(".txt-direccion").text($("#direccion").val());
    $(".txt-distrito").text($("#distrito").val());
    $(".txt-dni").text($("#dni").val());
    $(".txt-telefono").text($("#telefono").val());
    $(".txt-correo").text($("#correo").val());
    $(".txt-sexo").text(($("#sexo").val() == "M") ? "Hombre" : "Mujer");
    $(".txt-fec_nac").text($("#fec_nac").val());
    $(".txt-alu_centroestudio").text($("#alu_centroestudio").val());

    $(".txt-alu_segmedico").text($("#alu_segmedico").val());
    $(".txt-alu_enfermedades").text($("#alu_enfermedades").val());
    $(".txt-alu_antibioticos").text($("#alu_antibioticos").val());
    $(".txt-alu_gruposanguineo").text($("#alu_gruposanguineo").val());


    $(".txt-dniapo").text($("#dniapo").val());
    $(".txt-tflapo").text($("#tflapo").val());
    $(".txt-apo_fijo").text($("#apo_fijo").val());
    $(".txt-apoderado").text($("#apoderado").val());
    $(".txt-parentesco").text($("#parentesco").val());
    $(".txt-apo_correo").text($("#apo_correo").val());

}

function guardarCupo() {
    var obj = {};
    $('#form').find('input,select,radio').each(function(a, el) {
        obj[$(el)[0].id] = $(el)[0].value;
    })

    obj.id_seccion = categorioTaller;

    $.ajax({
        type: 'POST',
        url: "https://www.munisantanita.gob.pe/api/preregistro/registrar.php",
        data: JSON.stringify(obj),
        dataType: 'json',
        contentType: 'application/json',
        success: function(respuesta) {
            var parse = respuesta;
            $("#log").html(JSON.stringify(respuesta).toString());
            if (parse.estado == "OK") {
                $('.taller-codigo').text(parse.codigo);
                $("#talleresModal").css('display', 'block');
            } else alert("No se logro registrar, intente nuevamente.");
        },
        error: function() {
            console.log("No se ha podido obtener la información");
        }
    });
}

function validarStep1() {
    var pase = false;
    var msj = "";
    if (elementTipoStep == "codigo") {
        if (categorioTaller != "") {
            pase = true;
        }
        msj = "Precione el boton buscar para validar el taller";
    } else {
        var nombre = $("#select-nombre-taller").val();
        var categoria = $("#select-categoria-taller").val();
        var horario = $('input:radio[name=card-horario]:checked').val();
        if (nombre != "" && categoria != "" && horario != undefined && categorioTaller != "") {
            categorioTaller = horario;
            pase = true;
        }
        msj = (horario != undefined && categorioTaller != "") ? "Ingrese todos los campos" : "Marque el horario preferido";
    }
    if (!pase) alert(msj);
    return pase;
}


function validarStep2() {

    var nom_alumno = $("#nom_alumno").val();
    var ape_alumno = $("#ape_alumno").val();
    var direccion = $("#direccion").val();
    var distrito = $("#distrito").val();
    var dni = $("#dni").val();
    var sexo = $("#sexo").val();
    var fec_nac = $("#fec_nac").val();

    var msj = "";

    switch (true) {
        case nom_alumno.length <= 0:
            msj = "Ingrese nombre del estudiante";
            break;
        case ape_alumno.length <= 0:
            msj = "Ingrese apellido del estudiante";
            break;
        case direccion.length <= 0:
            msj = "Ingrese dirección";
            break;
        case distrito.length <= 0:
            msj = "Ingrese distrito";
            break;
        case dni.length <= 0:
            msj = "Ingrese dni";
            break;
        case dni.length != 8:
            msj = "Dni invalido";
            break;
        case sexo.length <= 0:
            msj = "Seleccione el sexo";
            break;
        case fec_nac.length <= 0:
            msj = "Ingrese fecha de nacimiento";
            break;
        default:
            msj = "";
            break;
    }

    if (msj.length > 0) alert(msj);

    return msj;
}

function validarStep3() {
    var dniapo = $("#dniapo").val();
    var tflapo = $("#tflapo").val();
    var apoderado = $("#apoderado").val();
    var parentesco = $("#parentesco").val();
    var msj = "";

    switch (true) {
        case dniapo.length <= 0:
            msj = "Ingrese dni del apoderado";
            break;
        case dniapo.length != 8:
            msj = "Dni invalido";
            break;
        case tflapo.length <= 0:
            msj = "Ingrese teléfono móvil";
            break;
        case apoderado.length <= 0:
            msj = "Ingrese nombre de apoderado";
            break;
        case parentesco.length <= 0:
            msj = "Ingrese parentesco";
            break;
        default:
            msj = "";
            break;
    }

    if (msj.length > 0) alert(msj);

    return msj;
}

function mostrarDetallesTaller(parse) {
    if (parse.nom_taller != undefined && parse.id_taller != undefined && parse.id_seccion != undefined) {
        var string = '<p><span>Nombre: </span> <strong>' + parse.nom_taller + '</strong></p>' +
            '<p><span>Categoria: </span> <strong>' + parse.nom_categoria + '</strong></p>' +
            '<p><span>Dia: </span> <strong>' + parse.nom_dia + '</strong></p>' +
            '<p><span>Hora: </span> <strong>' + parse.nom_horario + '</strong></p>' +

            '<p><span>Cupos: </span> <strong>' + parse.cupos_disponibles + '</strong></p>' +
            '<p><span>Lugar: </span> <strong>' + parse.lugar + '</strong></p>';

        $(".content-detalles-taller").html(string);
        categorioTaller = parse.id_seccion;
    }
}

$(document).on('change', 'input:radio[name=card-horario]', function() {
    if (this.checked) {
        //console.log("x : " + this.value);
        var codigo = this.value;
        $.ajax({
            type: 'GET',
            url: api + 'mod=seccion&id_seccion=' + codigo,
            success: function(respuesta) {
                var parse = respuesta;
                mostrarDetallesTaller(parse);
            },
            error: function() {
                console.log("No se ha podido obtener la información");
            }
        });

        categorioTaller = codigo;
    }
});
$(document).ready(function() {


    $("#btn-finalizar").click(function() {
        $("#talleresModal").css("display", "none");
        window.location.replace(window.location.href);
    });

    $("#btn-registrar-nuevo").click(function() {

        $("#select-nombre-taller").val("");
        limpiarSelect(1);
        limpiarSelect(1);
        limpiarSelect(3);
        init();
        $("#input-codigo-taller").val("");
        $(".content-detalles-taller").empty();

        // Estudiante
        $("#nom_alumno").val("");
        //$("#ape_alumno").val("");
        //$("#direccion").val("");
        //$("#distrito").val("");
        $("#dni").val("");
        $("#telefono").val("");
        $("#correo").val("");
        $("#sexo").val("");
        $("#fec_nac").val("");
        $("#alu_centroestudio").val("");
        $("#alu_segmedico").val("");
        $("#alu_enfermedades").val("");
        $("#alu_antibioticos").val("");
        //$("#alu_gruposanguineo").val("");

        // Text estudiante
        $("#txt-carnet_alumno").val("");
        $("#txt-nom_alumno").val("");
        $("#txt-ape_alumno").val("");
        $("#txt-direccion").val("");
        $("#txt-distrito").val("");
        $("#txt-dni").val("");
        $("#txt-telefono").val("");
        $("#txt-correo").val("");
        $("#txt-sexo").val("");
        $("#txt-fec_nac").val("");
        $("#txt-alu_centroestudio").val("");
        $("#txt-alu_segmedico").val("");
        $("#txt-alu_enfermedades").val("");
        $("#txt-alu_antibioticos").val("");
        $("#txt-alu_gruposanguineo").val("");

        $("#wizard").steps("reset");
        $("#talleresModal").css("display", "none");
    });


    $('input:radio[name="billing"]').change(function() {
        if (this.checked) {
            if (this.value == "codigo") {
                $("#element-" + this.value).removeClass("d-none").addClass("d-block");
                $("#element-lista").removeClass("d-block").addClass("d-none");
                elementTipoStep = "codigo";
            } else {
                $("#element-" + this.value).removeClass("d-none").addClass("d-block");
                $("#element-codigo").removeClass("d-block").addClass("d-none");
                elementTipoStep = "lista";
            }
        }
    });

    $("#btn-buscar-taller").click(function() {
        var codigo = $("#input-codigo-taller").val();
        $("#siecarga").css("display", "block");
        $(".content-detalles-taller").empty().html("<p>No se encontro resultados</p>");
        $.ajax({
            type: 'GET',
            url: api + 'mod=seccion&id_seccion=' + codigo,
            success: function(respuesta) {
                var parse = respuesta;
                mostrarDetallesTaller(parse);
                $("#siecarga").css("display", "none");
            },
            error: function() {
                console.log("No se ha podido obtener la información");
            }
        });
    });


    // Seleccion
    $("#select-nombre-taller").change(function() {
        limpiarSelect(2);
        $("#siecarga").css("display", "block");
        var nombre = $(this).val();
        var categoria = $("#select-categoria-taller");

        $.ajax({
            type: 'GET',
            url: api + 'mod=categoria&id_taller=' + nombre,
            success: function(respuesta) {
                $(respuesta).each(function(index, value) {
                    categoria.append($("<option>").attr('value', value.id_categoria).text(value.nom_categoria));
                });
                categorioTaller = "";
                $("#siecarga").css("display", "none");
            },
            error: function() {
                console.log("No se ha podido obtener la información");
            }
        });
    });

    $("#select-categoria-taller").change(function() {
        limpiarSelect(3);
        $("#siecarga").css("display", "block");
        var nombre = $("#select-nombre-taller").val();
        var categoria = $(this).val();

        $.ajax({
            type: 'GET',
            url: api + 'mod=secciones&id_taller=' + nombre + '&id_categoria=' + categoria,
            success: function(respuesta) {
                var parse = respuesta;
                var content = $(".content-card");
                if (respuesta.length > 0) {
                    var string = "";
                    var count = 0;
                    $(parse).each(function(index, value) {
                        if (value.cupos_disponibles > 0) {
                            string = '<div class="card">' +
                                '<input type="radio" id="card-' + value.id_seccion + '" class="check-card" name="card-horario" value="' + value.id_seccion + '">' +
                                '<label for="card-' + value.id_seccion + '">' +
                                '<h4 class="text-uppercase">' + value.nom_dia + '</h4>' +
                                '<p><strong>' + value.nom_horario + '</strong></p>' +
                                '<span class="sub-title">Dirección : </span>' +
                                '<p><strong>' + value.lugar + '</strong></p>' +
                                '<span class="sub-title"><strong>cupos : </strong></span> <span>' + value.cupos_disponibles + '</span>' +
                                '</label>' +
                                '</div>';
                            content.append(((index == 0) ? "<h3 class='text-center'>Marcar el horario preferido</h3>" : "") + string);
                            count++;
                        }
                        
                    });

                    if (count <= 0) content.append("No se encontro cupos en los horarios.");
                } else content.append("No se encontro cupos en los horarios.");
                categorioTaller = "";
                $("#siecarga").css("display", "none");
            },
            error: function() {
                console.log("No se ha podido obtener la información");
            }
        });
    });


});

function init() {
    $.ajax({
        type: 'GET',
        url: api + 'mod=taller',
        crossDomain: true,
        success: function(respuesta) {
            $(respuesta).each(function(index, value) {
                $("#select-nombre-taller").append($("<option>").attr('value', value.id_taller).text(value.nom_taller));
            });
        },
        error: function() {
            console.log("No se ha podido obtener la información");
        }
    });
}



function limpiarSelect(num) {
    var array = ["#select-categoria-taller", "#select-categoria-taller", ".content-card"];
    array.map((x, i) => {
        if ((i + 1) >= num) {
            var t = $(x);
            t.empty();
            if ((i + 1) != 3) t.append($("<option>").attr('value', "").text("Seleccionar"));
        }
    });
}

init();



function letras(e) {
    tecla = e.which || e.keyCode;
    patron = /[a-zA-Z ñÑ]/;
    te = String.fromCharCode(tecla);
    return (patron.test(te) || tecla == 9 || tecla == 8);
}

function numeros(e) {
    tecla = e.which || e.keyCode;
    patron = /\d/;
    te = String.fromCharCode(tecla);
    return (patron.test(te) || tecla == 9 || tecla == 8);
}