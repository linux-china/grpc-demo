package org.mvnsearch.service.reactive;

import org.mvnsearch.service.HelloReply;
import org.mvnsearch.service.HelloRequest;
import org.mvnsearch.service.ReactorGreeterGrpc;
import reactor.core.publisher.Mono;

/**
 * reactive greeter service implementation
 *
 * @author linux_china
 */
public class ReactiveGreeterServiceImpl extends ReactorGreeterGrpc.GreeterImplBase {
    @Override
    public Mono<HelloReply> sayHello(Mono<HelloRequest> request) {
        return request.map(helloRequest -> HelloReply.newBuilder().setMessage("Hello" + helloRequest.getName()).build());
    }

    @Override
    public Mono<HelloReply> sayHelloAgain(Mono<HelloRequest> request) {
        return request.map(helloRequest -> HelloReply.newBuilder().setMessage("Hello Again" + helloRequest.getName()).build());
    }
}
