package com.uhs.elephant.core.board;

import java.util.List;
import java.util.Objects;

/**
 * @author uhs
 * @since 8/6/19
 */
public class Node<T> {

    private int id;
    private T pieceType;
    private List<Node> adjacentNodes;

    public Node(int id) {
        this.id = id;
    }

    public Node(int id, T pieceType) {
        this.id = id;
        this.pieceType = pieceType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return id == node.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public T getPieceType() {
        return pieceType;
    }

    public void setPieceType(T pieceType) {
        this.pieceType = pieceType;
    }

    public List<Node> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(List<Node> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }
}
