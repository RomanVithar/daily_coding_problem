package com.tasks.task1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class T1 {
    private List<Integer> list = Arrays.asList(10, 15, 3, 7);
    private int k = 17;

    public void solution() {
        System.out.println(isNumberInListSum());
    }
    public boolean isNumberInListSum() {
        list.sort(Comparator.comparingInt(o -> o));
        int startIndex = 0;
        int endIndex = list.size()-1;
        while (startIndex!=endIndex) {
            if(list.get(startIndex)+list.get(endIndex)==k){
                System.out.println(list.get(startIndex)+" + "+list.get(endIndex)+" = "+ k);
                return true;
            }
            if(list.get(startIndex)+list.get(endIndex)>k){
                endIndex--;
            }else{
                startIndex++;
            }
        }
        return false;
    }
}
