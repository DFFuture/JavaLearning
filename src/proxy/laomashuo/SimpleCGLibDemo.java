package proxy.laomashuo;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class SimpleCGLibDemo {
    static class RealService {
        public void sayHello() {
            System.out.println("hello");
        }
    }

    static class SimpleInterceptor implements MethodInterceptor {
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("entering" + method.getName());
            Object result = methodProxy.invokeSuper(o, objects);
            System.out.println("leaving" + method.getName());
            return result;
        }
    }

    @SuppressWarnings("unchecked")
    private static<T> T getProxy(Class<T> cls) {
        Enhancer enhancer = new Enhancer();   //需要导入asm.jar
        enhancer.setSuperclass(cls);
        enhancer.setCallback(new SimpleInterceptor());
        return (T) enhancer.create();
    }

    public static void main(String[] args) {
        RealService proxyService = getProxy(RealService.class);
        proxyService.sayHello();
    }

}

