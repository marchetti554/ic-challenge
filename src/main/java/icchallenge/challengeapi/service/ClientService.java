package icchallenge.challengeapi.service;

import icchallenge.challengeapi.data.dao.ClientDAO;
import icchallenge.challengeapi.data.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientDAO clientDAO;

    public void saveClient(Client client) {
        clientDAO.save(client);
    }

    public Client getClient(long clientId) {
        return clientDAO.getByClientId(clientId);
    }

    public List<Client> getAllClients() {
        return clientDAO.getAll();
    }
}
