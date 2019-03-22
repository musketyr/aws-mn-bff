package lambda.function;

import io.micronaut.context.env.Environment;
import io.micronaut.function.FunctionBean;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@FunctionBean("lambda-function")
public class LambdaFunctionFunction implements Supplier<String> {

    private final Environment environment;

    public LambdaFunctionFunction(Environment environment) {
        this.environment = environment;
    }

    @Override
    public String get() {
        return String.join(",", environment.getActiveNames());
    }
}
