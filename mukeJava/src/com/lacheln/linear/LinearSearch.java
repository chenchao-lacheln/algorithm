package com.lacheln.linear;

/**
 * LinearSearch
 *
 * @author chaochen
 * @date 2023/12/22
 * @since 1.0.0
 */
public class LinearSearch {
    //线性查找
    //不希望用户创建LinearSearch对象，可以把LinearSearch构造函数设置成私有，外界无法调用
    private LinearSearch() {
    }

    ;

    //    定义泛型方法，不指定类型，用户调用时指定
    public static <E> int search(E[] data, E target) {
        for (int i = 0; i < data.length; i++) {
            //此时 data[i] 和 target是一个类对象，此时判断两个类型相等时，不能用 == ，==是判断的引用相等。
            //这里是需要判断值相等
            //注意：对于不同类来说，里面的equals()方法，具体实现逻辑有可能是不同的；
            //     当前是使用Integer作为例子，在java中Integer已经帮助我们实现了equals了，包括8个基本数据类型的包装类。
             //但是，如果使用自己定义的类的话，就需要在自己定义的类中，实现equals的逻辑。
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] data = {24, 18, 12, 19, 16, 66, 22, 4};

        //1.在java语言中，泛型只能接受类对象，不能接受基本数据类型。
        //2.<Integer>search老版本中写<Integer表示将要调用泛型方法，java8中可以省略
        //3.类型推断机制：search(data, 16); 可以自动推断出用户调用的search所对应的类型就是Integer类型 public static <E> int search(E[] data, E target) {}
        int res = LinearSearch.<Integer>search(data, 16);
        System.out.println(res);

        int res2 = LinearSearch.search(data, 999);
        System.out.println(res2);

        //注意：在实际的比较中，可能会有需求，需要忽略名字的大小写。进行比较。 可以在代码中进行修改.
        Student[] students = {new Student("lacheln"),new Student("jack"),new Student("kafka")};
        Student jack = new Student("JACK");
        int res3 = LinearSearch.search(students,jack);
        System.out.println(res3); //-1 实际上数组中是存在这个名字的。
    }

    // TODO: 2023/12/22 当前无法避免重复代码编写：只能在int类型种查找一个int类型的数，java种基本数据类型有8种。不希望重复的写search方法
    //解决方法：泛型，让search函数处理不同的数据类型。

    // TODO: 2023/12/22 设计一个student类，编写equals方法。

}

