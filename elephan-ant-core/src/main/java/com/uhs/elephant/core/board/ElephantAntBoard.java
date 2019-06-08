package com.uhs.elephant.core.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author uhs
 * @since 8/6/19
 */
public class ElephantAntBoard implements Cloneable {

    private Map<Node<PieceType>, List<Node<PieceType>>> pieces;
    private ArrayList<Set<Integer>> playLanes;

    public Map<Node<PieceType>, List<Node<PieceType>>> getPieces() {
        return pieces;
    }

    public void setPieces(Map<Node<PieceType>, List<Node<PieceType>>> pieces) {
        this.pieces = pieces;
    }

    public ArrayList<Set<Integer>> getPlayLanes() {
        return playLanes;
    }

    public void setPlayLanes(ArrayList<Set<Integer>> playLanes) {
        this.playLanes = playLanes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        pieces.forEach((piece, adjs) -> {
            sb.append(piece.getId() + " " + piece.getPieceType().getPieceChar());
            sb.append("\n");
        });

        return sb.toString();
    }
}
