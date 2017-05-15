package br.com.everest.tarefa.model;

import br.com.everest.tarefa.enumeration.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    @Temporal(TemporalType.TIMESTAMP)
    private Date criacao;

    @NotEmpty
    private String descricao;

    private String resposta;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Status status;

    private Long userId;

    private Boolean guardada = false;

    @Transient
    private User user;

    public String getData(){
        if (criacao != null){
            return new SimpleDateFormat("dd/MM/yyyy HH:mm").format(criacao);
        }
        return null;
    }
}
