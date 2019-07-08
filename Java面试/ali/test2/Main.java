package test2;

import com.alibaba.fastjson.JSON;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        testJSON();
    }

    private static void testJSON() {
        String str="[" +
                "    {" +
                "        \"path\": \"level0_0/\"," +
                "        \"value\": \"value\"," +
                "        \"children\": [" +
                "            {" +
                "                \"path\": \"level0_0/level1_0/\"," +
                "                \"value\": \"value\"," +
                "                \"children\": [" +
                "                    {" +
                "                        \"path\": \"level0_0/level1_0/level2_0\"," +
                "                        \"value\": \"value\"," +
                "                        \"children\": []" +
                "                    }," +
                "                    {" +
                "                        \"path\": \"level0_0/level1_0/level2_1\"," +
                "                        \"value\": \"value\"," +
                "                        \"children\": []" +
                "                    }," +
                "                    {" +
                "                        \"path\": \"level0_0/level1_0/level2_2\"," +
                "                        \"value\": \"value\"," +
                "                        \"children\": []" +
                "                    }" +
                "                ]" +
                "            }," +
                "            {" +
                "                \"path\": \"level0_0/level1_1/\"," +
                "                \"value\": \"value\"," +
                "                \"children\": [" +
                "                    {" +
                "                        \"path\": \"level0_0/level1_1/level2_0\"," +
                "                        \"value\": \"value\"," +
                "                        \"children\": []" +
                "                    }," +
                "                    {" +
                "                        \"path\": \"level0_0/level1_1/level2_1\"," +
                "                        \"value\": \"value\"," +
                "                        \"children\": []" +
                "                    }," +
                "                    {" +
                "                        \"path\": \"level0_0/level1_1/level2_2\"," +
                "                        \"value\": \"value\"," +
                "                        \"children\": []" +
                "                    }" +
                "                ]" +
                "            }" +
                "        ]" +
                "    }," +
                "    {" +
                "        \"path\": \"level0_1/\"," +
                "        \"value\": \"avaluerg\"," +
                "        \"children\": []" +
                "    }" +
                "]";
        String s = new String();
        s= str.replace(" ", "");
        List<Node> nodes = JSON.parseArray(s, Node.class);
        System.out.println(nodes);
        NodeUtils nodeUtils = new NodeUtils();
        Node node = nodeUtils.getNode(nodes, "level0_0/level1_1/");
        System.out.println(node);
    }
}
