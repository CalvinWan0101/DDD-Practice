package ntut.csie.sslab.kanban.board.usecase.service;

import ntut.csie.sslab.ddd.usecase.cqrs.CqrsOutput;
import ntut.csie.sslab.kanban.board.entity.MyBoard2;
import ntut.csie.sslab.kanban.board.usecase.port.in.create.CreateMyBoardInput2;
import ntut.csie.sslab.kanban.board.usecase.port.in.create.CreateMyBoardUseCase2;
import ntut.csie.sslab.kanban.board.usecase.port.out.MyBoardInMemoryRepository2;
import ntut.csie.sslab.kanban.board.usecase.port.out.repository.MyBoardRepository2;

public class CreateMyBoardService2 implements CreateMyBoardUseCase2 {

    private final MyBoardRepository2 repository;
    public CreateMyBoardService2 (MyBoardRepository2 repository) {
        this.repository = repository;
    }

    @Override
    public CqrsOutput execute(CreateMyBoardInput2 input) {
        MyBoard2 board = new MyBoard2(input.getTeamId(), input.getBoardId(), input.getName());

        repository.save(board);
        return CqrsOutput.create().setId(board.getBoardId());
    }

}
