package pe.gob.munisantanita.Website.Web.News.Repository;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import pe.gob.munisantanita.Website.Web.Base.Utils.F;
import pe.gob.munisantanita.Website.Web.Base.Utils.Helper;

@Repository("NewsRepository")
public class NewsRepository {
	
	public Object newsByCategories(String category, int quantity) {

		
        try {
			HttpResponse httpResponse = F.get(Helper.getServerApiNoticias("noticia/categoria/" + category + "?pag=1&mostrar=" + quantity));
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
	
	
	public Object findByNewsForCategory(String category, String pag) {
		try {
			pag = (pag == null) ? "1" : pag; 
			HttpResponse httpResponse = F.get(Helper.getServerApiNoticias("noticia/categoria/" + category + "?pag=" + pag + "&mostrar=12"));
			ObjectMapper objectMapper = new ObjectMapper();
			String r = EntityUtils.toString( httpResponse.getEntity());
			Object lista = objectMapper.readValue(r, Object.class);
			return lista;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Object findByNews(String slug){
		try {
			HttpResponse httpResponse = F.get(Helper.getServerApiNoticias("noticia/slug/" + slug));
			ObjectMapper objectMapper = new ObjectMapper();
			String r = EntityUtils.toString( httpResponse.getEntity());
			Object lista = objectMapper.readValue(r, Object.class);
			return lista;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
