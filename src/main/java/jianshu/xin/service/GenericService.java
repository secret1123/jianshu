package jianshu.xin.service;

import jianshu.xin.util.Pagination;

import java.io.Serializable;
import java.util.List;

/**
 * Created by AnLu on
 * 2017/8/7 16:23.
 * jianshu
 */
public interface GenericService<M extends Serializable,ID extends Number> {

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
