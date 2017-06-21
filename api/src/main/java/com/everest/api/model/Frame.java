package com.everest.api.model;

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
@Table(name = "FRAME")
public class Frame implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "USER", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "TEAM")
    private Team team;

    @NotEmpty
    @Column(name = "NAME", nullable = false)
    private String name;
}
