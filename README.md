gRPC
====
gRPC with Spring Boot

### Client Testing

Please refer GrpcAutoConfiguration for detail.

    $ grpc_cli call localhost:6565  SayHello src/main/proto/greeter.proto "name: 'world'"  --enable_ssl=false

### References

* proto3: https://developers.google.com/protocol-buffers/docs/proto3
* gRPC:  http://www.grpc.io/
* gPRC Java: http://www.grpc.io/docs/quickstart/java.html
* Protobuf Maven Plugin: https://www.xolstice.org/protobuf-maven-plugin/