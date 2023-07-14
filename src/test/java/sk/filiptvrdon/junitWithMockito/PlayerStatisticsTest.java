package sk.filiptvrdon.junitWithMockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class PlayerStatisticsTest {


    private Player patrickUnderThirty;

    @BeforeEach
    public void setUp() {
        System.out.println("Setting up test data...");
        patrickUnderThirty = new Player("Patrick", 27);
    }

    @Test
    public void playerNameEquals() {
        Player patrick27yo = new Player("Patrick", 27);
        assertThat(patrick27yo).isEqualTo(patrickUnderThirty);
    }

    @Test
    public void playerNamesNotEqual() {
        Player patrick27yo = new Player("Patrick", 27);
        Player patrick25yo = new Player("Kalvin", 25);
        assertNotEquals(patrick27yo, patrick25yo);

        assertThat(patrick27yo).isNotEqualTo(patrick25yo);
    }

    @Test
    public void playersEqual() {
        Player patrick27yo = new Player("Patrick", 27);
        assertEquals(patrick27yo, patrickUnderThirty);
    }

    @Test
    public void playersNotSame() {
        Player patrick27yo = new Player("Patrick", 27);
        Player patrick25yo = new Player("Patrick", 25);
//        assertNotSame(patrick27yo, patrick25yo);
        assertThat(patrick27yo).isNotSameAs(patrick25yo);
    }

    @Test
    public void youngerPlayerSame() {
        Player patrick27yo = new Player("Patrick", 27);
        Player patrick25yo = new Player("Patrick", 25);
        assertSame(patrick25yo, PlayerStatistics.getYoungerPlayer(patrick27yo, patrick25yo));
    }

    @Test
    public void underThirtyTrue(){
        Player patrick27yo = new Player("Patrick", 27);
        PlayerStatistics playerStatistics = new PlayerStatistics(patrick27yo, 10, 5);
        assertTrue(playerStatistics.isUnderThirty());
    }

    @Test
    public void underThirtyFalse(){
        Player patrick27yo = new Player("Patrick", 31);
        PlayerStatistics playerStatistics = new PlayerStatistics(patrick27yo, 10, 5);
        assertFalse(playerStatistics.isUnderThirty());
    }

    @Test
    public void csvReportNull(){
        Player player1 = new Player("Patrick", 27);
        PlayerStatistics playerStatistics = new PlayerStatistics(player1, 0, 0);
        assertNull(playerStatistics.getCsvRecord());
    }

    @Test
    public void csvReportNotNull(){
        Player player1 = new Player("Patrick", 27);
        PlayerStatistics playerStatistics = new PlayerStatistics(player1, 3, 3);
        assertNotNull(playerStatistics.getCsvRecord());
    }


}