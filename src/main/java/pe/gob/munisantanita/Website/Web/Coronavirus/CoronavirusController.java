package pe.gob.munisantanita.Website.Web.Coronavirus;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class CoronavirusController {

	@GetMapping(value="/coronavirus")
	public String inicio(@RequestParam(value="data",required = false) String data, Model model) {

		return "web/pages/coronavirus/index";
		
	}
}
