package dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @param <T> 用于泛型解耦和
 * Created by magenta9 on 2017/2/27.
 */
public interface Dao<T> {
    /**
     * 添加单个对象
     * @param t 被添加的对象
     * @return 受影响的条数
     */
    int add(T t);

    /**
     * 删除某个对象
     * @param t 待删除对象
     * @return 受影响的条数
     */
    int del(T t);

    /**
     * 更新某个对象
     *
     * @param t 待更新对象
     * @return 受影响的条数
     */
    int update(T t);

    /**
     * 通过ID查找一个对象
     * @param Id 待查询的对象的ID
     * @return 该ID对应的对象
     */
    T findById(int Id);

    /**
     * 查找对象集合
     * @return 返回对象集合
     */
    List<T> findAll();
}
