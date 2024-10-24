
package banquemisr.challenge05.security.models.entities;

import banquemisr.challenge05.security.models.enums.RoleEnum;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "USERS")
public class User implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "ROLE")
    @Enumerated(EnumType.STRING)
    private RoleEnum role;
}
