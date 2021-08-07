package my.little.controller.internal;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Error;
import io.netty.util.internal.ThrowableUtil;
import my.little.model.internal.ErrorResult;
import my.little.service.ErrorSequence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.time.Instant;

@Controller
public class ErrorHandler {

    private static final Logger log = LoggerFactory.getLogger(ErrorHandler.class);

    @Inject
    private ErrorSequence errorSequence;

    @Error(global = true)
    public HttpResponse<ErrorResult> error(HttpRequest<?> request, Throwable e) {
        String message = e.getMessage();
        String trace = ThrowableUtil.stackTraceToString(e);
        Long errorId = errorSequence.next();
        Instant time = Instant.now();
        ErrorResult error = new ErrorResult(message, trace, errorId, time);

        log.error("Error in endpoint: " + request.getPath() + "; with id: " + errorId + ":");
        log.error(trace);

        return HttpResponse.<ErrorResult>serverError()
                .body(error);
    }
}
