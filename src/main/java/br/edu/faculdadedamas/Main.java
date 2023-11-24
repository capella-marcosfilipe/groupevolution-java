package br.edu.faculdadedamas;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        // Criar alunos teste
        Student lucas = new Student("Lucas", "23.2.3.03");
        Student eduardo = new Student("Eduardo", "20.1.4.01");
        Student carlos = new Student("Carlos", "21.1.3.02");

        // Criar registros de lucas para teste
        ClassRecord novSeventh = new ClassRecord(
                LocalDate.of(2023, 11, 07),
                lucas,
                "Homework 3 done. Lesson 3 up to vocab w/o practice",
                "Lesson 3 from vocab practice. Focus on Present Perfect.",
                false);
        ClassRecord novFourteenth = new ClassRecord(
                LocalDate.of(2023, 11, 14),
                lucas,
                "Lesson 3 completed. Lyricstraining activity.",
                "Homework 3. Lesson 4.",
                false);

        Stack<ClassRecord> lucasRecords = new Stack<ClassRecord>();
        lucasRecords.add(novSeventh);
        lucasRecords.add(novFourteenth);

        // Home
        System.out.println("Group Evolution");
        // Retrieve students and ask for selection
        System.out.println("Escolha um aluno: ");
        Student[] enrolledStudents = new Student[3];
        enrolledStudents[0] = lucas;
        enrolledStudents[1] = eduardo;
        enrolledStudents[2] = carlos;
        printStudents(enrolledStudents);
        System.out.println("Escolha um aluno: ");
        Scanner scan = new Scanner(System.in);
        int opStudent = scan.nextInt();
        scan.close();
        
        // Show records for chosen student
        System.out.println(enrolledStudents[opStudent].name + "'s Class Diary");
        // Find records of 
    }

    private static void printStudents(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            System.out.println("[" + i + "] " + students[i]);
        }
    }
}
