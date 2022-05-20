package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
public class UserModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUser;

    @NotEmpty(message = "Nome do usuário não informado")
    private String nameUser;

    @NotEmpty(message = "Senha nao informada")
    private String passwordUser;

    @NotEmpty(message = "CPF não informado")
    @Column(unique = true, nullable = false)
    private String cpfUser;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private ProfileModel profile;

}
