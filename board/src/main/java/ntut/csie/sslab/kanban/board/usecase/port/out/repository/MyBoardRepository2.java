package ntut.csie.sslab.kanban.board.usecase.port.out.repository;

import ntut.csie.sslab.kanban.board.entity.MyBoard2;

import java.util.Optional;

public interface MyBoardRepository2 {
    Optional<MyBoard2> findById(String boardId);

    void save(MyBoard2 board);
}
