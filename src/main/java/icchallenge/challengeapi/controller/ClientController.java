package icchallenge.challengeapi.controller;

import icchallenge.challengeapi.data.model.Client;
import icchallenge.challengeapi.data.model.KpiData;
import icchallenge.challengeapi.data.request.CreateClientRequest;

import icchallenge.challengeapi.service.ClientService;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Controller in charge of {@link Client} related operations.
 *
 * @author Marco Marchetti
 */
@RestController("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @ApiOperation(value = "Calculates the client KPI.",
            notes = "Returns the average age and standard deviation.",
            response = KpiData.class)
    @GetMapping("/kpideclientes")
    public KpiData getClientsKpi() {
        return clientService.calculateClientsKpi();
    }

    @ApiOperation(value = "Retrieves all clients and calculates their estimated death date.",
            responseContainer = "Map")
    @GetMapping("/listclientes")
    public Map<Long, Client> getClients() {
        return clientService.listClientsWithEstimatedDeathDate();
    }

    @ApiOperation(value = "Creates a new Client in the database.",
            notes = "The Client age is calculated automatically.")
    @PostMapping("/creacliente")
    public void createClient(@RequestBody CreateClientRequest clientToCreate) {
        clientService.saveClient(clientToCreate.toModel());
    }
}
