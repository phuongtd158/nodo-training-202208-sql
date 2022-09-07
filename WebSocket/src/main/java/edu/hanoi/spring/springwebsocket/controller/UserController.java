package edu.hanoi.spring.springwebsocket.controller;

import edu.hanoi.spring.springwebsocket.dao.UserDAO;
import edu.hanoi.spring.springwebsocket.model.Message;
import edu.hanoi.spring.springwebsocket.model.User;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private final UserDAO userDAO;

    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @MessageMapping("/user")
    @SendTo("/topic/chat")
    public Message add(User user) {
        String status = userDAO.insert(user);
        System.out.println("User: " + user.getUsername() + " - email: " + user.getEmail());
        return new Message("Save " + status + " successful");
    }

}
