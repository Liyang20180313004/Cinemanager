package xyz.changzhen.cinemanager.models;

import java.util.UUID;

/**
 * @author zhen
 */
public class BaseEntity {
    UUID id;

    public BaseEntity() {
        id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    /**
     * 获取数据库内映射表的主键的值。该方法仅为备用，ORM获取主键值时优先获取注解为@AsPrimaryKey列的值，
     * 如果所有列都找不到注解时才使用本方法获取。
     * @return id
     */
    public Object getIdentityValue() {
        return id;
    }

}
