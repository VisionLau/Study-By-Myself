package com.vision.linkedList;

public class SingleLinkedList {
    private HeroNode head=new HeroNode(0,null,null);

    /**
     * 添加节点
     * @param heroNode  需要添加进单链表的新节点
     */
    public void addNode(HeroNode heroNode){
        //创建临时节点
        HeroNode tempNode=head;
        //通过死循环找next为null的节点
        while (true){
            //找到了直接结束循环
            if(tempNode.next==null){
                break;
            }
            //没找到可以继续找
            tempNode=tempNode.next;
        }
        //通过循环后  我们找到了最后一个节点  直接将heroNode给它即可
        tempNode.next=heroNode;
    }

    public void showAllNode(){
       //先判断单链表中是否有节点  没有直接返回
        if(head.next==null){
            System.out.println("链表中没有节点");
            return ;
        }
        //有 就直接获取头节点的下个节点 也就是一号节点
        HeroNode tempNode=head.next;
        //死循环遍历
        while(true){
            //没有下个节点就停止遍历
            if(tempNode==null){
                break;
            }
            //打印节点信息
            System.out.println(tempNode);
            //重新获取下个节点
            tempNode=tempNode.next;
        }
    }
}
