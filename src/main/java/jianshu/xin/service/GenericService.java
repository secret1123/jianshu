package jianshu.xin.service;

import jianshu.xin.util.Pagination;

import java.io.Serializable;

/**
 * Created by AnLu on
 * 2017/8/7 16:23.
 * jianshu
 */
public interface GenericService<M extends Serializable,ID extends Number> {

    void create(M model);

    void create(String statement,Object parameter);

    void removeById(ID id);

    void remove(String statement,Object parameter);

    void modify(M model);

    void modify(String statement,Object parameter);

    M queryById(ID id);

    M query(String statement,Object parameter);

    Pagination<M> queryAll(int currentPage);

    Pagination<M> query(String statement,Object parameter,int currentPage);
}
