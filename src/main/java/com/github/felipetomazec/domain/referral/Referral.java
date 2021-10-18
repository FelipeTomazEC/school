package com.github.felipetomazec.domain.referral;

import com.github.felipetomazec.domain.student.Student;

import java.time.LocalDateTime;

public class Referral {
    private Student creator;
    private Student referred;
    private LocalDateTime createdAt;

    public Referral (Student creator, Student referred) {
        this.creator = creator;
        this.referred = referred;
        this.createdAt = LocalDateTime.now();
    }

    public Student getCreator() {
        return creator;
    }

    public Student getReferred() {
        return referred;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
