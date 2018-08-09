gRPC demo with Spring Boot
==========================
gRPC with Spring Boot

### Client Testing
Now I use evans for gRPC client test, please refer https://github.com/ktr0731/evans for test. the demo is in 'src/main/proto'

### Load Balance

```
    ManagedChannel channel = ManagedChannelBuilder
            .forTarget("eureka://grpc-service-1")
            .nameResolverFactory(new EurekaNameResolverProvider(eurekaClientConfig))
            .loadBalancerFactory(RoundRobinLoadBalancerFactory.getInstance())
            .usePlaintext(true)
            .build();

```

### Health checking

Please refer grpc-services-1.13.1.jar!/grpc/health/v1/health.proto and io.grpc.health.v1.HealthGrpc,
and almost you should implement HealthGrpc.HealthImplBase for health checking, please check HealthServiceImpl.java

### References

* proto3: https://developers.google.com/protocol-buffers/docs/proto3
* gRPC:  http://www.grpc.io/
* gPRC Java: http://www.grpc.io/docs/quickstart/java.html
* gRPC Java Issues: https://github.com/grpc/grpc-java/issues
* Protobuf Maven Plugin: https://www.xolstice.org/protobuf-maven-plugin/

### Java without IDL

* https://github.com/supercharger/grpc-proxy
* https://github.com/grpc/grpc/blob/master/doc/PROTOCOL-HTTP2.md
