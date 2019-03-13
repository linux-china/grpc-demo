package org.mvnsearch.demo.client;

import org.mvnsearch.service.GreeterGrpc;
import org.mvnsearch.service.GreeterService;
import org.mvnsearch.service.HelloRequest;
import reactor.core.publisher.Mono;

/**
 * greeter service client
 *
 * @author linux_china
 */
public class GreeterServiceClient implements GreeterService {
    private GreeterGrpc.GreeterBlockingStub stub;

    public GreeterServiceClient(GreeterGrpc.GreeterBlockingStub stub) {
        this.stub = stub;
    }

    public Mono<String> sayHello(String name) {
        return Mono.fromCallable(() -> stub.sayHello(HelloRequest.newBuilder().setName(name).build()).getMessage());
    }

    @Override
    public Mono<String> sayHelloAgain(String name) {
        return Mono.fromCallable(() -> stub.sayHelloAgain(HelloRequest.newBuilder().setName(name).build()).getMessage());
    }
}
