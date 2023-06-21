package org.example;

// бинарное дерево
public class BinaryTreeSet<E extends Comparable<E>> {
    private Node root;

    // узел дерева
    private class Node {
        private E value;
        private Node left;
        private Node right;

        public Node(E value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    // добавление элемента в множество, если такого еще нет
    public boolean add(E elem) {
        if (contains(root, elem)) {
            return false;
        }

        root = add(root, elem);
        return true;
    }

    private Node add(Node node, E elem) {
        if (node == null) {
            return new Node(elem);
        }

        if (elem.compareTo(node.value) < 0) {
            node.left = add(node.left, elem);
        } else {
            node.right = add(node.right, elem);
        }

        return node;
    }

    // проверка, содержит ли множество определенный элемент
    public boolean contains(E elem) {
        return contains(root, elem);
    }

    private boolean contains(Node node, E elem) {
        if (node == null) {
            return false;
        }

        int cmp = elem.compareTo(node.value);
        if (cmp < 0) {
            return contains(node.left, elem);
        } else if (cmp > 0) {
            return contains(node.right, elem);
        } else {
            return true;
        }
    }

    // удаление элемента из множества, если он существует
    public boolean remove(E elem) {
        if (!contains(root, elem)) {
            return false;
        }

        root = remove(root, elem);
        return true;
    }

    private Node remove(Node node, E elem) {
        if (node == null) {
            return null;
        }

        int cmp = elem.compareTo(node.value);
        if (cmp < 0) {
            node.left = remove(node.left, elem);
        } else if (cmp > 0) {
            node.right = remove(node.right, elem);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                Node successor = findMin(node.right);
                node.value = successor.value;
                node.right = remove(node.right, successor.value);
            }
        }

        return node;
    }

    // находение минимального элемента в заданном поддереве.
    // Метод рекурсивно обходит левое поддерево, пока не достигнет узла с наименьшим значением.
    private Node findMin(Node node) {
        if (node.left == null) {
            return node;
        }

        return findMin(node.left);
    }

    // печать элементов в порядке возрастания
    public void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.value + " ");
            printInOrder(node.right);
        }
    }
}