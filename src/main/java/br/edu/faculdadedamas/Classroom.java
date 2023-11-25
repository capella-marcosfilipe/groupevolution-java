package br.edu.faculdadedamas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Stack;

public class Classroom {
    private int id;
    // (1,n) alunos matriculados
    private ArrayList<Student> studentsEnrolled = new ArrayList<Student>();
    // (0,n) registros de aula
    private Stack<ClassRecord> classRecords = new Stack<ClassRecord>();

    public Classroom(int id, ArrayList<Student> newStudents) {
        this.id = id;
        for (Student student : newStudents) {
            this.studentsEnrolled.add(student);
        }
    }

    public Classroom() {
        super();
    }

    public void enrollMultipleStudents(ArrayList<Student> newStudents) {
        for (Student student : newStudents) {
            this.studentsEnrolled.add(student);
        }
    }

    public void enrollSingleStudent(Student newStudent) {
        this.studentsEnrolled.add(newStudent);
    }

    public ClassRecord getRecordByDate(LocalDate searchingDate) {
        ClassRecord searchingRecord = new ClassRecord();
        for (int i = 0; i < this.classRecords.size(); i++) {
            if (this.classRecords.get(i).getClassDate().equals(searchingDate)) {
                searchingRecord = this.classRecords.get(i);
                break;
            }
        }
        return searchingRecord;
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
