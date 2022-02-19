import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyTest {
    public static void start(Class testClass) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = testClass.getMethods();
        int f1 = 0, f2 = 0;

        for (Method o: methods
             ) {
            if(o.getAnnotation(BeforeSuite.class) != null) {
                f1++;
            }
            if(o.getAnnotation(AfterSuite.class) != null) {
                f2++;
            }
        }

        if(f1 > 1 || f2 > 1) {
            throw new RuntimeException();
        }

        for (Method o: methods
             ) {
            if(o.getAnnotation(BeforeSuite.class) != null) {
                o.invoke(testClass);
                break;
            }
        }

        for (int i = 0; i <= 10; i++) {
            for (Method o: methods
                 ) {
                if(o.getAnnotation(Test.class) != null && o.getAnnotation(Test.class).priority() == i) {
                    o.invoke(testClass);
                }
            }
        }

        for (Method o: methods
        ) {
            if(o.getAnnotation(AfterSuite.class) != null) {
                o.invoke(testClass);
                break;
            }
        }
    }
}
