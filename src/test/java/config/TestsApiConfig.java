package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import business.api.UserControllerMock;
import business.controllers.UserController;

@Configuration
@ComponentScan(basePackages = {ResourceNames.REST_API, ResourceNames.CONTROLLERS})
public class TestsApiConfig {

    @Bean
    public UserController userController() {
        return new UserControllerMock();
    }

}
