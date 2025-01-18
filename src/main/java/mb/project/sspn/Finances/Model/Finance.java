package mb.project.sspn.Finances.Model;

import java.time.LocalDate;

public class Finance {

    private int financeid;
    private LocalDate date;
    private String transaction;
    private String description;
    private double value;

    public Finance() {
    }

    public Finance(int financeid, LocalDate date, String type, String description, double value) {
        this.financeid = financeid;
        this.date = date;
        this.transaction = type;
        this.description = description;
        this.value = value;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getFinanceid() {
        return financeid;
    }

    public String getTransaction() {
        return transaction;
    }

    public String getDescription() {
        return description;
    }

    public double getValue() {
        return value;
    }

    public void setFinanceid(int financeid) {
        this.financeid = financeid;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
