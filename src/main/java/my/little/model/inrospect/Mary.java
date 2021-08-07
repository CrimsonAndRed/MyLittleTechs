package my.little.model.inrospect;

import io.micronaut.context.annotation.Executable;
import io.micronaut.core.annotation.Introspected;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Introspected
public class Mary {

    private static final Logger log = LoggerFactory.getLogger(Mary.class);

    private String name;

    private Long count;

    public Mary() {
    }

    public Mary(String name, Long count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    /**
     * Does something on this bean.
     */
    @Executable
    public void doSomething() {
        log.debug("Did something");
    }
}
