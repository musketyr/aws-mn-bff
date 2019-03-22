package lambda.function;

import io.micronaut.function.client.FunctionClient;
import io.reactivex.Single;

import javax.inject.Named;

@FunctionClient
public interface LambdaFunctionClient {

    @Named("lambda-function")
    Single<String> index();

}
