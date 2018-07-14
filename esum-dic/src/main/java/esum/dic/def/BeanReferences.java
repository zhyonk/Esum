package esum.dic.def;


import java.util.Arrays;
import java.util.Objects;

/**
 * 表示一个注入点的Bean名称集合，一个注入点可以拥有多个bean的应用，当引用bean没有明确定义时使用。
 */
public class BeanReferences {

    private String[] names;

    public BeanReferences(final String ...names) {
        this.names = names;
    }

    /**
     * 创建Bean的引用
     * @param names 引用Bean名称集合
     * @return
     */
    public static BeanReferences of(final String ...names){
        Objects.requireNonNull(names);
        return new BeanReferences(names);
    }

    /**
     * 如果Bean引用的集合时空的返回true 返回{@code}.
     */
    public boolean isEmpty() {
        return names.length == 0;
    }

    /**
     * 返回引用Bean引用集合的长度
     */
    public int size() {
        return names.length;
    }

    /**
     * Returns the name on the index.
     */
    public String name(final int ndx) {
        return names[ndx];
    }

    public BeanReferences removeDuplicateNames(){
        if (names.length<2){
            return this;
        }
        int nullCount = 0;

        for (int i=1;i<names.length;i++){
            String thisRef = names[i];
            //如果当前遍历引用为null，nullCount加以
            if(thisRef == null){
                nullCount++;
                continue;
            }
            for (int j = 0;j<i;j++){
                if (names[j] == null){
                    continue;
                }
                //如果当前遍历的Bean引用出现重复，将当前的引用置为空
                if (thisRef.equals(names[j])){
                    names[i] = null;
                    break;
                }
            }
        }

        if(nullCount==0){
            return this;
        }
        //新的引用数组长度为原数组长度去掉重复值总数
        String[] newRefs = new String[names.length-nullCount];

        int ndx = 0;
        /**
         * 遍历原数组，将不为空的引用名称填入新引用数组
         */
        for (String name : names){
            if (name==null){
                continue;
            }
            newRefs[ndx] = name;
            ndx++;
        }
        return new BeanReferences(newRefs);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0;i<names.length;i++){
            if(i!=0){
                sb.append(",");
            }
            sb.append(names[i]);
        }
        sb.append(']');
        return sb.toString();
    }
}
