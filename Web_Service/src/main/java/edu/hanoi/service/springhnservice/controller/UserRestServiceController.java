package edu.hanoi.service.springhnservice.controller;

import edu.hanoi.service.springhnservice.dao.GroupDAO;
import edu.hanoi.service.springhnservice.dao.UserDAO;
import edu.hanoi.service.springhnservice.model.Group;
import edu.hanoi.service.springhnservice.model.User;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRestServiceController {

    private static final Logger LOGGER = Logger.getLogger(UserRestServiceController.class);
    private final UserDAO userDAO;
    private final GroupDAO groupDAO;

    public UserRestServiceController(UserDAO userDAO, GroupDAO groupDAO) {
        this.userDAO = userDAO;
        this.groupDAO = groupDAO;
    }

    @GetMapping("list")
    @PreAuthorize("hasRole('ADMIN')")
    @PostFilter("hasPermission(filterObject, 'read')")
    public @ResponseBody List<User> list() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (!request.isUserInRole("ROLE_ADMIN")) {
//            throw new RuntimeException("Access Denied");
//        }
        LOGGER.info("---------------->" + authentication.getAuthorities());
        return userDAO.list();
    }

    @GetMapping("list/group")
    public Group[] listGroup() {
        return groupDAO.list().toArray(new Group[0]);
    }

    @GetMapping("{username}")
    public User get(@PathVariable("username") String username) {
        return userDAO.get(username);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public String addUser(@RequestBody User user) {
        return userDAO.insert(user);
    }

    @PutMapping
    public void update(@RequestBody User user) {
        userDAO.update(user);
    }

    @DeleteMapping("{username}")
    public void delete(@PathVariable("username") String username) {
        userDAO.delete(username);
    }
}
