package com.tuanz.graph;


/**
 * 图 包含邻接表、邻接矩阵的方法
 */
public class Graph {

    private final int MAX_VERTS = 20;
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVerts;
    private StackX theStack;//DFS
    private Queue theQueue;//BFS
    private char sortedArray[];//topo

    public Graph(){
        vertexList = new Vertex[MAX_VERTS];

        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        //图坐标
        for (int j=0; j<MAX_VERTS; j++){
            for (int k=0; k<MAX_VERTS; k++){
                adjMat[j][k] = 0;
            }
        }
        //为了方便，节省了重复代码编写
        theStack = new StackX();
        theQueue = new Queue();
        sortedArray = new char[MAX_VERTS];
    }

    public void addVertex(char lab){
        vertexList[nVerts++] = new Vertex(lab);
    }

    //有向
    public void addEdgeTopo(int start, int end){
        adjMat[start][end] =1;
    }

    //无向
    public void addEdge(int start, int end){
        adjMat[start][end] =1;
        adjMat[end][start] =1;
    }

    public void displayVertex(int v){
        System.out.print(vertexList[v].label);
    }

    /**
     * 深度优先搜索
     */
    public void dfs(){
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theStack.push(0);

        while (!theStack.isEmpty()){
            int v = getAdjUnvisitedVertex( theStack.peek());
            if(v == -1){
                theStack.pop();
            }else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                theStack.push(v);
            }
        }

        for (int j=0; j<nVerts; j++){
            vertexList[j].wasVisited = false;
        }
    }

    public int getAdjUnvisitedVertex(int v){
        for(int j=0; j<nVerts; j++){
            if(adjMat[v][j] ==1 && !vertexList[j].wasVisited){
                return j;
            }
        }
        return -1;
    }

    /**
     * 广度优先搜索
     */
    public void bfs(){
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theQueue.insert(0);
        int v2;

        while (!theQueue.isEmpty()){
            int v1 = theQueue.remove();
            while ((v2=getAdjUnvisitedVertex(v1)) != -1){
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                theQueue.insert(v2);
            }
        }
        for (int j=0; j<nVerts; j++){
            vertexList[j].wasVisited =false;
        }
    }

    /**
     * 最小生成树 minimum spanning tree(DFS)
     */
    public void mst(){
        vertexList[0].wasVisited =true;
        theStack.push(0);

        while (!theStack.isEmpty()){
            int currentVertex = theStack.peek();
            int v = getAdjUnvisitedVertex(currentVertex);
            if(v == -1){
                theStack.pop();
            }else {
                vertexList[v].wasVisited = true;
                theStack.push(v);

                displayVertex(currentVertex);
                displayVertex(v);
                System.out.print(" ");
            }
        }

        for (int i=0; i<nVerts; i++){
            vertexList[i].wasVisited = false;
        }
    }

    public void topo(){
        int orig_nVerts = nVerts;

        while (nVerts>0){
            int currentVertex = noSucessors();
            if(currentVertex == -1){
                System.out.println("ERROR: Graph has cycles");
                return;
            }
            sortedArray[nVerts-1] = vertexList[currentVertex].label;

            deleteVertex(currentVertex);
        }

        System.out.println("TopoLogically sorted order: ");
        for (int j=0; j<orig_nVerts; j++){
            System.out.print(sortedArray[j]);
        }
        System.out.println("");
    }

    private int noSucessors(){
        boolean isEdge;

        for (int row=0; row<nVerts; row++) {
            isEdge = false;
            for (int col=0; col<nVerts; col++) {
                if(adjMat[row][col] >0) {
                    isEdge = true;
                    break;
                }
            }
            if(!isEdge){
                return row;
            }
        }
        return -1;
    }

    public void deleteVertex(int delVert){
        if(delVert != nVerts-1){
            for (int j=delVert; j<nVerts-1; j++){
                vertexList[j] = vertexList[j+1];
            }
            for (int row=delVert; row<nVerts-1; row++){
                moveRowUp(row,nVerts);
            }

            for (int col=delVert;col<nVerts-1;col++){
                moveColLeft(col,nVerts-1);
            }
        }
        nVerts--;
    }

    private void moveRowUp(int row, int lenght){
        for (int col=0; col<lenght; col++){
            adjMat[row][col] = adjMat[row+1][col];
        }
    }

    private void moveColLeft(int col, int lenght){
        for (int row=0; row<lenght; row++){
            adjMat[row][col] = adjMat[row][col+1];
        }
    }
}
