package costume.life.be.model.costume.life;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "costumes3")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Costume {
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
