package pe.gob.munisantanita.Website.Web.Dispositions.Repository;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import pe.gob.munisantanita.Website.Web.Base.Utils.F;
import pe.gob.munisantanita.Website.Web.Base.Utils.Helper;

@Repository("DispositionsRepository")
public class DispositionsRepository {

	public ArrayList<?> allType() {
		
		try {
       	 
   		 HttpResponse httpResponse = F.get(Helper.getServerApiResoluciones("tipo"));
   		 ObjectMapper objectMapper = new ObjectMapper();
   		 String r = EntityUtils.toString( httpResponse.getEntity());
   		 ArrayList<?> lista = objectMapper.readValue(r, ArrayList.class);
            return lista;
            
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		 return null;
		 
	}
	
	public ArrayList<?> allArea() {
		
		try {
       	 
   		 HttpResponse httpResponse = F.get(Helper.getServerApiResoluciones("area"));
   		 ObjectMapper objectMapper = new ObjectMapper();
   		 String r = EntityUtils.toString( httpResponse.getEntity());
   		 ArrayList<?> lista = objectMapper.readValue(r, ArrayList.class);
            return lista;
            
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		 return null;
		 
	}
	
}
