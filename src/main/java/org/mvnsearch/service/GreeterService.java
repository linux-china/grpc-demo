package org.mvnsearch.service;

import reactor.core.publisher.Mono;

/**
 * greeter service
 *
 * @author linux_china
 */
public interface GreeterService {

    /**
     * say hello
     *
     * @param name name
     * @return message
     */
    Mono<String> sayHello(String name);

    Mono<String> sayHelloAgain(String name);
}
