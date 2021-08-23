package my.little.service;

import io.micronaut.runtime.context.scope.Refreshable;

import javax.annotation.PostConstruct;
import java.util.concurrent.atomic.AtomicLong;

@Refreshable
public class RequestCounter {

    private AtomicLong count;

    @PostConstruct
    private void init() {
        count = new AtomicLong(0L);
    }

    public Long count() {
        return count.get();
    }

    public void inc() {
        count.getAndAdd(1);
    }
}
