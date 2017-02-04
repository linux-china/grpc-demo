package org.mvnsearch.demo.client;

import org.mvnsearch.service.GreeterGrpc;
import org.mvnsearch.service.GreeterService;
import org.mvnsearch.service.HelloRequest;

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
    public String sayHello(String name) {
        return stub.sayHello(HelloRequest.newBuilder().setName(name).build()).getMessage();
    }
}
