package dao;

import org.springframework.stereotype.Component;

@Component("dao")

public class DaoImpl implements IDao{

	public double getValue() {

		return 5;
	}
}
