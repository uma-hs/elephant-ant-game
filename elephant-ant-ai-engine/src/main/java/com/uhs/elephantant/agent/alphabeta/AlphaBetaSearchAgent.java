package com.uhs.elephantant.agent.alphabeta;


import com.google.common.base.Preconditions;
import com.uhs.elephant.core.board.ElephantAntBoard;
import com.uhs.elephant.core.board.PieceType;
import com.uhs.elephant.core.board.Point;
import com.uhs.elephantant.agent.ElephantAntAIAgent;
import com.uhs.elephantant.agent.evaluator.GameEvaluator;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.stream.Collectors;

/**
 * AI agent implementing alpha beta algorithm to get the best move.
 *
 * @author uhs
 * @since 26/6/19
 */
public class AlphaBetaSearchAgent implements ElephantAntAIAgent {

    private GameEvaluator evaluator;

    private int SEARCH_WIDTH = 10;

    public AlphaBetaSearchAgent(GameEvaluator evaluator) {
        this.evaluator = evaluator;
    }

    public void next(ElephantAntBoard board, PieceType pieceType) {
        Preconditions.checkArgument(!pieceType.equals(PieceType.EMPTY), "Player cannot be EMPTY");
    }


    public double search(ElephantAntBoard board, double alpha, double beta, int depth) {

        if (depth == 0) {
            return evaluator.evaluate(board);
        }

        //TODO
        Double estimate = 1.0;

        return 0.9 * estimate;
    }


    private List<Pair<Point, Double>> getBestPoints(ElephantAntBoard board, PieceType pieceType) {
        List<Point> emptyPoints = evaluator.getEmptyMoves(board);
        return emptyPoints.parallelStream().map(point -> {
            ElephantAntBoard clonedBoard = board.clone();
            clonedBoard.setPieceType(point, pieceType);
            Double estimate = evaluator.evaluate(clonedBoard);
            return Pair.of(point, estimate);
        }).sorted((a, b) -> Double.compare(b.getRight(), a.getRight())).limit(SEARCH_WIDTH)
                .collect(Collectors.toList());

    }
}
