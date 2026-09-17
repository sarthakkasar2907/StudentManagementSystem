import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
class Student {
    String name;
    int age;
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void display() {
        System.out.println("Student Name: " + name + " | Age: " + age);
    }
}
class Grades
Student extends Student {
    String researchArea;
    public GradesStudent(String name, int age, String researchArea) {
        super(name, age);
        this.researchArea = researchArea;
    }
    public void display() {
        System.out.println("Grad Student: " + name + " | Age: " + age + " | Research: " + researchArea);
    }
}
public class SimpleStudentSystem {
    public static void main(String[] args)
     {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();
        studList.add(new Student("Sarthak", 25));
        studList.add(new GradStudent("Arjun", 30, "AI"));
        boolean running = true;
        while (running) {
            System.out.println("-----STUDENT SYSTEM -----");
            System.out.println("1. View All Students");
            System.out.println("2. Add New Student");
            System.out.println("3. Save Data to File & Exit");
            System.out.println("Enter Choice (1,2,3): ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("\n--- Registered Students ---");
                        for (Student s : studList) {
                            s.display();
                        }
                        break;
                    case 2:
                        System.out.print("Enter Student Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Student Age: ");
                        int age = Integer.parseInt(scanner.nextLine());

                        studList.add(new Student(name, age));
                        System.out.println("Student added successfully!");
                        break;

                    case 3:
                        FileWriter writer = new FileWriter("student_records.txt");
                        for (Student s : studList) {
                            writer.write(s.name + " (" + s.age + " yrs)\n");
                        }
                        writer.close();
                        System.out.println("Data saved to 'student_records.txt'. Exiting...");
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid selection. Try 1 to 3.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
        scanner.close();
    }
}
