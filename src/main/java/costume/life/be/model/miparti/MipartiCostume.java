package costume.life.be.model.miparti;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MipartiCostume {
    @Id
    @Column(name = "model")
    private String vendorCode;
    private String name;
    @Column(name = "components")
    private String consistsOf;
    private int price;
    @Column(name = "image")
    private String imgPath;
    @Column(name = "ean")
    private String size;

}
