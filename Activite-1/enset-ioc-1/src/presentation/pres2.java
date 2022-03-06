package presentation;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;
public class pres2 {
    public static void main(String[] args) throws Exception {
        //injection des dependances par instanciation dynamique

        Scanner scanner=new Scanner(new File("conf.txt"));
        String daoClassName=scanner.nextLine();
        Class cDao=Class.forName(daoClassName); // chercher si cette class existe
        IDao dao=(IDao) cDao.newInstance();


        String metierClassName=scanner.nextLine();
        Class cMetier=Class.forName(metierClassName);
        IMetier metier=(IMetier) cMetier.newInstance();


        //appel dynamique d'une methode
        Method m=cMetier.getMethod("setDao", IDao.class); // nom_method,type de parametre
        m.invoke(metier,dao);   //invoquer la methode m sur l objet metier en passant dao comme parametre
        System.out.println(metier.calcul());


        //FileNotFoundException | ClassNotFoundException | InstantiationException | IllegalAccessException e

    }
}
