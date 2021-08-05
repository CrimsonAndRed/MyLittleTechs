package my.little.service;

import io.micronaut.runtime.context.scope.Refreshable;

import javax.annotation.PostConstruct;

@Refreshable
public class RequestCounter {

    private Long count;

    @PostConstruct
    private void init() {
        count = 0L;
    }

    public Long count() {
        return count;
    }

    public void inc() {
        count += 1;
    }
}
