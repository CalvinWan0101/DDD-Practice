package ntut.csie.sslab.kanban.board.usecase;

import ntut.csie.sslab.kanban.board.usecase.create.CreateMyBoardInput2;
import ntut.csie.sslab.kanban.board.usecase.create.CreateMyBoardUseCase2;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CreateMyBoardUseCaseTest2 {

    @Test
    public void create_myboard_use_case() {
        CreateMyBoardUseCase2 createMyBoardUseCase = new CreateMyBoardUseCase2();
        CreateMyBoardInput2 input = new CreateMyBoardInput2();
        input.setTeamId(UUID.randomUUID().toString());
        input.setBoardId(UUID.randomUUID().toString());
        input.setName("First test board");

        CqrsOutput2 output = createMyBoardUseCase.execute(input);

        assertNotNull(output.getId());
    }
}
