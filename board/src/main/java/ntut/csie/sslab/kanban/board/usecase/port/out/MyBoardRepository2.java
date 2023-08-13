package ntut.csie.sslab.kanban.board.usecase.port.out;

import ntut.csie.sslab.kanban.board.usecase.MyBoard2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MyBoardRepository2 {

    private final List<MyBoard2> store;

    public MyBoardRepository2() {
        store = new ArrayList<>();
    }

    public Optional<MyBoard2> findById(String boardId) {
        return store.stream().filter(x -> x.getBoardId().equals(boardId)).findAny();
    }

    public void save(MyBoard2 board) {
        store.add(board);
    }
}
