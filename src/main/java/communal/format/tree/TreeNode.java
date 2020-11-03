package communal.format.tree;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 树节点
 * @Author: 林少君
 * @Date: 2020/6/16 14:30
 */
@Data
public class TreeNode implements java.io.Serializable {

    private static final long serialVersionUID = 2105832744040469236L;

    //节点id
    private Integer id;

    //父节点id
    private Integer parentId;

    //节点名称
    private String name;

    //排序字段
    private float sort;

    //子节点集合
    private List<TreeNode> children;

    //其它属性对象
    private Map<Object, Object> dataMap;
}
