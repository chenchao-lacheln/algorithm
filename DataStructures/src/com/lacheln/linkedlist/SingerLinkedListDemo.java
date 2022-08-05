package com.lacheln.linkedlist;

/**
 * SingerLinkedList
 * 单向链表
 *
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
//        singerLinkedList.add(hero1);
//        singerLinkedList.add(hero4);
//        singerLinkedList.add(hero2);
//        singerLinkedList.add(hero3);

        //加入 按照编号的顺序
        singerLinkedList.addByOrder(hero1);
        singerLinkedList.addByOrder(hero4);
        singerLinkedList.addByOrder(hero2);
        singerLinkedList.addByOrder(hero3);
        singerLinkedList.addByOrder(hero3);

        //显示列表
        singerLinkedList.list();

        // 测试修改结点代码
        HeroNode newHeroNode = new HeroNode(3, "小卢", "玉麒麟~~");
        singerLinkedList.update(newHeroNode);

        System.out.println("修改后的链表的情况");
        singerLinkedList.list();

        //删除一个结点
        singerLinkedList.del(1);
        System.out.println("删除后的链表的情况");
        singerLinkedList.list();

        //求单链表的有效节点的个数
        System.out.println("有效的节点个数 = " + getLength(singerLinkedList.getHead()));
    }

    //查找单链表中的倒数第K个节点【新浪面试题】


    //获取到单链表的节点的个数（如果是带头结点的链表，需求不统计头结点）
    /**
     *
     * @param head 链表的头结点
     * @return 返回有效节点的个数
     */
    public static int getLength(HeroNode head){
        if (head.next == null){//空链表
            return 0;
        }
        int length = 0;
        //定义一个辅助变量
        HeroNode cur = head.next; //没有统计头结点
        while (cur != null){
            length++;
            cur = cur.next;//遍历
        }
        return length;
    }
}

//定义 SingerLinkedList管理英雄
class SingerLinkedList {
    // 初始化头结点，头结点不动，不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    //返回头结点
    public HeroNode getHead() {
        return head;
    }

    /**
     * 单向链表-不考虑编号顺序
     * @param heroNode
     */
    // 添加结点到单向链表 -当不考虑编号顺序时
    // 1.找到当前链表的最后结点
    // 2.将最后这个结点的 next  指向新的结点
    public void add(HeroNode heroNode) {
        //因为head结点不能动，因此我们需要一个辅助变量temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后，将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后这个结点的next 指向新的结点
        temp.next = heroNode;
    }

    /**
     *  单向链表-按照编号添加
     * @param heroNode
     */
    //第二种方式，在添加英雄时，根据排名将英雄插入到指定位置(如果有这个排名，则添加失败，并给出提示)
    public void addByOrder(HeroNode heroNode) {
        //头结点不能动，需要添加辅助辅助变量，来帮助找到添加的位置
        //因为单链表，因为我们找的temp 是位于添加位置的前一个结点，否则插入不了
        HeroNode temp = head;
        boolean flag = false; //flag 标志 添加的编号是否存在，默认为false
        while (true) {
            if (temp.next == null) { //说明temp已经在链表的最后
                break;
            }
            if (temp.next.no > heroNode.no) { //位置找到，就temp的后面插入
                break;
            } else if (temp.next.no == heroNode.no) { //说明 希望添加的 heroNode 的编号已经存在
                flag = true;// 编号存在
                break;
            }
            temp = temp.next; //后移，遍历当前链表
        }
        if (flag) { //不能添加，说明编号存在
            System.out.printf("准备插入的英雄编号 %d 已经存在，不能加入\n", heroNode.no);
        } else {
            //插入到链表中，temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //修改结点信息,根据no编号来修改，即no编号不能改
    //说明
    //1.根据newHeroNode 的no 来修改即可
    public void update(HeroNode newHeroNode) {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        //找到需要修改的结点，根据no编号
        //定义一个辅助变量
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break; //已经遍历完链表
            }
            if (temp.no == newHeroNode.no) {
                flag = true; //找到了
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到了要修改的结点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.printf("没有找到编号 %d 的结点，不能修改\n", newHeroNode.no);
        }

    }

    //删除结点
    //思路
    //1.head 不能动，因为我们需要一个temp辅助结点，找到待删结点的前一个结点
    //2.说明我们在比较时，是temp.next.no 和 需要删除的结点的no比较
    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false; // 标志是否找到待删除的结点
        while (true) {
            if (temp.next == null) { //已经到链表的最后
                break;
            }
            if (temp.next.no == no) {
                //找到了待删除结点的前一个结点 temp
                flag = true;
                break;
            }
            temp = temp.next; //temp 后移
        }
        if (flag){ //找到
             temp.next = temp.next.next;
        }else {
            System.out.printf("要删除的 %d 结点，不存在",no);
        }
    }

    //显示链表
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //头结点不能动，需要定义辅助变量进行遍历
        HeroNode temp = head.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
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
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname +
                '}';
    }
}
