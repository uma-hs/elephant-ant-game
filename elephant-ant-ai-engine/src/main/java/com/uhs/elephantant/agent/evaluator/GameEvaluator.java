package com.uhs.elephantant.agent.evaluator;

import com.uhs.elephant.core.board.ElephantAntBoard;
import com.uhs.elephant.core.board.PieceType;
import com.uhs.elephant.core.board.Point;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Evaluator of the game state at a given de[pth
 *
 * @author uhs
 * @since 26/6/19
 */
public interface GameEvaluator {

    double evaluate(ElephantAntBoard board);

    default List<Point> getEmptyMoves(ElephantAntBoard board) {
        return board.getPieces().keySet().stream().filter(n -> n.getPieceType().equals(PieceType.EMPTY)).collect(Collectors.toList());
    }
}
