package my.little.controller.internal;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Error;
import io.netty.util.internal.ThrowableUtil;
import my.little.model.internal.ErrorResult;
import my.little.service.ErrorSequence;

import javax.inject.Inject;
import java.time.Instant;

@Controller
public class ErrorHandler {

    @Inject
    private ErrorSequence errorSequence;

    @Error(global = true)
    public HttpResponse<ErrorResult> error(HttpRequest<?> request, Throwable e) {
        String message = e.getMessage();
        String trace = ThrowableUtil.stackTraceToString(e);
        Long errorId = errorSequence.next();
        Instant time = Instant.now();
        ErrorResult error = new ErrorResult(message, trace, errorId, time);

        System.out.println("Error in endpoint: " + request.getPath() + "; with id: " + errorId + ":");
        System.out.println(trace);

        return HttpResponse.<ErrorResult>serverError()
                .body(error);
    }
}
