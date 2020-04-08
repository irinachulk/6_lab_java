package com.chulk;

import java.util.HashMap;
import java.util.Map;

public class TrieTree {
    public TrieNode root;

    TrieTree() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode current = root;//начинаем от корня

        for (int i = 0; i < word.length(); i++) {//идем по буквам слова
            current = current.getChildren().computeIfAbsent(word.charAt(i), c -> new TrieNode());//проверяет существует ли уже в дереве такая буква,если да,то ничего не делаем,иначе добавляем
        }
        current.setEndOfWord(true);
    }

    boolean deleted(String word) {
        return delete(root, word, 0);
    }//вызываем рекурсивное удаление

    boolean checker(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.getChildren().get(ch);//проверяем на совпадение каждой буквы с каждым узлом дерева
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.isEndOfWord();
    }

    boolean isEmpty() {
        return root == null;
    }

    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord()) {//выход из рекурсии
                return false;
            }
            current.setEndOfWord(false);
            return current.getChildren().isEmpty();//удаляем узел
        }
        char ch = word.charAt(index);
        TrieNode node = current.getChildren().get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.isEndOfWord();//спускаемся ниже

        if (shouldDeleteCurrentNode) {
            current.getChildren().remove(ch);
            return current.getChildren().isEmpty();
        }
        return false;
    }
    public static void print(TrieNode node) {
        print2(node,0);
    }//вызов рекурсии

   static Map<Integer,String> levelMap = new HashMap<Integer,String>();//уровневая карта
    static String getSpace(int level) { //определяем количество пробелов необходиых для переданного уровня иерархии
        String result = levelMap.get(level);
        if (result == null) {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<level; i++) {
                sb.append(" ");
            }
            result = sb.toString();
            levelMap.put(level,result);
        }
        return result;
    }
    private static void print2(TrieNode node, int level) {//выводим дерево с пробелами,характеризующими иерархию
        for (Character ch : node.getChildren().keySet()) {
            System.out.println(getSpace(level)+ch);
            print2(node.getChildren().get(ch), level+1);
        }
        if (node.isEndOfWord()) {
            System.out.println();
        }
    }
}

