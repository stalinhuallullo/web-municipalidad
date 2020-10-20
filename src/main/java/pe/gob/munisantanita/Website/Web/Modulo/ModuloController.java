package pe.gob.munisantanita.Website.Web.Modulo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.gob.munisantanita.Website.Web.Base.Utils.Helper;
import pe.gob.munisantanita.Website.Web.Model.Menu;


@Controller
@RequestMapping("/modulo")
public class ModuloController {

	Helper help = new Helper();
	
	@GetMapping("consultas-en-linea")
	public String consulta(@RequestParam(value="data",required = false) String data, Model model) {

		Menu menu = new Menu();
		menu.setModule("");
		menu.setSection("");
		
		model.addAttribute("menu", menu);
		return help.vistaWeb("modulo/consultas-en-linea");
	}
	
	@GetMapping("licencias-de-edificacion")
	public String licencia(@RequestParam(value="data",required = false) String data, Model model) {

		Menu menu = new Menu();
		menu.setModule("");
		menu.setSection("");
		
		model.addAttribute("menu", menu);
		return help.vistaWeb("modulo/licencias-de-edificacion");
	}
	
}

