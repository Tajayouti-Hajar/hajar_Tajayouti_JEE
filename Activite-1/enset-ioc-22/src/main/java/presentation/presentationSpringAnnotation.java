package presentation;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.net.SocketTimeoutException;

public class presentationSpringAnnotation {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext("dao","metier"); //scanner les objets de pack dao et metier
        IMetier metier=context.getBean(IMetier.class); //donne moi un bean qui implimente l inerface IMetier
        System.out.println(metier.calcul());

    }
}
