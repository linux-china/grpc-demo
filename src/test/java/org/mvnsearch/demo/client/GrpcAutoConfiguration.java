package org.mvnsearch.demo.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.mvnsearch.service.GreeterGrpc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.TimeUnit;

/**
 * gRPC auto configuration
 *
 * @author linux_china
 */
@Configuration
public class GrpcAutoConfiguration {
    private ManagedChannel channel;

    @PostConstruct
    public void init() {
        channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid needing certificates.
                .usePlaintext(true).build();
    }

    @PreDestroy
    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    @Bean
    public GreeterServiceClient greeterServiceClient() {
        return new GreeterServiceClient(GreeterGrpc.newBlockingStub(channel));
    }
}
