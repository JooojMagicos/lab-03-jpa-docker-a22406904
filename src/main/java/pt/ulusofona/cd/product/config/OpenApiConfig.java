package pt.ulusofona.cd.product.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI productServiceApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Product Service API")
                        .version("v1")
                        .description("""
                                CRUD API for products, built in Laboratory 2 of \
                                Distributed Systems. Storage is in memory and is \
                                lost when the service restarts.""")
                        .contact(new Contact()
                                .name("Distributed Systems teaching team")
                                .url("https://moodle.ensinolusofona.pt/"))
                        .license(new License().name("Course material")))
                .servers(List.of(
                        new Server().url("http://localhost:8081").description("Local")));
    }
}