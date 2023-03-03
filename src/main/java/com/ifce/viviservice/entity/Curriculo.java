package com.ifce.viviservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Curriculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Integer status;

    @Column(nullable = true)
    private String linkedin;

    @Column(nullable = true)
    private String github;

    @Column(nullable = false)
    private Integer periodoDisponivel;

    @Column(nullable = false)
    private Integer nivelIngles;

    @Column(nullable = false)
    private Integer nivelEspanhol;

    @Column(nullable = true)
    private String competencias;

    @Column(nullable = true)
    private String observacoes;

    @Column(nullable = false)
    private Date dataInclusao;

    @Column(nullable = true)
    private Date dataAlteracao;

    @Column(nullable = true)
    private String usuarioAlteracao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

}