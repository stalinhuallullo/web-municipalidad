package pe.gob.munisantanita.Website.Web.Base.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class F {

	public static double getRandom(double min, double max){
	    double x = (Math.random()*((max-min)+1))+min;
	    return x;
	}
	
	public static String getTimeStamp() {
	    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
	}
	

	public static HttpResponse post(String Uri, String json) {
		try {
			
			CloseableHttpClient httpClient = HttpClientBuilder.create().build();
	        HttpResponse httpResponse = null;
	        
	        HttpPost httpPost = new HttpPost(Uri);

	        httpPost.addHeader("content-type", "application/json");
	        //httpPost.addHeader("token-CSRF", AES.encrypt("default")  );
            
	        //httpPost.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	        //httpPost.setHeader("Pragma", "no-cache");
	        //httpPost.setHeader("Expires", "0");
	        
	        if(json != null) httpPost.setEntity(new StringEntity(json));
            httpResponse = httpClient.execute(httpPost);
            return httpResponse;
            
		} catch (Exception ex) {
		    // handle exception here
		} finally {
			
		}
		
		return null;
	}
	
	

	public static HttpResponse get(String Uri) {
		try {
			
			CloseableHttpClient httpClient = HttpClientBuilder.create().build();
	        HttpResponse httpResponse = null;
	        
	        HttpGet httpGet = new HttpGet(Uri);

	        httpGet.addHeader("content-type", "application/json");
	        //httpGet.addHeader("token-CSRF", AES.encrypt("default")  );
            
	        /*httpGet.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	        httpGet.setHeader("Pragma", "no-cache");
	        httpGet.setHeader("Expires", "0");*/
	        

            httpResponse = httpClient.execute(httpGet);
            return httpResponse;
           
		} catch (Exception ex) {
		    // handle exception here
		} finally {
			
		}
		
		return null;
	}
	
	
	public static HttpResponse put(String Uri, String json) {
		try {
			
			CloseableHttpClient httpClient = HttpClientBuilder.create().build();
	        HttpResponse httpResponse = null;
	        
	        
	        HttpPut httpPut = new HttpPut(Uri);

	        httpPut.addHeader("content-type", "application/json");
	        /*httpPut.addHeader("token-CSRF", AES.encrypt("default")  );
            
	        httpPut.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	        httpPut.setHeader("Pragma", "no-cache");
	        httpPut.setHeader("Expires", "0");*/
	        
	        if(json != null) httpPut.setEntity(new StringEntity(json));
	        
            httpResponse = httpClient.execute(httpPut);
            return httpResponse;
            
		} catch (Exception ex) {
		    // handle exception here
		} finally {
			
		}
		
		return null;
	}

	public static HttpResponse delete(String Uri) {
		try {
			
			CloseableHttpClient httpClient = HttpClientBuilder.create().build();
	        HttpResponse httpResponse = null;
	        
	        
	        HttpDelete httpDelete = new HttpDelete(Uri);

	        httpDelete.addHeader("content-type", "application/json");
	        /*httpDelete.addHeader("token-CSRF", AES.encrypt("default")  );
            
	        httpDelete.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	        httpDelete.setHeader("Pragma", "no-cache");
	        httpDelete.setHeader("Expires", "0");*/

            httpResponse = httpClient.execute(httpDelete);
            return httpResponse;
            
		} catch (Exception ex) {
		    // handle exception here
		} finally {
			
		}
		
		return null;
	}
	
}
