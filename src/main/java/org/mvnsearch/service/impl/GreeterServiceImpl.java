package org.mvnsearch.service.impl;

import org.mvnsearch.service.GreeterService;
import org.springframework.stereotype.Service;

/**
 * greeter service implementation
 *
 * @author linux_china
 */
@Service
public class GreeterServiceImpl implements GreeterService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }

    @Override
    public String sayHelloAgain(String name) {
        return "Hello Again" + name;
    }
}
