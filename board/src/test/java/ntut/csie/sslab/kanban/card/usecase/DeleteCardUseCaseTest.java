package ntut.csie.sslab.kanban.usecase.card;


import ntut.csie.sslab.ddd.usecase.cqrs.CqrsCommandOutput;
import ntut.csie.sslab.ddd.usecase.cqrs.ExitCode;
import ntut.csie.sslab.kanban.card.entity.CardType;
import ntut.csie.sslab.kanban.usecase.AbstractSpringBootJpaTest;
import ntut.csie.sslab.kanban.card.usecase.delete.in.DeleteCardInput;
import ntut.csie.sslab.kanban.card.usecase.delete.in.DeleteCardUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class DeleteCardUseCaseTest extends AbstractSpringBootJpaTest {

    @BeforeEach
    public void setUp() {
        super.setUp();

        boardId = "board id for delete card";
        workflowId = "workflow id for delete card";
        rootStageId = "root stage id for delete card";
        userId = "user id for delete card";
        username = "Teddy";
    }

    @Test
    public void should_succeed_when_delete_card() {

        String cardId = createCard(
                userId,
                workflowId,
                rootStageId,
                "firstCard",
                "estimate",
                "notes",
                "2020/03/01",
                CardType.General.toString(),
                username,
                boardId);

        DeleteCardUseCase deleteCardUseCase = newDeleteCardUseCase();

        DeleteCardInput input = new DeleteCardInput();
        input.setWorkflowId(workflowId);
        input.setLaneId(rootStageId);
        input.setCardId(cardId);
        input.setUserId(userId);
        input.setUsername(username);
        input.setBoardId(boardId);

        CqrsCommandOutput output = deleteCardUseCase.execute(input);

        assertNotNull(output.getId());
        assertEquals(ExitCode.SUCCESS, output.getExitCode());
        Assertions.assertFalse(cardRepository.findById(output.getId()).isPresent());
    }
}