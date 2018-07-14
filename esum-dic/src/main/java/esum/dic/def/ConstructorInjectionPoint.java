package esum.dic.def;

import java.lang.reflect.Constructor;
import java.util.Objects;

/**
 * 注入点的构造器
 */
public class ConstructorInjectionPoint {

    public static final ConstructorInjectionPoint EMPTY= new ConstructorInjectionPoint();

    public final Constructor constructor;

    public final BeanReferences[] references;

    public ConstructorInjectionPoint() {
        this.constructor= null;
        this.references = null;
    }

    public ConstructorInjectionPoint(Constructor constructor, BeanReferences[] references) {
        Objects.requireNonNull(constructor);
        Objects.requireNonNull(references);
        this.constructor = constructor;
        this.references = references;
    }
}
