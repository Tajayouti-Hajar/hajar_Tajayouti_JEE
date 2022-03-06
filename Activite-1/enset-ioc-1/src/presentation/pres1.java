package presentation;


import dao.DaoImpl;
import metier.MetierImpl;

public class pres1 {

	public static void main(String[] args) throws Exception {
	/*injection des dependances par instanciation  statique*/

	  DaoImpl dao=new DaoImpl();
		MetierImpl metier=new MetierImpl();
		metier.setDao(dao);//injection....  invoquer la methede setDao sur l'objet metier
		System.out.println(metier.calcul());
	}
}


