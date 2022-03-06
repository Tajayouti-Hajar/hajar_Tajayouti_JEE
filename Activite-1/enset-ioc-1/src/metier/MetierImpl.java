package metier;

import dao.IDao;



public class MetierImpl implements IMetier{

	private IDao dao;  
	
	public double calcul() {
		//pour faire des calcul il faut appeler la methode getdata
		double nb=dao.getValue();
		return nb*2;
	}

	public void setDao(IDao dao) {
		this.dao = dao;
	}

}
