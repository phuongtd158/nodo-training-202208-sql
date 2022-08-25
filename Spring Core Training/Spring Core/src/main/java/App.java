import edu.java.spring.HelloClazz;
import edu.java.spring.HelloWorld;
import edu.java.spring.JavaClazz;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class);

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

//        HelloClazz obj = (HelloClazz) context.getBean("helloJavaClazz");
//        obj.printMessage();

        HelloWorld obj2 = (HelloWorld) context.getBean("helloWorld1");
        obj2.sayHello();

        JavaClazz clazz = (JavaClazz) context.getBean("jee01");
        LOGGER.info("Map implement is: " + clazz.getStudents().getClass());
        LOGGER.info("There are: " + clazz.getStudents().size() + " in the class");

        HelloClazz clazz2 = (HelloClazz) context.getBean("helloJavaClazz");
        LOGGER.info("Total classes is: " + clazz2.getClazzes().size());
    }
}
