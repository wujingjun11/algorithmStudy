package com.tuanz.link;

/**
 * 单链表
 */
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
     * @param id
     * @param dd
     */
    public void insertFirst(int id,double dd){
        Link newLink = new Link(id,dd);
        newLink.next = first;
        first = newLink;
    }

    /**
     * 删除链结点
     * @return
     */
    public Link deleteFirst(){
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void displayList(){
        System.out.print("List (first-->last): ");
        Link current = first;
        while (current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }

    /**
     * 根据结点查询
     * @param key
     * @return
     */
    public Link find(int key){
        Link current = first;
        while (current.iData != key){
            if(current.next == null){
                return null;
            }else {
                current = current.next;
            }
        }
        return current;
    }

    public Link delete(int key){
        Link current = first;
        Link previous = first;
        while (current.iData != key){
            if(current.next==null){
                return null;
            }else {
                previous =current;
                current = current.next;
            }
        }
        //置换前后结点
        if(current == first){
            first = first.next;
        }else {
            previous.next = current.next;
        }
        return current;
    }
}
