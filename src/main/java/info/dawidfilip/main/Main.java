package info.dawidfilip.main;

import static info.dawidfilip.phone.common.PrintBulider.*;

import java.io.IOException;

import javax.persistence.EntityManager;

//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.select.Elements;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import info.dawidfilip.dao.PhoneDAOImpl;
import info.dawidfilip.phone.app.configuration.ApplicationBeanConfiguration;
import info.dawidfilip.phone.common.PhoneBuilder;
import info.dawidfilip.phone.entity.Phone;

//@SpringBootApplication
public class Main {
	
	
	private static void typeTest(Class<?> type) {
		System.out.println(type);
		System.out.println(type.getName());
		System.out.println(type.getSimpleName());
	}
	
	public static void main(String[] args) {
		
		typeTest(Phone.class);
		
		/*String url = "http://www.mgsm.pl/pl/katalog/sony/xperiaz1c6902/Sony-Xperia-Z1-C6902.html";
		try {
			Document doc = Jsoup.connect(url).get();
			Elements elementsByClass = doc.select("div[class=large-7 medium-12 small-12 columns phonedatas]");  //doc.getElementsByClass("columns || phonedatas");   <div class="large-7 medium-12 small-12 columns phonedatas">
			System.out.println("" + elementsByClass.toString());
			
			
			
		} catch (IOException e) {
			System.out.println("error");
			e.printStackTrace();
		}*/

		
		//SpringApplication.run(Main.class, args);
		
		/*print("Starting application: '" + Main.class.getSimpleName() + "' class executing!");
		
		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class); 
		
		EntityManager phoneEntityManager = context.getBean("entityManager", EntityManager.class);
		
		PhoneTestDao phoneTestDao = context.getBean("phoneTestDao", PhoneTestDao.class);
		phoneTestDao.persist(PhoneTestBuilder.creatDummyPhoneTest());
		
		
		phoneEntityManager.getTransaction().begin();
		phoneEntityManager.persist(PhoneTestBuilder.creatDummyPhoneTest());
		phoneEntityManager.getTransaction().commit();
		
		
		phoneEntityManager.getEntityManagerFactory().close();
		phoneEntityManager.close();
		
		print("Closing application: '" + Main.class.getSimpleName() + "'!");*/
		
	}	
	
}