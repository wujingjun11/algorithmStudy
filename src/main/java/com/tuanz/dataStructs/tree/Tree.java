package com.tuanz.dataStructs.tree;

import java.util.Stack;

public class Tree {

    private Node root;

    public Tree(){
        root = null;
    }

    public Node find(int key){
        Node current = root;
        while (current.iData != key){
            if(key < current.iData){
                current = current.leftChild;
            }else {
                current = current.rightChild;
            }
            if(current ==null){
                return null;
            }
        }
        return current;
    }

    public void insert(int id, double dd){
        Node newNode = new Node();
        newNode.iData = id;
        newNode.dData = dd;
        if(root == null){
            root = newNode;
        }else {
            Node current = root;
            Node parent;
            while (true){
                //从左往右开始
                parent = current;
                if(id < current.iData){
                    current = current.leftChild;
                    if (current == null){
                        parent.leftChild = newNode;
                        return;
                    }
                }else {
                    current = current.rightChild;
                    if(current == null){
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }


    public boolean delete(int key){
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while (current.iData != key){
            parent = current;
            if (key < current.iData){
                isLeftChild = true;
                current = current.leftChild;
            }else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null){
                return false;
            }
        }

        //不是子节点
        if (current.leftChild == null && current.rightChild==null ){
            if(current == root){
                root = null;
            }else if(isLeftChild){
                parent.leftChild = null;
            }else {
                parent.rightChild = null;
            }
        //不是右节点
        }else if(current.rightChild == null){
            if(current == root){
                root = current.leftChild;
            }else if (isLeftChild){
                parent.leftChild = current.leftChild;
            }else {
                parent.rightChild = current.leftChild;
            }
         //不是左节点
        }else if(current.leftChild==null){
            if(current == root){
                root = current.rightChild;
            }else if(isLeftChild){
                parent.leftChild = current.rightChild;
            }else {
                parent.rightChild = current.rightChild;
            }
        }else {
            Node successor = getSuccessor(current);
            if(current == root){
                root = successor;
            }else if(isLeftChild){
                parent.leftChild = successor;
            }else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    private Node getSuccessor(Node delNode){
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;
        while (current!=null){
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        if(successor != delNode.rightChild){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    //前序 中序 后序遍历树
    public void traverse(int traverseType){
        switch (traverseType){
            case 1:
                System.out.print("\nPreorder traversal: ");
                preOrder(root);
                break;
            case 2:
                System.out.print("\nInorder traversal: ");
                inOrder(root);
                break;
            case 3:
                System.out.print("\nPostorder traversal: ");
                postOrder(root);
                break;
        }
        System.out.println("");
    }

    //前序
    private void preOrder(Node localRoot){
        if(localRoot != null){
            System.out.print(localRoot.iData + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    //中序
    private void inOrder(Node localRoot){
        if(localRoot != null){
            preOrder(localRoot.leftChild);
            System.out.print(localRoot.iData + " ");
            preOrder(localRoot.rightChild);
        }
    }

    //后续
    private void postOrder(Node localRoot){
        if(localRoot != null){
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
            System.out.print(localRoot.iData + " ");
        }
    }

    public void displayTree(){
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("............................");
        while (!isRowEmpty){
            Stack localStack = new Stack();
            isRowEmpty = true;

            for (int j=0; j<nBlanks; j++){
                System.out.print(' ' );
            }

            while (!globalStack.isEmpty()){
                Node temp = (Node) globalStack.pop();
                if(temp != null){
                    System.out.println(temp.iData);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if(temp.leftChild != null || temp.rightChild !=null){
                        isRowEmpty = false;
                    }
                }else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int i=0; i<nBlanks*2-2; i++){
                    System.out.print(" ");
                }
            }
            System.out.println();
            nBlanks /=2;
            while (!localStack.isEmpty()){
                globalStack.push(localStack.pop());
            }
        }
        System.out.println("............................");
    }
}
