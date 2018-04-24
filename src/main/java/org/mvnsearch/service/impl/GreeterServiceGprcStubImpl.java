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
@GRpcService
public class GreeterServiceGprcStubImpl extends GreeterGrpc.GreeterImplBase {
    @Autowired
    private GreeterService greeterService;

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        HelloReply reply = HelloReply.newBuilder().setMessage(greeterService.sayHello(request.getName())).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void sayHelloAgain(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        HelloReply reply = HelloReply.newBuilder().setMessage(greeterService.sayHelloAgain(request.getName())).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
