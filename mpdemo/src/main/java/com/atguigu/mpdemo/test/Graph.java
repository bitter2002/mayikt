package com.atguigu.mpdemo.test;

import jdk.nashorn.internal.ir.Node;

public class Graph<D> {
    Map<Node<D>, Node<D>> nodeMap = new HashMap<Node<D>, Node<D>>();
    SortedMap<Edge<D>, Edge<D>> edgeMap = new TreeMap<Edge<D>, Edge<D>>();
    Graph<D> addNode(Node<D> node){
        nodeMap.put(node, node);
        return this;
    }
    Graph<D> addNode(D data){
        return addNode(new Node<D>(data));
    }
    Graph<D> addEdge(D node1, D node2, Long length ) {
        return addEdge(new Edge<D>(new Node<D>(node1)
                , new Node<D>(node2), length));
    }
    Graph<D> addEdge(Edge<D> edge){
        Node<D> node1 = edge.getNodes().get(0);
        node1 = nodeMap.get(node1);
        Node<D> node2 = edge.getOther(node1);
        node2 = nodeMap.get(node2);
        edge = new Edge<D>(node1, node2, edge.getLength());
        node1.addEdge(edge);
        node2.addEdge(edge);

        edgeMap.put(edge, edge);

        return this;
    }
}
