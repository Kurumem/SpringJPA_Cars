package SberHW.services;

import SberHW.entities.Modification;
import SberHW.repository.ModificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModificationService {
    @Autowired
    private ModificationRepository modificationRepository;


    public List<Modification> getAllModification(){
        List<Modification> modifications = new ArrayList<>();
        modificationRepository.findAll().forEach(modification -> modifications.add(modification));
        return modifications;
    }

    public Modification getModificationId(long id){ return modificationRepository.findById(id).get();}



    public void saveOrUpdateModification(Modification modification){
        modificationRepository.save(modification);

    }


    public List<Modification> getNameBeginEnd(String name, int periodBegin, int periodEnd) {
        return new ArrayList<>(modificationRepository.findByNameIgnoreCaseAndPeriodBeginAndPeriodEnd(name, periodBegin, periodEnd));
    }

    public List<Modification> getNameBeginToNow(String name, int periodBegin) {
        return new ArrayList<>(modificationRepository.findByNameIgnoreCaseAndPeriodBegin(name, periodBegin));
    }

    public List<Modification> getNameToEnd(String name, int periodEnd) {
        return new ArrayList<>(modificationRepository.findByNameIgnoreCaseAndPeriodEnd(name, periodEnd));
    }

    public List<Modification> getByNameIn(String name){return new ArrayList<>(modificationRepository.findByNameIgnoreCase(name));}


}
