package io.nana.emailconfirmation.confirmation;

import org.springframework.data.repository.CrudRepository;

public interface ConfirmationRepository  extends CrudRepository<ConfirmationModel, Long> {
}
