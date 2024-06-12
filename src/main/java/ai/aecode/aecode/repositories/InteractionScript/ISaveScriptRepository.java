package ai.aecode.aecode.repositories.InteractionScript;

import ai.aecode.aecode.entities.InteractionScript.SaveScript;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISaveScriptRepository extends JpaRepository<SaveScript, Integer> {
}
