package jianshu.xin.controller;

import jianshu.xin.model.Note;
import jianshu.xin.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by AnLu on
 * 2017/8/25 11:50.
 * jianshu
 */
@Controller
@RequestMapping("note")
public class NoteController extends BaseController{

    private NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService){
        this.noteService = noteService;
    }

    @ResponseBody
    @RequestMapping("create")
    private Map<String,Object> create(Note note){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        note.setTime(dateFormat.format(new Date()));
        noteService.create(note);
        Map<String,Object> result = new HashMap<>();
        result.put("status",true);
        return result;
    }
}
