package com.uhs.elephantant.agent.alphabeta;


import com.google.common.base.Preconditions;
import com.uhs.elephant.core.board.ElephantAntBoard;
import com.uhs.elephant.core.board.PieceType;
import com.uhs.elephantant.agent.ElephantAntAIAgent;
import com.uhs.elephantant.agent.evaluator.GameEvaluator;

/**
 * AI agent implementing alpha beta algorithm to get the best move.
 *
 * @author uhs
 * @since 26/6/19
 */
public class AlphaBetaSearchAgent implements ElephantAntAIAgent {


    public void next(ElephantAntBoard board, PieceType pieceType) {
        Preconditions.checkArgument(!pieceType.equals(PieceType.EMPTY), "Player cannot be EMPTY");
    }


    public double search(ElephantAntBoard board, double alpha, double beta, int depth) {

        if (depth == 0) {
            return GameEvaluator.evaluate(board);
        }

        return 0.0;
    }
}
