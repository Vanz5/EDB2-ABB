package br.com.waldson.aula11;

import java.util.Objects;

public class Node {
    private Node left;
    private Node right;
    private int value;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getValue() {
        return value;
    }

    public void insert(Node node) {
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.insert(node);
            }
        } else if (node.value > this.value) {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.insert(node);
            }
        }
    }

    public Node search(int key) {
        if (key == this.value) {
            return this;
        }

        if (key < this.value) {
            if (this.left != null) {
                return this.left.search(key);
            }
        }

        if (key > this.value) {
            if (this.right != null) {
                return this.right.search(key);
            }
        }

        return null;
    }

    public Node removeNode(Node node, int key){
        if (node == null){
            return node;
        }
        if(key > node.getValue()){
            node.right = removeNode(node.right,key);
        }
        else if(key < node.getValue()){
            node.left = removeNode(node.left,key);
        }
        else{
            if(key == node.getValue()){
                if (node.getLeft() == null && node.getRight() == null){
                    return null;
                }
                else if(node.getLeft() == null){
                    return  node.getRight();
                }
                else if(node.getRight() == null){
                    return  node.getLeft();
                }
                else{
                    int menor = removeMenorNode(node.right);
                    node.value = menor;
                    node.right = removeNode(node.right,node.getValue());
                }
            }
        }
        return node;
    }

    private int removeMenorNode(Node node) {
        if(node.left != null){
            return removeMenorNode(node.left);
        }
        return node.getValue();
    }
}
