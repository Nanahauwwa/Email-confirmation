package io.nana.emailconfirmation.confirmation;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table( name = "user_detail")
public class ConfirmationModel {

    @Id
    @Column
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column( name = "firstname" , nullable = false)
    private String firstname;
    @Column( name = "lastname" , nullable = false)
    private String lastname;
    @Column( name = "email" , nullable = false)
    private String email;
    @Column( name = "password" , nullable = false)
    private String password;
}
