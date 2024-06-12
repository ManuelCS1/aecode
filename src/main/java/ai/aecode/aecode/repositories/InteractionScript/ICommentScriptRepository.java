package ai.aecode.aecode.repositories.InteractionScript;

import ai.aecode.aecode.entities.InteractionScript.CommentScript;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentScriptRepository extends JpaRepository<CommentScript,Integer> {
}
