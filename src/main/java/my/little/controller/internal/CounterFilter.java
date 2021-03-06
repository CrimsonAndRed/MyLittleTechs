package my.little.controller.internal;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Filter;
import io.micronaut.http.filter.FilterChain;
import io.micronaut.http.filter.HttpFilter;
import io.micronaut.http.filter.OncePerRequestHttpServerFilter;
import io.micronaut.http.filter.ServerFilterChain;
import my.little.service.RequestCounter;
import org.reactivestreams.Publisher;

import javax.inject.Inject;

/**
 * This filter counts each request.
 */
@Filter(Filter.MATCH_ALL_PATTERN)
public class CounterFilter extends OncePerRequestHttpServerFilter {

    @Inject
    private RequestCounter requestCounter;

    @Override
    protected Publisher<MutableHttpResponse<?>> doFilterOnce(HttpRequest<?> request, ServerFilterChain chain) {
        requestCounter.inc();
        return chain.proceed(request);
    }
}
