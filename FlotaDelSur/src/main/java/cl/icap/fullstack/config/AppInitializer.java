package cl.icap.fullstack.config;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import cl.icap.fullstack.FlotaDelSurApplication;

public class AppInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(FlotaDelSurApplication.class);
	}

}
