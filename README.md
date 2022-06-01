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

* target: the compliant URI for NameResolver. URL can contains gRPC service name

```
class XdsNameResolverProvider extends NameResolverProvider {
     
     public XdsNameResolver newNameResolver(URI targetUri, Args args) { 
     
     }
 }
```

### Health check

Please refer grpc-services-1.13.1.jar!/grpc/health/v1/health.proto and io.grpc.health.v1.HealthGrpc,
and almost you should implement HealthGrpc.HealthImplBase for health checking, please check HealthServiceImpl.java
```
$ cd src/main/health-check
$ evans
```

### TLS

Please consider to use mkcert for testing

```
 grpc:
    security:
      cert-chain: classpath:cert/server-cert.pem
      private-key: file:../grpc-spring-boot-starter-demo/src/test/resources/cert/server-key.pem
```

### Reactive gPRC

Reactive programming with grpc-java: https://github.com/salesforce/reactive-grpc

### References

* gRPC Wire format(gRPC over HTTP2): https://github.com/grpc/grpc/blob/master/doc/PROTOCOL-HTTP2.md
* proto3: https://developers.google.com/protocol-buffers/docs/proto3
* gRPC:  http://www.grpc.io/
* gPRC Java: http://www.grpc.io/docs/quickstart/java.html
* gRPC Java Issues: https://github.com/grpc/grpc-java/issues
* Protobuf Maven Plugin: https://www.xolstice.org/protobuf-maven-plugin/
* Protoc plugin for bringing together Kotlin, Protobuf, Coroutines, and gRPC: https://github.com/marcoferrer/kroto-plus
* gRPC Load Balancing: https://grpc.io/blog/loadbalancing/ https://github.com/makdharma/grpc-zookeeper-lb/blob/master/examples/src/main/java/io/grpc/examples/helloworld/HelloWorldClient.java
* Protocol Buffers Well-Known Types: https://developers.google.cn/protocol-buffers/docs/reference/google.protobuf

### Java without IDL

* https://github.com/supercharger/grpc-proxy
* https://github.com/grpc/grpc/blob/master/doc/PROTOCOL-HTTP2.md
* gRPC semantics: https://github.com/grpc/grpc/blob/ea6facf634569727b0e44099d66e9fba1046019d/doc/PROTOCOL-SEMANTICS.md
* gRPC: Up and Running: https://learning.oreilly.com/library/view/grpc-up-and/9781492058328/

### Tools

* evans: more expressive universal gRPC client - https://github.com/ktr0731/evans 
* BloomRPC: GUI Client for GRPC Services - https://github.com/bloomrpc/bloomrpc
* gRPCurl: Like cURL, but for gRPC - https://github.com/fullstorydev/grpcurl