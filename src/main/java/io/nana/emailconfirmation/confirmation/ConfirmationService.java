package io.nana.emailconfirmation.confirmation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ConfirmationService {
    @Autowired
    private ConfirmationRepository confirmationRepository;


    public ResponseEntity<?> saveUser(ConfirmationDTO userdata){
        ConfirmationModel user = new ConfirmationModel();
        user.setFirstname(userdata.getFirstname());
        user.setLastname(userdata.getLastname());
        user.setEmail(userdata.getEmail());
        user.setPassword(userdata.getPassword());


    return  ResponseEntity.ok().body(confirmationRepository.save(user));
    }
}
