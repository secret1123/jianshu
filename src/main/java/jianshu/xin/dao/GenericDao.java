package jianshu.xin.dao;

import jianshu.xin.util.Pagination;

import java.io.Serializable;
import java.util.List;

/**
 * Created by AnLu on
 * 2017/8/13 11:46.
 * jianshu
 */
public interface GenericDao<M extends Serializable, ID extends Number> {
    M create(M model);

    Object create(String statement,Object parameter);

    void removeById(ID id);

    void remove(String statement,Object parameter);

    void modify(M model);

    void modify(String statement,Object parameter);

    M queryById(ID id);

    M queryOne(String statement,Object parameter);

    List<Object> queryList(String statement,Object parameter);

    List<M> queryAll();

    Pagination<M> queryAll(int currentPage);

    Pagination<M> query(String statement,Object parameter,int currentPage);
}
