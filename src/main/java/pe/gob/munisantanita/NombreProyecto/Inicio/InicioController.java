package pe.gob.munisantanita.NombreProyecto.Inicio;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class InicioController {
	
	//@RequestMapping(value="/{user}", method=RequestMethod.GET)
	@GetMapping(value="/", produces = "text/html;charset=ISO-8859-1")
	public String inicio(@RequestParam(value="data",required = false) String data, Model model) {
		model.addAttribute("data", data );
		return "pages/index";
	}
}
