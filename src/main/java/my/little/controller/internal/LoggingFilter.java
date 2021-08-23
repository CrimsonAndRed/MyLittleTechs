package my.little.controller.internal;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Filter;
import io.micronaut.http.filter.FilterChain;
import io.micronaut.http.filter.HttpFilter;
import io.micronaut.http.filter.OncePerRequestHttpServerFilter;
import io.micronaut.http.filter.ServerFilterChain;
import io.reactivex.Flowable;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This filter logs each request.
 */
@Filter(Filter.MATCH_ALL_PATTERN)
public class LoggingFilter extends OncePerRequestHttpServerFilter {

    private final static Logger log = LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    protected Publisher<MutableHttpResponse<?>> doFilterOnce(HttpRequest<?> request, ServerFilterChain chain) {
        log.info("Received request: {}", request.getPath());
        return Flowable.fromPublisher(chain.proceed(request))
                .doOnNext(it -> log.info("Finished request with status: {}", it.getStatus().getCode()));
    }
}
