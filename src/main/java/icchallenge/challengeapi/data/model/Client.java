package icchallenge.challengeapi.data.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * Model class in charge of represent a Client.
 *
 * @author Marco Marchetti
 */
@Data
@Entity
@NoArgsConstructor
@Table(name = "clients")
public class Client {

    public Client(String name, String lastName, LocalDate birthDate, int age) {
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.age = age;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private long clientId;

    @Column(name = "client_name")
    private String name;

    @Column(name = "client_last_name")
    private String lastName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "client_birth_date")
    private LocalDate birthDate;

    @Column(name = "client_age")
    private int age;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "client_estimated_death_date")
    private LocalDate estimatedDeathDate;
}