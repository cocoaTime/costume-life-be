package costume.life.be.service;

import costume.life.be.model.costume.life.Costume;
import costume.life.be.model.miparti.MipartiCostume;
import costume.life.be.repository.costume.life.CostumeLifeRepository;
import costume.life.be.repository.miparti.MiPartyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MipartiService {
    private final MiPartyRepository miPartyRepository;
    private final CostumeLifeRepository costumeLifeRepository;

    public List<MipartiCostume> getAllCostumes(){
        return miPartyRepository.getAllCostumes();
    }

    public void migrateAllCostumes(){
        List<MipartiCostume> mipartiCostumes = miPartyRepository.getAllCostumes();
        List<Costume> costumes = mipartiCostumes.stream()
                .map(this::createCostume)
                .collect(Collectors.toList());
        costumeLifeRepository.saveAll(costumes);
    }

    private Costume createCostume(MipartiCostume mipartiCostume){
        return Costume.builder()
                .name(mipartiCostume.getName())
                .imgPath(mipartiCostume.getImgPath())
                .price(mipartiCostume.getPrice())
                .size(mipartiCostume.getSize())
                .vendorCode(mipartiCostume.getVendorCode())
                .consistsOf(mipartiCostume.getConsistsOf())
                .build();
    }
}
