package presentation;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class presentationSpringXML {
    public static void main(String[] args) {

        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        IMetier metier=(IMetier)context.getBean("metier");//lire le fichier XML puis cherche un bean qui s'appelle metier et le retourner
        System.out.println(metier.calcul());
    }
}