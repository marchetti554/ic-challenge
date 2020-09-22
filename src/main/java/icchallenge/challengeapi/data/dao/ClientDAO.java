package icchallenge.challengeapi.data.dao;

import icchallenge.challengeapi.data.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * DAO in charge of {@link Client} database operations.
 *
 * @author Marco Marchetti
 */
@Repository
public interface ClientDAO extends JpaRepository<Client, Integer> {

}
