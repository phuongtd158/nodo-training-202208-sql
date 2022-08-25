import edu.java.spring.AppConfig;
import edu.java.spring.HelloClazz;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        HelloClazz bean = (HelloClazz) context.getBean("bean2");
        bean.printMessage();

    }
}
