package com.github.felipetomazec.domain.student;

public class StudentBuilder {
    private String name;
    private String cpf;
    private String email;

    public StudentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public StudentBuilder setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public StudentBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public Student build() {
        var email = new Email(this.email);
        var cpf = new CPF(this.cpf);

        return new Student(name, cpf, email);
    }
}
