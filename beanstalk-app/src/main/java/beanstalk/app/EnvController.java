package beanstalk.app;

import io.micronaut.context.ApplicationContext;
import io.micronaut.context.annotation.Value;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import javax.annotation.Nullable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@Controller("/env")
public class EnvController {

    private final ApplicationContext applicationContext;
    private final String conferenceName;
    private final String conferenceSecret;

    public EnvController(
            ApplicationContext applicationContext,
            @Nullable @Value("${conference.name}") String conferenceName,
            @Nullable @Value("${conference.secret}") String conferenceSecret
    ) {
        this.applicationContext = applicationContext;
        this.conferenceName = conferenceName;
        this.conferenceSecret = conferenceSecret;
    }

    @Get("/")
    public Set<String> index() {
        return applicationContext.getEnvironment().getActiveNames();
    }

    @Get("/conference")
    public Map<String, Object> conferenceInjected() {
        Map<String, Object> conferenceProperties = new LinkedHashMap<>();
        conferenceProperties.put("name", conferenceName);
        conferenceProperties.put("conferenceSecret", conferenceSecret);
        return conferenceProperties;
    }

}