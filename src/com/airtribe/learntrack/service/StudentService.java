package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;

public class StudentService {
    private final StudentRepository studentRepository = new StudentRepository();

   public void addStudent(String firstName, String lastName, String email, String batch) {
       Student student = new Student(IdGenerator.generateStudentId(), firstName, lastName, email, batch);
       studentRepository.save(student);
   }

   public ArrayList<Student> getAll() {
       return studentRepository.findAll();
   }

   public Student getStudentById(int id) throws EntityNotFoundException {
      Student student = studentRepository.findById(id);
      if (student == null) {
          throw new EntityNotFoundException("Student with ID " + id + " not found.");
      }
      return student;
   }

   public void deactivateStudent(int id) throws EntityNotFoundException {
       Student student = getStudentById(id);
       student.setActive(false);
   }
}
