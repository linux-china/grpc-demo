package org.mvnsearch.service.impl;

import org.mvnsearch.service.GreeterService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * greeter service implementation
 *
 * @author linux_china
 */
@Service
public class GreeterServiceImpl implements GreeterService {

    @Override
    public Mono<String> sayHello(String name) {
        return Mono.just("Hello " + name);
    }

    @Override
    public Mono<String> sayHelloAgain(String name) {
        return Mono.just("Hello Again" + name);
    }
}
