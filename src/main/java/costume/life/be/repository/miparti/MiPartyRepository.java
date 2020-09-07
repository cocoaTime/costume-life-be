package costume.life.be.repository.miparti;

import costume.life.be.model.miparti.MipartiCostume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MiPartyRepository extends JpaRepository<MipartiCostume, Long> {
    @Query(nativeQuery = true, value =
    "SELECT " +
            "product.model, product.ean, product.image, product.price, dscrptn.name, dscrptn.components " +
            "FROM jos_mijoshop_product product\n" +
            "JOIN jos_mijoshop_product_description dscrptn\n" +
            "ON product.product_id = dscrptn.product_id\n" +
            "WHERE dscrptn.language_id = 3;")
    List<MipartiCostume> getAllCostumes();
}
