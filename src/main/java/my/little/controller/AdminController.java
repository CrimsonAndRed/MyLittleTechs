package my.little.controller;

import io.micronaut.context.event.ApplicationEventPublisher;
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
    private ApplicationEventPublisher eventPublisher;

    @Inject
    private RequestCounter requestCounter;

    /**
     * This request is showing RequestCounter state.
     */
    @Get(uri = "/requests")
    public RequestCount requests() {
        return new RequestCount(requestCounter.count());
    }

    /**
     * This request is testing Refreshable scoped beans functionality.
     */
    @Post(uri = "/refresh")
    public HttpStatus refresh() {
        RefreshEvent refreshEvent = new RefreshEvent();
        eventPublisher.publishEventAsync(refreshEvent);
        return HttpStatus.ACCEPTED;
    }
}
