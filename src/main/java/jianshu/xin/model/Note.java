package jianshu.xin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Created by AnLu on
 * 2017/8/7 16:59.
 * jianshu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Note extends BaseModel{

    private Integer id;
    private String title;
    private String markdown;
    private String content;
    private String time;
    int views;
    int notebookId;
}
