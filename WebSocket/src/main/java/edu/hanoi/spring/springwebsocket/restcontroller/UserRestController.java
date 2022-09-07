package edu.hanoi.spring.springwebsocket.restcontroller;

import edu.hanoi.spring.springwebsocket.dao.UserDAO;
import edu.hanoi.spring.springwebsocket.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserRestController {

    private final UserDAO userDAO;


    public UserRestController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping("list")
    public ResponseEntity<List<User>> list() {
        return new ResponseEntity<>(userDAO.list(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody User user) {
        return new ResponseEntity<>(userDAO.insert(user), HttpStatus.CREATED);
    }

    @DeleteMapping("{username}")
    public void delete(@PathVariable("username") String username) {
       userDAO.delete(username);
    }

    @PutMapping
    public void update(@RequestBody User user) {
        userDAO.update(user);
    }

}
