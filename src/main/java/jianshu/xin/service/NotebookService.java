package jianshu.xin.service;

import jianshu.xin.model.Notebook;

/**
 * Created by AnLu on
 * 2017/8/7 16:37.
 * jianshu
 */
public interface NotebookService extends GenericService<Notebook,Integer> {

    void init(int userId);
}
