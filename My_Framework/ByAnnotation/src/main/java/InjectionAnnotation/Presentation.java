package InjectionAnnotation;

import metier.Imetier;

import java.lang.reflect.InvocationTargetException;

public class Presentation {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
    ConfigurationAnnotation contx=new ConfigurationAnnotation();
    contx.getClasses("dao", "metier");
    Imetier imetier= (Imetier) contx.getInstances().get(Imetier.class);

        System.out.println(imetier.calcule());
}}

