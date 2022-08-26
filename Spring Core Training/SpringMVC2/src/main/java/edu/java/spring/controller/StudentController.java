package edu.java.spring.controller;

import com.fasterxml.jackson.core.util.Separators;
import edu.java.spring.dao.StudentDAO;
import edu.java.spring.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentDAO studentDAO;

    @GetMapping("list")
    public ModelAndView listStudent(@RequestParam("q") Optional<String> name) {
        ModelAndView modelAndView = new ModelAndView();

        if (name.isPresent()) {
            modelAndView.addObject("list", studentDAO.listStudentByName(name.get()));
        } else {
            modelAndView.addObject("list", studentDAO.list());
        }
        modelAndView.setViewName("student_list");
        return modelAndView;
    }

    @GetMapping("json/{id}")
    public @ResponseBody
    Student viewJson(@PathVariable("id") Integer id) {
        return studentDAO.get(id);
    }

    @GetMapping("add")
    public ModelAndView add() {
        return new ModelAndView(
                "student_form",
                "command",
                new Student());
    }

    @PostMapping("save-or-update")
    public ModelAndView saveOrUpdate(@Valid @ModelAttribute("command") Student student,
                                     BindingResult result,
                                     @RequestParam("id") Optional<Integer> id) {
        ModelAndView modelAndView = new ModelAndView();

        if (result.hasErrors()) {
            modelAndView = new ModelAndView("student_form", "command", student);
            return modelAndView;
        }

        if (id.isPresent()) {
            studentDAO.update(student);
        } else {
            studentDAO.insert(student);
        }

        modelAndView.addObject("student", student);
        modelAndView.addObject("list", studentDAO.list());
        modelAndView.setViewName("student_list");

        return modelAndView;
    }

    @PostMapping("avatar/save")
    public String handlerFormUpload(@RequestParam("file") MultipartFile file,
                                    HttpServletRequest request,
                                    @RequestParam("id") Integer id) throws IOException {

        if (file.isEmpty()) {
            return "student_error";
        }

        byte[] bytes = file.getBytes();
        System.out.println("Found: " + bytes.length);
        Path avatarFile = getImageFile(request, id);
        Files.write(avatarFile, file.getBytes(), StandardOpenOption.CREATE);

        System.out.println(avatarFile);
        return "redirect:/student/list";
    }

    private Path getImageFile(HttpServletRequest request, @RequestParam("id") Integer id) {
        ServletContext servletContext = request.getSession().getServletContext();
        String realPath = servletContext.getRealPath("/");
        File folder = new File(realPath + File.separator + "avatar");
        folder.mkdirs();
        return Path.of(String.valueOf(folder), String.valueOf(id) + ".jpg");
    }

    @GetMapping("avatar/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable("id") Integer id, HttpServletRequest request) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (id != null) {
            Path avatarPath = getImageFile(request, id);
            if (Files.exists(avatarPath)) {
                byteArrayOutputStream.write(Files.readAllBytes(avatarPath));
            }
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.IMAGE_JPEG);

        return new ResponseEntity<>(byteArrayOutputStream.toByteArray(), httpHeaders, HttpStatus.CREATED);
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        studentDAO.delete(id);
        return "redirect:/student/list";
    }

    @GetMapping("edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id) {
        Student student = studentDAO.get(id);
        return new ModelAndView("student_form", "command", student);
    }
}
