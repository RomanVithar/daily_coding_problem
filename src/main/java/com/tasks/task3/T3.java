package com.tasks.task3;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T3 implements Serializable {
    private Node root;
    private final ObjectMapper objectMapper;
    private  Pattern pattern;

    public T3() {
        root = null;
        objectMapper = new ObjectMapper();
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void serialize(File file) throws IOException {
        objectMapper.writeValue(file, root);
    }

    public void deserialize(File file) throws IOException {
        root = objectMapper.readValue(file, Node.class);
    }

    public void mySerialize(File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file, false);
        StringBuilder stringBuilder = new StringBuilder();
        createString(stringBuilder, root);
        fileWriter.write(stringBuilder.toString());
        fileWriter.close();
    }

    private void createString(StringBuilder stringBuilder, Node currentNode) {
        stringBuilder.append(currentNode.val).append("{");
        if (currentNode.left == null) {
            stringBuilder.append("null");
        } else {
            createString(stringBuilder, currentNode.left);
        }
        stringBuilder.append(";");
        if (currentNode.right == null) {
            stringBuilder.append("null");
        } else {
            createString(stringBuilder, currentNode.right);
        }
        stringBuilder.append("}");
    }

    public void myDeserialize(File file) throws IOException {
        String str = Files.lines(Paths.get(file.getPath())).reduce("", String::concat);
        pattern = Pattern.compile("([\\w,.]+)\\{([\\w,.;{}]+});([\\w,.;}{]+)}");
        root = createTree(str);
    }

    private Node createTree(String str) {
        Pattern patternCheckNull = Pattern.compile("([\\w,.]+)\\{null;null}");
        Matcher matcherCheckNull = patternCheckNull.matcher(str);
        if(matcherCheckNull.find()){
            if(matcherCheckNull.start() == 0 && matcherCheckNull.end() == str.length()){
                return new Node(matcherCheckNull.group(1), null,null);
            }
        }
        Matcher matcher = pattern.matcher(str);
        if(matcher.find()) {
            return new Node(matcher.group(1),
                    createTree(matcher.group(2)),
                    createTree(matcher.group(3)));
        }
        return null;
    }
}
