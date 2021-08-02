package br.com.estudo.estoquebasico.configuracao;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

    public static final String TAG_PRODUTO_CONTROLLER_V1 = "Produto";
    public static final String TAG_ESTOQUE_CONTROLLER_V1 = "Estoque";

    @Bean
    public Docket api10() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("estoque-basico-api-1.0")
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("br.com.estudo.estoquebasico.controller.v1"))
                .paths(PathSelectors.any())
                .build()
                .tags(new Tag(TAG_PRODUTO_CONTROLLER_V1, "Operações relacionadas ao cadastro de produto"),
                        new Tag(TAG_ESTOQUE_CONTROLLER_V1, "Operações relacionadas ao estoque"))
                .apiInfo(new ApiInfoBuilder()
                        .version("1.0")
                        .title("Estoque básico API")
                        .description("API de estoque básico")
                        .build());
    }

}
