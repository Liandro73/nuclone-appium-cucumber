package br.com.liandro.steps.hooks;

import br.com.liandro.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.net.MalformedURLException;

public class Hooks {

    @Before
    public void start() throws MalformedURLException {
        DriverManager.startDriver();
    }

    @After
    public void tearDown() {
        DriverManager.tearDown();
    }

}
