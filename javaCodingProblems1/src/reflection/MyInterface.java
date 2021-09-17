package reflection;

public interface MyInterface {

    default String method2() {
        return "This is the default value";
    }
}
