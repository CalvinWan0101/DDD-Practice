package ntut.csie.sslab.kanban.board.usecase.create;

import ntut.csie.sslab.ddd.usecase.Input;

public class CreateMyBoardInput2 implements Input {
    private String teamId;
    private String boardId;
    private String name;

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
