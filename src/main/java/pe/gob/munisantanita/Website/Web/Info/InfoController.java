package pe.gob.munisantanita.Website.Web.Info;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.gob.munisantanita.Website.Web.Base.Utils.Helper;
import pe.gob.munisantanita.Website.Web.Model.Menu;

//@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
@RequestMapping("/info")
public class InfoController {
	
	Helper help = new Helper();
	
	//@CrossOrigin(origins = "http://www.transparencia.gob.pe/")
	//@CrossOrigin
	@GetMapping(value="/**")
	public String info(HttpServletRequest request, Model model) throws MalformedURLException {

		String titulo = "";
		String descripcion = "";
		String Keywords = "";
	    String ruta = request.getRequestURI().toString().replace("/info/", "");
	    String municipio 	= "municipio";
	    String servicios  	= "servicios";
	    String tramites		= "tramites";
	    String turismo 		= "turismo";
	    String distrito 	= "distrito";
	    String obras 		= "obras";
	    String mejoras 		= "mejoras";
	    String informacion	= "informacion";
	    String contactenos	= "contactenos";
	    
	    String modulo = "";
	    String pagina = "default";
	    String[] rutaSubPage = null;
	    
	    switch(ruta) {
			 // Municipio
		    case "mensaje-de-alcalde":
		        titulo = "Mensaje del Alcalde";
		        descripcion = "Queridos vecinos, ha llegado el momento de sumar esfuerzos. Todos juntos vamos a lograr que nuestro distrito se consolide y sea referente de Lima Este y el País. Hay una ardua tarea por cumplir.";
		        Keywords  = "Queridos vecinos, ha llegado el momento de sumar esfuerzos. Todos juntos vamos a lograr que nuestro distrito se consolide y sea referente de Lima Este y el País. Hay una ardua tarea por cumplir.";
		        pagina = help.vistaWeb("municipality/message-mayor");   
		        modulo = municipio; 
		        break;
		    case "concejo-municipal":              
		        titulo = "Concejo municipal";
		        descripcion = "Concejo municipal de la Municipalidad Distrital de Santa Anita.";
		        Keywords  = "Concejo municipal de la Municipalidad Distrital de Santa Anita.";
		        pagina = help.vistaWeb("municipality/concejo-municipal");            
		        modulo = municipio; 
		        break;
            case "funcionarios":              
		        titulo = "Funcionarios municipal";
		        descripcion = "Consejo municipal de la Municipalidad Distrital de Santa Anita.";
		        Keywords  = "Consejo municipal de la Municipalidad Distrital de Santa Anita.";
		        pagina = help.vistaWeb("municipality/funcionarios");            
		        modulo = municipio; 
		        break;
		    case "comisiones":          
		        titulo = "Comisión de Regidores";
		        descripcion = "Consejo de Regidores de la Municipalidad Distrital de Santa Anita.";
		        Keywords  = "Consejo de Regidores de la Municipalidad Distrital de Santa Anita.";
		        pagina = help.vistaWeb("municipality/commissions");     
		        modulo = municipio; 
		        break;
            case "organigrama":                         
		        titulo = "Organigrama";
		        descripcion = "Representación gráfica de la estructura de la Municipalidad Distrital de Santa Anita.";
		        Keywords  = "Representación gráfica de la estructura de la Municipalidad Distrital de Santa Anita.";
		        pagina = help.vistaWeb("information/organization-chart");               
		        modulo = municipio; 
		        break;
            case "marco-legal":                         
		        titulo = "Marco Legal";
		        descripcion = "Informacion general de leyes de la Municipalidad Distrital de Santa Anita.";
		        Keywords  = "Informacion general de leyes de la Municipalidad Distrital de Santa Anita.";
		        pagina = help.vistaWeb("information/legal-framework");                  
		        modulo = municipio; 
		        break;
            case "instalaciones":                         
		        titulo = "Instalaciones";
		        descripcion = "Instalaciones";
		        Keywords  = "Instalaciones";
		        pagina = help.vistaWeb("municipality/instalaciones");                  
		        modulo = municipio; 
		        break;
		        
		    // Servicios
		    case "centro-de-desarrollo-para-la-mujer":                  
		        titulo = "Centro de Desarrollo para la Mujer";
		        descripcion = "El Centro de Desarrollo para la Mujer (Casa de la Mujer) está ubicado entre la Urbanización Residencial Risso y la Cooperativa de Vivienda Benjamin Doig, cuenta con diferentes servicios dirigidos a todas nuestras vecinas.";
		        Keywords  = "El Centro de Desarrollo para la Mujer (Casa de la Mujer) está ubicado entre la Urbanización Residencial Risso y la Cooperativa de Vivienda Benjamin Doig, cuenta con diferentes servicios dirigidos a todas nuestras vecinas.";
		        pagina = help.vistaWeb("services/women-house");                 
		        modulo = servicios; 
		        break;
		    case "centro-integral-de-atencion-al-adulto-mayor-ciam":    
		        titulo = "Centro Integral de Atención al Adulto Mayor - CIAM";
		        descripcion = "Es una obra de la Municipalidad de Santa Anita, creada ante la falta de espacios para los adulto mayores del distrito. La infraestructura cuenta con un auditorio, patio exterior e interior, aulas en sus tres niveles y ascensor.";
		        Keywords  = "Es una obra de la Municipalidad de Santa Anita, creada ante la falta de espacios para los adulto mayores del distrito. La infraestructura cuenta con un auditorio, patio exterior e interior, aulas en sus tres niveles y ascensor.";
		        pagina = help.vistaWeb("services/house-of-the-elderly-adult");  
		        modulo = servicios; 
		        break;
		    case "clinica-municipal":                                   
		        titulo = "Clínica Municipal";
		        descripcion = "La clínica Municipal tiene los servicios de Cardiología, Cirugía General, Cirugía Oncológica, Medicina General, Psiquiatría, Urgencias, Ecografías entre otros.";
		        Keywords  = "La clínica Municipal tiene los servicios de Cardiología, Cirugía General, Cirugía Oncológica, Medicina General, Psiquiatría, Urgencias, Ecografías entre otros.";
		        pagina = help.vistaWeb("services/municipal-clinic");            
		        modulo = servicios; 
		        break;
		    case "demuna":                                              
		        titulo = "Demuna";
		        descripcion = "La Defensoráa Municipal del Niño y del Adolescente (DEMUNA), es un servicio encargado de proteger y promover los derechos de los niños y adolescentes. Desde 1997 está considerada en la Ley Orgánica de Municipalidades como una funcián de los gobiernos.";
		        Keywords  = "La Defensoráa Municipal del Niño y del Adolescente (DEMUNA), es un servicio encargado de proteger y promover los derechos de los niños y adolescentes. Desde 1997 está considerada en la Ley Orgánica de Municipalidades como una funcián de los gobiernos.";
		        pagina = help.vistaWeb("services/demuna");                      
		        modulo = servicios; 
		        break;
		    
		    case "guarderia-municipal":                                 
		        titulo = "Guardería Municipal";
		        descripcion = "En nuestras Guarderías Municipal, se realizan actividades divertidas que propician el desarrollo motriz, cognitivo, socioemocional y lenguaje. Nuestra metodología está diseñada para el aprendizaje y desarrollo de nuestros pequeños y siempre con mucho amor.";
		        Keywords  = "En nuestras Guarderías Municipal, se realizan actividades divertidas que propician el desarrollo motriz, cognitivo, socioemocional y lenguaje. Nuestra metodología está diseñada para el aprendizaje y desarrollo de nuestros pequeños y siempre con mucho amor.";
		        pagina = help.vistaWeb("services/municipal-guard");             
		        modulo = servicios; 
		        break;
		    case "resultados-de-olimpiadas":                            
		        titulo = "Resultados de Olimpiadas";
		        descripcion = "Resultados de la Olimpiadas de Conocimiento.";
		        Keywords  = "Resultados de la Olimpiadas de Conocimiento.";
		        pagina = help.vistaWeb("services/olympic-results");             
		        modulo = servicios; 
		        break;
            
		    case "omaped":                                              
		        titulo = "OMAPED";
		        descripcion = "La OMAPED es la Oficina Municipal de Atención a las Personas con Discapacidad, en nuestro municipio, se enmarca en la visión de lograr calidad de vida para las personas con algún tipo de discapacidad, asimismo, velar por sus derechos y fomentar su participación.";
		        Keywords  = "La OMAPED es la Oficina Municipal de Atención a las Personas con Discapacidad, en nuestro municipio, se enmarca en la visión de lograr calidad de vida para las personas con algún tipo de discapacidad, asimismo, velar por sus derechos y fomentar su participación.";
		        pagina = help.vistaWeb("services/omaped");                      
		        modulo = servicios; 
		        break;
		    case "recoleccion-de-recursos-solidos":                     
		        titulo = "Recolección de RR.SS.";
		        descripcion = "Servicio de recolección de residuos sólidos.";
		        Keywords  = "Servicio de recolección de residuos sólidos.";
		        pagina = help.vistaWeb("services/solid-waster-collection");     
		        modulo = servicios; 
		        break;
		    case "servicios-publicos":                                  
		        titulo = "Servicios Públicos";
		        descripcion = "La Sub Gerencia de Servicios Públicos, es un órgano de línea encargada de planificar, organizar, dirigir, ejecutar y controlar los procesos técnicos administrativos relacionados con la prestación de servicios municipale.";
		        Keywords  = "La Sub Gerencia de Servicios Públicos, es un órgano de línea encargada de planificar, organizar, dirigir, ejecutar y controlar los procesos técnicos administrativos relacionados con la prestación de servicios municipale.";
		        pagina = help.vistaWeb("services/public-services");             
		        modulo = servicios; 
		        break;
	
		    // Trámites         
		    case "obras-privadas":              
		        titulo = "Obras Privadas";
		        descripcion = "Se denomina Obra a todos los trabajos de construcción, que sean de Infraestruras o edificación, promovidas por la Municipalidad teniendo como objetivo el beneficio de la comunidad.";
		        Keywords  = "Se denomina Obra a todos los trabajos de construcción, que sean de Infraestruras o edificación, promovidas por la Municipalidad teniendo como objetivo el beneficio de la comunidad.";
		        pagina = help.vistaWeb("formalities/private-works");                
		        modulo = tramites; 
		        break;
		    case "defensa-civil":               
		        titulo = "Defensa Civil";
		        descripcion = "Es una organización cuya función es brindar apoyo a la población en el marco de emergencias generadas por catástrofes naturales u otros fenomenos. Estas entidades cuentran con el respaldo del los gobiernos para su funcionamiento.";
		        Keywords  = "Es una organización cuya función es brindar apoyo a la población en el marco de emergencias generadas por catástrofes naturales u otros fenomenos. Estas entidades cuentran con el respaldo del los gobiernos para su funcionamiento.";
		        pagina = help.vistaWeb("formalities/civil-defense");                
		        modulo = tramites; 
		        break;
		    case "transporte":                  
		        titulo = "Transporte";
		        descripcion = "Es un conjunto de procesos que tienen como finalidad el desplazamiento y comunicación. Para poder llevar a cabo dichos procesos se emplean diferentes medios de transporte (automovil, camion y motos), que circulan por determinadas vias de comunicación.";
		        Keywords  = "Es un conjunto de procesos que tienen como finalidad el desplazamiento y comunicación. Para poder llevar a cabo dichos procesos se emplean diferentes medios de transporte (automovil, camion y motos), que circulan por determinadas vias de comunicación.";
		        pagina = help.vistaWeb("formalities/transport");                    
		        modulo = tramites; 
		        break;
		    case "catastro":                    
		        titulo = "Catastro";
		        descripcion = "Es un registro administrativo dependiente del estado en el que se describen los bienes inmuebles rusticos, urbanos y de caracteristicas especiales. Se encuentra que es un registro estadistico para determinar la extensión geográfica y riqueza de alguna demarcación.";
		        Keywords  = "Es un registro administrativo dependiente del estado en el que se describen los bienes inmuebles rusticos, urbanos y de caracteristicas especiales. Se encuentra que es un registro estadistico para determinar la extensión geográfica y riqueza de alguna demarcación.";
		        pagina = help.vistaWeb("formalities/cadastre");                     
		        modulo = tramites; 
		        break;
		    case "administracion-tributaria":   
		        titulo = "Administración Tributaria";
		        descripcion = "Es un órgano estado cuyo objetivo primordial es la recaudación de los tributos atribuidos a su competencia por mandato de la constitución y la ley.";
		        Keywords  = "Es un órgano estado cuyo objetivo primordial es la recaudación de los tributos atribuidos a su competencia por mandato de la constitución y la ley.";
		        pagina = help.vistaWeb("formalities/tax-administration");           
		        modulo = tramites; 
		        break;
		    case "fiscalizacion":               
		        titulo = "Fiscalización";
		        descripcion = "Consiste en examinar una actividad para comprobar si cumple con la normativa vigentes.";
		        Keywords  = "Consiste en examinar una actividad para comprobar si cumple con la normativa vigentes.";
		        pagina = help.vistaWeb("formalities/inspection");                   
		        modulo = tramites; 
		        break;
		    case "licencias":                   
		        titulo = "Licencias";
		        descripcion = "Es un contrato mediante el cual una persona recibel de otra el derecho de uso, de copia, de distribución, de estudios y de modificación de varios de sus bienes, normalmente de carácter no tangible o intelectual, pudiendo darse a cambio del pago de un monto.";
		        Keywords  = "Es un contrato mediante el cual una persona recibel de otra el derecho de uso, de copia, de distribución, de estudios y de modificación de varios de sus bienes, normalmente de carácter no tangible o intelectual, pudiendo darse a cambio del pago de un monto.";
		        pagina = help.vistaWeb("formalities/licenses");                     
		        modulo = tramites; 
		        break;
		    
            case "divorcio":                                            
		        titulo = "Divorcio";
		        descripcion = "Procedimiento no contencioso de separación convencional y divorcio ulterior ante municipalidades.";
		        Keywords  = "Procedimiento no contencioso de separación convencional y divorcio ulterior ante municipalidades.";
		        pagina = help.vistaWeb("services/divorce");                     
		        modulo = tramites; 
		        break;
		    case "matrimonio-civil":                                    
		        titulo = "Matrimonio Civil";
		        descripcion = "Matrimonio Civil realizado por la Subgerencia de Atención al Ciudadano y Gestión Documentaria.";
		        Keywords  = "Matrimonio Civil realizado por la Subgerencia de Atención al Ciudadano y Gestión Documentaria.";
		        pagina = help.vistaWeb("services/civil-marriage");              
		        modulo = tramites; 
		        break;
	
		    // Turismo
		    case "lugares-turisticos":  
		        titulo = "Lugares Turísticos";
		        descripcion = "Conoce las zonas turísticas que se tiene en el distrito de Santa Anita.";
		        Keywords  = "Conoce las zonas turísticas que se tiene en el distrito de Santa Anita.";
		        pagina = help.vistaWeb("tourism/tourist-places");   
		        modulo = turismo; 
		        break;
		    case "ubicacion":           
		        titulo = "Ubicación";
		        descripcion = "Es un lugar, un sitio o una localización donde está ubicado algo o alguien. Una ubicación es una situación, un establecimiento, un asiento, es la existencia de un ser o de algo en algún sitio o lugar.";
		        Keywords  = "Es un lugar, un sitio o una localización donde está ubicado algo o alguien. Una ubicación es una situación, un establecimiento, un asiento, es la existencia de un ser o de algo en algún sitio o lugar.";
		        pagina = help.vistaWeb("district/location");        
		        modulo = turismo; 
		        break;
	
		    // Distrito
		    case "historia-de-santa-anita":                         
		        titulo = "Historia";
		        descripcion = "Santa Anita es uno de los distritos más jóvenes del departamento de Lima; su creación se dio el 25 de Octubre de 1989, por ley N°. 25116, siendo Presidente Constitucional de la República el Dr. Alan García Pérez y Alcalde de Lima Metropolitana el Dr. Jorge del.";
		        Keywords  = "Santa Anita es uno de los distritos más jóvenes del departamento de Lima; su creación se dio el 25 de Octubre de 1989, por ley N°. 25116, siendo Presidente Constitucional de la República el Dr. Alan García Pérez y Alcalde de Lima Metropolitana el Dr. Jorge del.";
		        pagina = help.vistaWeb("district/history");         
		        modulo = distrito; 
		        break;
		    case "geografia-de-santa-anita":                        
		        titulo = "Geografia";
		        descripcion = "Geografía del distrito.";
		        Keywords  = "Geografía del distrito.";
		        pagina = help.vistaWeb("district/geography");       
		        modulo = distrito; 
		        break;
		    case "ubicacion-de-la-municipalidad-de-santa-anita":    
		        titulo = "Mapa Urbano";
		        descripcion = "Mapa Urbano";
		        Keywords  = "Mapa Urbano";
		        pagina = help.vistaWeb("district/location");        
		        modulo = distrito; 
		        break;
		    case "ley-de-creacion":                                 
		        titulo = "Ley de Creación";
		        descripcion = "Ley de Creación";
		        Keywords  = "Ley de Creación";
		        pagina = help.vistaWeb("district/creation-law");    
		        modulo = distrito; 
		        break;
		    case "escudo-digital-municipalidad-de-santa-anita":     
		        titulo = "Escudo Distrital";
		        descripcion = "Escudo Distrital";
		        Keywords  = "Escudo Distrital";
		        pagina = help.vistaWeb("district/digital-shield");  
		        modulo = distrito; 
		        break;
	

	
		    // Información
		    case "directivas":                          
		        titulo = "Directivas";
		        descripcion = "Son directivas de diversas areas de la Municipalidad Distrital de Santa Anita.";
		        Keywords  = "Son directivas de diversas areas de la Municipalidad Distrital de Santa Anita.";
		        pagina = help.vistaWeb("information/directives");                       
		        modulo = informacion; 
		        break;
		    case "informacion-adicional":               
		        titulo = "Información Adicional";
		        descripcion = "Es informacion de diversas areas de la Municipalidad Distrital de Santa Anita.";
		        Keywords  = "Es informacion de diversas areas de la Municipalidad Distrital de Santa Anita.";
		        pagina = help.vistaWeb("information/additional-information");           
		        modulo = informacion; 
		        break;
		    case "acceso-a-la-informacion":             
		        titulo = "Acceso a la Información";
		        descripcion = "Es el Formato de solicitud de Acceso a la Información Pública.";
		        Keywords  = "Es el Formato de solicitud de Acceso a la Información Pública.";
		        pagina = help.vistaWeb("information/access-to-information");            
		        modulo = informacion; 
		        break;
		    case "mejoras-implementadas":               
		        titulo = "Mejoras Implementadas";
		        descripcion = "Son documentos donde se indican las mejoras  de diversas areas de la Municipalidad de Santa Anita.";
		        Keywords  = "Son documentos donde se indican las mejoras  de diversas areas de la Municipalidad de Santa Anita.";
		        pagina = help.vistaWeb("information/implemented-improvements");         
		        modulo = informacion; 
		        break;
		    case "convocatoria-cas":                    
		        titulo = "Convocatorias CAS";
		        descripcion = "Publicacion de ofertas laborales en la Municipalidad Distrital de Santa Anita.";
		        Keywords  = "Publicacion de ofertas laborales en la Municipalidad Distrital de Santa Anita.";
		        pagina = help.vistaWeb("information/announcement-cas");                 
		        modulo = informacion; 
		        break;
            case "presupuesto-participativo":   
		        titulo = "Presupuesto Participativo";
		        descripcion = "Es un proceso de intervención directa, permanente, voluntaria y universal mediante el cual la ciudadanía, conjuntamente con las autoridades, delibera y decide la asignación de recursos públicos.";
		        Keywords  = "Es un proceso de intervención directa, permanente, voluntaria y universal mediante el cual la ciudadanía, conjuntamente con las autoridades, delibera y decide la asignación de recursos públicos.";
		        pagina = help.vistaWeb("formalities/presupuesto-participativo");    
		        modulo = informacion; 
		        break;
		    
		    
		    case "tupa":                                
		        titulo = "TUPA";
		        descripcion = "Documento de gestión que contiene toda la información la Municipalidad Distrital de Santa Anita.";
		        Keywords  = "Documento de gestión que contiene toda la información la Municipalidad Distrital de Santa Anita.";
		        pagina = help.vistaWeb("information/tupa");                             
		        modulo = informacion; 
		        break;
		    case "transparencia":                       
		        titulo = "Transparencia";
		        descripcion = "Información que tiene por finalidad promover la transparencia de los actos de la Municipalidad Distrital de Santa Anita.";
		        Keywords  = "Información que tiene por finalidad promover la transparencia de los actos de la Municipalidad Distrital de Santa Anita.";
		        pagina = help.vistaWeb("information/transparency");                     
		        modulo = informacion; 
		        break;
		    case "telefonos":                           
		        titulo = "Teléfonos";
		        descripcion = "Telefonos de la Municipalidad Distrital de Santa Anita.";
		        Keywords  = "Telefonos de la Municipalidad Distrital de Santa Anita.";
		        pagina = help.vistaWeb("contact-us/phones");                            
		        modulo = informacion; 
		        break;
		    case "ubicacion-de-santa-anita":            
		        titulo = "Ubicación";
		        descripcion = "Ubicación de la Municipalidad Distrital de Santa Anita.";
		        Keywords  = "Ubicación de la Municipalidad Distrital de Santa Anita.";
		        pagina = help.vistaWeb("contact-us/contact-us-location");               
		        modulo = informacion; 
		        break;
		    case "proceso-de-elecciones":                        
		        titulo = "Proceso de elecciones";
		        descripcion = "Proceso de elecciones de la Municipalidad Distrital de Santa Anita.";
		        Keywords  = "Proceso de elecciones de la Municipalidad Distrital de Santa Anita.";
		        pagina = help.vistaWeb("information/proceso-de-elecciones2");
		        modulo = informacion; 
		        break;
		    case "beneficiarios-de-las-canastas-basicas":                                
		        titulo = "Beneficiarios de las canastas básicas";
		        descripcion = "Beneficiarios de las canastas básicas de la Municipalidad Distrital de Santa Anita.";
		        Keywords  = "Beneficiarios de las canastas básicas de la Municipalidad Distrital de Santa Anita.";
		        pagina = help.vistaWeb("information/beneficiarios-de-las-canastas-basicas");
		        modulo = informacion; 
		        break;
	
		    // Links sueltos
		    case "alerta-policial":                     
		        titulo = "";
		        descripcion = "";
		        Keywords  = "";
		        pagina = help.vistaWeb("modulo/alerta-policial");               
		        modulo = ""; 
		        break;
		    case "sistema-de-control-interno":          
		        titulo = "";
		        descripcion = "";
		        Keywords  = "";
		        pagina = help.vistaWeb("modulo/sistema-de-control-interno");    
		        modulo = ""; 
		        break;
		    case "cabildo-abierto":                     
		        titulo = "";
		        descripcion = "";
		        Keywords  = "";
		        pagina = help.vistaWeb("modulo/cabildo-abierto");               
		        modulo = ""; 
		        break;
		    case "formatos-tupa":                       
		        titulo = "";
		        descripcion = "";
		        Keywords  = "";
		        pagina = help.vistaWeb("modulo/formatos-tupa");                 
		        modulo = ""; 
		        break;
	
	
		    // Transparencia
		    case "portal-de-transparencia":     
		    	titulo = "Portal de Transparencia";
		        descripcion = "Es una herramienta informática de información estandarizada e integral, para facilitar el acceso a la información sobre el uso de los recursos públicos y de gestión institucional e incrementar los niveles de transparencia.";
		        Keywords  = "Es una herramienta informática de información estandarizada e integral, para facilitar el acceso a la información sobre el uso de los recursos públicos y de gestión institucional e incrementar los niveles de transparencia.";
		        pagina = help.vistaWeb("transparency/transparency-general"); 
		        break;
		        
		    default:
		    	rutaSubPage = dd(ruta);
		    	break;
	    }
	    
	    
	    if(rutaSubPage != null) {
	    	
	    	switch (rutaSubPage[1].toString()) {
		    	case "restauracion": 						
		    		titulo = "Restauración de Obras";
		            descripcion = "Es una acción que realiza la Municipalidad Distrital de Santa Anita en beneficio de la comunidad para mejorar el distrito.";
		            Keywords  = "Es una acción que realiza la Municipalidad Distrital de Santa Anita en beneficio de la comunidad para mejorar el distrito.";
		    		pagina = help.vistaWeb("improvements/restoration/index"); 			
		    		modulo = mejoras; 
		    		break;
		    	case "seguridad-ciudadana": 				
		    		titulo = "Seguridad Ciudadana";
		            descripcion = "El Plan de Acción de Seguridad Ciudadana de Santa Anita 2019, es un instrumento de gestión elaborado por la sociedad civil organizada, instituciones del Estado y el sector privado; todos ellos integrantes del Comité Distrital de Seguridad Ciudadana CODISEC";
		            Keywords  = "El Plan de Acción de Seguridad Ciudadana de Santa Anita 2019, es un instrumento de gestión elaborado por la sociedad civil organizada, instituciones del Estado y el sector privado; todos ellos integrantes del Comité Distrital de Seguridad Ciudadana CODISEC";
		    		pagina = help.vistaWeb("services/citizen-security/index"); 			
		    		modulo = servicios; 
		    		break;
		    	case "proceso-de-cambio-de-zonificacion": 	
		    		titulo = "Proceso de cambio de zonificación";
		            descripcion = "Es el proceso que aplica el acondicionamiento territorial para el desarrollo urbano dentro de los limites del distrito.";
		            Keywords  = "Es el proceso que aplica el acondicionamiento territorial para el desarrollo urbano dentro de los limites del distrito.";
		    		pagina = help.vistaWeb("information/zoning-change-process/index");	
		    		modulo = informacion; 
		    		break;
                case "centro-cultural": 	
		    		titulo = "Centro Cultural";
                    descripcion = "Inauguración de los talleres culturales, educativos y juveniles.";
                    Keywords  = "Inauguración de los talleres culturales, educativos y juveniles.";
		    		pagina = help.vistaWeb("services/centro-cultural/index");	
		    		modulo = servicios; 
		    		break;
				default:
					break;
			}
		    ruta = rutaSubPage[1];
	    	model.addAttribute("subPage", rutaSubPage[0].toString());
	    }
	    
	   
		
		
	    Menu menu = new Menu();
	    menu.setName(titulo); //
	    menu.setDescripcion(descripcion);//descripcion
		menu.setKeywords(Keywords);///
		
		menu.setModule(modulo);//
		menu.setSection(ruta);//
		model.addAttribute("menu", menu);
		
	    return pagina;
	    
	}
	
	private String[] dd(String path) {
		
		String[] ruta = new String[2];
		
		if(path.contains("restauracion")) {
			ruta[0] = path.replace("restauracion/", "").replace("restauracion", "");
			ruta[1] = "restauracion";
		}
		else if(path.contains("seguridad-ciudadana")) {
			ruta[0] = path.replace("seguridad-ciudadana/", "").replace("seguridad-ciudadana", "");
			ruta[1] = "seguridad-ciudadana";
		}
		
		else if(path.contains("proceso-de-cambio-de-zonificacion")) {
			ruta[0] = path.replace("proceso-de-cambio-de-zonificacion/", "").replace("proceso-de-cambio-de-zonificacion", "");
			ruta[1] = "proceso-de-cambio-de-zonificacion";
		}

        else if(path.contains("centro-cultural")) {
			ruta[0] = path.replace("centro-cultural/", "").replace("centro-cultural", "");
			ruta[1] = "centro-cultural";
		}
		
		return ruta;
		
	}
	
}
