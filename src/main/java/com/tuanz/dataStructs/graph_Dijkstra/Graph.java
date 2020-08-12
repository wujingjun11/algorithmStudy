package com.tuanz.dataStructs.graph_Dijkstra;

public class Graph {

    private final int MAX_VERTS = 20;
    private final int INFINITY = 1000000;//最够大的值
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVerts;
    private int currentVert;
    private DistPar sPath[];
    private int nTree;
    private int srartToCurrent;

    public Graph(){
        vertexList = new Vertex[MAX_VERTS];

        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        nTree =0;
        //图坐标
        for (int j=0; j<MAX_VERTS; j++){
            for (int k=0; k<MAX_VERTS; k++){
                adjMat[j][k] = INFINITY;
            }
        }
        sPath = new DistPar[MAX_VERTS];
    }

    public void addVertex(char lab){
        vertexList[nVerts++] = new Vertex(lab);
    }

    //有向,带权
    public void addEdge(int start, int end,int weight){
        adjMat[start][end] =weight;
    }

    public void displayVertex(int v){
        System.out.print(vertexList[v].label);
    }

    public void path(){
        int startTree = 0;
        vertexList[startTree].isInTree = true;
        nTree = 1;

        for (int j=0; j<nVerts; j++){
            int tempDist = adjMat[startTree][j];
            sPath[j] = new DistPar(startTree,tempDist);
        }

        while (nTree < nVerts){
            int indexMin = getMin();
            int minDist = sPath[indexMin].distance;

            if(minDist == INFINITY){
                System.out.println("There are unreachable vertices");
                break;
            }else {
                currentVert = indexMin;
                srartToCurrent = sPath[indexMin].distance;
            }
            vertexList[currentVert].isInTree = true;
            nTree++;
            adjust_sPath();
        }

        displayPaths();
        nTree = 0;
        for (int j=0; j<nVerts; j++){
            vertexList[j].isInTree = true;
        }
    }

    public int getMin(){
        int minDist = INFINITY;
        int indexMin = 0;
        for (int j=1; j<nVerts; j++){
            if(!vertexList[j].isInTree && sPath[j].distance < minDist){
                minDist = sPath[j].distance;
                indexMin = j;
            }
        }
        return indexMin;
    }

    public void adjust_sPath(){
        int column = 1;
        while (column < nVerts){
            if(vertexList[column].isInTree){
                column++;
                continue;
            }

            int currentToFringe = adjMat[currentVert][column];
            int startToFringe = srartToCurrent + currentToFringe;
            int sPathDist = sPath[column].distance;

            if(startToFringe < sPathDist){
                sPath[column].parentVert = currentVert;
                sPath[column].distance = startToFringe;
            }
            column++;
        }
    }

    public void displayPaths(){
        for (int j=0; j<nVerts; j++){
            System.out.print(vertexList[j].label + "=");
            if(sPath[j].distance == INFINITY){
                System.out.print("inf");
            }else {
                System.out.print(sPath[j].distance);
            }
            char parent = vertexList[ sPath[j].parentVert ].label;
            System.out.print("(" + parent + ") ");
        }
        System.out.println("");
    }
}
