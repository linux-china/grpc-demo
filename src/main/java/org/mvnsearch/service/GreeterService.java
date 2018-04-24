package org.mvnsearch.service;

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
    String sayHello(String name);

    String sayHelloAgain(String name);
}
