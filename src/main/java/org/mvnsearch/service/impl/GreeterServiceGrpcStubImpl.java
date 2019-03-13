package org.mvnsearch.service.impl;

import org.lognet.springboot.grpc.GRpcService;
import org.mvnsearch.service.HelloReply;
import org.mvnsearch.service.HelloRequest;
import org.mvnsearch.service.ReactorGreeterGrpc;
import reactor.core.publisher.Mono;

/**
 * greeter service grpc stub impl
 *
 * @author linux_china
 */
@GRpcService
public class GreeterServiceGrpcStubImpl extends ReactorGreeterGrpc.GreeterImplBase {
    @Override
    public Mono<HelloReply> sayHello(Mono<HelloRequest> request) {
        return request.map(helloRequest -> HelloReply.newBuilder().setMessage("Hello" + helloRequest.getName()).build());
    }

    @Override
    public Mono<HelloReply> sayHelloAgain(Mono<HelloRequest> request) {
        return request.map(helloRequest -> HelloReply.newBuilder().setMessage("Hello Again" + helloRequest.getName()).build());
    }
}
