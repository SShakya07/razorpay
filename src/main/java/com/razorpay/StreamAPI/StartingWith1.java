package com.razorpay.StreamAPI;

import java.util.List;
import java.util.stream.Collectors;

public class StartingWith1 {

    public static void main(String[] args) {
        List<Integer> list = List.of(12,3,4,38,11,1,8,91);
        List<String> collect = list.stream().map(i -> i + "").filter(i -> i.startsWith("1")).collect(Collectors.toList());
        System.out.println(collect);
    }
}
