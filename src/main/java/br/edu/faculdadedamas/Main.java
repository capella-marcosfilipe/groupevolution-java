package br.edu.faculdadedamas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    private static Scanner globalScan = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Classroom> todasAsTurmas = new ArrayList<Classroom>();

        // Criar alunos teste
        Student lucas = new Student(1, "Lucas", "23.2.3.01");
        Student luisa = new Student(2, "Luísa", "23.2.3.02");

        ArrayList<Student> novaTurma = new ArrayList<Student>();
        novaTurma.add(lucas);
        novaTurma.add(luisa);

        // Criar turma e matricular lucas e luísa
        Classroom turma01 = new Classroom(1, novaTurma);
        todasAsTurmas.add(turma01);

        // // Printar alunos matriculados
        // System.out.println(turma01.getStudentsEnrolled().toString());

        // Matricular só Júlia
        Student julia = new Student(3, "Júlia", "23.2.3.03");
        turma01.enrollSingleStudent(julia);

        // // Printar alunos matriculados
        // System.out.println(turma01.getStudentsEnrolled().toString());

        // Criar as primeiras 3 aulas do grupo
        ClassRecord sepThirtyFirst = new ClassRecord(
                1,
                LocalDate.of(2023, 10, 31),
                "Lesson 2 completed. Activity about the topic.",
                "Homework 2. Lesson 3.",
                false);
        ClassRecord novSeventh = new ClassRecord(
                2,
                LocalDate.of(2023, 11, 07),
                "Homework 2 done. Lesson 3 up to vocab w/o practice",
                "Lesson 3 from vocab practice. Focus on Present Perfect.",
                false);
        ClassRecord novFourteenth = new ClassRecord(
                3,
                LocalDate.of(2023, 11, 14),
                "Lesson 3 completed. Lyricstraining activity.",
                "Homework 3. Lesson 4.",
                false);

        // Salvar os primeiros 3 registros de aula no diário
        turma01.getClassRecords().add(sepThirtyFirst);
        turma01.getClassRecords().add(novSeventh);
        turma01.getClassRecords().add(novFourteenth);

        // // Printar diário de aula
        // System.out.println(turma01.getClassRecords().toString());

        // Início do programa
        System.out.println("GROUP EVOLUTION");
        printLine();
        System.out.println("Your classes: ");
        for (Classroom classroom : todasAsTurmas) {
            System.out.println("> Class " + classroom.getId());
            for (Student student : classroom.getStudentsEnrolled()) {
                System.out.println("  - " + student.toString());
            }
        }

        System.out.print("Choose a class: ");
        int opClass = globalScan.nextInt();
        clearScreen();

        // Tela da turma
        // Printar matriculados
        Classroom chosenClass = todasAsTurmas.get(opClass - 1);
        System.out.println("You've picked class #" + opClass);
        printLine();
        System.out.println("Enrolled student(s): ");

        for (Student student : chosenClass.getStudentsEnrolled()) {
            System.out.println("> " + student.toString());
        }
        // Printar registros de aula
        printLine();
        System.out.println("Class records: ");
        for (ClassRecord record : chosenClass.getClassRecords()) {
            System.out.println(record.toString());
        }

        // Apresentar menu opções
        printLine();

        while (true) {
            // Display menu options and get user input
            int choice = classScreenOptionMenu();
            
            // Process user choice
            Scanner scanString = new Scanner(System.in);
            switch (choice) {
                // Show descending
                case 1:
                    printLine();
                    printReversed(chosenClass.getClassRecords());
                    break;
                // Search for record based on date
                case 2:
                    printLine();
                    int year = 0;
                    int month = 0;
                    int day = 0;

                    System.out.println("Type in day: ");
                    day = globalScan.nextInt();

                    System.out.println("Type in month");
                    month = globalScan.nextInt();

                    System.out.println("Type in year");
                    year = globalScan.nextInt();

                    LocalDate searchingDate = LocalDate.of(year, month, day);
                    System.out.println("Chosen date: " + searchingDate.toString());
                    ClassRecord searchedRecord = chosenClass.getRecordByDate(searchingDate);

                    printLine();
                    System.out.println(searchedRecord.toString());
                    break;
                    // Add new record
                case 3:
                    clearScreen();
                    System.out.println("Adding new record");
                    ClassRecord newRecord = new ClassRecord();
                    // Setting id
                    newRecord.setId(chosenClass.getClassRecords().peek().getId() + 1);

                    // Setting date
                    int newYear = 0;
                    int newMonth = 0;
                    int newDay = 0;

                    System.out.println("Type in day: ");
                    newDay = globalScan.nextInt();

                    System.out.println("Type in month");
                    newMonth = globalScan.nextInt();

                    System.out.println("Type in year");
                    newYear = globalScan.nextInt();

                    LocalDate newDate = LocalDate.of(newYear, newMonth, newDay);
                    newRecord.setClassDate(newDate);

                    // Cancelled?
                    System.out.println("Was the class canceled? y/n");
                    String isCanceled = scanString.nextLine().toLowerCase().strip();
                    if (isCanceled.contains("y")) {
                        newRecord.setCanceled(true);
                    } else if (isCanceled.contains("n")) {
                        newRecord.setCanceled(false);
                    } else {
                        System.out.println("Opção inválida");
                        break;
                    }

                    // Registering doneInClass
                    System.out.println("What was done in class: ");
                    newRecord.setDoneInClass(scanString.nextLine());

                    // Registering nextClass
                    System.out.println("What will be done next class: ");
                    newRecord.setNextClass(scanString.nextLine());

                    chosenClass.getClassRecords().add(newRecord);

                    System.out.println("Class records: ");
                    for (ClassRecord record : chosenClass.getClassRecords()) {
                        System.out.println(record.toString());
                    }
                    break;

                // Close program
                case 4:
                    System.out.println("Exiting program");
                    scanString.close();
                    globalScan.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void printLine() {
        System.out.println("====================================");
    }

    private static void printReversed(Stack<ClassRecord> stack) {
        if (stack.isEmpty())
            return;
        ClassRecord record = stack.pop(); // .pop() retorna o valor excluído
        System.out.println(record);
        printReversed(stack);
        stack.push(record); // restaura a pilha
    }

    private static int classScreenOptionMenu() {
        System.out.print(
                "MENU:\n" +
                        "[1] Show in descending order\n" +
                        "[2] Search for record\n" +
                        "[3] Add new record\n" +
                        "[4] Exit program\n" +
                        "Option: ");
        int option = globalScan.nextInt();
        return option;
    }
}
