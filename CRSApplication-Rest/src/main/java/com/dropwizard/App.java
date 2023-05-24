package com.dropwizard;

/**
 * Hello world!
 *
 */

import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.flipkart.restController.*;

public class App extends Application<Configuration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
 
    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }
 
    @Override
    public void run(Configuration c, Environment e) throws Exception {
        LOGGER.info("Registering REST resources");
      //  e.jersey().register(new EmployeeRESTController(e.getValidator()));
        e.jersey().register(new AdminController());
        e.jersey().register(new ProfessorController());
        e.jersey().register(new StudentController());
        e.jersey().register(new UserController());
        e.jersey().register(new PaymentController());
    }
 
    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
}


