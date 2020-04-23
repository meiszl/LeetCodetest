package util;

import java.util.List;

public class GraphNode<T> {
    public T data;
    public List<GraphNode<T>> neighborList;
    public GraphNode(T data,List<GraphNode<T>> neighborList){
        this.data = data;
        this.neighborList = neighborList;
    }
    public GraphNode(){

    }
}
