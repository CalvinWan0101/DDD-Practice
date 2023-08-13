package ntut.csie.sslab.kanban.board.usecase;

import ntut.csie.sslab.ddd.usecase.cqrs.CqrsOutput;
import ntut.csie.sslab.kanban.board.usecase.create.CreateMyBoardInput2;
import ntut.csie.sslab.kanban.board.usecase.create.CreateMyBoardUseCase2;
import ntut.csie.sslab.kanban.board.usecase.create.MyBoardRepository2;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateMyBoardUseCaseTest2 {

    @Test
    public void create_myboard_use_case() {
        MyBoardRepository2 repository = new MyBoardRepository2();
        CreateMyBoardUseCase2 createMyBoardUseCase = new CreateMyBoardUseCase2(repository);
        CreateMyBoardInput2 input = new CreateMyBoardInput2();
        input.setTeamId(UUID.randomUUID().toString());
        input.setBoardId(UUID.randomUUID().toString());
        input.setName("First test board");

        CqrsOutput output = createMyBoardUseCase.execute(input);

        assertNotNull(output.getId());
        assertTrue(repository.findById(output.getId()).isPresent());
    }
}
