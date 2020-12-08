package com.mycompany.dvdStore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mycompany.dvdStore.controller.MovieController;


/**
 * Hello world!
 *
 */

@Configuration
@ComponentScan(basePackages = {"com.mycompany.dvdStore.controller","com.mycompany.dvdStore.repository.file","com.mycompany.dvdStore.service"})
@PropertySource("classpath:application.properties")
public class App 
{
    public static void main( String[] args )
    {
    	//ApplicationContext  context= new  ClassPathXmlApplicationContext("applicationContext.xml");
    	ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
    	MovieController movieController = context.getBean(MovieController.class);
    	
    	movieController.addUsingConsole();
    	
    	/*MovieController movieController = new MovieController();
    	FileMovieRepository movieRepo= new FileMovieRepository();
    	DefaultMovieService movieService = new DefaultMovieService();
    	movieService.setMovieRepository(movieRepo);
    	movieController.setMovieService(movieService);
    	movieController.addUsingConsole();*/
    }
}
