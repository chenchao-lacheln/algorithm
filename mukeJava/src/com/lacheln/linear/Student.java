package com.lacheln.linear;

/**
 * Student
 *
 * @author chaochen
 * @date 2023/12/22
 * @since 1.0.0
 */
public class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }


    //覆盖方法--注意
    @Override
    public boolean equals(Object student) {
        //注意这里需要增加判断，因为(Student)student;这里强转，可能会抛出异常，导致无法强制转化。
        //判断当前对象Student是否就是(Object student)这个对象，地址是否一致。
        if (this == student) {
            return true;
        }

        //判断传递对象是否为空。
        //当前student肯定是非空，如果(Object student)传递了一个空对象，就是false。
        if (student == null) {
            return false;
        }

        //判断强转是否成立
        //当前类对象Student所对应的类是否和传递来的(Object student)中的student类对象一致。（判断是否属于同一个类）
        if (this.getClass() != student.getClass()) {
            return false;
        }

        //student是一个Object类的对象，把student强制转化为Student对象
        Student another = (Student) student;

        //判断比较相等的逻辑.
        //equals表示的是 private String name;中String类对象的equals方法
        //把2个学生类对象的比较，变成了字符串的比较。
        //如果两个学生名字对应的字符串相等，就说明2个学生一样。
        return this.name.equals(another.name);

        //注意：上面的 equals 比较逻辑可以进行其他修改。实际中，Student类中，可能不止有name这一个属性。

    }
}
