package leetCodeTest;

import util.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class 扁平化嵌套列表迭代器 {
    public static void main(String[] args) {
//        NestedInteger nestedInteger = new NestedInteger();
//        nestedInteger.setNum(1);
//        NestedInteger nestedInteger1 = new NestedInteger();
//        nestedInteger1.setNum(1);
//        List<NestedInteger> list = new ArrayList<>();
//        list.add(nestedInteger);
//        list.add(nestedInteger1);
//        NestedInteger nestedInteger2 = new NestedInteger();
//        nestedInteger2.setList(list);
//        NestedInteger nestedInteger3 = new NestedInteger();
//        nestedInteger3.setNum(2);
//        List<NestedInteger> list1 = new ArrayList<>();
//        list1.add(nestedInteger);
//        list1.add(nestedInteger1);
//        NestedInteger nestedInteger4 = new NestedInteger();
//        nestedInteger4.setList(list1);
//        List<NestedInteger> list2 = new ArrayList<>();
//        list2.add(nestedInteger2);
//        list2.add(nestedInteger3);
//        list2.add(nestedInteger4);
        NestedInteger nestedInteger = new NestedInteger();
        nestedInteger.setNum(1);
        NestedInteger nestedInteger1 = new NestedInteger();
        nestedInteger1.setNum(4);
        NestedInteger nestedInteger2 = new NestedInteger();
        nestedInteger2.setNum(6);
        List<NestedInteger> list = new ArrayList<>();
        List<NestedInteger> list1 = new ArrayList<>();
        List<NestedInteger> list2 = new ArrayList<>();
        list.add(nestedInteger2);
        NestedInteger nestedInteger3 = new NestedInteger();
        nestedInteger3.setList(list);
        list1.add(nestedInteger1);
        list1.add(nestedInteger3);
        NestedInteger nestedInteger4 = new NestedInteger();
        nestedInteger4.setList(list1);
        list2.add(nestedInteger);
        list2.add(nestedInteger4);
        NestedIterator nestedIterator = new NestedIterator(list2);
        List<Integer> res = new ArrayList<>();
        while (nestedIterator.hasNext()){
            res.add(nestedIterator.next());
        }
        System.out.println("res = " + res);
    }
}

/**
 * 递归实现，套娃输出。
 */
//class NestedIterator implements Iterator<Integer> {
//    private List<Integer> list1;
//    int point;
//    public NestedIterator(List<NestedInteger> nestedList) {
//        list1 = new ArrayList<>();
//        findAllInteger(nestedList);
//        point = 0;
//        System.out.println("list1 = " + list1);
//    }
//
//    @Override
//    public Integer next() {
//        return list1.get(point++);
//    }
//
//    @Override
//    public boolean hasNext() {
//        if (point >= list1.size())
//            return false;
//        else
//            return true;
//    }
//
//    public List<Integer> findAllInteger(List<NestedInteger> list){
//        int i;
//        for (i=0;i<list.size();i++){
//            if (list.get(i).isInteger()){
//                list1.add(list.get(i).getInteger());
//            }else {
//                findAllInteger(list.get(i).getList());
//            }
//        }
//        return list1;
//    }
//}

/**
 * 使用栈代替递归实现
 */
class NestedIterator implements Iterator<Integer> {
    private Stack<NestedInteger> list1;
    public NestedIterator(List<NestedInteger> nestedList) {
        list1 = new Stack<>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            list1.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return list1.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!list1.isEmpty()){
            NestedInteger pop = list1.peek();
            if (pop.isInteger()){
                return true;
            }
            list1.pop();
            List<NestedInteger> list = pop.getList();
            for (int i = list.size() - 1; i >= 0; i--) {
                list1.push(list.get(i));
            }
        }
        return false;
    }

}