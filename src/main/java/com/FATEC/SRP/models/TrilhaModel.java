package com.fatec.srp.models;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Getter
@Setter
@Entity
@Table(name="Trilhas")
public class TrilhaModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "trilha")
    private List<CursoTrilhaModel> trilhaCurso;

    @Column(name = "nome_trilha", nullable = false, length = 100)
    private String nomeTrilha;

    @Column(name = "desc_trilha", nullable = false, length = 100)
    private String descTrilha;

    @Column(name = "dt_cadastro", updatable = false)
    private LocalDateTime dtCadastro;

    @Column(name = "dt_alteracao")
    private LocalDateTime dtAlteracao;

    @PrePersist
    protected void onCreate() {
        dtCadastro = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        dtAlteracao = LocalDateTime.now();
    }
} 
