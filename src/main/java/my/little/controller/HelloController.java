package my.little.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import my.little.model.HelloModel;
import my.little.service.RequestCounter;

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
