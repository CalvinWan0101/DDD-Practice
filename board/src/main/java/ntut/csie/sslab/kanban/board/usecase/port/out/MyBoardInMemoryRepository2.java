package ntut.csie.sslab.kanban.board.usecase.port.out;

import ntut.csie.sslab.kanban.board.entity.MyBoard2;
import ntut.csie.sslab.kanban.board.usecase.port.out.repository.MyBoardRepository2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MyBoardInMemoryRepository2 implements MyBoardRepository2 {

    private final List<MyBoard2> store;

    public MyBoardInMemoryRepository2() {
        store = new ArrayList<>();
    }


    @Override
    public Optional<MyBoard2> findById(String boardId) {
        return store.stream().filter(x -> x.getBoardId().equals(boardId)).findAny();
    }

    @Override
    public void save(MyBoard2 board) {
        store.add(board);
    }
}
