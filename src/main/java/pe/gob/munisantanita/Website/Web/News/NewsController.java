package pe.gob.munisantanita.Website.Web.News;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import pe.gob.munisantanita.Website.Web.Base.Utils.Helper;
import pe.gob.munisantanita.Website.Web.Model.Menu;
import pe.gob.munisantanita.Website.Web.News.Model.News;
import pe.gob.munisantanita.Website.Web.News.Repository.CategoryRepository;
import pe.gob.munisantanita.Website.Web.News.Repository.NewsRepository;


@Controller
@RequestMapping("/noticias")
public class NewsController {

	@Autowired
	CategoryRepository objCategoryRepository;
	
	@Autowired
	NewsRepository objNewsRespository;
	private String urlNoticiasCategoria = "noticias/categoria/";
	
	@GetMapping({"", "/"})
	public String News(@RequestParam(value="data",required = false) String data, Model model) {

		Menu menu = new Menu();
		menu.setName("Últimas Noticias - Municipalidad de Santa Anita");
		menu.setDescripcion("Entérate de las últimas noticias local, distrital y Nacional.");
		menu.setKeywords("Entérate de las últimas noticias local, distrital y Nacional.");
		menu.setModule("municipio");
		menu.setSection("noticias");
		
		
		ArrayList<?> arrayAllCategory = objCategoryRepository.all();
		
		/*
		 * Category
		 * */
		Object objCategory1 = objNewsRespository.newsByCategories("seguridad", 6);
		Object objCategory2 = objNewsRespository.newsByCategories("educacion", 4);
		Object objCategory3 = objNewsRespository.newsByCategories("salud", 4);
		Object objCategory4 = objNewsRespository.newsByCategories("cultural", 4);
		

		Map<ArrayList<?>, Object> arrayCategory1 = (Map<ArrayList<?>, Object>) objCategory1;
		Map<ArrayList<?>, Object> arrayCategory2 = (Map<ArrayList<?>, Object>) objCategory2;
		Map<ArrayList<?>, Object> arrayCategory3 = (Map<ArrayList<?>, Object>) objCategory3;
		Map<ArrayList<?>, Object> arrayCategory4 = (Map<ArrayList<?>, Object>) objCategory4;
		
	
		ArrayList<Object> listCategory1 = ((ArrayList<Object>) arrayCategory1.get("noticias"));
		ArrayList<Object> listCategory2 = (ArrayList<Object>) arrayCategory2.get("noticias");
		ArrayList<Object> listCategory3 = (ArrayList<Object>) arrayCategory3.get("noticias");
		ArrayList<Object> listCategory4 = (ArrayList<Object>) arrayCategory4.get("noticias");

		
	
		model.addAttribute("categories", arrayAllCategory);

		model.addAttribute("listCategory1", listCategory1);
		model.addAttribute("listCategory2", listCategory2);
		model.addAttribute("listCategory3", listCategory3);
		model.addAttribute("listCategory4", listCategory4);
		model.addAttribute("urlCategory", urlNoticiasCategoria);
		model.addAttribute("menu", menu);
		
		return "web/pages/municipality/news/home";
		
	}
	
	@GetMapping({"categoria/", "categoria/{slugCategoria}", "categoria/{slugCategoria}/{pag}"})
	public String CitizenSecurity(@PathVariable(required = false) String slugCategoria, @PathVariable(required = false) String pag, Model model) {

		
		
		ArrayList<?> arrayAllCategory = objCategoryRepository.all();
		Object nameCategory = objCategoryRepository.showCategory(slugCategoria);
		Map<ArrayList<?>, Object> arrayNameCategory = (Map<ArrayList<?>, Object>) nameCategory;  
	
		
		Object objNewsForCategory = objNewsRespository.findByNewsForCategory(slugCategoria, pag);
		Map<ArrayList<?>, Object> arrayNewForCategory = (Map<ArrayList<?>, Object>) objNewsForCategory;  
		ArrayList<Object> listNewForCategory = (ArrayList<Object>) arrayNewForCategory.get("noticias");  
		
		
		
		int total = Integer.parseInt(arrayNewForCategory.get("total_paginas").toString());
		int actual = Integer.parseInt(arrayNewForCategory.get("pag_actual").toString());

		String categoria = arrayNameCategory.get("nombre").toString();
		
		
		Menu menu = new Menu();
		menu.setName("Noticias de " + categoria + " - Municipalidad de Santa Anita");
		menu.setDescripcion("Entérate de las últimas noticias de " + categoria);
		menu.setKeywords("Entérate de las últimas noticias de " + categoria);
		menu.setModule("municipio");
		menu.setSection("noticias");
		
		
		
		model.addAttribute("categories", arrayAllCategory);
		model.addAttribute("data", listNewForCategory);
		model.addAttribute("nombreCategoria", categoria);
		model.addAttribute("categoria", slugCategoria);
		model.addAttribute("total", total);
		model.addAttribute("actual", actual);
		model.addAttribute("urlPag", urlNoticiasCategoria + slugCategoria);
		model.addAttribute("urlCategory", urlNoticiasCategoria);
		model.addAttribute("pagFormato", "parameter");
		model.addAttribute("menu", menu);
		
		return "web/pages/municipality/news/list";
		
	}
	
	@GetMapping("{slug}")
	public String postSingle(@PathVariable(required = false) String slug, Model model) {

		
		
		ArrayList<?> arrayAllCategory = objCategoryRepository.all();
		
		
		Object objNews = objNewsRespository.findByNews(slug);
		Map<ArrayList<?>, Object> arrayNews =(Map<ArrayList<?>, Object>) objNews;
		
		
		Object objShowCategory = objCategoryRepository.show(arrayNews.get("categoria_id").toString());
		Map<ArrayList<?>, Object> category = (Map<ArrayList<?>, Object>) objShowCategory;
		
		Object objCategory = objNewsRespository.newsByCategories(category.get("slug").toString(), 8);
		Map<ArrayList<?>, Object> arrayCategory = (Map<ArrayList<?>, Object>) objCategory;
		ArrayList<?> listrelatedNews = (ArrayList<?>) arrayCategory.get("noticias");

		String subtitulo = arrayNews.get("subtitulo").toString();
		Menu menu = new Menu();
		menu.setName(arrayNews.get("titulo") + " - Municipalidad de Santa Anita");
		menu.setDescripcion(subtitulo);
		menu.setKeywords(subtitulo);
		menu.setModule("municipio");
		menu.setSection("noticias");
		
		
		
		model.addAttribute("categories", arrayAllCategory);
		model.addAttribute("urlCategory", urlNoticiasCategoria);
		model.addAttribute("listRelatedNews", listrelatedNews);
		model.addAttribute("slug", slug);
		model.addAttribute("news", arrayNews);	
		model.addAttribute("menu", menu);
		
		
		
		return "web/pages/municipality/news/single";
	}
}

