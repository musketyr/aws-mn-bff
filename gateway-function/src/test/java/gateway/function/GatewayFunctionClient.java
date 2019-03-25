package gateway.function;

import io.micronaut.function.client.FunctionClient;
import io.reactivex.Single;

import javax.inject.Named;

@FunctionClient
public interface GatewayFunctionClient {

    @Named("gateway-function")
    Single<String> index();

}
