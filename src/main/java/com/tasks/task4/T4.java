package com.tasks.task4;

import java.util.Collections;
import java.util.List;

public class T4 {
    public int solution(List<Integer> list) {
        divideNumbers(list);
        return minPositive(getIndexStartPositive(list), list);
    }

    private void divideNumbers(List<Integer> list) {
        int j = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > 0) {
                Collections.swap(list, i, j);
                j++;
            }
        }
    }

    private int getIndexStartPositive(List<Integer> list) {
        return (int) list.stream().filter(a -> a > 0).count();
    }

    private int minPositive(int size, List<Integer> list) {
        for (int i = 0; i < size; i++) {
            int x = Math.abs(list.get(i));
            if (x - 1 < size && list.get(x - 1) > 0) {
                list.set(x - 1, -list.get(x - 1));
            }
        }
        for (int i = 0; i < size; i++) {
            if (list.get(i) > 0) {
                return i + 1;
            }
        }
        return size + 1;
    }
}
