package leetCodeTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class 根据身高重建队列 {
    public static void main(String[] args) {
        int[][] people = new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int[][] ints = reconstructQueue(people);
        for (int[] anInt : ints) {
            System.out.println("Arrays.toString(anInt) = " + Arrays.toString(anInt));
        }
    }
    public static int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0||people[0].length == 0) return new int[0][0];
        Arrays.sort(people, ((o1, o2) -> o1[0] == o2[0]?o1[1] - o2[1]:o2[0] - o1[0]));
        List<int[]> output = new LinkedList<>();
        for(int[] p : people){
            output.add(p[1], p);
        }

        int n = people.length;
        return output.toArray(new int[n][2]);
    }
}
