package com.fatec.srp.models;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidade que representa uma pessoa.
 */

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
@Table(name = EscolaridadesModel.TABLE_NAME)
public class EscolaridadesModel {
    static final String TABLE_NAME = "escolaridades";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    /**
     * Nível de escolaridade.
     */
    @Column(name = "nivel", length = 20 , nullable = false)
    private String nivel;


}
