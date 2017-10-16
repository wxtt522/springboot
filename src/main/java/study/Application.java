package study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by Administrator on 2017/8/16.
 */
@SpringBootApplication
@MapperScan("study.dao")
//public class Application extends SpringBootServletInitializer implements WebApplicationInitializer {
public class Application {

    /**继承后重写configure方法，同时在pom文件中添加<packaging>war</packaging>
     * 可以使用外部tomcat
     * 最骚的在于还不影响内置tomcat的使用
     */
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(Application.class);
//    }
//
//    @Bean
//    /**事实证明，@Bean可以直接写在配置类里，不需要额外context加载配置类*/
//    /**修改内置tomcat端口*/
//    public EmbeddedServletContainerFactory servletContainer(){
//        return new TomcatEmbeddedServletContainerFactory(80);
//    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

/*    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        servletContext.addListener(new ContextLoaderListener(context));

        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
        servlet.addMapping("*.htm");
//        servlet.setLoadOnStartup(2);

    }*/

}
