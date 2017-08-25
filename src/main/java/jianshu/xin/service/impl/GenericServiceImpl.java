package jianshu.xin.service.impl;

import jianshu.xin.dao.GenericDao;
import jianshu.xin.service.GenericService;
import jianshu.xin.util.Pagination;

import java.io.Serializable;
import java.util.List;

/**
 * Created by AnLu on
 * 2017/8/7 17:09.
 * jianshu
 */
public abstract class GenericServiceImpl<M extends Serializable,ID extends Number> implements GenericService<M,ID> {

    GenericDao<M,ID> genericDao;

    @SuppressWarnings("unused")
    public abstract void setGenericDao(GenericDao<M,ID> genericDao);

    @Override
    public M create(M model) {
        return genericDao.create(model);
    }

    @Override
    public Object create(String statement, Object parameter) {
        return genericDao.create(statement,parameter);
    }

    @Override
    public void removeById(ID id) {
        genericDao.removeById(id);
    }

    @Override
    public void remove(String statement, Object parameter) {
        genericDao.remove(statement,parameter);
    }

    @Override
    public void modify(M model) {
        genericDao.modify(model);
    }

    @Override
    public void modify(String statement, Object parameter) {
        genericDao.modify(statement, parameter);
    }

    @Override
    public M queryById(ID id) {
        return genericDao.queryById(id);
    }

    @Override
    public M queryOne(String statement, Object parameter) {
        return genericDao.queryOne(statement, parameter);
    }

    @Override
    public List<Object> queryList(String statement, Object parameter) {
        return genericDao.queryList(statement, parameter);
    }

    @Override
    public List<M> queryAll() {
        return genericDao.queryAll();
    }

    @Override
    public Pagination<M> queryAll(int currentPage) {
        return genericDao.queryAll(currentPage);
    }

    @Override
    public Pagination<M> query(String statement, Object parameter, int currentPage) {
        return genericDao.query(statement, parameter, currentPage);
    }
}
