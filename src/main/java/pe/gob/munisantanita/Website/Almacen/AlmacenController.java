package pe.gob.munisantanita.Website.Almacen;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/almacen")
public class AlmacenController {
	
	
	@GetMapping("/principal")
	public String index() {
		return "pages/almacen";
	}
	
}
