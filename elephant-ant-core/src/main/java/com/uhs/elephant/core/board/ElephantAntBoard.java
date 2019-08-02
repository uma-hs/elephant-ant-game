package com.uhs.elephant.core.board;

import org.apache.commons.lang.SerializationUtils;

import java.io.Serializable;
import java.util.*;

/**
 * @author uhs
 * @since 8/6/19
 */
public class ElephantAntBoard implements Cloneable, Serializable {

    private Map<Point, List<Point>> pieces;

    private ArrayList<Set<Integer>> playLanes;

    public Map<Point, List<Point>> getPieces() {
        return pieces;
    }

    public void setPieces(Map<Point, List<Point>> pieces) {
        this.pieces = pieces;
    }

    public ArrayList<Set<Integer>> getPlayLanes() {
        return playLanes;
    }

    public void setPlayLanes(ArrayList<Set<Integer>> playLanes) {
        this.playLanes = playLanes;
    }


    public void setPieceType(Point point, PieceType pieceType) {
        Optional<Point> found = pieces.keySet().stream().filter(p -> p.equals(point)).findFirst();
        if (!found.isPresent())
            throw new RuntimeException("Point can not be empty");

        found.get().setPieceType(pieceType);
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

    @Override
    public ElephantAntBoard clone() {
        //TODO Performance overhead, modify later.
        return (ElephantAntBoard) SerializationUtils.clone(this);
    }
}
