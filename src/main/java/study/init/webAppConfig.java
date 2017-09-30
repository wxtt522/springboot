package study.init;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import study.interceptor.logInterceptor;

/**
 * Created by Administrator on 2017/9/30.
 */
@Configuration
public class webAppConfig extends WebMvcConfigurerAdapter {

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(new logInterceptor()).addPathPatterns("/**");
            super.addInterceptors(registry);
        }
    }
