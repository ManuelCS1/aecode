package ai.aecode.aecode.repositories.RepoTableScript;

import ai.aecode.aecode.entities.Software;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISoftwareRepository extends JpaRepository<Software, Integer> {
}
