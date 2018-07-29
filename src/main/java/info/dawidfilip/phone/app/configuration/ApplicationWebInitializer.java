package info.dawidfilip.phone.app.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	 
	@Override
    protected Class<?>[] getRootConfigClasses() {
    	@SuppressWarnings("rawtypes")
		Class[] webServices = new Class[] {
    			ApplicationWebConfiguration.class
    	};
        return webServices;
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/rest/*" };
    }
 
}