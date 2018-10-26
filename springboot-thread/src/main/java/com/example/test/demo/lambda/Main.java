package com.example.test.demo.lambda;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
        //System.out.println(1<<30);
        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
        //生成一个等差数列
        Stream.iterate(0,n -> n+3).limit(10).forEach(x -> System.out.print(x + " "));
    }

    @Test
    public void test04(){
        LocalDate now = LocalDate.now();
        //是否是闰年
        boolean leapYear = now.isLeapYear();
        System.out.println(leapYear);
        //获取时间戳
        Instant timestamp = Instant.now();
        System.out.println("当前时间戳:" + timestamp);
    }

    @Test
    public void test05(){
        List<String> languages = Arrays.asList("java","scala","python");
        System.out.println("----------jdk8 before----------");
        for (String language : languages) {
            System.out.println(language);
        }
        System.out.println("----------jdk8 lambda----------");
        //languages.forEach(x -> System.out.println(x));
        languages.forEach(System.out::println);
    }

    @Test
    public void  test06(){
        List<Double> cost = Arrays.asList(10.0, 20.0,30.0);
        //map的作用是将一个对象变换为另外一个
        cost.stream().map(x -> x + x*0.05).forEach(System.out::println);
        //reduce实现的则是将所有值合并为一个
        Double all = cost.stream().map(x -> x + x*0.05).reduce((sum, x) -> sum + x).get();
        System.out.println(all);
        //从原始的集合中过滤掉一部分元素
        List<Double> collect = cost.stream().filter(x -> x > 25.0).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

}
