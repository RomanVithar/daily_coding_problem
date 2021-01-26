package com.tasks.task3;

import junit.framework.TestCase;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;

public class T3Test extends TestCase {

    public void testSerialize() throws IOException {
        T3 t3 = new T3();
        t3.setRoot(new Node("root",
                new Node("left", new Node("left.left")),
                new Node("right")));
        File file = new File("src\\main\\java\\com\\tasks\\task3\\data.json");
        Assert.assertEquals("left.left", t3.getRoot().left.left.val);
        t3.serialize(file);
        t3.deserialize(file);
        Assert.assertEquals("left.left", t3.getRoot().left.left.val);
    }

    public void testMySerialize() throws IOException {
        T3 t3 = new T3();
        t3.setRoot(new Node("root",
                new Node("left", new Node("left.left")),
                new Node("right")));
        File file = new File("src\\main\\java\\com\\tasks\\task3\\data.json");
        Assert.assertEquals("left.left", t3.getRoot().left.left.val);
        t3.mySerialize(file);
        t3.myDeserialize(file);
        Assert.assertEquals("left.left", t3.getRoot().left.left.val);
    }
}