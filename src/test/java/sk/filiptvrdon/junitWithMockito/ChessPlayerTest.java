package sk.filiptvrdon.junitWithMockito;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ChessPlayerTest {

    @Test
    public void testAssignCategorySpyTrue() throws Exception {
        ChessPlayer chessPlayer = new ChessPlayer("Filip", 31);
        ChessPlayer chessPlayerSpy = spy(chessPlayer);

        chessPlayerSpy.assignCategory();
        assertEquals("Senior", chessPlayerSpy.getCategory());
    }

    @Test
    public void testAssignCategorySpyFalse() throws Exception {
        ChessPlayer chessPlayer = new ChessPlayer("Filip", 31);
        ChessPlayer chessPlayerSpy = spy(chessPlayer);

        doNothing().when(chessPlayerSpy).assignCategory();
        assertNotEquals("Senior", chessPlayerSpy.getCategory());
    }

    @Test
    public void testAssignCategoryMock() throws Exception {
        ChessPlayer chessPlayer = mock(ChessPlayer.class);
        when(chessPlayer.getAge()).thenReturn(31);
        doCallRealMethod().when(chessPlayer).assignCategory();
        doCallRealMethod().when(chessPlayer).getCategory();
        chessPlayer.assignCategory();
        System.out.println("Category: " + chessPlayer.getCategory());
        assertEquals("Senior", chessPlayer.getCategory());
    }

    @Test
    public void testAssignCategoryMockException() throws Exception {
        ChessPlayer chessPlayerMock = mock(ChessPlayer.class);
        doThrow(Exception.class).when(chessPlayerMock).assignCategory();
        assertThrows(Exception.class, chessPlayerMock::assignCategory);
    }

    @Test
    public void testAssignScoreStats(){
        ChessPlayer chessPlayer = new ChessPlayer("Filip", 31);
        ChessPlayer chessPlayerSpy = spy(chessPlayer);
        doAnswer(chessP -> {
            ChessPlayer player = (ChessPlayer) chessP.getMock();
            player.setWins(3);
            player.setPoints(9);
            return null;
        }).when(chessPlayerSpy).assignScoreStats();

        chessPlayerSpy.assignScoreStats();
    }

}