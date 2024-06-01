package ai.aecode.aecode.repositories.RepoTableScript;

import ai.aecode.aecode.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITagRepository extends JpaRepository<Tag, Integer> {
}
