package pe.gob.munisantanita.Website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class WebsiteApplication extends SpringBootServletInitializer{
	

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebsiteApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(WebsiteApplication.class, args);
	}

	
}
        