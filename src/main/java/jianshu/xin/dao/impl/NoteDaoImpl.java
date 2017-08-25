package jianshu.xin.dao.impl;

import jianshu.xin.dao.NoteDao;
import jianshu.xin.model.Note;
import org.springframework.stereotype.Repository;

/**
 * Created by AnLu on
 * 2017/8/13 12:15.
 * jianshu
 */
@Repository
public class NoteDaoImpl extends GenericDaoImpl<Note,Integer> implements NoteDao {
}
