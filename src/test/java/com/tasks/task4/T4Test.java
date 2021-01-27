package com.tasks.task4;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

public class T4Test extends TestCase {

    public void testSolution() {
        T4 t = new T4();
        List<Integer> list = Arrays.asList(3, 4, -1, 1);
        List<Integer> list2 = Arrays.asList(1,2,3,4,5,6);
        List<Integer> list3 = Arrays.asList(6,5,3,1);

        Assert.assertEquals(2,t.solution(list));
        Assert.assertEquals(7,t.solution(list2));
        Assert.assertEquals(2,t.solution(list3));
    }
}