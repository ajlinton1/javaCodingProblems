package reflection;

@MyAnnotation
public class MySubclass extends MyClass {

    @Override
    public void method1() {
        System.out.println("Method1 called");
    }
}
