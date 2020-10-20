package pe.gob.munisantanita.Website.Web.Inicio.Repository;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import pe.gob.munisantanita.Website.Web.Base.Utils.F;
import pe.gob.munisantanita.Website.Web.Base.Utils.Helper;

@Repository("InicioEventosRepository")
public class EventosRepository {

	public Object categoria(String category, int quantity) {

        try {
			HttpResponse httpResponse = F.get(Helper.getServerApiEventos( "evento?categorias=" + category + "&pag=1&mostrar=" + quantity ));
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
	
	public Object todos(int quantity) {

        try {
			HttpResponse httpResponse = F.get(Helper.getServerApiEventos( "evento?mostrar=" + quantity ));
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
