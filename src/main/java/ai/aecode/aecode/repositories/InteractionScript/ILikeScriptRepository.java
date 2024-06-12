package ai.aecode.aecode.repositories.InteractionScript;

import ai.aecode.aecode.entities.InteractionScript.LikeScript;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILikeScriptRepository extends JpaRepository<LikeScript, Integer> {
}
