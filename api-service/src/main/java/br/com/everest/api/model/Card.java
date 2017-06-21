package br.com.everest.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Joao on 29/05/2017.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CARD")
public class Card implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "BOARD", nullable = false)
    private Board board;

    @NotEmpty
    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;
}
