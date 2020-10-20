package pe.gob.munisantanita.Website.Web.Api;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.munisantanita.Website.Web.Base.Utils.AES;
import pe.gob.munisantanita.Website.Web.Base.Utils.F;
import pe.gob.munisantanita.Website.Web.Base.Utils.Helper;


@RestController
@RequestMapping("/api")
public class ServidorController {

	
	@PostMapping(value="/**", produces = "application/json")
	@ResponseBody
	public String post(@RequestBody(required=false) String json, HttpServletRequest request, HttpServletResponse res) {		

		String ruta = request.getRequestURI().substring(request.getContextPath().length() + "/api".length()) ; // -5 del string "/api/"
		String Uri = ruta + ( request.getQueryString() != null ? "?"+request.getQueryString() : "" );

		
         try {
        	 
    		 HttpResponse httpResponse = F.post(Helper.getServerApiBaseUrl(Uri), json);
             res.setStatus(httpResponse.getStatusLine().getStatusCode());
             
             return EntityUtils.toString( httpResponse.getEntity());
             
		} catch (ParseException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return null;
		 
	}
	
	@GetMapping(value="/**", produces = "application/json")
	@ResponseBody
	public String get(@RequestBody(required=false) String json, HttpServletRequest request, HttpServletResponse res) {		
		
		String rutaUri = "";
		String ruta = request.getRequestURI().substring(request.getContextPath().length() + "/api/".length()) ; // -5 del string "/api/"
		String Uri = ruta+"?"+request.getQueryString();

		System.out.println(ruta);
		System.out.println(Uri);
		
		
		String[] apiModulo = ruta.split("/");
		
		switch(apiModulo[0]) {
			case "resolucion":
					rutaUri = Helper.getServerApiResoluciones( Uri );
				break;
		}
	
		System.out.println("---------------Uri");
		System.out.println(rutaUri.toString());

		try {
			CloseableHttpClient httpClient = HttpClientBuilder.create().build();
	        HttpResponse httpResponse = null;

	        HttpGet httpGet = new HttpGet(rutaUri);

	        httpGet.addHeader("content-type", "application/json");
            httpGet.addHeader("token-CSRF", AES.encrypt("default")  );

            httpResponse = httpClient.execute(httpGet);
            
            int code = httpResponse.getStatusLine().getStatusCode();

            String response = EntityUtils.toString( httpResponse.getEntity());
            httpClient.close();
            res.setStatus(code); 

            return response;
 
		} catch (Exception ex) {
		    // handle exception here
		} finally {
			 
		}
		
		return null;
	}
	
	@PutMapping(value="/**", produces = "application/json")
	@ResponseBody
	public String put(@RequestBody(required=false) String json, HttpServletRequest request, HttpServletResponse res) {		

		String ruta = request.getRequestURI().substring(request.getContextPath().length() + "/api".length()) ; // -5 del string "/api/"
		String Uri = ruta + ( request.getQueryString() != null ? "?"+request.getQueryString() : "" );
	

        try {
        	 
    		 HttpResponse httpResponse = F.put(Helper.getServerApiBaseUrl(Uri), json);
             res.setStatus(httpResponse.getStatusLine().getStatusCode());
             String r = EntityUtils.toString( httpResponse.getEntity());
             
 			 System.out.println("----------------------------------------------------httpResponse: " + r);
			
			
             return r;
             
		} catch (ParseException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return null;
		
	}
	
	@DeleteMapping(value="/**", produces = "application/json")
	@ResponseBody
	public String delete(HttpServletRequest request, HttpServletResponse res) {		

		String ruta = request.getRequestURI().substring(request.getContextPath().length() + "/api".length()) ; // -5 del string "/api/"
		String Uri = ruta + ( request.getQueryString() != null ? "?"+request.getQueryString() : "" );
	

        try {
        	 
    		 HttpResponse httpResponse = F.delete(Helper.getServerApiBaseUrl(Uri));
             res.setStatus(httpResponse.getStatusLine().getStatusCode());
             String r = EntityUtils.toString( httpResponse.getEntity());
             
             return r;
             
		} catch (ParseException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return null;
		
	}
	
}
