package ai.aecode.aecode.repositories;

import ai.aecode.aecode.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IProfileRepository extends JpaRepository<Profile,Integer> {
    @Query("SELECT p FROM Profile p WHERE p.username = :username OR p.profile_email = :email")
    Profile findByUsernameOrEmail(@Param("username") String username, @Param("email") String email);
}
