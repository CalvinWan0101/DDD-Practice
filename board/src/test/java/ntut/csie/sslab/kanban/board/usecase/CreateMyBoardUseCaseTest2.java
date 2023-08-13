package ntut.csie.sslab.kanban.board.usecase;

import org.junit.jupiter.api.Test;

import java.util.UUID;

public class CreateMyBoardUseCaseTest2 {

    @Test
    public void create_myboard_use_case() {
        CreateMyBoardUseCase2 createMyBoardUseCase = new CreateMyBoardUseCase2();
        CreateMyBoardInput2 input = new CreateMyBoardInput2();
        input.setTeamId(UUID.randomUUID().toString());
        input.setBoardId(UUID.randomUUID().toString());
        input.setName("First test board");

        CreateMyBoardOutput2 output = createMyBoardUseCase.execute(input);

        assertNotNUll(output.getId());
    }
}
