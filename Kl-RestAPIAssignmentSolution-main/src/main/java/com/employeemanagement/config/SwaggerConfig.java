package com.employeemanagement.config;

import java.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket employeeApi() {
//		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
//				.groupName("Library-API")
//				.select().apis(RequestHandlerSelectors.basePackage("com.greatlearning.library.controller"))
//				.build();
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).groupName("Employee-API").select()
                .apis(RequestHandlerSelectors.basePackage("com.employeemanagement.controller")).build()
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, Arrays.asList(new ResponseMessageBuilder().code(500).message(
                                        "Unknown Error: Dispatcher servlet is not able to redirect this API call to any existing GET API’s in this application")
                                .build(),
                        new ResponseMessageBuilder().code(403)
                                .message("Forbidden: Contact your manager or TPM to get access to this GET API")
                                .build(),
                        new ResponseMessageBuilder().code(401).message("Fantastic you are not authorized").build(),
                        new ResponseMessageBuilder().code(400)
                                .message("Bad Request: Check the API URL or the request parameters again").build(),
                        new ResponseMessageBuilder().code(402).message("Payment is required to access this GET API")
                                .build(),
                        new ResponseMessageBuilder().code(404).message("Not Found: No such data is available").build(),
                        new ResponseMessageBuilder().code(408)
                                .message("Request Timeout: Time limit is 60 seconds for this API execution").build()))
                .globalResponseMessage(RequestMethod.POST, Arrays.asList(new ResponseMessageBuilder().code(500).message(
                                        "Unknown Error: Dispatcher servlet is not able to redirect this API call to any existing POST API’s in this application")
                                .build(),
                        new ResponseMessageBuilder().code(403)
                                .message("Forbidden: Contact your manager or TPM to get access to this POST API")
                                .build(),
                        new ResponseMessageBuilder().code(401).message("Fantastic you are not authorized").build(),
                        new ResponseMessageBuilder().code(400)
                                .message("Bad Request: Check the API URL or the request parameters again").build(),
                        new ResponseMessageBuilder().code(402).message("Payment is required to access this POST API")
                                .build(),
                        new ResponseMessageBuilder().code(404).message("Not Found: No such data is available").build(),
                        new ResponseMessageBuilder().code(408)
                                .message("Request Timeout: Time limit is 60 seconds for this API execution").build()))
                .globalResponseMessage(RequestMethod.DELETE, Arrays.asList(
                        new ResponseMessageBuilder().code(500).message(
                                        "Unknown Error: Dispatcher servlet is not able to redirect this API call to any existing DELETE API’s in this application")
                                .build(),
                        new ResponseMessageBuilder().code(403)
                                .message("Forbidden: Contact your manager or TPM to get access to this DELETE API")
                                .build(),
                        new ResponseMessageBuilder().code(401).message("Fantastic you are not authorised").build(),
                        new ResponseMessageBuilder().code(400)
                                .message("Bad Request: Check the API URL or the request parameters again").build(),
                        new ResponseMessageBuilder().code(402).message("Payment is required to access this DELETE API")
                                .build(),
                        new ResponseMessageBuilder().code(404).message("Not Found: No such data is available").build(),
                        new ResponseMessageBuilder().code(408)
                                .message("Request Timeout: Time limit is 60 seconds for this API execution").build()));

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Employee API").description("Employee API referance for developers")
                .termsOfServiceUrl("http://fakeEmployee.com")
                .contact(new Contact(" API", "http://fake.com", "fake@gmail.com"))
                .license("License").licenseUrl("http://fake.com").version("1.0").build();
    }
}
