package com.revature;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.model.AutowiredFlashcard;
import com.revature.model.ComponentScannedFlashcard;
import com.revature.model.ConstructorInjectionFlashcard;
import com.revature.model.Flashcard;
import com.revature.model.Topic;

public class Driver {

	public static void main(String[] args) {
		// access the ApplicationContext, the IoC container
		// AbstractApplicationContext is an abstract class which implements ApplicationContext
		// ClassPathXmlApplicationContext is a concrete class which extends AbstractApplicationContext
		// provide constructor with location of XML Spring configuration file
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		// obtain an instance of Topic bean from the AC
		// argument to getBean() refers to the name given in the Spring configuration
		// (USUALLY.. just the name of the class, in camelCase)
		Topic t = (Topic) ac.getBean("topicBean");
		System.out.println(t);
		
		//obtain an instance of Flashcard using setter injection
		Flashcard f = (Flashcard) ac.getBean("flashcard");
		System.out.println(f);
		
		//Constructor injection
		//ConstructorInjectionFlashcard c = (ConstructorInjectionFlashcard) ac.getBean("constructorInjectionFlashcard");
		//System.out.println(c);
		
		//AutowiredFlashcard a = (AutowiredFlashcard) ac.getBean("autowiredFlashcard");
		//System.out.println(a);
		
		//ComponentScannedFlashcard csf = (ComponentScannedFlashcard) ac.getBean("componentScannedFlashcard");
		//System.out.println(csf);
		
		ac.close();
		
		System.out.println(f);//Note f is still in memory but no longer availabel in the context of the Application context
	}

}