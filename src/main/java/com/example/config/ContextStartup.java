package com.example.config;

import com.example.interceptor.RequestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置加载拦截器
 * 两种方式:1.继承WebMvcConfigurationSupport类(webMvc自动配置失效,比如无法访问静态资源js,css等),因为WebMvc在WebMvcAutoConfiguration类中,
 *          但此类中有@ConditionalOnMissingBean{(WebMvcConfigurationSupport.class)}注解,如果继续该类,则WebMvcAutoConfiguration不加载.
 *         2.实现WebMvcConfigure接口(推荐)
 */
@Configuration
public class ContextStartup implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequestInterceptor()).addPathPatterns("/**");
    }
}
