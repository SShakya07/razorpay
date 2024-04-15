package com.razorpay.StreamAPI;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindDuplicate {
    public static void main(String[] args) {
        List<Integer> list = List.of(2,4,5,2,7,1,0,1);
        Set<Integer> set = new HashSet();
       list.stream().filter(i -> !set.add(i)).forEach(System.out::println);


    }
}
