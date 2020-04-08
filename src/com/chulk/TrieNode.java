package com.chulk;

import java.util.HashMap;
import java.util.Map;
class TrieNode {
    private final Map<Character, TrieNode> children = new HashMap<>();
    private boolean endOfWord;//конец слова

    Map<Character, TrieNode> getChildren() {
        return children;
    }//вернуть потомка

    boolean isEndOfWord() {
        return endOfWord;
    }

    void setEndOfWord(boolean endOfWord) {
        this.endOfWord = endOfWord;
    }
}