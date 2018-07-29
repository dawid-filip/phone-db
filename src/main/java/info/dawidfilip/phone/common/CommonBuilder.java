package info.dawidfilip.phone.common;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import info.dawidfilip.phone.app.configuration.ApplicationBeanConfiguration;

public class CommonBuilder {
	public static final AbstractApplicationContext CONTEXT = new AnnotationConfigApplicationContext(ApplicationBeanConfiguration.class); 
}
