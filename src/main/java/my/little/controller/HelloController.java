package my.little.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.netty.util.internal.logging.Slf4JLoggerFactory;
import my.little.model.HelloModel;
import my.little.service.RequestCounter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@Controller("/hello")
public class HelloController {

    @Inject
    DataSource dataSource;


    /**
     * This request is testing database connection.
     */
    @Get
    public HelloModel get() throws SQLException {
        Connection c = dataSource.getConnection();
        ResultSet results = c.prepareStatement("SELECT 43 AS id").executeQuery();
        Long num = null;
        if (results.next()) {
            num = results.getLong("id");
        }
        return new HelloModel(num);
    }


}
