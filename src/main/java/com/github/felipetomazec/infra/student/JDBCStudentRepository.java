package com.github.felipetomazec.infra.student;

import com.github.felipetomazec.domain.student.CPF;
import com.github.felipetomazec.domain.student.Student;
import com.github.felipetomazec.domain.student.StudentBuilder;
import com.github.felipetomazec.domain.student.StudentRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class JDBCStudentRepository implements StudentRepository {
    private Connection connection;

    public JDBCStudentRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void enroll(Student student) {
        var sql = "INSERT INTO STUDENT VALUES(?, ?, ?)";
        try (var studentPST = connection.prepareStatement(sql)) {
            studentPST.setString(1, student.getCpf());
            studentPST.setString(2, student.getEmail());
            studentPST.setString(3, student.getName());
            studentPST.execute();

            sql = "INSERT INTO PHONE VALUES (?, ?, ?)";

            for(var phone: student.getPhones()) {
                var phonePST = connection.prepareStatement(sql);
                phonePST.setString(1, phone.getDdd());
                phonePST.setString(2, phone.getNumber());
                phonePST.setString(3, student.getCpf());
                phonePST.execute();
            };

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Student> retrieveStudentByCPF(CPF cpf) {
        var sql = "SELECT * FROM STUDENT WHERE cpf = ?";
        try (var getStudentPST = connection.prepareStatement(sql)) {
            getStudentPST.setString(1, cpf.getNumber());

            var results = getStudentPST.executeQuery();
            var builder = new StudentBuilder();

            if(results.first()) {
                var name = results.getString("name");
                var email = results.getString("email");
                builder.setCpf(cpf.getNumber());
                builder.setEmail(email);
                builder.setName(name);

                return Optional.of(builder.build());
            }

            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> retrieveAllEnrolledStudents() {
        return Collections.emptyList();
    }
}
