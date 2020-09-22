package icchallenge.challengeapi.data.request;

import icchallenge.challengeapi.data.model.Client;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;

/**
 * Model class in charge of serve as a request to
 * create a new {@link Client}.
 *
 * @author Marco Marchetti
 */
@Data
public class CreateClientRequest {

    private String name;
    private String lastName;
    private LocalDate birthDate;

    /**
     * Transforms the request to the model to be saved in the
     * database, also calculating the client birth date.
     *
     * @return a {@link Client}
     */
    public Client toModel() {
        return new Client(name, lastName, birthDate, Period.between(birthDate, LocalDate.now()).getYears());
    }
}
