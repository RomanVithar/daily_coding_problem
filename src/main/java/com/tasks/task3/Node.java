package com.tasks.task3;

import java.util.Objects;

public class Node {
    public String val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(String val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public Node(String val, Node left) {
        this(val, left, null);
    }

    public Node(String val) {
        this(val, null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(val, node.val) &&
                Objects.equals(left, node.left) &&
                Objects.equals(right, node.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }
}
