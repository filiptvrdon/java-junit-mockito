package sk.filiptvrdon.junitWithMockito;

import java.util.ArrayList;
import java.util.List;

public class GradeCalculator {
    public List<String> getGrades(List<Integer> scores){
        List<String> grades = new ArrayList<>();
        for (Integer score : scores) {
            grades.add(getGrade(score));
        }
        return grades;
    }

    private String getGrade(Integer score) {
        return score < 78 ? "fail" : "pass";
    }
}
