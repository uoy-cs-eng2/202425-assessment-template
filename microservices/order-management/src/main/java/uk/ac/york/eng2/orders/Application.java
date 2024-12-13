package uk.ac.york.eng2.orders;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.info.*;

@OpenAPIDefinition(
    info = @Info(
            title = "order-management",
            version = "0.0"
    )
)
public class Application {

    public static final String DATA_SOURCE = "orders";

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }

}