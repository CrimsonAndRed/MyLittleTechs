package my.little.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/test")
public class TestController {

    /**
     * Testing error responses.
     */
    @Get(uri = "/error")
    public void error() {
        throw new RuntimeException("My Little Exception");
    }
}
