package org.mvnsearch.demo.loadbalance;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.NameResolverRegistry;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mvnsearch.service.GreeterGrpc;
import org.mvnsearch.service.HelloRequest;
import org.mvnsearch.service.loadbalance.RSocketNameResolverProvider;

/**
 * gRPC RSocket load balance test
 *
 * @author linux_china
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GrpcRSocketLoadBalanceTest {
    private ManagedChannel managedChannel;
    private GreeterGrpc.GreeterBlockingStub greeterBlockingStub;

    @BeforeAll
    public void setUp() throws Exception {
        NameResolverRegistry registry = NameResolverRegistry.getDefaultRegistry();
        registry.register(new RSocketNameResolverProvider());
        managedChannel = ManagedChannelBuilder
                .forTarget("rsocket://127.0.0.1:9999")
                .usePlaintext()
                .build();
        greeterBlockingStub = GreeterGrpc.newBlockingStub(managedChannel);
    }

    @AfterAll
    public void tearDown() {
        managedChannel.shutdown();
    }

    @Test
    public void testLoadBalance() {
        String message = greeterBlockingStub.sayHello(HelloRequest.newBuilder().setName("Jackie").build()).getMessage();
        System.out.println(message);
    }
}
