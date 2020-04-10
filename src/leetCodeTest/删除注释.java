package leetCodeTest;

import java.util.ArrayList;
import java.util.List;

public class 删除注释 {
    public static void main(String[] args) {
        String[] source = new String[]{"a/*/b//*c","blank","d/*/e*//f"};
        List<String> list = removeComments(source);
        System.out.println("list = " + list);
    }

    /**
     * 使用indexof找到注释开始的位置，然后遍历向下寻找结束位置，截取注释之外的字符。
     * @param source
     * @return
     */
    public static List<String> removeComments(String[] source) {
        int i;
        List<String> list = new ArrayList();
        for (i=0;i<source.length;i++){
            int startBlock = source[i].indexOf("/*");
            int startLine = source[i].indexOf("//");
            if (startBlock >= 0 && (startLine < 0 || startBlock <startLine)){
                String substring = source[i].substring(0, startBlock);
                source[i] = source[i].substring(startBlock + 2);
                while (source[i].indexOf("*/") == -1){
                    i++;
                }
                int blockEnd = source[i].indexOf("*/");
                source[i] = substring + source[i].substring(blockEnd + 2);
                i--;
            }else if (startLine >= 0 && (startBlock < 0 || startLine < startBlock)){
                source[i] = source[i].substring(0,startLine);
                i--;
            }else {
                if (!source[i].isEmpty())
                    list.add(source[i]);
            }
        }
        return list;
    }
}
