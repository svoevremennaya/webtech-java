package client.view;

import client.view.impl.IllegalArgumentsResponseProcessor;
import client.view.impl.InternalFailureResponseProcessor;
import client.view.impl.NoSuchCommandResponseProcessor;
import client.view.impl.SuccessResponseProcessor;
import domain.response.ResponseCode;

import java.util.HashMap;
import java.util.Map;

public class ResponseProcessorFactory {
    private static final Map<ResponseCode, ResponseProcessor> processors;

    private ResponseProcessorFactory() {
    }

    static {
        processors = new HashMap<>();
        processors.put(ResponseCode.SUCCESS, new SuccessResponseProcessor());
        processors.put(ResponseCode.NO_SUCH_COMMAND, new NoSuchCommandResponseProcessor());
        processors.put(ResponseCode.INTERNAL_FAILURE, new InternalFailureResponseProcessor());
        processors.put(ResponseCode.ILLEGAL_ARGUMENTS, new IllegalArgumentsResponseProcessor());
    }

    public static Map<ResponseCode, ResponseProcessor> getResponseProcessors() {
        return new HashMap<>(processors);
    }
}
