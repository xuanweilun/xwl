package com.xwl.tool;

public class BaseTest {
    public static void main(String[] args) {
        String name = null;
        int i = 0;
        while (name == null){
            i++;
            if(i == 100){
                name = "fj";
            }
            System.out.println(name);
        }
    }
}
