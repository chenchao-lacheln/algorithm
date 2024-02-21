package com.lacheln.selectionSort;

/**
 * SelectionSort2
 *
 * @author chaochen
 * @date 2023/12/27
 * @since 1.0.0
 */
public class SelectionSort3 {
    private SelectionSort3() {
    }

    public static <E extends Comparable<E>> void srot(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 4, 2, 3, 6, 5};
        SelectionSort3.srot(arr);
        for (int e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();

        Student[] students = {
                new Student("Alice",98),
                new Student("Jack",100),
                new Student("Charles",67),
        };
        SelectionSort3.srot(students);
        for (Student student : students){
            System.out.print(student + " ");
        }
        System.out.println();
    }
}
