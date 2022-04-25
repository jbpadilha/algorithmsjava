package com.padilha.algorithms.java;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
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

    public static Double findBestAvgGrade(String[][] grades) {
        long start = System.nanoTime();
        Double bestAvgGrade = 0D;
        if (grades == null || grades.length == 0) {
            return bestAvgGrade;
        } else {
            Map<String, Double> bestGrades = new HashMap<>();
            // Iterate All Grades
            for (String[] grade : grades) {
                if(grade == null) {
                    continue;
                }
                String student = grade[0];
                if (!bestGrades.containsKey(grade[0])) {
                    if (isNumber(grade[1])) {
                        bestGrades.put(student, Double.parseDouble(grade[1]));
                    }
                } else {
                    Double averageScore = Arrays.stream(grades).filter(getPredicate(student))
                            .mapToDouble(grd -> Double.parseDouble(grd[1])).average().getAsDouble();
                    bestGrades.put(student, averageScore);
                }
            }
            if (!bestGrades.isEmpty()) {
                Double bestSudent = bestGrades.entrySet().stream().max((student1, student2) -> student1.getValue() > student2.getValue() ? 1 : -1).get().getValue();
                bestAvgGrade = bestSudent;
            }
        }
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println("Time Find Best Grade - "+ timeElapsed + " milliseconds");
        return bestAvgGrade;
    }

    private static Predicate<String[]> getPredicate(String student) {
        return grd -> (grd[0].equals(student) && isNumber(grd[1]));
    }

    // Better performance Solution
    public static Double fasterFindBestAvgGrade(String[][] grades) {
        long start = System.nanoTime();
        Double bestAvgGrade = Double.MIN_VALUE;
        if (grades != null && grades.length != 0) {
            Map<String, ArrayList<Double>> groupListGrades = new HashMap<>();
            for (String[] grade : grades) {
                if (grade == null || !isNumber(grade[1])) {
                    continue;
                }
                String student = grade[0];
                Double currentGrade = Double.parseDouble(grade[1]);
                ArrayList<Double> studentGrades;
                if (!groupListGrades.containsKey(student)) {
                    studentGrades = new ArrayList<>();
                    studentGrades.add(currentGrade);
                } else {
                    ArrayList<Double> currStudentGrade = groupListGrades.get(student);
                    currStudentGrade.add(currentGrade);
                    studentGrades = currStudentGrade;
                }

                groupListGrades.put(student, studentGrades);
            }
            for (Map.Entry<String, ArrayList<Double>> pair : groupListGrades.entrySet()) {
                ArrayList<Double> gradCurr = pair.getValue();
                if (gradCurr.size() == 1) {
                    bestAvgGrade = (bestAvgGrade < gradCurr.get(0)) ? gradCurr.get(0) : bestAvgGrade;
                } else {
                    Double bestStudent = gradCurr.stream().mapToDouble(a -> a).average().orElse(0D);
                    bestAvgGrade = bestStudent > bestAvgGrade ? bestStudent : bestAvgGrade;
                }
            }
        }
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println("Time Find Best Grade (Fast Way)- "+ timeElapsed + " milliseconds");
        return bestAvgGrade;
    }


    public static void main(String[] args) {
        // System.out.println(pass());
        String[][] s1 = { { "Rohan", "84" }, { "Sachin", "102" }, { "Ishan", "55" }, { "Sachin", "18" },{ "Sachin", "12" } };
        if(findBestAvgGrade(s1) == 84D && fasterFindBestAvgGrade(s1) == 84D) {
            System.out.println("S1 - Passed: 84D");
        } else {
            System.out.println("S1 - Failed ");
        }

        String [][] s2 = { { "Janie", "-66" },{ "Janie", "0" },{ "Gina", "-88" },{ "Bobby", "0" },{ "Gina", "44" },{ "Bobby", "0" },{ "Bobby", "-6" } };
        if(findBestAvgGrade(s2) == -2 && fasterFindBestAvgGrade(s2) == -2) {
            System.out.println("S2 - Passed: -2");
        } else {
            System.out.println("S2 - Failed ");
        }


        String [][] s3 = { { "Janie", "66" },{ "Janie", "0" },{ "Gina", "89" },{ "bobby", "lp" },{ "Gina", "44" },{ "Bobby", "0" },{ "Bobby", "6" } };
        if(findBestAvgGrade(s3) == 66.5 && fasterFindBestAvgGrade(s3) == 66.5) {
            System.out.println("S3 - Passed: 66.5");
        } else {
            System.out.println("S3 - Failed ");
        }

        //String [][] s4  = {};
        //bestAvgGrade1(s4);
        //fasterFindBestAvgGrade(s4);
        //String [][] s5 = {null};
        // findBestAvgGrade(s5);
        //fasterFindBestAvgGrade(s5);

    }


}
