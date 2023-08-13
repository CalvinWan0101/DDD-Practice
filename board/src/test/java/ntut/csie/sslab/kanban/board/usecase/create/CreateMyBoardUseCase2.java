package ntut.csie.sslab.kanban.board.usecase.create;

import ntut.csie.sslab.kanban.board.entity.MyBoard2;

public class CreateMyBoardUseCase2 {
    public CreateMyBoardOutput2 execute(CreateMyBoardInput2 input){
        MyBoard2 board = new MyBoard2(input.getTeamId(), input.getBoardId(), input.getName());

        CreateMyBoardOutput2 output = new CreateMyBoardOutput2();
        output.setId(board.getBoardId());
        return output;
    }
}
