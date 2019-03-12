package org.mvnsearch.service.reactive;

import io.grpc.Server;
import io.grpc.ServerBuilder;

/**
 * Reactor services server
 *
 * @author linux_china
 */
public class ReactorServicesServer {
    
    public static void main(String[] args) throws Exception {
        // Start the server
        Server server = ServerBuilder.forPort(8888).addService(new ReactiveGreeterServiceImpl()).build().start();
        server.awaitTermination();
    }
}
