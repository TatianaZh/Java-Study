import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        PersonTo person1 = new PersonTo("Mary", 20, false, "Moscow");
        PersonFrom person2 = new PersonFrom("drf ",0,true,"information");
        BeanUtils.assign(person2,person1);


        System.out.println(person2.getName());
        System.out.println(person2.getAge());
        System.out.println(person2.getSex());
        System.out.println(person2.getSomeinformation());

    }
}
