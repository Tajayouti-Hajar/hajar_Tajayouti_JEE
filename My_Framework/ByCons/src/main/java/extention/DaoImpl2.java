package extention;

import Dao.IDao;

public class DaoImpl2 implements IDao {
    //version capteur
    @Override
    public double getData() {
        System.out.println("version 2");
        return 4000;
    }
}
