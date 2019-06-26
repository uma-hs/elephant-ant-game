package com.uhs.elephant.core;

import com.uhs.elephant.core.board.BoardInitializer;
import com.uhs.elephant.core.board.ElephantAntBoard;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author uhs
 * @since 8/6/19
 */
public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException {
        ElephantAntBoard board = new BoardInitializer().getDefaultBoard();
        System.out.println(board);
    }
}
