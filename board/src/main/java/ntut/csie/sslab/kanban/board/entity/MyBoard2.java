package ntut.csie.sslab.kanban.board.entity;

import ntut.csie.sslab.ddd.model.AggregateRoot;
import ntut.csie.sslab.kanban.board.entity.event.MyBoardCreated;

public class MyBoard2 extends AggregateRoot<String> {
    private String teamId;
    private String boardId;
    private String name;

    public MyBoard2(String teamId, String boardId, String name) {
        super(boardId);
        this.teamId = teamId;
        this.boardId = boardId;
        this.name = name;

        addDomainEvent(new MyBoardCreated2(teamId, boardId, name));
    }

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
