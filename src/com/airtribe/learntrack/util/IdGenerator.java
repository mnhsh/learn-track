package com.airtribe.learntrack.util;

public class IdGenerator {
    private static int nextStudentId = 1;
    private static int nextCourseId = 1;
    private static int nextEnrollmentId = 1;

    public static int generateStudentId() {
        return nextStudentId++;
    }

    public static int generateCourseId() {
        return nextCourseId++;
    }

    public static int generateEnrollmentId() {
        return nextEnrollmentId++;
    }
}
