package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.time.LocalDate;
import java.util.ArrayList;

public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository = new EnrollmentRepository();
    
    private final StudentService studentService;
    private final CourseService courseService;

    public EnrollmentService(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    public void enrollStudent(int studentId, int courseId) throws EntityNotFoundException {
        studentService.getStudentById(studentId);
        courseService.getCourseById(courseId);
        String enrollmentDate = LocalDate.now().toString();
        Enrollment enrollment = new Enrollment(IdGenerator.generateEnrollmentId(), studentId, courseId, enrollmentDate, "ACTIVE");
        enrollmentRepository.save(enrollment);
    }

    public ArrayList<Enrollment> getAll() {
        return enrollmentRepository.findAll();
    }

    public ArrayList<Enrollment> getEnrollmentsByStudentId(int studentId) throws EntityNotFoundException {
        studentService.getStudentById(studentId);
        ArrayList<Enrollment> studentEnrollments = new ArrayList<>();
        for (Enrollment enrollment : enrollmentRepository.findAll()) {
            if (enrollment.getStudentId() == studentId) {
                studentEnrollments.add(enrollment);
            }
        }
        return studentEnrollments;
    }

    public void updateEnrollmentStatus(int enrollmentId, String status) throws EntityNotFoundException {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId);
        if (enrollment == null) {
            throw new EntityNotFoundException("Enrollment with ID " + enrollmentId + " not found.");
        }
        enrollment.setStatus(status);
    }
}
