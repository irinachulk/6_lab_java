package com.chulk;



public class Main {

    public static void main(String[] args) {
       BinaryTree binaryTree= new BinaryTree();
        binaryTree.add(6);
        binaryTree.add(14);
        binaryTree.add(7);
        binaryTree.add(5);
        binaryTree.add(2);
        binaryTree.add(3);
        binaryTree.add(11);
        //обход дерева
        binaryTree.showInOrder(binaryTree.root);
        System.out.println();
        binaryTree.showPostOrder(binaryTree.root);
System.out.println();
        binaryTree.showPreOrder(binaryTree.root);
        //поиск минимума
        System.out.println(binaryTree.minvalue(binaryTree.root));
        ////////////////////////
        System.out.println("************************");
        TrieTree trieTree=new TrieTree();
        trieTree.insert("apple");
        trieTree.insert("actor");
        trieTree.insert("appl");
        trieTree.insert("wizard");
        trieTree.print(trieTree.root);//при выполении обхода мы понимаем что у apple и actor одинаковая буква начала и она не дублируется
                                      // appl входит в состав слова apple

    }
}
