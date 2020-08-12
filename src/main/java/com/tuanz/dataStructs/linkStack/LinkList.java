package com.tuanz.dataStructs.linkStack;

public class LinkList {

    private Link first;

    public void LinkList(){
        first = null;
    }

    public boolean isEmpty(){
        return (first==null);
    }

    /**
     * 在表头插入新链结点
     * @param dd
     */
    public void insertFirst(long dd){
        Link newLink = new Link(dd);
        newLink.next = first;
        first = newLink;
    }

    /**
     * 删除链结点
     * @return
     */
    public long deleteFirst(){
        Link temp = first;
        first = first.next;
        return temp.dData;
    }

    public void displayList(){
        //System.out.print("List (first-->last): ");
        Link current = first;
        while (current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}
