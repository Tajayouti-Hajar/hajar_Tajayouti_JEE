package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MetierImpl implements IMetier{
//@Autowired
	private IDao dao;

	public MetierImpl(IDao dao)
	{
		this.dao = dao;
	}

	public double calcul() {

		double nb=dao.getValue();
		return nb*2;
	}

	public void setDao(IDao dao)
	{
		this.dao = dao;
	}

}
