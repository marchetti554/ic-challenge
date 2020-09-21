package icchallenge.challengeapi.data.request;

import icchallenge.challengeapi.data.model.Client;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;

@Data
public class CreateClientRequest {

    private String name;
    private String lastName;
    private LocalDate birthDate;

    public Client toModel() {
        return new Client(name, lastName, birthDate, Period.between(birthDate, LocalDate.now()).getYears());
    }
}
