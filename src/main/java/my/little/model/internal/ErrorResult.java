package my.little.model.internal;

import java.time.Instant;

public class ErrorResult {

    public ErrorResult(String message, String trace, Long id, Instant time) {
        this.message = message;
        this.trace = trace;
        this.id = id;
        this.time = time;
    }

    private String message;

    private String trace;

    private Long id;

    private Instant time;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }
}
