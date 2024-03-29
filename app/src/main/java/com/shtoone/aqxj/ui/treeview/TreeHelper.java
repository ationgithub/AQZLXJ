package com.shtoone.aqxj.ui.treeview;

import android.util.Log;

import com.shtoone.aqxj.R;
import com.shtoone.aqxj.ui.treeview.annotation.TreeNodeId;
import com.shtoone.aqxj.ui.treeview.annotation.TreeNodeLabel;
import com.shtoone.aqxj.ui.treeview.annotation.TreeNodePid;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TreeHelper {
    private static final String TAG = "TreeHelper";

    /**
     * 将用户的数据转化为树形数据
     *
     * @param datas
     * @return
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     */
    public static <T> List<Node> convertDatas2Nodes(List<T> datas)
            throws IllegalArgumentException, IllegalAccessException {
        List<Node> nodes = new ArrayList<Node>();
        Node node = null;
        for (T t : datas) {
            String id = null;
            String pid = null;
            String label = null;

            node = new Node();
            Class clazz = t.getClass();
            Field[] fields = clazz.getDeclaredFields();//获取类中所有属性
            for (Field field : fields) {
                if (field.getAnnotation(TreeNodeId.class) != null) {
                    field.setAccessible(true);
                    id = (String) field.get(t);
                }
                if (field.getAnnotation(TreeNodePid.class) != null) {
                    field.setAccessible(true);
                    pid = (String) field.get(t);
                }
                if (field.getAnnotation(TreeNodeLabel.class) != null) {
                    field.setAccessible(true);
                    label = (String) field.get(t);
                }
            }
            node = new Node(id, pid, label);
            nodes.add(node);
        }// for end

        Log.e("TAG", nodes + "");
        Log.e("TAG", "设置Node间的节点关系");

        /**
         * 设置Node间的节点关系
         */
        for (int i = 0; i < nodes.size(); i++) {
            Node n = nodes.get(i);

            for (int j = i + 1; j < nodes.size(); j++) {
                Node m = nodes.get(j);
//                Log.e(TAG, "index:" + i + "n:" + n + "||||||m:" + m);
                if (String.valueOf(m.getpId()).equals(n.getId())) {
                    n.getChildren().add(m);
                    m.setParent(n);
                } else if (m.getId().equals(String.valueOf(n.getpId()))) {
                    m.getChildren().add(n);
                    n.setParent(m);
                }
            }
        }

        for (Node n : nodes) {
            setNodeIcon(n);
        }
        Log.e(TAG,"nodes.size>>>>>"+nodes.size());
        return nodes;
    }

    public static <T> List<Node> getSortedNodes(List<T> datas,
                                                int defaultExpandLevel) throws IllegalArgumentException,
            IllegalAccessException {
        List<Node> result = new ArrayList<Node>();
        List<Node> nodes = convertDatas2Nodes(datas);
        // 获得树的根结点
        List<Node> rootNodes = getRootNodes(nodes);

        for (Node node : rootNodes) {
            addNode(result, node, defaultExpandLevel, 1);
        }

        Log.e("TAG", result.size() + "");
        return result;
    }

    /**
     * 把一个节点的所有孩子节点都放入result
     *
     * @param result
     * @param node
     * @param defaultExpandLevel
     * @param currentLevel
     */
    private static void addNode(List<Node> result, Node node, int defaultExpandLevel, int currentLevel) {
        result.add(node);
        if (defaultExpandLevel >= currentLevel) {
            node.setExpand(true);
        }
        if (node.isLeaf())
            return;

        for (int i = 0; i < node.getChildren().size(); i++) {
            addNode(result, node.getChildren().get(i), defaultExpandLevel,
                    currentLevel + 1);
        }

    }

    /**
     * 过滤出可见的节点
     *
     * @param nodes
     * @return
     */
    public static List<Node> filterVisibleNodes(List<Node> nodes) {
        List<Node> result = new ArrayList<Node>();

        for (Node node : nodes) {
            if (node.isRoot() || node.isParentExpand()) {
                setNodeIcon(node);
                result.add(node);
            }
        }
        return result;
    }

    /**
     * 从所有节点中过滤出根节点
     *
     * @param nodes
     * @return
     */
    private static List<Node> getRootNodes(List<Node> nodes) {
        List<Node> root = new ArrayList<Node>();
        for (Node node : nodes) {
            if (node.isRoot()) {
                root.add(node);
            }
        }
        return root;
    }

    /**
     * 为Node设置图标
     *
     * @param n
     */
    private static void setNodeIcon(Node n) {
        if (n.getChildren().size() > 0 && n.isExpand()) {
            n.setIcon(R.drawable.tree_ex);
        } else if (n.getChildren().size() > 0 && !n.isExpand()) {
            n.setIcon(R.drawable.tree_ec);
        } else {
            n.setIcon(-1);
        }
    }
}
