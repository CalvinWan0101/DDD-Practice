package ntut.csie.sslab.kanban.board.entity;

import ntut.csie.sslab.ddd.model.DomainEvent;
import ntut.csie.sslab.ddd.model.common.DateProvider;

public class MyBoardCreated2 extends DomainEvent {
    private final String teamId;
    private final String boardId;
    private final String name;

    public MyBoardCreated2(String teamId, String boardId, String name) {
        super(DateProvider.now());
        this.teamId = teamId;
        this.boardId = boardId;
        this.name = name;
    }

    public String teamId() {
        return teamId;
    }

    public String boardId() {
        return boardId;
    }

    public String name() {
        return name;
    }
}
