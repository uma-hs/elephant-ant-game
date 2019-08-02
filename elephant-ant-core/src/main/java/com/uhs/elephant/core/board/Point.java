package com.uhs.elephant.core.board;

/**
 * @author uhs
 * @since 3/8/19
 */
public class Point extends Node<PieceType> {
    public Point(int id) {
        super(id);
    }

    public Point(int id, PieceType pieceType) {
        super(id, pieceType);
    }
}
