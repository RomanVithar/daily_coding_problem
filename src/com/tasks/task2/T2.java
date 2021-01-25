package com.tasks.task2;

import java.util.Arrays;
import java.util.List;

public class T2 {
    List<Integer> list = Arrays.asList(1,2,3,4,5);

    public void solution() {
        int multiplication = list.stream().mapToInt(e -> e).reduce(1, (a, b) -> a * b);
        for(int i = 0;i<list.size();i++) {
            list.set(i,multiplication/list.get(i));
        }
        System.out.println(list);
    }
}
