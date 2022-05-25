package metier;

import Dao.IDao;
//import InjectionAnotation.AmAutowired;
//import InjectionAnotation.AmComponent;
//@AmComponent
public class ImetierImpl implements Imetier {
  //  @AmAutowired
    private IDao dao; //couplage faible
    @Override
    public double calcule() {
        return dao.getData()*540/Math.cos(Math.PI*40);
    }

 public void setDao(IDao dao) {
        this.dao = dao;
    }
}
