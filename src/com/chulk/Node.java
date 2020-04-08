package com.chulk;

public class Node {
    int value;//значение текущего узла
    Node left;//ссылка на левый узел
    Node right;//ссылка на правый узел

    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }
}
