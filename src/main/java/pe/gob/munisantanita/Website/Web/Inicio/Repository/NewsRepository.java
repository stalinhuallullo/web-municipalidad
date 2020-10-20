package pe.gob.munisantanita.Website.Web.Inicio.Repository;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import pe.gob.munisantanita.Website.Web.Base.Utils.F;
import pe.gob.munisantanita.Website.Web.Base.Utils.Helper;

@Repository("InicioNewsRepository")
public class NewsRepository {

	public Object news(int quantity) {

		
        try {
			HttpResponse httpResponse = F.get(Helper.getServerApiNoticias("noticia?mostrar="+quantity));
			ObjectMapper objectMapper = new ObjectMapper();
			String r = EntityUtils.toString( httpResponse.getEntity());
			Object lista = objectMapper.readValue(r, Object.class);
			
			return lista;
    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.print("catch catch  => " + e.getMessage());
			e.printStackTrace();
		}
		
		 return null;
	}
	
}
