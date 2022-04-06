package com.padilha.algorithms.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**

 https://cp-algorithms.com/others/josephus_problem.html

 * A group of students are sitting in a circle. The teacher is electing a new class president.
 * The teacher does this by singing a song while walking around the circle. After the song is
 * finished the student at which the teacher stopped is removed from the circle.
 *
 * Starting at the student next to the one that was just removed, the teacher resumes singing and walking around the circle.
 * After the teacher is done singing, the next student is removed. The teacher repeats this until only one student is left.
 *
 * A song of length k will result in the teacher walking past k students on each round. The students are numbered 1 to n. The teacher starts at student 1.
 *
 * For example, suppose the song length is two (k=2). And there are four students to start with (1,2,3,4). The first
 * student to go would be `2`, after that `4`, and after that `3`. Student `1` would be the next president in this example.
 *
 */
public class StudentElection {

    /**
     * @param n the number of students sitting in a circle.
     * @param k the length (in students) of each song.
     * @return the number of the student that is elected.
     */
    public static int whoIsElected(int n, int k) {
        Integer elected = null;
        Set<Integer> students = new HashSet<>();
        for(int i = 1; i <= n; i++) {
            students.add(i);
        }
        // running the circle
        int count = 1;
        int spos = 0;
        while(students.size() != 1) {
            if (spos >= students.size()) {
                spos = 0;
            }
            if (count == k) {
                Integer studentToBeRemoved = new ArrayList<>(students).get(spos);
                students.remove(studentToBeRemoved);
                count = 0;
                spos--;
            }
            count ++;
            spos ++;
        }
        if (students != null && students.size() == 1) {
            elected = students.stream().findFirst().get();
        }
        return elected;

    }

    public static void main(String[] args) {
        int[][] testCases = {
                // {1, 1, 1},
                // {2, 2, 1},
                {4, 2, 1},
                {100, 2, 73},
                {5, 3, 4},
                {6, 4, 5},
                {1000, 5, 763}
        };

        for(int[] test: testCases) {
            int elected = whoIsElected(test[0], test[1]);
            System.out.println("The elected Student is: "+ elected);
            if (elected == test[2]) {
                System.out.println("Test has passed. Expected: "+test[2]+" - Got:"+ elected);
            } else {
                System.out.println("Test has failed. Expected: "+test[2]+" - Got:"+ elected);
            }
        }

    }
}
