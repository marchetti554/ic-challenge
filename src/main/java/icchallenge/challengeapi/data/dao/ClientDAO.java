package icchallenge.challengeapi.data.dao;

import icchallenge.challengeapi.data.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientDAO extends JpaRepository<Client, Integer> {

    Client getByClientId(long id);
    List<Client> getAllBy();
}
