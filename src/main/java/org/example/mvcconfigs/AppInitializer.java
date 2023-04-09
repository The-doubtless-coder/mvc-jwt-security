package org.example.mvcconfigs;

import org.springframework.core.annotation.Order;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

//import javax.servlet.Filter;

@Order(0)
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

   @Override
   protected Class<?>[] getRootConfigClasses() {
       return new Class[] {
               AppConfig.class, //
               DataSourceConfig.class, //            
               JpaConfig.class, //
               ExceptionHandlerExceptionResolver.class,//
               DataJpaConfig.class,//
               SecurityConfig.class,//   
               Jackson2ObjectMapperConfig.class,//
               MessageSourceConfig.class
       };
   }


   @Override
   protected Class<?>[] getServletConfigClasses() {
       return new Class[] {
           WebConfig.class //
           //SwaggerConfig.class
       };
   }

   @Override
   protected String[] getServletMappings() {
       return new String[] { "/" };
   }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        return new Filter[]{(Filter) encodingFilter};
    }
}