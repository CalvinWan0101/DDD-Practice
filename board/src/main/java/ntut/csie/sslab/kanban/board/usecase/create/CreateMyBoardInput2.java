package ntut.csie.sslab.kanban.board.usecase.create;

public class CreateMyBoardInput2 {
    private String TeamId;
    private String BoardId;
    private String Name;

    public String getTeamId() {
        return TeamId;
    }

    public void setTeamId(String teamId) {
        TeamId = teamId;
    }

    public String getBoardId() {
        return BoardId;
    }

    public void setBoardId(String boardId) {
        BoardId = boardId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
