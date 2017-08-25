package jianshu.xin.service.impl;

import jianshu.xin.dao.GenericDao;
import jianshu.xin.model.Notebook;
import jianshu.xin.service.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by AnLu on
 * 2017/8/13 12:51.
 * jianshu
 */
@Service
public class NotebookServiceImpl extends GenericServiceImpl<Notebook,Integer> implements NotebookService{

    private static final String[] INIT_TITLES = {"日记本","随笔"};

    @Override
    @Autowired
    @Qualifier("notebookDaoImpl")
    public void setGenericDao(GenericDao<Notebook, Integer> genericDao) {
        super.genericDao = genericDao;
    }

    @Override
    public void init(int userId){
        for (String initTitle : INIT_TITLES){
            Notebook notebook = new Notebook(initTitle,userId);
            genericDao.create(notebook);
        }
    }
}
