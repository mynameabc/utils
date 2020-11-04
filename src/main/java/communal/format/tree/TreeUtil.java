package communal.format.tree;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

/**
 * @Author: 林少君
 * @Date: 2020/6/16 14:45
 */
public class TreeUtil {

    static final Integer DEFAULT_PARENT_ID = 0;  //最上级的节点其父节点默认值

    public static List<TreeNode> getTree(List<TreeNode> treeNodeList) {
        return getTree(DEFAULT_PARENT_ID, treeNodeList);
    }

    public static List<TreeNode> getTreeAll(List<TreeNode> treeNodeList) {
        treeNodeList = comparatorSort(treeNodeList);
        treeNodeList = getTree(DEFAULT_PARENT_ID, treeNodeList);
        return treeNodeList;
    }

    public static List<TreeNode> getTreeAll(Integer parentId, List<TreeNode> treeNodeList) {
        treeNodeList = comparatorSort(treeNodeList);
        treeNodeList = getTree(parentId, treeNodeList);
        return treeNodeList;
    }

    public static List<TreeNode> getTree(Integer parentId, List<TreeNode> treeNodeList) {

        List<TreeNode> result = new ArrayList<>();
        for (TreeNode treeNode : treeNodeList) {
            if (treeNode.getParentId().equals(parentId)) {
                result.add(treeNode);
            }
            for (TreeNode child : treeNodeList) {
                if (child.getParentId().equals(treeNode.getId())) {

                    List<TreeNode> treeNodes = treeNode.getChildren();
                    if (null == treeNodes) {
                        treeNodes = new ArrayList<>();
                        treeNode.setChildren(treeNodes);
                    }
                    treeNode.getChildren().add(child);
                }
            }
        }
        return result;
    }

    /**
     * 去重
     * @param treeNodeList
     * @return
     */
    public static List<TreeNode> duplicateRemoval(List<TreeNode> treeNodeList) {
        treeNodeList = treeNodeList.stream().collect(collectingAndThen(toCollection(() -> new TreeSet<>(comparingInt(TreeNode::getId))), ArrayList::new));
        return getTree(treeNodeList);
    }

    /**
     * 根据Id排序
     * @param treeNodeList
     * @return
     */
    public static List<TreeNode> comparatorId(List<TreeNode> treeNodeList) {
        treeNodeList = treeNodeList.stream().sorted(Comparator.comparing(TreeNode::getId)).collect(Collectors.toList());
        return getTree(treeNodeList);
    }

    /**
     * 根据sort排序
     * @param treeNodeList
     * @return
     */
    public static List<TreeNode> comparatorSort(List<TreeNode> treeNodeList) {
        treeNodeList = treeNodeList.stream().sorted(Comparator.comparing(TreeNode::getSort)).collect(Collectors.toList());
        return getTree(treeNodeList);
    }

    public static void main(String args[]) {

        TreeNode treeNode = new TreeNode();
        treeNode.setId(1);
        treeNode.setParentId(0);
        treeNode.setName("name");
        treeNode.setSort(1.3F);

        Map<Object, Object>dataMap = new HashMap<>();
        dataMap.put("A", "1");
        dataMap.put("B", "2");
        dataMap.put("C", "你好!");
        treeNode.setDataMap(dataMap);

        TreeNode treeNode1 = new TreeNode();
        treeNode1.setId(2);
        treeNode1.setParentId(0);
        treeNode1.setName("name");
        treeNode1.setSort(1.6F);

        TreeNode treeNode2 = new TreeNode();
        treeNode2.setId(3);
        treeNode2.setParentId(0);
        treeNode2.setName("name");
        treeNode2.setSort(1.2F);

        TreeNode treeNode3 = new TreeNode();
        treeNode3.setId(4);
        treeNode3.setParentId(0);
        treeNode3.setName("name");
        treeNode3.setSort(1.1F);

        TreeNode treeNode4 = new TreeNode();
        treeNode4.setId(5);
        treeNode4.setParentId(0);
        treeNode4.setName("name");
        treeNode4.setSort(1.6F);

        TreeNode treeNode6 = new TreeNode();
        treeNode6.setId(1);
        treeNode6.setParentId(0);
        treeNode6.setName("name");
        treeNode6.setSort(1.3F);

        List<TreeNode> treeNodeList = new ArrayList<>();
        treeNodeList.add(treeNode);
        treeNodeList.add(treeNode4);
        treeNodeList.add(treeNode2);
        treeNodeList.add(treeNode3);
        treeNodeList.add(treeNode1);
        treeNodeList.add(treeNode6);

        List<TreeNode> treeNodeList2 = TreeUtil.comparatorId(treeNodeList);
        List<TreeNode> treeNodeList3 = TreeUtil.comparatorSort(treeNodeList);
        List<TreeNode> treeNodeList4 = TreeUtil.duplicateRemoval(treeNodeList);

        System.out.println(treeNode.getDataMap().get("C"));
    }
}
