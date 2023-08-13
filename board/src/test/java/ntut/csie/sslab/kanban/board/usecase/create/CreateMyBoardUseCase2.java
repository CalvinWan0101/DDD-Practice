package ntut.csie.sslab.kanban.board.usecase.create;

import ntut.csie.sslab.kanban.board.usecase.MyBoard2;

public class CreateMyBoardUseCase2 {

    public CreateMyBoardUseCase2(MyBoardRepository2 repository) {

    }

    public CqrsOutput2 execute(CreateMyBoardInput2 input){
        MyBoard2 board = new MyBoard2(input.getTeamId(), input.getBoardId(), input.getName());

        return CqrsOutput2.create().setId(board.getBoardId());
    }
}
