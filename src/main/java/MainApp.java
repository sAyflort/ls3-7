import java.lang.reflect.InvocationTargetException;

public class MainApp {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        MyTest.start(MainApp.class);
    }

    @BeforeSuite
    public static void before() {
        System.out.println(1);
    }

    @Test
    public static void test1() {
        System.out.println(2);
    }

    @Test
    public static void test11() {
        System.out.println(22);
    }

    @Test(priority = 10)
    public static void test2() {
        System.out.println(3);
    }

    @AfterSuite
    public static void after() {
        System.out.println(4);
    }
}
