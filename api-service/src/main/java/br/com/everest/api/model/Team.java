package br.com.everest.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Joao on 29/05/2017.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TEAM")
public class Team implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @NotEmpty
    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;
}
