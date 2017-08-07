package jianshu.xin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Created by AnLu on
 * 2017/8/7 17:00.
 * jianshu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Notebook extends BaseModel{

    private Integer id;
    private String title;
    private String time;
    private int userId;
}
