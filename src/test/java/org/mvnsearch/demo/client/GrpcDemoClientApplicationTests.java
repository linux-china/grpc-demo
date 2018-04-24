package org.mvnsearch.demo.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mvnsearch.service.GreeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GrpcDemoClientApplicationTests {

    @Autowired
    private GreeterService greeterService;

    @Test
    public void testSayHello() {
        System.out.println(greeterService.sayHello("Jacky"));
    }

}
