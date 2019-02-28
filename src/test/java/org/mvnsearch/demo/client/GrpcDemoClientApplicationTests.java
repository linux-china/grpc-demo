package org.mvnsearch.demo.client;

import org.junit.jupiter.api.Test;
import org.mvnsearch.service.GreeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GrpcDemoClientApplicationTests {

    @Autowired
    private GreeterService greeterService;

    @Test
    public void testSayHello() {
        System.out.println(greeterService.sayHello("Jacky"));
    }

}
