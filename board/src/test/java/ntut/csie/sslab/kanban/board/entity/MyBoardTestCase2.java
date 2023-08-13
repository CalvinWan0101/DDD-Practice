package ntut.csie.sslab.kanban.board.entity;

import ntut.csie.sslab.kanban.board.entity.event.MyBoardCreated;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyBoardTestCase2 {
    @Test
    public void create_a_myboard_generates_a_myboard_created_domain_event(){
        MyBoard2 board = new MyBoard2("", "", "");

        assertEquals(1,board.getDomainEvents().size());
        assertEquals(MyBoardCreated.class, board.getDomainEvents().get(0).getClass());
    }
}
