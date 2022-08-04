package com.lacheln.linkedlist;

/**
 * SingerLinkedList
 * 单向链表 按照顺序添加
 * @author lacheln
 * @date 2022/8/4 21:47
 * @since 1.0.0
 */
public class SingerLinkedListDemo {
    public static void main(String[] args) {
        //创建结点
        HeroNode hero1 = new HeroNode(1, "晁盖", "托塔天王");
        HeroNode hero2 = new HeroNode(2, "宋江", "及时雨");
        HeroNode hero3 = new HeroNode(3, "卢俊义", "玉麒麟");
        HeroNode hero4 = new HeroNode(4, "吴用", "智多星");

        //创建链表
        SingerLinkedList singerLinkedList = new SingerLinkedList();
        //加入
        singerLinkedList.add(hero1);
        singerLinkedList.add(hero2);
        singerLinkedList.add(hero3);
        singerLinkedList.add(hero4);

        //显示列表
        singerLinkedList.list();

    }
}

//定义 SingerLinkedList管理英雄
class SingerLinkedList {
    // 初始化头结点，头结点不动，不存放具体的数据
    private HeroNode head = new HeroNode(0,"","");

    // 添加结点到单向链表
    // 当不考虑编号顺序时
    // 1.找到当前链表的最后结点
    // 2.将最后这个结点的 next  指向新的结点
    public void add(HeroNode heroNode){
        //因为head结点不能动，因此我们需要一个辅助变量temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true){
            //找到链表的最后
            if (temp.next == null){
                break;
            }
            //如果没有找到最后，将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后这个结点的next 指向新的结点
        temp.next = heroNode;
    }

    //显示链表
    public void list(){
        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //头结点不能动，需要定义辅助变量进行遍历
        HeroNode temp = head.next;
        while (true){
            //判断是否到链表最后
            if (temp == null){
                break;
            }
            //输出结点信息
            System.out.println(temp);
            //将temp 后移
            temp = temp.next;
        }
    }
}

//定义HeroNode，每个HeroNode就是一个对象
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next; //指向下一个结点

    //构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no  +
                ", name='" + name + '\'' +
                ", nickname='" + nickname +
                '}';
    }
}
