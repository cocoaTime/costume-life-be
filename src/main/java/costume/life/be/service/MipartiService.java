package costume.life.be.service;

import costume.life.be.model.costume.life.Costume;
import costume.life.be.model.miparti.MipartiCostume;
import costume.life.be.repository.costume.life.CostumeLifeRepository;
import costume.life.be.repository.miparti.MiPartyRepository;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MipartiService {
    private final MiPartyRepository miPartyRepository;
    private final CostumeLifeRepository costumeLifeRepository;

    public void migrateAllCostumes(){
        List<MipartiCostume> mipartiCostumes = miPartyRepository.getAllCostumes();
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        List<Costume> costumes =  mapperFacade.mapAsList(mipartiCostumes, Costume.class);
        costumeLifeRepository.saveAll(costumes);
    }
}
