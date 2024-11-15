import java.time.LocalDateTime;

/**
 * Representa o modelo de uma trilha.
 * 
 * <p>Esta classe utiliza anotações do JPA para mapear a entidade para uma tabela no banco de dados.
 * Também utiliza anotações do Lombok para gerar automaticamente os métodos getters, setters, 
 * construtores e o padrão de projeto Builder.</p>
 * 
 * <p>Conceitos de POO utilizados:</p>
 * <ul>
 *   <li>Encapsulamento: Os atributos são privados e acessados através de métodos públicos gerados pelo Lombok.</li>
 *   <li>Construtores: Construtores padrão e com argumentos são gerados pelo Lombok.</li>
 *   <li>Builder: Padrão de projeto para facilitar a criação de instâncias da classe.</li>
 * </ul>
 */
@Entity
@Table(name = "trilhas")
public class TrilhaModel {

    /**
     * Identificador único da trilha.
     * 
     * <p>Este campo é gerado automaticamente pelo banco de dados.</p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTrilha;

    /**
     * Nome da trilha.
     * 
     * <p>Este campo é obrigatório.</p>
     */
    @Column(name = "nome_trilha", nullable = false)
    private String nomeTrilha;

    /**
     * Descrição da trilha.
     */
    @Column(name = "desc_trilha")
    private String descTrilha;
    /**
     * Método executado antes de persistir um novo registro.
     * Define a data de cadastro como a data e hora atual.
     * 
     * @PrePersist Indica que o método deve ser executado antes de persistir o registro.
     */
    @PrePersist
    protected void onCreate() {
        dtCadastro = LocalDateTime.now();
    }

    /**
     * Método executado antes de atualizar um registro existente.
     * Define a data de alteração como a data e hora atual.
     * 
     * @PreUpdate Indica que o método deve ser executado antes de atualizar o registro.
     */
    @PreUpdate
    protected void onUpdate() {
        dtAlteracao = LocalDateTime.now();
    }
}
