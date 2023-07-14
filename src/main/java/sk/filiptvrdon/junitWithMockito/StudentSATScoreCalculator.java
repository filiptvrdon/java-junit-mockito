package sk.filiptvrdon.junitWithMockito;

public class StudentSATScoreCalculator {
    private int satScore;

    public int calulateSATScore(int mathScore, int verbalScore) {
        if (mathScore < 0 ||  mathScore > 100 || verbalScore < 0 || verbalScore > 100) {
            return -1;
        } else {
            System.out.println("Total score: " + mathScore * verbalScore);
            return mathScore * verbalScore;
        }

    }

}
