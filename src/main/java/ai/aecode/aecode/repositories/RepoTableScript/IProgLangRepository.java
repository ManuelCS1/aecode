package ai.aecode.aecode.repositories.RepoTableScript;

import ai.aecode.aecode.entities.ProgLang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProgLangRepository extends JpaRepository<ProgLang, Integer> {
}
