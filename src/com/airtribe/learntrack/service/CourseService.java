package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;

public class CourseService {
    private final CourseRepository courseRepository = new CourseRepository();

    public void addCourse(String courseName, String description, int durationInWeeks) {
        Course course = new Course(IdGenerator.generateCourseId(), courseName, description, durationInWeeks);
        courseRepository.save(course);
    }

    public ArrayList<Course> getAll() {
        return courseRepository.findAll();
    }

    public Course getCourseById(int id) throws EntityNotFoundException {
        Course course = courseRepository.findById(id);
        if (course == null) {
            throw new EntityNotFoundException("Course with ID " + id + " not found.");
        }
        return course;
    }

    public void deactivateCourse(int id) throws EntityNotFoundException {
        Course course = getCourseById(id);
        course.setActive(false);
    }
}
