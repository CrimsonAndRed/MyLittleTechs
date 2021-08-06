package my.little.controller.internal;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Filter;
import io.micronaut.http.filter.FilterChain;
import io.micronaut.http.filter.HttpFilter;
import my.little.service.RequestCounter;
import org.reactivestreams.Publisher;

import javax.inject.Inject;

/**
 * This filter counts each request.
 */
@Filter(Filter.MATCH_ALL_PATTERN)
public class CounterFilter implements HttpFilter {

    @Inject
    private RequestCounter requestCounter;

    @Override
    public Publisher<? extends HttpResponse<?>> doFilter(HttpRequest<?> request, FilterChain chain) {
        requestCounter.inc();
        return chain.proceed(request);
    }
}
