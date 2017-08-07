package jianshu.xin.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Created by AnLu on
 * 2017/8/7 16:31.
 * jianshu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagination<M extends Serializable> {
    private List<M> list;
    private String statement;
    private int pageSize;
    private int totalRows;
    private int totalPages;
    private int currentPage;
}
