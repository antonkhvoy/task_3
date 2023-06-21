package org.example;

public class Main {
    public static void main(String[] args) {
        BinaryTreeSet<Integer> set = new BinaryTreeSet<>();

        // добавление элементов в множество
        set.add(5);
        set.add(3);
        set.add(8);
        set.add(1);
        set.add(4);
        set.add(7);

        // печать элементов в порядке возрастания
        System.out.println("Элементы в порядке возрастания:");
        set.printInOrder();
        System.out.println();

        // проверка, существуют ли в множестве заданные элементы
        System.out.println("Есть ли 3? " + set.contains(3));
        System.out.println("Есть ли 6? " + set.contains(6));
        System.out.println();

        // удаление элементов из множества
        System.out.println("Удаление 3: " + set.remove(3));
        System.out.println("Удаление 6: " + set.remove(6));
        System.out.println();

        System.out.println("Элементы множества после удаления в порядке возрастания:");
        set.printInOrder();
        System.out.println();
    }
}