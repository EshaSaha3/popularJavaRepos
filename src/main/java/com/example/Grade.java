package com.example;

public class Grade {
    public static String gradeFromScore(double score) {
        if (score >= 90) return "A+";
        if (score >= 80) return "A";
        if (score >= 70) return "B";
        if (score >= 60) return "C";
        return "F";
    }
}
