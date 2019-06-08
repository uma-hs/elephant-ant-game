package com.uhs.elephant.core.board;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author uhs
 * @since 8/6/19
 */
public class BoardInitializer {

    public ElephantAntBoard getDefaultBoard() throws URISyntaxException, IOException {

        Map<Node<PieceType>, List<Node<PieceType>>> graph = new LinkedHashMap<>();
        Path path = Paths.get(getClass().getClassLoader()
                .getResource("defaultBoard.txt").toURI());

        Stream<String> lines = Files.lines(path);
        List<String> stringList = lines.collect(Collectors.toList());
        int nodeSize = Integer.valueOf(stringList.get(0));
        int curIndex = 1;
        Map<Integer, Node<PieceType>> idNodeMap = new HashMap<>();
        for (int i = 1; i < 1 + nodeSize; i++) {
            curIndex++;
            String[] tokens = stringList.get(i).split("\\s+");
            Node<PieceType> node = new Node<>(Integer.valueOf(tokens[0]), PieceType.fromName(tokens[1].charAt(0)));
            idNodeMap.put(node.getId(), node);
            graph.put(node, new ArrayList<>());
        }
        int edgesSize = Integer.valueOf(stringList.get(curIndex++));
        for (int i = curIndex; i < edgesSize; i++) {
            curIndex++;
            String[] tokens = stringList.get(i).split("\\s+");
            int v1 = Integer.valueOf(tokens[0]);
            int v2 = Integer.valueOf(tokens[1]);
            Node node1 = idNodeMap.get(v1);
            Node node2 = idNodeMap.get(v2);
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
