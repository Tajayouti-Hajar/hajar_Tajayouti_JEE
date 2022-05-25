package extention;

import Dao.IDao;

public class DaoImpl2 implements IDao {

    @Override
    public double getData() {
        System.out.println("version capteure");
        return Math.random()*10;
    }
}
