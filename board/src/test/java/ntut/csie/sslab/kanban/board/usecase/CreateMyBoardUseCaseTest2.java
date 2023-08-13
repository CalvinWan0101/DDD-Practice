package ntut.csie.sslab.kanban.board.usecase;

import ntut.csie.sslab.ddd.usecase.cqrs.CqrsOutput;
import ntut.csie.sslab.kanban.board.usecase.port.in.create.CreateMyBoardInput2;
import ntut.csie.sslab.kanban.board.usecase.port.in.create.CreateMyBoardUseCase2;
import ntut.csie.sslab.kanban.board.usecase.port.out.repository.MyBoardRepository2;
import ntut.csie.sslab.kanban.board.usecase.service.CreateMyBoardService2;
import ntut.csie.sslab.kanban.board.usecase.port.out.MyBoardInMemoryRepository2;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateMyBoardUseCaseTest2 {

    @Test
    public void create_myboard_use_case() {
        MyBoardRepository2 repository = new MyBoardInMemoryRepository2();
        CreateMyBoardUseCase2 createMyBoardService = new CreateMyBoardService2(repository);
        CreateMyBoardInput2 input = new CreateMyBoardInput2();
        input.setTeamId(UUID.randomUUID().toString());
        input.setBoardId(UUID.randomUUID().toString());
        input.setName("First test board");

        CqrsOutput output = createMyBoardService.execute(input);

        assertNotNull(output.getId());
        assertTrue(repository.findById(output.getId()).isPresent());
    }
}
