# LearnTrack

## Project Description
LearnTrack is a simple console based Student and Course Management System built with Core Java. It allows users to manage students, create courses, and enroll students into those courses using an interactive menu. All data is managed in-memory using ArrayLists.

## How to Compile and Run
You can run this project either from your terminal or using an IDE.

### Option 1: Using a Terminal
1. Open your terminal and navigate to the project's root folder.
2. Compile the Java files by running:
   ```bash
   javac -d out/ src/com/airtribe/learntrack/**/*.java src/com/airtribe/learntrack/*.java
3. Run the application by running:
   java -cp out/ com.airtribe.learntrack.Main
### Option 2: Using an IDE (IntelliJ IDEA, Eclipse, VS Code)
1. Clone the GitHub repository to your local machine:
   git clone https://github.com/mnhsh/learn-track.git
2. Open the cloned folder as a project in your IDE.
3. In the project explorer, navigate to src/com/airtribe/learntrack/ui/Main.java.
4. Click the "Run" button (usually a green play icon) to start the application.
## Class Diagram
   Here is a simple overview of how the classes are related in this project:
- Person (Base class containing common details like ID and Name)
- Student (Inherits from Person and adds batch/active status)
- Course (Standalone entity for course details)
- Enrollment (Links a Student ID to a Course ID with a status)

## Architecture Flow:
  Main (Menu) ➔ Services (Business Logic) ➔ Repositories (Data Storage in ArrayLists)