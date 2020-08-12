package com.tuanz.dataStructs.graph;

public class TopoAPP {

    public static void main(String[] args) {

        Graph theGraph = new Graph();
        theGraph.addVertex('A');//0
        theGraph.addVertex('B');//1
        theGraph.addVertex('C');//2
        theGraph.addVertex('D');//3
        theGraph.addVertex('E');//4
        theGraph.addVertex('F');//5
        theGraph.addVertex('G');//6
        theGraph.addVertex('H');//7

        theGraph.addEdgeTopo(0,3);//AD
        theGraph.addEdgeTopo(0,4);//AE
        theGraph.addEdgeTopo(1,4);//BE
        theGraph.addEdgeTopo(2,5);//CF
        theGraph.addEdgeTopo(3,6);//DG
        theGraph.addEdgeTopo(4,6);//EG
        theGraph.addEdgeTopo(5,7);//FH
        theGraph.addEdgeTopo(6,7);//GH

        theGraph.topo();
        System.out.println();
    }
}
