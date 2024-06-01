package ai.aecode.aecode.repositories.RepoTableScript;

import ai.aecode.aecode.entities.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICurrencyRepository extends JpaRepository<Currency, Integer> {

}
