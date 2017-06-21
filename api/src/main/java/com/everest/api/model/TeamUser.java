package com.everest.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Joao on 29/05/2017.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TEAM_USER")
public class TeamUser implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "TEAM", nullable = false, unique = true)
    private Team team;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "USER", nullable = false, unique = true)
    private User user;
}
