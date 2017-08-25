package jianshu.xin.service.impl;

import jianshu.xin.dao.GenericDao;
import jianshu.xin.model.Note;
import jianshu.xin.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by AnLu on
 * 2017/8/13 12:32.
 * jianshu
 */
@Service
public class NoteServiceImpl extends GenericServiceImpl<Note,Integer> implements NoteService{

    @Override
    @Autowired
    @Qualifier("noteDaoImpl")
    public void setGenericDao(GenericDao<Note, Integer> genericDao) {
        super.genericDao = genericDao;
    }
}
