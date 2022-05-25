package Dao;

//import InjectionAnotation.AmComponent;

//@AmComponent
public class DaoImpl implements IDao {
    @Override
    public double getData() {

        System.out.println("version base de donnes");
        return Math.random()*10;
    }
}
