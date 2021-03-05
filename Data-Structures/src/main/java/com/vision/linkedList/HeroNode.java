package com.vision.linkedList;

public class HeroNode {
    public int heroNo;
    public String heroName;
    public String heroNickname;
    public HeroNode next;

    public HeroNode(int heroNo, String heroName, String heroNickname) {
        this.heroNo = heroNo;
        this.heroName = heroName;
        this.heroNickname = heroNickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "heroNo=" + heroNo +
                ", heroName='" + heroName + '\'' +
                ", heroNickname='" + heroNickname + '\'' +
                ", next=" + next +
                '}';
    }
}
