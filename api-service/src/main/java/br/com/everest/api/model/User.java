package br.com.everest.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by joao on 11/05/17.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USER")
public class User implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @NotEmpty
    @Column(name = "NAME", nullable = false)
    private String name;

    @NotEmpty
    @Email
    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @NotEmpty
    @Column(name = "USERNAME", nullable = false, unique = true)
    private String username;

    @NotEmpty
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "CREATED", nullable = false, updatable = false)
    private LocalDateTime created;
}
