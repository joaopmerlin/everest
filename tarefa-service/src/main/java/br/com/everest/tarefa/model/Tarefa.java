package br.com.everest.tarefa.model;

import br.com.everest.tarefa.enumeration.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by Joao on 11/05/2017.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tarefa implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(updatable = false)
    private LocalDateTime criacao;

    @NotEmpty
    private String descricao;

    private String resposta;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Status status;

    private Long userId;

    @Transient
    private User user;
}
