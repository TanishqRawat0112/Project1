package com.employee;

import java.util.ArrayList;

public class StudentUtil {
    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades){
        double[] gpa = new double[studentIdList.length];
        for(int i = 0; i < studentIdList.length; i++){
            double GPASum = 0;
            int numberOfSubjects = studentsGrades[i].length;
            for(int j = 0; j < numberOfSubjects; j++){
                GPASum += (4 - (studentsGrades[i][j]-'A'));
            }
            gpa[i] = GPASum/numberOfSubjects;
        }
        return gpa;
    }

    public static int[] getStudentsByGPA(double lower, double upper,int[] studentIdList, char[][] studentsGrades ){
        double[] gpa = calculateGPA(studentIdList, studentsGrades);
        ArrayList<Integer> studentsInRange = new ArrayList<>();
        for(int i = 0; i < studentIdList.length; i++){
            if(gpa[i] >= lower && gpa[i] <= upper){
                studentsInRange.add(studentIdList[i]);
            }
        }
        int[] studentsInRangeArray = new int[studentsInRange.size()];
        for(int i = 0; i < studentsInRangeArray.length; i++){
            studentsInRangeArray[i] = studentsInRange.get(i);
        }
        return studentsInRangeArray;
    }
}
