import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanUtils {
        public static void assign(Object to, Object from)  throws IllegalAccessException, NoSuchMethodException, InvocationTargetException  {

           Class toClass = to.getClass();
           List<Method> getters = getGetters(from.getClass());

            for (Field field : toClass.getDeclaredFields()) {
                String fieldName = field.getName();
                fieldName = fieldName.substring(0,1).toUpperCase() + fieldName.substring(1).toLowerCase();
                String nameGetter = "get".concat(fieldName);
                for(Method getter : getters) {
                    if(getter.getName().equals(nameGetter)) {
                            Method setter = toClass.getDeclaredMethod("set".concat(fieldName), getter.getReturnType());
                            setter.invoke(to,getter.invoke(from));
                    }
                }
            }
        }

    private static List<Method> getGetters(Class clazz) {
        List<Method> getters = new ArrayList<>();
        Method[] methods = clazz.getMethods();
        for(Method method : methods) {
            if (isGetter(method)) {
                getters.add(method);
            }
        }
        return getters;
    }

    private static boolean isGetter(Method method){
        if(!method.getName().startsWith("get"))      return false;
        if(method.getParameterTypes().length != 0)   return false;
        return !void.class.equals(method.getReturnType());
    }
}