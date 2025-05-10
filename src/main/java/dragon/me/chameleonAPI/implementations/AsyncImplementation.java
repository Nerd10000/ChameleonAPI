package dragon.me.chameleonAPI.implementations;

import dragon.me.chameleonAPI.annotations.Async;
import dragon.me.chameleonAPI.annotations.SyncOnly;
import dragon.me.chameleonAPI.exceptions.ProxyHandlingError;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncImplementation {


    private static final ExecutorService SERVICE = Executors.newCachedThreadPool();

    private static final ThreadLocal<Boolean> isAsync = ThreadLocal.withInitial(() -> false);

    @SuppressWarnings("unchecked")
    public static <T> T createProxy(T instance) {
        checkForFinalFields(instance);

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(instance.getClass());
        enhancer.setCallback(new AsyncMethodInterceptor<>(instance));
        return (T) enhancer.create();

    }

    private static void checkForFinalFields(Object instance) {
        for (Field field : instance.getClass().getDeclaredFields()) {
            if (java.lang.reflect.Modifier.isFinal(field.getModifiers())) {
                throw new ProxyHandlingError("The class contains a FINAL field which cglib cannot read!" + "(field_name: " + field.getName() + ")");
            }
        }


    }


    private  static  class AsyncMethodInterceptor<T> implements MethodInterceptor {
        private  final T instance;

        private AsyncMethodInterceptor(T instance) {
            this.instance = instance;
        }


        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            Method method1 = instance.getClass().getMethod(method.getName(),method.getParameterTypes());

            if (method1.isAnnotationPresent(Async.class)){
                SERVICE.submit(() -> {
                    try {
                        isAsync.set(true);
                        methodProxy.invoke(instance,objects);
                    } catch (Throwable e) {
                        throw new RuntimeException(e);
                    }

                });
                return null;
            }
            if (method.isAnnotationPresent(SyncOnly.class)){
                if (isAsync.get()){
                    throw  new ProxyHandlingError("Tried to make a method async which is sync only! (method_name: " + method.getName() + ")");
                }
            }

            return methodProxy.invoke(instance,objects);
        }
    }
}

