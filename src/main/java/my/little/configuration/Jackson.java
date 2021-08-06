package my.little.configuration;

import com.fasterxml.jackson.databind.SerializationFeature;
import io.micronaut.context.event.BeanCreatedEvent;
import io.micronaut.context.event.BeanCreatedEventListener;
import io.micronaut.jackson.JacksonConfiguration;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;


@Singleton
public class Jackson implements BeanCreatedEventListener<JacksonConfiguration> {

    @Override
    public JacksonConfiguration onCreated(BeanCreatedEvent<JacksonConfiguration> event) {
        final JacksonConfiguration jc = event.getBean();
        Map<SerializationFeature, Boolean> serialization = new HashMap<>();
        serialization.put(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        jc.setSerialization(serialization);
        return jc;
    }
}
