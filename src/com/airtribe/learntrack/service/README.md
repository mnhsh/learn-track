# LearnTrack

## Project Description
LearnTrack is a simple console based Student and Course Management System built with Core Java. It allows users to manage students, create courses, and enroll students into those courses using an interactive menu. All data is managed in-memory using ArrayLists.

## How to Compile and Run

1. Open your terminal and navigate to the project's root folder.
2. Compile the Java files by running:
   ```bash
   javac -d out/ src/com/airtribe/learntrack/**/*.java src/com/airtribe/learntrack/*.java
3. Run the application by running:
   java -cp out/ com.airtribe.learntrack.Main

## Class Diagram
   Here is a simple overview of how the classes are related in this project:
- Person (Base class containing common details like ID and Name)
- Student (Inherits from Person and adds batch/active status)
- Course (Standalone entity for course details)
- Enrollment (Links a Student ID to a Course ID with a status)
---
  Architecture Flow:
  Main (Menu) ➔ Services (Business Logic) ➔ Repositories (Data Storage in ArrayLists)