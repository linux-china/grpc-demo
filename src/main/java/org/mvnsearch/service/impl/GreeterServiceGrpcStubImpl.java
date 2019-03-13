package org.mvnsearch.service.impl;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.mvnsearch.service.GreeterGrpc;
import org.mvnsearch.service.GreeterService;
import org.mvnsearch.service.HelloReply;
import org.mvnsearch.service.HelloRequest;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * greeter service grpc stub impl
 *
 * @author linux_china
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@GRpcService
public class GreeterServiceGrpcStubImpl extends GreeterGrpc.GreeterImplBase {
    @Autowired
    private GreeterService greeterService;

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        greeterService.sayHello(request.getName())
                .map(s -> HelloReply.newBuilder().setMessage(s).build())
                .doFinally(signalType -> responseObserver.onCompleted())
                .subscribe(responseObserver::onNext);
    }

    @Override
    public void sayHelloAgain(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        greeterService.sayHelloAgain(request.getName())
                .map(s -> HelloReply.newBuilder().setMessage(s).build())
                .doFinally(signalType -> responseObserver.onCompleted())
                .subscribe(responseObserver::onNext);
    }
}
