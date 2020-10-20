package pe.gob.munisantanita.Website.Web.Eventos.Repository;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import groovyjarjarcommonscli.ParseException;
import pe.gob.munisantanita.Website.Web.Base.Utils.F;
import pe.gob.munisantanita.Website.Web.Base.Utils.Helper;

//import pe.gob.munisantanita.Base.Utils.F;
//import pe.gob.munisantanita.Base.Utils.Helper;


@Repository("EventoRepository")
public class EventosRepository {

	public Object all() {

        try {
       	 
   		 HttpResponse httpResponse = F.get(Helper.getServerApiEventos("evento"));
   		 ObjectMapper objectMapper = new ObjectMapper();
   		 String r = EntityUtils.toString( httpResponse.getEntity());
   		 Object lista = objectMapper.readValue(r, Object.class);
            return lista;
            
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return null;
	}
	
	public ArrayList<?> allCategory() {

        try {
       	 
   		 HttpResponse httpResponse = F.get(Helper.getServerApiEventos("categoria"));
   		 ObjectMapper objectMapper = new ObjectMapper();
   		 String r = EntityUtils.toString( httpResponse.getEntity());
   		ArrayList<?> lista = objectMapper.readValue(r, ArrayList.class);
            return lista;
            
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return null;
	}
	
	public Object showCategory(String category, String pag) {

        try {
			pag = (pag == null) ? "1" : pag; 
			HttpResponse httpResponse = F.get(Helper.getServerApiEventos("evento?categorias=" + category + "&pag=" + pag + "&mostrar=12"));
			ObjectMapper objectMapper = new ObjectMapper();
			String r = EntityUtils.toString( httpResponse.getEntity());
			Object lista = objectMapper.readValue(r, Object.class);
			return lista;
            
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return null;
	}
	
	public Object showNameCategory(String slug) {

        try {
        	
			HttpResponse httpResponse = F.get(Helper.getServerApiEventos("categoria/slug/" + slug));
			ObjectMapper objectMapper = new ObjectMapper();
			String r = EntityUtils.toString( httpResponse.getEntity());
			Object lista = objectMapper.readValue(r, Object.class);
			return lista;
            
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return null;
	}
	
	public Object categoria(String category, int quantity) {

         try {
        	 
    		 HttpResponse httpResponse = F.get(Helper.getServerApiEventos("evento?categorias=" + category + "&pag=1&mostrar=" + quantity));
    		 ObjectMapper objectMapper = new ObjectMapper();
    		 String r = EntityUtils.toString( httpResponse.getEntity());
    		 Object lista = objectMapper.readValue(r, Object.class);
             return lista;
             
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return null;
	}
		
	public Object show(String id) {

        try {
        	
			HttpResponse httpResponse = F.get(Helper.getServerApiEventos("evento/" + id));
			ObjectMapper objectMapper = new ObjectMapper();
			String r = EntityUtils.toString( httpResponse.getEntity());
			Object lista = objectMapper.readValue(r, Object.class);
			return lista;
            
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return null;
	}
	
}
