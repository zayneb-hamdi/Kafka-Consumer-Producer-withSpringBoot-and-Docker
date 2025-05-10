package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bonus")
public class Bonus {
    @Id
    @Column(name ="id")
    private int id;
    @Column(name ="student")
    private int student;
    @Column(name ="amount")
    private int amount;
    public Bonus(int id, int student, int amount) {
        this.id = id;
        this.student = student;
        this.amount = amount;
    }

    public Bonus() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudent() {
        return student;
    }

    public void setStudent(int student) {
        this.student = student;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }



}
