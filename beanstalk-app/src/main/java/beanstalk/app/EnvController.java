package beanstalk.app;

import io.micronaut.context.ApplicationContext;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.Set;

@Controller("/env")
public class EnvController {

    private final ApplicationContext applicationContext;

    public EnvController(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Get("/")
    public Set<String> index() {
        return applicationContext.getEnvironment().getActiveNames();
    }
}