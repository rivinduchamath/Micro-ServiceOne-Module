/**
 * @author - Chamath_Wijayarathna
 * Date :6/13/2022
 */


package lk.sliit.mtit.ecommerce.cart.configarations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrossHandle{
//
//    @Bean
//    public WebMvcConfigurer corsConfigure(){
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                WebMvcConfigurer.super.addCorsMappings(registry);
//                registry.addMapping("/**")
//                        .allowedOrigins("*")
//                        .allowedMethods("GET", "POST", "PUT", "DELETE","PATCH");
//            }
//        };
//    }

}
