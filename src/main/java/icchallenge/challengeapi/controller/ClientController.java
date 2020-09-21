package icchallenge.challengeapi.controller;

import icchallenge.challengeapi.data.model.Client;
import icchallenge.challengeapi.data.request.CreateClientRequest;
import icchallenge.challengeapi.service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/client")
public class ClientController {

    @Autowired
    private Environment env;

    @Autowired
    private ClientService clientService;

    @GetMapping("/test-db")
    public Client testEndpointDb() {
        return clientService.getClient(1);
    }

    @GetMapping("/get")
    public Client getClientById(@RequestParam long clientId) {
        return clientService.getClient(clientId);
    }

    @PostMapping("/create")
    public void createClient(@RequestBody CreateClientRequest clientToCreate) {
        clientService.saveClient(clientToCreate.toModel());
    }
}
