package com.vision.linkedList;

public class ReSingleLinkedList {
   //创建头节点
    private HeroNode head=new HeroNode(0,null,null);

    //添加节点
    public void addNode(HeroNode heroNode){
        //遍历查找next为null的节点
        HeroNode tempNode=head;
        while (true){
            if(tempNode.next==null){
                break;
            }
            tempNode=tempNode.next;
        }
        tempNode.next=heroNode;
    }

    public void showNodes(){
        if(head.next==null){
            System.out.println("当前链表为空！");
            return;
        }
        HeroNode tempNode=head.next;
        while (true){
            if(tempNode==null){
                return ;
            }
            System.out.println(tempNode);
            tempNode=tempNode.next;
        }
    }
}
