package costume.life.be.repository.costume.life;

import costume.life.be.model.costume.life.Costume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostumeLifeRepository extends JpaRepository<Costume, Long> {
}
