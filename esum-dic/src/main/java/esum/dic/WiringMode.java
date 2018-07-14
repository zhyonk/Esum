package esum.dic;

/**
 * 装配模式
 */
public enum WiringMode {
    /**
     * 默认的装配模式，由容器来设置
     */
    DEFAULT(-1),
    /**
     * 没有装配
     */
    NONE(0),
    /**
     * 严格的装配模式，由确切的注入点，如果不能装载返回Exception
     */
    STRICT(1),
    /**
     * 自选装配模式，有明确的注入点，如果没有自动装载，不会返回异常
     */
    OPTIONAL(2),
    /**
     * 自动装配Bean，在任何满足命名约定的地方自动将bean注入到注入点，如果不能装配不会返回异常
     */
    AUTOWIRE(3);

    private final int value;

    WiringMode(final int value) {
        this.value = value;
    }

    public int value(){
        return value;
    }

    @Override
    public String toString() {
        return name();
    }
}
