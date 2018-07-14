package esum.dic.scope;

import esum.dic.BeanDefinition;

public interface Scope {

    /**
     * 查找Bean的名称，如果Bean没有找到或者没有注册，则返回null
     * */
    Object lookup();

    void register(BeanDefinition beanDefinition, Object bean);
}
