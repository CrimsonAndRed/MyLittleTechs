package my.little.controller;

import io.micronaut.context.ApplicationContext;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.runtime.context.scope.refresh.RefreshEvent;
import my.little.model.admin.RequestCount;
import my.little.service.RequestCounter;

import javax.inject.Inject;

@Controller("/admin")
public class AdminController {

    @Inject
    private ApplicationContext applicationContext;

    @Inject
    private RequestCounter requestCounter;

    @Get(uri = "/requests")
    public RequestCount count() {
        return new RequestCount(requestCounter.count());
    }

    @Post(uri = "/refresh")
    public HttpStatus refresh() {
        RefreshEvent refreshEvent = new RefreshEvent();
        applicationContext.publishEventAsync(refreshEvent);
        return HttpStatus.ACCEPTED;
    }
}
