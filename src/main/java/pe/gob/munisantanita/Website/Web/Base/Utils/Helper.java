package pe.gob.munisantanita.Website.Web.Base.Utils;

import java.text.DateFormat;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Component;


@Component
public class Helper {
	
	// BASE URL
	public static String getURL(String str) { return Constant.BASE_URL + str; }
	public static String getURLApi(String str) { return Constant.BASE_URL_API + str; }
	
	
	// SERVER API
	public static String getServerApiBaseUrl(String str) { return Constant.SERVER_API_BASE_URL + str; }
	public static String getServerApiRecursos(String str) { return Constant.SERVER_API_RECURSOS + "recursos/cdn/" + str; }
	public static String getServerApiDataWeb(String str) { return Constant.SERVER_API_RECURSOS + str; }
	public static String getServerApiPDF(String str) { return Constant.SERVER_API_PDF + str; }
	public static String getServerApiNoticias(String str) { return Constant.SERVER_API_NOTICIAS + str; }
	public static String getServerApiResoluciones(String str) { return Constant.SERVER_API_RESOLUCIONES + str; }
	public static String getServerApiEventos(String str) { return Constant.SERVER_API_EVENTOS + str; }
	public static String getServerApiImgNoticias(String str) { return Constant.SERVER_API_DATA_WEB_IMG_NOTICIAS + str; }
	public static String getServerApiImgEventos(String str) { return Constant.SERVER_API_DATA_WEB_IMG_EVENTOS + str; }
	

	
	// PAGES
	public static String getPageInfo(String str) { return Constant.PAGE_INFO + str; }
	
	
	// RECURSOS
	public static String assets(String str) { return Constant.ASSETS + str; }
	public static String assetsCss(String str) { return Constant.ASSETS_CSS + str; }
	public static String assetsJsc(String str) { return Constant.ASSETS_JSC + str; }
	public static String assetsImg(String str) { return Constant.ASSETS_IMG + str; }
	public static String assetsImgDefault() { return Constant.ASSETS_IMG_DEFAUT; }
	public static String assetsImgDefaultHombre() { return Constant.ASSETS_IMG_DEFAUT_HOMBRE; }
	public static String assetsImgDefaultMujer() { return Constant.ASSETS_IMG_DEFAUT_MUJER; }
	public static String assetsVendors(String str) { return Constant.ASSETS_VEN + str; }
	//public static String assetsPdf(String str) { return str; }

	
	// Vistas
	public static String Vista(String str) { return Constant.VISTA_ADMIN + str; }
	public static String vistaWeb(String str) { return Constant.VISTA_WEB + str; }
	
	
	
	public static String convertirFecha(String str){ 

		String reformattedStr = "";
		try {
			
			reformattedStr = (str.length() > 0) ? new SimpleDateFormat("dd MMM, yyyy").format(new SimpleDateFormat("yyyy-MM-dd").parse(str)) : "";
			
		}
		catch (ParseException e)  {
			e.printStackTrace();
		}
		
		return reformattedStr;

	}
	
	public static String convertirHora(String str) { 
	
		String reformattedStr = "";
		try {
			reformattedStr = (str.length() > 0) ? new SimpleDateFormat("hh:mm a").format(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(str)) : "";
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return reformattedStr;
	}
	
	public static String seo_url(String str){
		return Normalizer.normalize(str.toLowerCase(), Form.NFD)
	             .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
	             .replaceAll("[^\\p{Alnum}]+", "-");
	}
	
}
