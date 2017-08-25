package jianshu.xin.controller;

import jianshu.xin.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by AnLu on
 * 2017/8/25 14:46.
 * jianshu
 */
@Controller
public class RootController extends BaseController{

    private final NoteService noteService;

    @Autowired
    public RootController(NoteService noteService){
        this.noteService = noteService;
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    private String root(){
        List<Object> list = noteService.queryList("queryAllNotes",null);
        for (Object item : list){
            // item
        }
        session.setAttribute("list",list);
        return "redirect:/default.jsp";
    }
}
