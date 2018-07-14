package esum.dic;

import esum.dic.def.ConstructorInjectionPoint;
import esum.dic.def.PropertyInjectionPoint;
import esum.dic.def.SetInIngectionPoint;
import esum.dic.scope.Scope;

import java.util.function.Consumer;

public class BeanDefinition<T> {

    //finals
    protected final String name;    //bean名字
    protected final Class<T> type;  //bean类型
    protected final Scope scope;    //  bean的作用域
    protected final WiringMode wiringMode;//装配模式
    protected final Consumer<T> consumer;//bean的使用者，可以为null
    //cache 缓存
    protected ConstructorInjectionPoint constructorInjectionPoint;
    protected PropertyInjectionPoint[] propertys;
    protected SetInIngectionPoint[] sets;



}
