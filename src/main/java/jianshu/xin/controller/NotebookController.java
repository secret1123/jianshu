package jianshu.xin.controller;

import jianshu.xin.model.Note;
import jianshu.xin.model.Notebook;
import jianshu.xin.service.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by AnLu on
 * 2017/8/25 14:41.
 * jianshu
 */
@Controller
@RequestMapping("notebook")
public class NotebookController extends BaseController{

    private NotebookService notebookService;

    @Autowired
    public NotebookController(NotebookService notebookService){
        this.notebookService = notebookService;
    }

    @RequestMapping("create")
    private String create(Notebook notebook){
        notebookService.create(notebook);
        return null;
    }

    @ResponseBody
    @RequestMapping("queryNotesById/{id}")
    private List<Note> queryNotesById(@PathVariable int id){
        return notebookService.queryOne("queryNotesById",id).getNotes();
    }
}
