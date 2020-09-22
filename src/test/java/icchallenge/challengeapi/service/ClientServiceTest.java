package icchallenge.challengeapi.service;

import icchallenge.challengeapi.data.dao.ClientDAO;
import icchallenge.challengeapi.data.model.Client;
import icchallenge.challengeapi.data.model.ClientKpiData;
import org.junit.Before;


import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Test class in charge of validate the {@link ClientService}
 * methods behavior.
 *
 * @author Marco Marchetti
 */
public class ClientServiceTest {

    @InjectMocks
    private ClientService clientService;

    @Mock
    private ClientDAO clientDAOMock;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void saveClient() {

    }

    @Test
    public void calculateClientKPIShouldSuccess() {

        double expectedAverage = 42;
        double expectedStandardDeviation = 18;

        when(clientDAOMock.findAll()).thenReturn(createClientList());

        ClientKpiData result = clientService.calculateClientsKpi();

        verify(clientDAOMock).findAll();

        assertEquals(expectedAverage, result.getAgeAverage());
        assertEquals(expectedStandardDeviation, result.getAgeStandardDeviation());
    }

    private List<Client> createClientList() {
        Client client1 = new Client("TestName1", "TestLastName1", LocalDate.now(), 60);
        Client client2 = new Client("TestName2", "TestLastName2", LocalDate.now(), 24);
        return List.of(client1, client2);
    }
}