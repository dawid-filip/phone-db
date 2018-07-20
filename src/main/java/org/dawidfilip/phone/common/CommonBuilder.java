package org.dawidfilip.phone.common;

import org.dawidfilip.phone.app.configuration.ApplicationBeanConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class CommonBuilder {
	public static final AbstractApplicationContext CONTEXT = new AnnotationConfigApplicationContext(ApplicationBeanConfiguration.class); 
}
