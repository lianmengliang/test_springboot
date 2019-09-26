package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class SpringbootSampleApplicationContext {
    public static void main( String[] args ) {

        SpringApplication.run(SpringbootSampleApplicationContext.class,args);

      /**
       * public class ServletInitializer extends SpringBootServletInitializer {
    public ServletInitializer() {
      System.out.println("初始化ServletInitializer");
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {  
        return application.sources(MyApplication.class);//MyApplication是启动类名
    }  
        }
       */

    }
}
