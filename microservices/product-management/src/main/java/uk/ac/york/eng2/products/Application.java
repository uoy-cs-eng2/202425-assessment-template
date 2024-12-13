package uk.ac.york.eng2.products;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.info.*;

@OpenAPIDefinition(
    info = @Info(
            title = "product-management",
            version = "0.0"
    )
)
public class Application {

    public static final String DATA_SOURCE = "products";

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}