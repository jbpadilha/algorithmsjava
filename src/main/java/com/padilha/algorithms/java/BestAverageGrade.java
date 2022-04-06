package com.padilha.algorithms.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

//  Find the best average grade.
//  Given a list of student test scores
//  Each student may have more than one test score in the list.
public class BestAverageGrade {

    public static boolean isNumber(String value) {
        try {
            Double doubleValue = Double.parseDouble(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void bestAvgGrade1(String[][] grades) {
        if (grades == null || grades.length == 0) {
            System.out.println("0.00");
        } else {
            Map<String, Double> bestgrades = new HashMap<>();

            // Iterate All Grades
            for (String[] grade : grades) {
                if(grade == null) {
                    continue;
                }
                String student = grade[0];
                if (!bestgrades.containsKey(grade[0])) {
                    if (isNumber(grade[1])) {
                        bestgrades.put(student, Double.parseDouble(grade[1]));
                    }
                } else {
                    Double averageScore = Arrays.stream(grades).filter(getPredicate(student))
                            .mapToDouble(grd -> Double.parseDouble(grd[1])).average().getAsDouble();
                    bestgrades.put(student, averageScore);
                }
            }
            if (!bestgrades.isEmpty()) {
                String bestSudent = bestgrades.entrySet().stream().max((student1, student2) -> student1.getValue() > student2.getValue() ? 1 : -1).get().getKey();
                System.out.println(bestgrades.get(bestSudent));
            } else {
                System.out.println("0.00");
            }
        }
    }

    private static Predicate<String[]> getPredicate(String student) {
        return grd -> (grd[0].equals(student) && isNumber(grd[1]));
    }

    public static void main(String[] args) {
        // System.out.println(pass());
        String[][] s1 = { { "Rohan", "84" }, { "Sachin", "102" }, { "Ishan", "55" }, { "Sachin", "18" },{ "Sachin", "12" } };
        //bestAvgGrade1(s1);
        String [][] s2 = { { "Janie", "-66" },{ "Janie", "0" },{ "Gina", "-88" },{ "Bobby", "0" },{ "Gina", "44" },{ "Bobby", "0" },{ "Bobby", "-6" } };
        //bestAvgGrade1(s2);
        String [][] s3 = { { "Janie", "66" },{ "Janie", "0" },{ "Gina", "88" },{ "bobby", "lp" },{ "Gina", "44" },{ "Bobby", "0" },{ "Bobby", "6" } };
        //bestAvgGrade1(s3);
        String [][] s4  = {};
        //bestAvgGrade1(s4);
        String [][] s5 = {null};
        bestAvgGrade1(s5);

    }
}
