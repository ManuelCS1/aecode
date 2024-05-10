package ai.aecode.aecode.repositories;

import ai.aecode.aecode.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseRepository extends JpaRepository<Course,Integer> {
}
