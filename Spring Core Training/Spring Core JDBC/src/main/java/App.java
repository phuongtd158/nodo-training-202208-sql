import edu.java.spring.Student;
import edu.java.spring.StudentJdbcDAO;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        StudentJdbcDAO jdbc = (StudentJdbcDAO) context.getBean("studentJdbcDAO");
        LOGGER.info("Create bean " + jdbc);

        //jdbc.insert("Test", 21);
        //jdbc.updateAgeByName("Phong", 10);
        //jdbc.deleteStudentByName("Test");

//        List<Student> students = new ArrayList<>();
//
//        students.add(new Student("Tran Thi A", 26));
//        students.add(new Student("Le Van L", 20));
//        students.add(new Student("Phan Thi Z", 16));
//
//        int[] values = jdbc.addBatch(students);
//
//        for (int i = 0; i < values.length; i++) {
//            LOGGER.info("Add record " + (i + 1) + ": " + (values[i] == 0 ? "failed" : "success"));
//        }

        jdbc.save("User1", 10);

//        LOGGER.info("Total record: " + jdbc.totalRecords());
//        jdbc.loadAllStudent().forEach(LOGGER::info);

    }
}
