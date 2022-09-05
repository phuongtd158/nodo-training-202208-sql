package edu.hanoi.service.springhnservice;

import edu.hanoi.service.springhnservice.controller.UserRestServiceController;
import edu.hanoi.service.springhnservice.model.Group;
import edu.hanoi.service.springhnservice.model.User;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.ServletTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)

class WebServiceApplicationTests {

    @Autowired
    private UserRestServiceController userRestServiceController;

    private RestTemplate restTemplate;

    @Before
    public void setUp() {
        System.out.println("Before");
        HttpClientBuilder builder = HttpClientBuilder.create();
        CloseableHttpClient httpClient = builder.build();
        restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory(httpClient));
    }

//    @Test
//    void contextLoads() {
//        List<User> users = userRestServiceController.list();
//        Assert.isTrue(users.size() > 0);

//        String url = "http://localhost:8080/user/list";
//        ResponseEntity<List> userEntity = restTemplate.getForEntity(url, List.class);
//        List<User> users = userEntity.getBody();


//        String url = "http://localhost:8080/user/list/group";
//        ResponseEntity<Group[]> groupEntity = restTemplate.getForEntity(url, Group[].class);
//        Group[] groups = groupEntity.getBody();
//        Assert.assertTrue(groups.length > 0);
//
//        Arrays.stream(groups).forEach(System.out::println);

//        User user = new User();
//
//        user.setUsername("testttt");
//        user.setPassword("123");
//        user.setAge(1);
//        user.setGroupId(14);
//        user.setEmail("testtt@gmail.com");
//
//        String url = "http://localhost:8080/user/add";
//        ResponseEntity<String> insertEntity = restTemplate.postForEntity(url, user, String.class);
//        Assert.assertEquals(user.getUsername(), insertEntity.getBody());

//        restTemplate = new RestTemplate();
//        String url = "http://localhost:8080/user/test1";
//        ResponseEntity<User> getEntity = restTemplate.getForEntity(url, User.class);
//        Assert.assertEquals("test1", getEntity.getBody().getUsername());


//        String urlDelete = "http://localhost:8080/user/test1";
//        restTemplate.delete(urlDelete);
//
//        String urlGet = "http://localhost:8080/user/test1";
//        ResponseEntity<User> getEntity = restTemplate.getForEntity(urlGet, User.class);
//        Assert.assertEquals(null, getEntity.getBody());

//        restTemplate = new RestTemplate();
//        String url = "http://localhost:8080/user/testttt";
//        ResponseEntity<User> getEntity = restTemplate.getForEntity(url, User.class);
//        User user = getEntity.getBody();
//        Assert.assertNotNull(user);
//
//        user.setPassword("1111111111111");
//        url = "http://localhost:8080/user";
//        restTemplate.put(url, user);
//
//        url = "http://localhost:8080/user/testttt";
//        ResponseEntity<User> getEntity2 = restTemplate.getForEntity(url, User.class);
//        Assert.assertEquals(user.getPassword(), getEntity2.getBody().getPassword());
//    }

    @Test
    @WithMockUser(username = "admin", password = "123", roles = "{USER}")
    public void contextLoads() {
        List<User> users = userRestServiceController.list();
        Assert.assertTrue(users.size() > 0);

        users.forEach(user ->{
            Assert.assertTrue(user.getAge() > 50);
        });

    }

    @After
    public void done() {
        System.out.println("@After - executed after all test methods.");
    }

}
