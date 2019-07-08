package test2;

import java.util.List;

public class NodeUtils {
    //判断s1是否是s2的左前缀
    boolean isLeft(String s1,String s2){
        int len1 = s1.length();
        int len2 = s2.length();
        if(len1>=len2)return false;
        for (int i = 0; i < len1; i++) {
            if(s1.charAt(i)!=s2.charAt(i)){
                return false;
            }
        }
        return true;
    }
    //获取 path 对应的节点内容
    //使用 DFS 加剪枝
    Node getNode(List<Node> nodes, String path){
        if (nodes.size()==0) return null;
        for(int i=0;i<nodes.size();++i){
            if(nodes.get(i).path.equals(path)){
                return nodes.get(i);
            }
            if(isLeft(nodes.get(i).path,path)){
                Node node=new Node();
                node = getNode(nodes.get(i).children,path);
                if(node != null){
                    return node;
                }
            }
        }
        return null;
    }

}
