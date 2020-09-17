package costume.life.be.repository.costume.life;

import costume.life.be.model.costume.life.ERole;
import costume.life.be.model.costume.life.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
