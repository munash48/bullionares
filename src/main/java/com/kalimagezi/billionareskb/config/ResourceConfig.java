package com.kalimagezi.billionareskb.config;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ResourceConfig implements WebMvcConfigurer {
	
	public void addResourceHandler(final ResourceHandlerRegistry registry) {
		
		Path currentPath = Paths.get(".");
		Path absolutePath = currentPath.toAbsolutePath();
		registry.addResourceHandler("/uploads/**").addResourceLocations("file:///"+absolutePath+"/uploads/");
	}
	
}
