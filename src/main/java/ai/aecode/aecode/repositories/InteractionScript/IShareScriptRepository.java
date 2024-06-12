package ai.aecode.aecode.repositories.InteractionScript;

import ai.aecode.aecode.entities.InteractionScript.ShareScript;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IShareScriptRepository extends JpaRepository<ShareScript,Integer> {
}
