package util;

import java.util.ArrayList;
import java.util.List;
public class NestedInteger {
      List<NestedInteger> list;
      Integer num;
      NestedInteger next;
      public void NestedInteger(){
       list = new ArrayList();
      }

      public void setList(List<NestedInteger> list) {
       this.list = list;
      }

      public Integer getNum() {
       return num;
      }

       public void setNum(Integer num) {
        this.num = num;
       }

       public NestedInteger getNext() {
        return next;
       }

       public void setNext(NestedInteger next) {
        this.next = next;
       }

 // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger(){
       if (num != null)
          return true;
       else
        return false;
      }

      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger(){
         return num;
      }

      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return null if this NestedInteger holds a single integer
      public List<NestedInteger> getList(){
        return list;
      }
}