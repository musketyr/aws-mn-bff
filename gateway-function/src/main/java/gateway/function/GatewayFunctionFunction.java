package gateway.function;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.context.ApplicationContext;
import io.micronaut.function.FunctionBean;

import java.util.Set;
import java.util.function.Function;

@FunctionBean("gateway-function")
public class GatewayFunctionFunction
        implements Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    private final ApplicationContext context;
    private final ObjectMapper objectMapper;

    public GatewayFunctionFunction(ApplicationContext context, ObjectMapper objectMapper) {
        this.context = context;
        this.objectMapper = objectMapper;
    }

    @Override
    public APIGatewayProxyResponseEvent apply(APIGatewayProxyRequestEvent request) {
        if ("GET".equalsIgnoreCase(request.getHttpMethod()) &&
                "/env".equalsIgnoreCase(request.getPath())) {
            try {
                Set<String> names = context.getEnvironment().getActiveNames();
                String body = objectMapper.writeValueAsString(names);
                return new APIGatewayProxyResponseEvent().withBody(body);
            } catch (JsonProcessingException e) {
                return new APIGatewayProxyResponseEvent().withStatusCode(500);
            }
        }
        return new APIGatewayProxyResponseEvent().withStatusCode(404);
    }
}
