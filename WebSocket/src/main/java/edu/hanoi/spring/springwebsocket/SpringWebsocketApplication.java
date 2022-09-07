package edu.hanoi.spring.springwebsocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "edu.hanoi.spring.springwebsocket",
        "edu.hanoi.spring.springwebsocket.controller"
})
public class SpringWebsocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebsocketApplication.class, args);
    }

}
