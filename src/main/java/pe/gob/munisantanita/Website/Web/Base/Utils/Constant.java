package pe.gob.munisantanita.Website.Web.Base.Utils;

import org.springframework.stereotype.Component;

@Component
public class Constant {
	
	// BASE URL
	//  http://190.12.74.214/
	//  http://172.16.36.244/
	//	https://www.munisantanita.gob.pe/
	//public static final String BASE_URL = "http://localhost:8585/";
	public static final String BASE_URL = "https://www.munisantanita.gob.pe/";
	
	public static final String BASE_URL_PP = "http://172.16.36.20/";
	public static final String BASE_URL_API = BASE_URL_PP;// + "api/";
	

	// SERVIDOR
	public static final String SERVER_API_BASE_URL = BASE_URL;
	
	
	// SERVER API
	public static final String SERVER_API_RECURSOS = SERVER_API_BASE_URL + "data/web/";
	public static final String SERVER_API_DATA_WEB = SERVER_API_BASE_URL + "data/web/";
	public static final String SERVER_API_DATA_WEB_IMG_NOTICIAS = SERVER_API_DATA_WEB + "noticias/galeria/";
	public static final String SERVER_API_DATA_WEB_IMG_EVENTOS = SERVER_API_DATA_WEB + "eventos/galeria/";
	public static final String SERVER_API_PDF = SERVER_API_RECURSOS + "pdf/resoluciones/";
	public static final String SERVER_API_NOTICIAS = BASE_URL_API + "MicroservicioNoticias/";
	public static final String SERVER_API_RESOLUCIONES = BASE_URL_API + "MicroservicioResoluciones/";
	public static final String SERVER_API_EVENTOS = BASE_URL_API + "MicroservicioEventos/";
	
	
	// PAGES
	public static final String PAGE_INFO = BASE_URL + "info/"; //BASE_URL + "info/";
	//public static final String PAGE_INFO = "http://172.16.36.244:8080/info/";
	
	
	// RECURSOS
	public static final String ASSETS = BASE_URL + "cdn/web/";
	public static final String ASSETS_CSS = BASE_URL + "cdn/web/css/";
	public static final String ASSETS_JSC = BASE_URL + "cdn/web/jsc/";
	public static final String ASSETS_IMG = SERVER_API_BASE_URL + "data/web/recursos/";
	public static final String ASSETS_IMG_DEFAUT = SERVER_API_BASE_URL + "data/web/recursos/default.jpg";
	public static final String ASSETS_IMG_DEFAUT_HOMBRE = SERVER_API_BASE_URL + "data/web/recursos/default-hombre.png";
	public static final String ASSETS_IMG_DEFAUT_MUJER = SERVER_API_BASE_URL + "data/web/recursos/default-mujer.png";
	public static final String ASSETS_VEN = BASE_URL + "cdn/web/vendors/";
	
	
	// Vistas
	public static final String VISTA_ADMIN = "admin/pages/";
	public static final String VISTA_WEB = "web/pages/";
	
	
	// KEY
	public static final String LLAVE_ENCRIPTACION = "FWMA$wg<6&LRYd=Q";
	
	
	
	

	
	//public static final String DIR_UPLOAD_RESOLUCIONES_ARCHIVOS = "/web/usuarios/avatares/";
	//public static final String RESOLUCIONES_ARCHIVOS = System.getProperty("jboss.server.data.dir") + DIR_UPLOAD_RESOLUCIONES_ARCHIVOS;
	
}