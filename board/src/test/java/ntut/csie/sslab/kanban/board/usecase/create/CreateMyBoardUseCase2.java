package ntut.csie.sslab.kanban.board.usecase.create;

import ntut.csie.sslab.ddd.usecase.cqrs.CqrsOutput;
import ntut.csie.sslab.kanban.board.usecase.MyBoard2;

public class CreateMyBoardUseCase2 {

    private final MyBoardRepository2 repository;
    public CreateMyBoardUseCase2(MyBoardRepository2 repository) {
        this.repository = repository;
    }

    public CqrsOutput execute(CreateMyBoardInput2 input){
        MyBoard2 board = new MyBoard2(input.getTeamId(), input.getBoardId(), input.getName());

        repository.save(board);

        return CqrsOutput.create().setId(board.getBoardId());
    }
}
