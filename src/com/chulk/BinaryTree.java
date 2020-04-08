package com.chulk;


import javax.swing.*;

public class BinaryTree {

    Node root;


    private Node addRecurs(Node current, int value) {
        if (current == null) {
            return new Node(value);//если текущий узел нулевой-создаем узел, выход из рекурсии
        }
        if (value < current.value) {
            current.left = addRecurs(current.left, value);//если значение меньше значения текущего узла,то он будет располагаться левее
        } else if (value > current.value) {
            current.right = addRecurs(current.right, value);//иначе левее
        } else {
            //значение уже существует
            return current;
        }

        return current;
    }
    public void add(int value) {
        root = addRecurs(root, value);
    }//вызываем рекурсивное добавление

    private boolean checkRecurs(Node current, int value) {
        if (current == null) { //выход из рекурсии, если текущий узел нулевой->значение не найдено
            return false;
        }
        if (value == current.value) {//если совпадает,то найден
            return true;
        }
        return value < current.value//спускаемся ниже по иерархии,выбор направления зависит от value
                ? checkRecurs(current.left, value)
                : checkRecurs(current.right, value);
    }
    public boolean check(int value) {
        return checkRecurs(root, value);
    }//вызов рекурсивной проверки


    private Node deleteRecurs(Node current, int value) {//удаление
        if (current == null) {//свыход из рекурсии
            return null;
        }

        if (value == current.value) {//нашли узел
            if (current.left == null && current.right == null) {//нет дочерних узлов
                return null;
            }
            if (current.right == null) {//один левый дочерний узел
                return current.left;
            }

            if (current.left == null) {//один правый дочерний узел
                return current.right;
            }
            if (current.left != null && current.right != null) {//два дочерних узла
                int smallestValue = minvalue(current.right);//ищем узел для замены удаленному,самый минимальный
                current.value = smallestValue;
                current.right = deleteRecurs(current.right, smallestValue);
                return current;
            }

        }
        if (value < current.value) {
            current.left = deleteRecurs(current.left, value);//спускаемся вниз по иерархии
            return current;
        }
        current.right = deleteRecurs(current.right, value);//спускаемся вниз по иерархии
        return current;
    }
   public int minvalue(Node root) {
        return root.left == null ? root.value : minvalue(root.left);
    }//поиск мин элемента

    public void delete(int value) {
        root = deleteRecurs(root, value);
    }//вызов рекурсивной функции


    public void showInOrder(Node node) {//Симметричный (in-order)Обойти левое поддерево-Посетить корень-Обойти правое поддерево
        if (node != null) {
            showInOrder(node.left);
            System.out.print(" " + node.value);
            showInOrder(node.right);
        }
    }
    public void showPostOrder(Node node) {//В обратном порядке (post-order)Обойти левое поддерево-Обойти правое поддерево-Посетить корень

        if (node != null) {
            showPostOrder(node.left);
            showPostOrder(node.right);
            System.out.print(" " + node.value);
        }
    }
    public void showPreOrder(Node node) {//Прямой (pre-order)Посетить корень-Обойти левое поддерево-Обойти правое поддерево
        if (node != null) {
            System.out.print(" " + node.value);
            showPreOrder(node.left);
            showPreOrder(node.right);
        }
    }
}