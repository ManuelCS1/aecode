package ai.aecode.aecode.repositories;

import ai.aecode.aecode.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepository extends JpaRepository<Comment,Integer> {
}
