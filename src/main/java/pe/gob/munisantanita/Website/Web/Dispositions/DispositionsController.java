package pe.gob.munisantanita.Website.Web.Dispositions;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;

import groovy.transform.Field;
import pe.gob.munisantanita.Website.Web.Base.Utils.AES;
import pe.gob.munisantanita.Website.Web.Base.Utils.Helper;
import pe.gob.munisantanita.Website.Web.Dispositions.Repository.DispositionsRepository;
import pe.gob.munisantanita.Website.Web.Model.Menu;


@Controller
@RequestMapping("disposiciones")
public class DispositionsController {

	Helper help = new Helper();
	
	@Autowired
	DispositionsRepository objDispositionsRepository;
	
	@GetMapping({"", "/"})
	public String Dispositions(@RequestParam(value = "data", required = false) String data, Model model, HttpServletRequest request, HttpServletResponse res) {
		
		Menu menu = new Menu();
		menu.setName("Disposiciones y Resoluciones - Municipalidad de Santa Anita");
		menu.setDescripcion("Son reglamentos que establece la autoridad y que deben ser cumplidos según su alcance.");
		menu.setKeywords("Son reglamentos que establece la autoridad y que deben ser cumplidos según su alcance.");
		menu.setModule("informacion");
		menu.setSection("disposiciones");
		
		ArrayList<?> arrayAllType = objDispositionsRepository.allType();
		ArrayList<?> arrayAllArea = objDispositionsRepository.allArea();
		
		if (request.getQueryString() != null) {
			
			String urlApi = Helper.getServerApiResoluciones( "resolucion?" + request.getQueryString() );
			
			try {
				CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		        HttpResponse httpResponse = null;
	
		        HttpGet httpGet = new HttpGet(urlApi);
	
		        httpGet.addHeader("content-type", "application/json");
	            httpGet.addHeader("token-CSRF", AES.encrypt("default")  );
	
	            httpResponse = httpClient.execute(httpGet);
	            
	            int code = httpResponse.getStatusLine().getStatusCode();
	
	            String response = EntityUtils.toString( httpResponse.getEntity());
	            httpClient.close();
	            res.setStatus(code); 
	            
	            ObjectMapper objectMapper = new ObjectMapper();
				Object objRes = objectMapper.readValue(response, Object.class);
				
				
	            Map<ArrayList<?>, Object> arrayRes = (Map<ArrayList<?>, Object>) objRes;
	            ArrayList<Object> listRes = ((ArrayList<Object>) arrayRes.get("datos"));
	           
	            
	            int totalResultados = Integer.parseInt(arrayRes.get("total_resultados").toString());
	            int total = Integer.parseInt(arrayRes.get("total_paginas").toString());
	    		int actual = Integer.parseInt(arrayRes.get("pag_actual").toString());
	    		
	    		
	    		String getQueryString = request.getQueryString();
	    		
	    		String[] splitParamQuery = getQueryString.split("&", -1);
	    		String url = "";
	    		
	    		
	    		Map<String, String> tagMap = new HashMap<String, String>();

	    		if(splitParamQuery.length > 0) {
	    			
	    			for (String str : splitParamQuery) {
	    				String[] val = str.split("=",-1);
	    				
	    				if(!val[1].isEmpty() && !val[0].equals("pag")) {
                            url += val[0] + '=' + val[1] + '&';
                            if(!val[0].equals("orderby") && !val[0].equals("orden")) {
                                tagMap.put(val[0], val[1]);
                            }
	    				}
	    				
	    			}
	    			
	    			url = url.substring(0, url.length() - 1);
	    			url = "disposiciones" + '?' + url;
	    			
	    		}

    			if(listRes.size() > 0) model.addAttribute("datos", listRes);
	    		model.addAttribute("totalResultados", totalResultados);
	    		model.addAttribute("total", total);
	    		model.addAttribute("actual", actual);
	    		
	    		model.addAttribute("urlPag", url);
	    		model.addAttribute("tags", tagMap);
	            
			} catch (Exception ex) {
			    // handle exception here
			}
		}
		
		
		
		model.addAttribute("type", arrayAllType);
		model.addAttribute("area", arrayAllArea);
		model.addAttribute("anioActual", Calendar.getInstance().get(Calendar.YEAR));
		model.addAttribute("menu", menu);
		return help.vistaWeb("information/dispositions");
		
	}
	 
}

