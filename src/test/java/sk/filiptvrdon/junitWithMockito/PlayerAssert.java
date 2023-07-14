package sk.filiptvrdon.junitWithMockito;

import org.assertj.core.api.AbstractAssert;

public class PlayerAssert extends AbstractAssert<PlayerAssert, Player> {

    public static PlayerAssert assertThat(Player player) {
        return new PlayerAssert(player);
    }

    protected PlayerAssert(Player player) {
        super(player, PlayerAssert.class);
    }

    public PlayerAssert hasName(String name) {
        isNotNull();

        if (!actual.getName().equals(name)) {
            failWithMessage("Expected player's name to be <%s> but was <%s>", name, actual.getName());
        }

        return this;
    }
}
