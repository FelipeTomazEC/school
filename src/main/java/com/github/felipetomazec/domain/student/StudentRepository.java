package com.github.felipetomazec.domain.student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    void enroll(Student student);

    Optional<Student> retrieveStudentByCPF(CPF cpf);

    List<Student> retrieveAllEnrolledStudents();
}
