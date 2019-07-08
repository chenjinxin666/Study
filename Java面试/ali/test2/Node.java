package test2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Node {
    String path;
    String value;
    ArrayList<Node> children;
    //设置默认参数，用来格式化输出
    @Override
    public String toString(){
        return toString(0);
    }
    public String toString(int l) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        for (int i = 0; i < l; i++) {
            stringBuilder.append("\t");
        }
        stringBuilder.append("{\n");
        for (int i = 0; i < l+1; i++) {
            stringBuilder.append("\t");
        }
        stringBuilder.append("\"path\":"+"\""+path+"\","+"\n");
        for (int i = 0; i < l+1; i++) {
            stringBuilder.append("\t");
        }
        stringBuilder.append("\"value\":"+"\""+value+"\","+"\n");
        for (int i = 0; i < l+1; i++) {
            stringBuilder.append("\t");
        }
        stringBuilder.append("\"children\":");
        if(children.size()==0){
            stringBuilder.append("[]");
        }
        else{
            stringBuilder.append("[");
            for(int i=0;i<children.size()-1;++i) {
                stringBuilder.append(children.get(i).toString(l+2));
                stringBuilder.append(",");
            }
            stringBuilder.append(children.get(children.size()-1).toString(l+2));
            stringBuilder.append("\n");
            for (int i = 0; i < l+1; i++) {
                stringBuilder.append("\t");
            }
            stringBuilder.append("]");
        }
        stringBuilder.append("\n");
        for (int i = 0; i < l; i++) {
            stringBuilder.append("\t");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Node> children) {
        this.children = children;
    }
}
