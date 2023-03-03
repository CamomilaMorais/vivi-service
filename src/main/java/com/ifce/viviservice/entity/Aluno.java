package com.ifce.viviservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String documento;

    @Column(nullable = false, unique = true)
    private String matricula;

    @Column(nullable = false)
    private Integer ddd;

    @Column(nullable = false)
    private Integer celular;

    @Column(nullable = false)
    private Integer status;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private Integer semestre;

    @Column(nullable = false)
    private Date dataIngresso;

    @Column(nullable = true)
    private Date dataEgresso;

    @Column(nullable = false)
    private Date dataInclusao;

    @Column(nullable = true)
    private Date dataAlteracao;

    @Column(nullable = true)
    private String usuarioAlteracao;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "autenticacao_id")
    private Autenticacao autenticacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campus_id")
    private Campus campus;

}