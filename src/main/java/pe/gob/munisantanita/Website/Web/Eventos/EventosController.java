package pe.gob.munisantanita.Website.Web.Eventos;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.gob.munisantanita.Website.Web.Model.Menu;
import pe.gob.munisantanita.Website.Web.Base.Utils.Helper;
import pe.gob.munisantanita.Website.Web.Eventos.Repository.EventosRepository;


@Controller
@RequestMapping("/eventos")
public class EventosController {

	Helper help = new Helper();
	String urlCategory = "eventos/categoria/";
	
	
	@Autowired
	EventosRepository objEventosRepository;
	

	@GetMapping({"", "/"})
	public String News(@RequestParam(value="data",required = false) String data, Model model) {

		Menu menu = new Menu();
		menu.setName("Eventos Municipales y ciudadanas - Municipalidad de Santa Anita");
		menu.setDescripcion("No te pierdas de los próximos eventos y actividades realizados por nuestra Munipalidad.");
		menu.setKeywords("No te pierdas de los próximos eventos y actividades realizados por nuestra Munipalidad.");
		menu.setModule("municipio");
		menu.setSection("eventos");
		
		ArrayList<?> arrayAllCategory = objEventosRepository.allCategory();
		
		
		
		Object objEventos1 = objEventosRepository.categoria("centro-cultural", 4);
		Object objEventos2 = objEventosRepository.categoria("bienestar-social", 4);
		Object objEventos3 = objEventosRepository.categoria("izamientos", 4);
		
		Map<ArrayList<?>, Object> arrayEventos1 = (Map<ArrayList<?>, Object>) objEventos1;
		Map<ArrayList<?>, Object> arrayEventos2 = (Map<ArrayList<?>, Object>) objEventos2;
		Map<ArrayList<?>, Object> arrayEventos3 = (Map<ArrayList<?>, Object>) objEventos3;
		
		
		ArrayList<Object> listEventos1 = (ArrayList<Object>) arrayEventos1.get("eventos");
		ArrayList<Object> listEventos2 = (ArrayList<Object>) arrayEventos2.get("eventos");
		ArrayList<Object> listEventos3 = (ArrayList<Object>) arrayEventos3.get("eventos");
		
		
		model.addAttribute("categories", arrayAllCategory);
		model.addAttribute("listEventos1", listEventos1);
		model.addAttribute("listEventos2", listEventos2);
		model.addAttribute("listEventos3", listEventos3);
		model.addAttribute("urlCategory", urlCategory);
		model.addAttribute("menu", menu);
		return help.vistaWeb("municipality/eventos/home");
		
	}
	
	@GetMapping({"categoria/", "categoria/{slugCategoria}", "categoria/{slugCategoria}/{pag}"})
	public String showCategory(@PathVariable(required = false) String slugCategoria, @PathVariable(required = false) String pag, Model model) {

		
		ArrayList<?> arrayAllCategory = objEventosRepository.allCategory();
		Object nameCategory = objEventosRepository.showNameCategory(slugCategoria);
		Map<ArrayList<?>, Object> arrayNameCategory = (Map<ArrayList<?>, Object>) nameCategory;  
		
		
		Object objEventoCategoria = objEventosRepository.showCategory(slugCategoria, pag);
		Map<ArrayList<?>, Object> arrayEventoCategoria = (Map<ArrayList<?>, Object>) objEventoCategoria;  
		ArrayList<Object> listEventoCategoria = (ArrayList<Object>) arrayEventoCategoria.get("eventos");  
		
		
		int total = Integer.parseInt(arrayEventoCategoria.get("total_paginas").toString());
		int actual = Integer.parseInt(arrayEventoCategoria.get("pag_actual").toString());

		
		String categoria = arrayNameCategory.get("nombre").toString();
		
		Menu menu = new Menu();
		menu.setName("Eventos de " + categoria + " - Municipalidad de Santa Anita");
		menu.setDescripcion("No te pierdas de los próximos eventos y actividades realizados por nuestra Munipalidad de " + categoria);
		menu.setKeywords("No te pierdas de los próximos eventos y actividades realizados por nuestra Munipalidad de " + categoria);
		menu.setModule("municipio");
		menu.setSection("eventos");
		
		
		model.addAttribute("categories", arrayAllCategory);
		model.addAttribute("data", listEventoCategoria);
		model.addAttribute("nombreCategoria", categoria);
		model.addAttribute("categoria", slugCategoria);
		model.addAttribute("total", total);
		model.addAttribute("actual", actual);
		model.addAttribute("urlPag", urlCategory + slugCategoria);
		model.addAttribute("urlCategory", urlCategory);
		model.addAttribute("pagFormato", "parameter");
		model.addAttribute("menu", menu);

		return help.vistaWeb("municipality/eventos/list");
		
	}
	
	@GetMapping({"{id}/{slug}"})
	public String show(@PathVariable(required = false) String id, @PathVariable(required = false) String slug, Model model) {

		
		ArrayList<?> arrayAllCategory = objEventosRepository.allCategory();
		
		Object objEvento = objEventosRepository.show(id);
		Map<ArrayList<?>, Object> arrayEvento = (Map<ArrayList<?>, Object>) objEvento;
		
		
		Object objCategory = objEventosRepository.categoria( arrayEvento.get("categoria_slug").toString(), 12 );
		Map<ArrayList<?>, Object> arrayCategory = (Map<ArrayList<?>, Object>) objCategory;
		ArrayList<Object> listCategory = ((ArrayList<Object>) arrayCategory.get("eventos"));
		
		String titulo = arrayEvento.get("titulo").toString();
		
		
		Menu menu = new Menu();
		menu.setName(titulo + " - Municipalidad de Santa Anita");
		menu.setDescripcion(titulo);
		menu.setKeywords(titulo);
		menu.setModule("municipio");
		menu.setSection("eventos");
		
		
		model.addAttribute("categories", arrayAllCategory);
		model.addAttribute("evento", objEvento);
		model.addAttribute("relacionadas", listCategory);
		model.addAttribute("urlCategory", urlCategory);
		model.addAttribute("menu", menu);
		
		return help.vistaWeb("municipality/eventos/single");

	}
	
}

