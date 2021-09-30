package reflection;

import org.junit.Assert;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.*;

public class TestDynamicProxy {

    @Test
    public void testDynamicProxy() {

        CountingInvocationHandler invocationHandler
                = new CountingInvocationHandler(new ArrayList<>());

        List<String> listProxy = (List<String>) Proxy.newProxyInstance(
                List.class.getClassLoader(), new Class[] {
                        List.class}, invocationHandler);

        listProxy.add("Adda");
        listProxy.add("Mark");
        listProxy.add("John");
    }

    public class CountingInvocationHandler implements InvocationHandler {

        private final Map<String, Integer> counter = new HashMap<>();
        private final Object targetObject;

        public CountingInvocationHandler(Object targetObject) {
            this.targetObject = targetObject;

            for (Method method:targetObject.getClass().getDeclaredMethods()) {
                this.counter.put(method.getName()
                        + Arrays.toString(method.getParameterTypes()), 0);
            }
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args)
                throws Throwable {

            Object resultOfInvocation = method.invoke(targetObject, args);
            counter.computeIfPresent(method.getName()
                    + Arrays.toString(method.getParameterTypes()), (k, v) -> ++v);

            return resultOfInvocation;
        }
    }
}
