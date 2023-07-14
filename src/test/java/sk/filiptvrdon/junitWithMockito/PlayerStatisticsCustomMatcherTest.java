package sk.filiptvrdon.junitWithMockito;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static sk.filiptvrdon.junitWithMockito.PlayerAssert.assertThat;

public class PlayerStatisticsCustomMatcherTest {

    @Test
    public void playerConstructorAssignsNameTest() {
        Player player = new Player("Filip", 31);
//        assertThat(player.getName()).isEqualTo("Filip");
        assertThat(player).hasName("Filip");
    }

}