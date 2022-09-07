package edu.hanoi.spring.springwebsocket.restcontroller;

import edu.hanoi.spring.springwebsocket.dao.GroupDAO;
import edu.hanoi.spring.springwebsocket.model.Group;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {

    private final GroupDAO groupDAO;

    public GroupController(GroupDAO groupDAO) {
        this.groupDAO = groupDAO;
    }

    @GetMapping("list")
    public ResponseEntity<List<Group>> list() {
        return new ResponseEntity<>(groupDAO.list(), HttpStatus.OK);
    }
}
