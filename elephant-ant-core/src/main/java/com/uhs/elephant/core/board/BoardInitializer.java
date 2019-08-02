package com.uhs.elephant.core.board;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author uhs
 * @since 8/6/19
 */
public class BoardInitializer {

    private static final Logger LOGGER = Logger.getLogger(BoardInitializer.class.getName());
    private static final String INIT_FILE = "defaultBoard.txt";

    public static ElephantAntBoard DEFAULT_BOARD;

    static {
        try {
            DEFAULT_BOARD = getDefaultBoard();
        } catch (URISyntaxException | IOException e) {
            LOGGER.severe("Error initialising board");
        }
    }

    private static ElephantAntBoard getDefaultBoard() throws URISyntaxException, IOException {

        Map<Point, List<Point>> graph = new LinkedHashMap<>();
        Path path = Paths.get(BoardInitializer.class.getClassLoader()
                .getResource(INIT_FILE).toURI());

        Stream<String> lines = Files.lines(path);
        List<String> stringList = lines.collect(Collectors.toList());
        int nodeSize = Integer.valueOf(stringList.get(0));
        int curIndex = 1;
        Map<Integer, Point> idNodeMap = new HashMap<>();
        for (int i = 1; i < 1 + nodeSize; i++) {
            curIndex++;
            String[] tokens = stringList.get(i).split("\\s+");
            Point node = new Point(Integer.valueOf(tokens[0]), PieceType.fromName(tokens[1].charAt(0)));
            idNodeMap.put(node.getId(), node);
            graph.put(node, new ArrayList<>());
        }
        int edgesSize = Integer.valueOf(stringList.get(curIndex++));
        for (int i = curIndex; i < edgesSize; i++) {
            curIndex++;
            String[] tokens = stringList.get(i).split("\\s+");
            int v1 = Integer.valueOf(tokens[0]);
            int v2 = Integer.valueOf(tokens[1]);
            Point node1 = idNodeMap.get(v1);
            Point node2 = idNodeMap.get(v2);
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        ArrayList<Set<Integer>> playLanes = new ArrayList<>();

        for (int i = curIndex; i < stringList.size(); i++) {
            playLanes.add(Arrays.stream(stringList.get(i).split("\\s+"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toSet()));
        }

        ElephantAntBoard board = new ElephantAntBoard();
        board.setPieces(graph);
        board.setPlayLanes(playLanes);
        lines.close();

        return board;

    }
}
