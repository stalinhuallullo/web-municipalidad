package pe.gob.munisantanita.Website.Web.Inicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.gob.munisantanita.Website.Web.Model.Menu;
import pe.gob.munisantanita.Website.Web.Base.Utils.Helper;
import pe.gob.munisantanita.Website.Web.Inicio.Repository.EventosRepository;
import pe.gob.munisantanita.Website.Web.Inicio.Repository.NewsRepository;

@Controller
@RequestMapping("/")
public class InicioController {
	
	@Autowired
	NewsRepository objNewsRepository;
	
	@Autowired
	EventosRepository objEventosRepository;
	
	
	@GetMapping(value="/")
	public String inicio(@RequestParam(value="data",required = false) String data, @RequestParam(value="video",required = false) Integer video, Model model) {


		Menu menu = new Menu();
		menu.setName("Municipalidad de Santa Anita");
		menu.setDescripcion("Bienvenidos a la Municipalidad Distrital de Santa Anita. Conozca más sobre nuestra gestión, planes y servicios municipales que puede hacer en el distrito.");
		menu.setKeywords("Información institucional, Atención al Ciudadano, Servicios Municipales, Transparencia Municipal, Actividades Culturales, Turismo, Gestión ambiental.");
		menu.setModule("home");
		menu.setSection("home");
		
		Object objAllNews = objNewsRepository.news(6);
		Object objEventosAnuncios = objEventosRepository.categoria("anuncios", 25);
		Object objEventosTodos = objEventosRepository.todos(35);
		Object objEventos1 = objEventosRepository.categoria("centro-cultural", 25);
		Object objEventos2 = objEventosRepository.categoria("bienestar-social", 25);
		Object objEventos3 = objEventosRepository.categoria("izamientos", 25);
		
		
		Map<ArrayList<?>, Object> arrayAllNews = (Map<ArrayList<?>, Object>) objAllNews;
		Map<ArrayList<?>, Object> arrayEventosAnuncios = (Map<ArrayList<?>, Object>) objEventosAnuncios;
		Map<ArrayList<?>, Object> arrayEventosTodos = (Map<ArrayList<?>, Object>) objEventosTodos;
		Map<ArrayList<?>, Object> arrayEventos1 = (Map<ArrayList<?>, Object>) objEventos1;
		Map<ArrayList<?>, Object> arrayEventos2 = (Map<ArrayList<?>, Object>) objEventos2;
		Map<ArrayList<?>, Object> arrayEventos3 = (Map<ArrayList<?>, Object>) objEventos3;
		
		
		ArrayList<Object> listAllNews = ((ArrayList<Object>) arrayAllNews.get("noticias"));
		ArrayList<Object> listEventosAnuncios = ((ArrayList<Object>) arrayEventosAnuncios.get("eventos"));
		ArrayList<Object> listEventosTodos = ((ArrayList<Object>) arrayEventosTodos.get("eventos"));
		ArrayList<Object> listEventos1 = ((ArrayList<Object>) arrayEventos1.get("eventos"));
		ArrayList<Object> listEventos2 = ((ArrayList<Object>) arrayEventos2.get("eventos"));
		ArrayList<Object> listEventos3 = ((ArrayList<Object>) arrayEventos3.get("eventos"));
		

		
		model.addAttribute("news", listAllNews);
		model.addAttribute("anuncios", listEventosAnuncios);
		model.addAttribute("todos", listEventosTodos);
		model.addAttribute("centroCultural", listEventos1);
		model.addAttribute("bienestarSocial", listEventos2);
		model.addAttribute("izamientos", listEventos3);
		model.addAttribute("menu", menu);
		
		video = video != null ? video : 100;
		model.addAttribute("video", video);
		
		return "web/pages/index";
		
	}
	
	@GetMapping(value="/inicio2")
	public String inicio2(@RequestParam(value="data",required = false) String data, @RequestParam(value="video",required = false) Integer video, Model model) {


		Menu menu = new Menu();
		menu.setName("Municipalidad de Santa Anita");
		menu.setDescripcion("Bienvenidos a la Municipalidad Distrital de Santa Anita. Conozca más sobre nuestra gestión, planes y servicios municipales que puede hacer en el distrito.");
		menu.setKeywords("Información institucional, Atención al Ciudadano, Servicios Municipales, Transparencia Municipal, Actividades Culturales, Turismo, Gestión ambiental.");
		menu.setModule("home");
		menu.setSection("home");
		
		Object objAllNews = objNewsRepository.news(6);
		Object objEventosAnuncios = objEventosRepository.categoria("anuncios", 25);
		Object objEventosTodos = objEventosRepository.todos(35);
		Object objEventos1 = objEventosRepository.categoria("centro-cultural", 25);
		Object objEventos2 = objEventosRepository.categoria("bienestar-social", 25);
		Object objEventos3 = objEventosRepository.categoria("izamientos", 25);
		
		
		Map<ArrayList<?>, Object> arrayAllNews = (Map<ArrayList<?>, Object>) objAllNews;
		Map<ArrayList<?>, Object> arrayEventosAnuncios = (Map<ArrayList<?>, Object>) objEventosAnuncios;
		Map<ArrayList<?>, Object> arrayEventosTodos = (Map<ArrayList<?>, Object>) objEventosTodos;
		Map<ArrayList<?>, Object> arrayEventos1 = (Map<ArrayList<?>, Object>) objEventos1;
		Map<ArrayList<?>, Object> arrayEventos2 = (Map<ArrayList<?>, Object>) objEventos2;
		Map<ArrayList<?>, Object> arrayEventos3 = (Map<ArrayList<?>, Object>) objEventos3;
		
		
		ArrayList<Object> listAllNews = ((ArrayList<Object>) arrayAllNews.get("noticias"));
		ArrayList<Object> listEventosAnuncios = ((ArrayList<Object>) arrayEventosAnuncios.get("eventos"));
		ArrayList<Object> listEventosTodos = ((ArrayList<Object>) arrayEventosTodos.get("eventos"));
		ArrayList<Object> listEventos1 = ((ArrayList<Object>) arrayEventos1.get("eventos"));
		ArrayList<Object> listEventos2 = ((ArrayList<Object>) arrayEventos2.get("eventos"));
		ArrayList<Object> listEventos3 = ((ArrayList<Object>) arrayEventos3.get("eventos"));
		

		
		model.addAttribute("news", listAllNews);
		model.addAttribute("anuncios", listEventosAnuncios);
		model.addAttribute("todos", listEventosTodos);
		model.addAttribute("centroCultural", listEventos1);
		model.addAttribute("bienestarSocial", listEventos2);
		model.addAttribute("izamientos", listEventos3);
		model.addAttribute("menu", menu);
		
		video = video != null ? video : 100;
		model.addAttribute("video", video);
		
		return "web/pages/index2";
		
	}
	
}
