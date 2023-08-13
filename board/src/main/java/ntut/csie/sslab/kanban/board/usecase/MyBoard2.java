package ntut.csie.sslab.kanban.board.usecase;

public class MyBoard2 {
    private String teamId;
    private String boardId;
    private String name;

    public MyBoard2(String teamId, String boardId, String name) {
        this.teamId = teamId;
        this.boardId = boardId;
        this.name = name;
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
