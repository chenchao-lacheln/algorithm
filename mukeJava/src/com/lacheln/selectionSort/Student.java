package com.lacheln.selectionSort;

/**
 * Student
 *
 * @author chaochen
 * @date 2023/12/22
 * @since 1.0.0
 * 对Student类进行排序
 */

//implements Comparable<Student> 实现Comparable接口，针对Student类进行比较
public class Student implements Comparable<Student> {
    private String name;
    private int score; //对学生排序，希望是根据学生分数进行排序。

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    //实现compareTo方法
    @Override
    public int compareTo(Student another) {
//        if (this.score < another.score){
//            return -1;
//        }else if (this.score == another.score){
//            return 0;
//        }else {
//            return 1;
//        }
        // 相减是负数就直接返回负数，相减是正数就直接返回正数。
//        return this.score - another.score; //从小到大排序
        return another.score - this.score; //从大到小排序
    }

    //覆盖方法--注意
    @Override
    public boolean equals(Object student) {
        if (this == student) {
            return true;
        }
        if (student == null) {
            return false;
        }
        if (this.getClass() != student.getClass()) {
            return false;
        }
        Student another = (Student) student;
        return this.name.toLowerCase().equals(another.name.toLowerCase());
    }

    //打印Student类对象
    @Override
    public String toString() {
        return String.format("Student(name:%s,score:%d)", name, score);
    }
}
