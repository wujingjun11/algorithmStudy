package com.tuanz.graph01;

/**
 * 带权最小生成树，最短路径问题
 */
public class MSTWApp {

    public static void main(String[] args) {

        Graph theGraph = new Graph();
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');
        theGraph.addVertex('F');

        theGraph.addEdge(0,1,6);//AB 6
        theGraph.addEdge(0,3,4);//AD 4
        theGraph.addEdge(1,2,10);//BC 10
        theGraph.addEdge(1,3,7);//BD 7
        theGraph.addEdge(1,4,7);//BE 7
        theGraph.addEdge(2,3,8);//CD 8
        theGraph.addEdge(2,4,5);//CE 5
        theGraph.addEdge(2,5,6);//CF 6
        theGraph.addEdge(3,4,12);//DE 12
        theGraph.addEdge(4,5,7);//EF 7

        System.out.print("Minimum spanning tree: ");
        theGraph.mstw();
        System.out.println("");
    }
}
