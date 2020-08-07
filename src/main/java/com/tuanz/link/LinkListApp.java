package com.tuanz.link;

public class LinkListApp {

    public static void main(String[] args) {
        LinkList theList = new LinkList();

        theList.insertFirst(22,2.99);
        theList.insertFirst(33,4.52);
        theList.insertFirst(44,6.88);
        theList.insertFirst(88,8.99);

        theList.displayList();

        while ( !theList.isEmpty()){
            Link aLink = theList.deleteFirst();
            System.out.print("Deleted ");
            aLink.displayLink();
            System.out.println("");
        }
        theList.displayList();
    }
}
