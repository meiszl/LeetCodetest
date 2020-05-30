package test;

import util.TreeNode;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class test {
    public static void main(String[] args) {
        int n = Integer.MAX_VALUE;
        System.out.println("args = " + (int)(-1+Math.sqrt(1+8*(long)n))/2);
    }
    private void sortUsingJava7(List<String> names){
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
    }
}
