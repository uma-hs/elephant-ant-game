package com.uhs.elephantant.agent;


import com.uhs.elephant.core.board.ElephantAntBoard;
import com.uhs.elephant.core.board.PieceType;

/**
 * @author uhs
 * @since 26/6/19
 */
public interface ElephantAntAIAgent {

    void next(ElephantAntBoard board, PieceType pieceType);
}
