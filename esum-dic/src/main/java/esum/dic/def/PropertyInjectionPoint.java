package esum.dic.def;

import esum.introspector.PropertyDescriptor;

import java.util.Objects;

/**
 * 注入点的属性
 */
public class PropertyInjectionPoint {

    public static final PropertyInjectionPoint[] EMPTY = new PropertyInjectionPoint[0];

    public final PropertyDescriptor propertyDescriptor;
    public final BeanReferences beanReferences;

    public PropertyInjectionPoint(final PropertyDescriptor propertyDescriptor, final BeanReferences beanReferences) {
        Objects.requireNonNull(propertyDescriptor);
        Objects.requireNonNull(beanReferences);
        this.propertyDescriptor = propertyDescriptor;
        this.beanReferences = beanReferences;
    }
}
