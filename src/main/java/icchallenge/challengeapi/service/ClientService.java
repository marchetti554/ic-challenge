package icchallenge.challengeapi.service;

import icchallenge.challengeapi.data.dao.ClientDAO;

import icchallenge.challengeapi.data.model.Client;
import icchallenge.challengeapi.data.model.ClientKpiData;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Service in charge of {@link Client} related operations.
 *
 * @author Marco Marchetti
 */
@Service
public class ClientService {

    @Autowired
    private ClientDAO clientDAO;

    private static final int LIFE_EXPECTANCY_YEARS = 80;

    /**
     * Saves a client into the database.
     *
     * @param client the client to save
     */
    public void saveClient(Client client) {
        clientDAO.save(client);
    }

    /**
     * Calculates the clients KPI:
     * - the client average age
     * - the age standard deviation
     *
     * @return a {@link ClientKpiData}.
     */
    public ClientKpiData calculateClientsKpi() {
        List<Client> clients = clientDAO.findAll();
        return ClientKpiData.builder()
                .ageAverage(calculateAgeAverage(clients))
                .ageStandardDeviation(calculateStandardDeviation(clients))
                .build();
    }

    /**
     * Calculates the average age of a given list of clients.
     *
     * @param clients the clients to calculate the standard deviation
     * @return the standard deviation
     */
    private double calculateAgeAverage(List<Client> clients) {
        return clients.stream().mapToDouble(Client::getAge)
                .average()
                .orElse(0);
    }

    /**
     * Calculates the age standard deviation of a given list
     * of clients.
     *
     * @param clients the clients to calculate the standard deviation
     * @return the standard deviation
     */
    private double calculateStandardDeviation(List<Client> clients) {
        double average = clients.stream()
                .mapToDouble(Client::getAge)
                .sum() / clients.size();
        double sum = clients.stream()
                .mapToDouble(Client::getAge)
                .map(s -> s = Math.pow(s - average, 2))
                .sum();
        return Math.sqrt(sum / (clients.size()));
    }

    /**
     * Retrieves all clients, calculates their estimated
     * death date and then returns a {@link Map} of clients.
     *
     * @return the clients with their estimated death dates
     */
    public Map<Long, Client> listClientsWithEstimatedDeathDate() {
        return clientDAO.findAll().stream()
                .peek(client -> client.setEstimatedDeathDate(client.getBirthDate().plusYears(LIFE_EXPECTANCY_YEARS)))
                .collect(Collectors.toMap(Client::getClientId, Function.identity()));
    }
}
