package pe.gob.munisantanita.Website.Web.News.Repository;

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


@Repository("CategoriaRepository")
public class CategoryRepository {


	public ArrayList<?> all() {

         try {
        	 
    		 HttpResponse httpResponse = F.get(Helper.getServerApiNoticias("categoria"));
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
	
	public Object show(String slug) {

        try {
        	
			HttpResponse httpResponse = F.get(Helper.getServerApiNoticias("categoria/" + slug));
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
	
	public Object showCategory(String slug) {

        try {
        	
			HttpResponse httpResponse = F.get(Helper.getServerApiNoticias("categoria/slug/" + slug));
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
