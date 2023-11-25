package br.edu.faculdadedamas;

import java.time.LocalDate;

public class ClassRecord {
    private int id;
    private LocalDate classDate;
    private String doneInClass;
    private String nextClass;
    private boolean canceled;

    public ClassRecord(int id, LocalDate classDate, String doneInClass, String nextClass, boolean canceled) {
        this.id = id;
        this.classDate = classDate;
        this.doneInClass = doneInClass;
        this.nextClass = nextClass;
        this.canceled = canceled;
    }

    public ClassRecord() {
        this.id = 0;
        this.classDate = null;
        this.doneInClass = "";
        this.nextClass = "";
        this.canceled = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getClassDate() {
        return classDate;
    }

    public void setClassDate(LocalDate classDate) {
        this.classDate = classDate;
    }

    public String getDoneInClass() {
        return doneInClass;
    }

    public void setDoneInClass(String doneInClass) {
        this.doneInClass = doneInClass;
    }

    public String getNextClass() {
        return nextClass;
    }

    public void setNextClass(String nextClass) {
        this.nextClass = nextClass;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

    @Override
    public String toString() {
        return "Id: " + id + "\tData: " + classDate + "\nFeito = " + doneInClass
                + "\nPróxima aula = " + nextClass + "\nCancelada? = " + (canceled ? "sim" : "não") + "\n";
    }

}
