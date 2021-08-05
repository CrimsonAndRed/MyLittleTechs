package my.little.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import my.little.model.admin.RequestCount;
import my.little.service.RequestCounter;

import javax.inject.Inject;

@Controller("/admin")
public class AdminController {

    @Inject
    RequestCounter requestCounter;

    @Get(uri = "/requests")
    public RequestCount count() {
        return new RequestCount(requestCounter.count());
    }
}
