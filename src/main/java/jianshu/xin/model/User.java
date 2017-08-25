package jianshu.xin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by AnLu on
 * 6/30/17 09:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class User extends BaseModel { // 标识接口

    private Integer id;
    private String nick;
    private String mobile;
    private String password;
    private String avatar;
    private int    pay;
    private double money;
    private String lastIp;
    private String lastTime;
    private String signUpTime;

    private List<Notebook> notebooks;
   }
