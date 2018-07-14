package esum.dic.def;

import esum.dic.DicException;
import esum.introspector.FieldDescriptor;
import esum.introspector.MethodDescriptor;
import esum.introspector.PropertyDescriptor;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

public class SetInIngectionPoint<T> {

    public static final SetInIngectionPoint[] EMPTY = new SetInIngectionPoint[0];

    public final PropertyDescriptor propertyDescriptor;

    public final Class<T> type;

    public final Class targetClass;


    public SetInIngectionPoint(final PropertyDescriptor propertyDescriptor) {
        Objects.requireNonNull(propertyDescriptor);

        this.propertyDescriptor = propertyDescriptor;
        this.type = resolveSetType(propertyDescriptor);

        //解析component类型
        Class targetClass = null;

        MethodDescriptor writeMethodDescriptor = propertyDescriptor.getWriteMethonDescriptor();

        FieldDescriptor fieldDescriptor = propertyDescriptor.getFieldDescriptor();

        if (writeMethodDescriptor != null){
            targetClass = writeMethodDescriptor.getSetterRawComponentType();
        }
        if (targetClass == null && fieldDescriptor == null){
            targetClass = fieldDescriptor.getRawComponentType();
        }
        this.targetClass = targetClass;

        if (targetClass == null){
            throw new DicException("Unknown dic set component type "+
            type.getSimpleName()+'.'+propertyDescriptor.getName());
        }
    }
    @SuppressWarnings({"unchecked"})
    private Class<T> resolveSetType(final PropertyDescriptor propertyDescriptor) {
        Class<T> type = (Class<T>) propertyDescriptor.getType();

        if (ClassUtil.isTypeOf(type, Collection.class)){
            return type;
        }
        throw new dicException(type.getName()+":dic不支持设置此类型");
    }

    /**
     * Creates target set for injection. For now it creates <code>HashSet</code>,
     * but custom implementation can change this setting.
     */
    public Collection<T> createSet(final int length) {
        return new HashSet<>(length);
    }
}
