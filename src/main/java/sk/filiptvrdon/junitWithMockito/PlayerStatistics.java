package sk.filiptvrdon.junitWithMockito;

public class PlayerStatistics {
    private Player player;
    private int games;
    private int goals;

    public PlayerStatistics(Player player, int games, int goals) {
        this.player = player;
        this.games = games;
        this.goals = goals;
    }

    public double gamesPerGoal() {
        return (double) games / goals;
    }

    public double goalsPerGame() {
        return (double) goals / games;
    }

    public boolean isUnderThirty() {
        return player.getAge() < 30;
    }

    public Double[] getCsvRecord() {
        if (this.games == 0){
            return null;
        }
        return new Double[]{goalsPerGame(), gamesPerGoal()};
    }

    public static Player getYoungerPlayer(Player player1, Player player2) {
        if (player1.getAge() < player2.getAge()) {
            return player1;
        }
        return player2;
    }




}
