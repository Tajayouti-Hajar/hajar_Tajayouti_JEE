package metier;

import Dao.IDao;

import InjectionAnnotation.TaJaAutowired;
import InjectionAnnotation.TaJaComponent;

@TaJaComponent
public class ImetierImpl implements Imetier {
   @TaJaAutowired
    private IDao dao; //couplage faible
    @Override
    public double calcule() {
        return dao.getData()*540/Math.cos(Math.PI*40);
    }

 public void setDao(IDao dao) {
        this.dao = dao;
    }
}
