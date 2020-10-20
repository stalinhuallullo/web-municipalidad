package pe.gob.munisantanita.Website.Web.Reclamaciones;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.gob.munisantanita.Website.Web.Model.Menu;

@Controller
@RequestMapping("/")
public class ReclamacionController {
	
	@GetMapping(value="/libro-de-reclamaciones")
	public String inicio(@RequestParam(value="data",required = false) String data, Model model) {
		
		Menu menu = new Menu();
		menu.setName("Libro de reclamaciones - Municipalidad de Santa Anita");
		menu.setDescripcion("Bienvenidos al libro de reclamaciones de la Municipalidad Distrital de Santa Anita");
		menu.setKeywords("Bienvenidos al libro de reclamaciones de la Municipalidad Distrital de Santa Anita");
		menu.setModule("home");
		menu.setSection("home");
		
		model.addAttribute("menu", menu);

		return "web/pages/reclamaciones/index";
		
	}
}
