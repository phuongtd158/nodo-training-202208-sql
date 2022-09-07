package edu.hanoi.spring;

import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
@Component
public class UserService {

    @WebMethod
    public String sayHello(String name) {
        return "Hanoi java say hello to " + name;
    }

}
