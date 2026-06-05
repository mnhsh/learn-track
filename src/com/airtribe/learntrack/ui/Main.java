package com.airtribe.learntrack.ui;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService(studentService, courseService);
        System.out.println("Welcome to LearnTrack!");
        boolean keepRunning = true;
        
        while (keepRunning) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Deactivate Student");
            System.out.println("5. Add Course");
            System.out.println("6. View Courses");
            System.out.println("7. Deactivate Course");
            System.out.println("8. Enroll Student in Course");
            System.out.println("9. View Student Enrollments");
            System.out.println("10. Update Enrollment Status");
            System.out.println("11. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter First Name: ");
                        String fName = scanner.nextLine();
                        System.out.print("Enter Last Name: ");
                        String lName = scanner.nextLine();
                        System.out.print("Enter Email: ");
                        String email = scanner.nextLine();
                        System.out.print("Enter Batch: ");
                        String batch = scanner.nextLine();
                        
                        studentService.addStudent(fName, lName, email, batch);
                        System.out.println("Student added!");
                        break;
                        
                    case 2:
                        System.out.println("--- Student List ---");
                        for (Student s : studentService.getAll()) {
                            System.out.println(s.getId() + " - " + s.getDisplayName() + " | Active: " + s.isActive());
                        }
                        break;
                        
                    case 3:
                        System.out.print("Enter Student ID to search: ");
                        int searchStudentId = scanner.nextInt();
                        scanner.nextLine();
                        
                        Student foundStudent = studentService.getStudentById(searchStudentId);
                        System.out.println("Found: " + foundStudent.getDisplayName() + " | Email: " + foundStudent.getEmail() + " | Active: " + foundStudent.isActive());
                        break;

                    case 4:
                        System.out.print("Enter Student ID to deactivate: ");
                        int deactStudentId = scanner.nextInt();
                        scanner.nextLine();
                        
                        studentService.deactivateStudent(deactStudentId);
                        System.out.println("Student deactivated!");
                        break;

                    case 5:
                        System.out.print("Enter Course Name: ");
                        String cName = scanner.nextLine();
                        System.out.print("Enter Description: ");
                        String desc = scanner.nextLine();
                        System.out.print("Enter Duration (in weeks): ");
                        int duration = scanner.nextInt();
                        scanner.nextLine();
                        
                        courseService.addCourse(cName, desc, duration);
                        System.out.println("Course added!");
                        break;
                        
                    case 6:
                        System.out.println("--- Course List ---");
                        for (Course c : courseService.getAll()) {
                            System.out.println(c.getId() + " - " + c.getCourseName() + " (" + c.getDurationInWeeks() + " weeks) | Active: " + c.isActive());
                        }
                        break;
                        
                    case 7:
                        System.out.print("Enter Course ID to deactivate: ");
                        int deactCourseId = scanner.nextInt();
                        scanner.nextLine();
                        
                        courseService.deactivateCourse(deactCourseId);
                        System.out.println("Course deactivated!");
                        break;

                    case 8:
                        System.out.print("Enter Student ID: ");
                        int sId = scanner.nextInt();
                        System.out.print("Enter Course ID: ");
                        int cId = scanner.nextInt();
                        scanner.nextLine();
                        
                        enrollmentService.enrollStudent(sId, cId);
                        System.out.println("Successfully enrolled!");
                        break;
                        
                    case 9:
                        System.out.print("Enter Student ID to view enrollments: ");
                        int searchId = scanner.nextInt();
                        scanner.nextLine();
                        
                        System.out.println("--- Enrollments ---");
                        for (Enrollment e : enrollmentService.getEnrollmentsByStudentId(searchId)) {
                            System.out.println("Enrollment ID: " + e.getId() + " | Course ID: " + e.getCourseId() + " | Status: " + e.getStatus());
                        }
                        break;
                        
                    case 10:
                        System.out.print("Enter Enrollment ID: ");
                        int eId = scanner.nextInt();
                        scanner.nextLine();
                        
                        System.out.print("Enter New Status (ACTIVE, COMPLETED, CANCELLED): ");
                        String status = scanner.nextLine();
                        
                        enrollmentService.updateEnrollmentStatus(eId, status);
                        System.out.println("Enrollment updated!");
                        break;

                    case 11:
                        System.out.println("Bye!");
                        keepRunning = false;
                        break;
                        
                    default:
                        System.out.println("Invalid option, try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
