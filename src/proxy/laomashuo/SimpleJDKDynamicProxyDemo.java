package proxy.laomashuo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SimpleJDKDynamicProxyDemo {

    interface IService {
        void sayHello();
        void sayHello(String s);
    }

    static class RealService implements IService {

        @Override
        public void sayHello() {
            System.out.println("hello");
        }

        @Override
        public void sayHello(String s) {
            System.out.println(s);
        }
    }

    static class SimpleInvocationHandler implements InvocationHandler {

        private Object realObj;
        public SimpleInvocationHandler(Object realObj) {
            this.realObj = realObj;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("entering " + method.getName());
            Object result = method.invoke(realObj, args);
            System.out.println("leaving " + method.getName());
            return result;
        }
    }

    public static void main(String[] args) {
        IService realService = new RealService();
        IService proxyService = (IService) Proxy.newProxyInstance(IService.class.getClassLoader(),
                new Class<?>[] {IService.class}, new SimpleInvocationHandler(realService));
        proxyService.sayHello();
        proxyService.sayHello("world");
    }
}
