package com.uhs.elephant.core.board;

import java.util.Arrays;

/**
 * @author uhs
 * @since 8/6/19
 */
public enum PieceType {
    EMPTY('-'),
    ELEPHANT('E'),
    ANT('A');

    private char pieceChar;

    PieceType(char pieceChar) {
        this.pieceChar = pieceChar;
    }

    public static PieceType fromName(char name) {
        return Arrays.stream(PieceType.values()).filter(f -> f.pieceChar == name).findAny().orElseThrow(IllegalArgumentException::new);
    }

    public char getPieceChar() {
        return pieceChar;
    }}
