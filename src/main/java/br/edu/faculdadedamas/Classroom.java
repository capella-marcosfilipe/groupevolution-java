package br.edu.faculdadedamas;

import java.util.ArrayList;
import java.util.Stack;

public class Classroom {
    private int id;
    // (1,n) alunos matriculados
    private ArrayList<Student> studentsEnrolled;
    // (0,n) registros de aula
    private Stack<ClassRecord> classRecords = new Stack<ClassRecord>();

    public Classroom(int id, ArrayList<Student> newStudents) {
        this.id = id;
        for (Student student : newStudents) {
            this.studentsEnrolled.add(student);
        }
    }
    
    public void enrollStudents(ArrayList<Student> newStudents) {
        for (Student student : newStudents) {
            this.studentsEnrolled.add(student);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Student> getStudentsEnrolled() {
        return studentsEnrolled;
    }

    public void setStudentsEnrolled(ArrayList<Student> studentsEnrolled) {
        this.studentsEnrolled = studentsEnrolled;
    }

    public Stack<ClassRecord> getClassRecords() {
        return classRecords;
    }

    public void setClassRecords(Stack<ClassRecord> classRecords) {
        this.classRecords = classRecords;
    }

}
