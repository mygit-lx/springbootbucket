package com.example.test.demo.lambda;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * 函数式与命令式编程
 */
public class Main {

    static Integer count = 0;
    public static void getCount(){
        count++;
        System.out.println(count);
    }

    public static void T(){
        for (int i = 0; i < 20; i++) {
            new Thread(() -> getCount()).start();
        }
    }

    public static void main(String[] args) {
        new Thread(() -> T()).start();
        new Thread(() -> T()).start();
        new Thread(() -> T()).start();
    }

    @Test
    public void test01(){
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8};

        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if(num<min){
                min = num;
            }
        }
        System.out.println(min);
        System.out.println("-------------函数式编程-------------");
        System.out.println(IntStream.of(nums).min().getAsInt());
    }

    @Test
    public void test02(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running");
            }
        }).start();
        System.out.println("-------------函数式编程-------------");
        //注：箭头的左边是输入，右边则是输出
        new Thread(() -> System.out.println("Running")).start();
    }

    @Test
    public void test03(){
        Map<String,Object> map = new HashMap<>();
        System.out.println(1<<30);
    }
}
