package my.little.service;

import javax.inject.Singleton;
import java.util.concurrent.atomic.AtomicLong;

@Singleton
public class ErrorSequence {

    private final AtomicLong sequence = new AtomicLong(0L);

    public Long next() {
        return sequence.addAndGet(1);
    }
}
