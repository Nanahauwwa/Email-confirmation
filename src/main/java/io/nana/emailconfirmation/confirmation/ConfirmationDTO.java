package io.nana.emailconfirmation.confirmation;

import lombok.Data;

@Data
public class ConfirmationDTO {

    public String firstname;

    public String lastname;

    public String email;

    public String password;
}
