package my.little.service;

import javax.inject.Singleton;

@Singleton
public class ErrorSequence {

    private Long sequence = 0L;

    public Long next() {
        return ++sequence;
    }
}
