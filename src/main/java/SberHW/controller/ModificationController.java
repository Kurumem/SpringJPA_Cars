package SberHW.controller;

import SberHW.entities.Modification;
import SberHW.services.ModificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ModificationController {

    @Autowired
    ModificationService modificationService;

    //Список модификаций
    @GetMapping("/modification")
    public List<Modification> getAllModifications(){
        return modificationService.getAllModification();
    }

    //Поиск модификаций по айди
    @GetMapping("/modification/{id}")
    public Modification getModificationId(@PathVariable long id){
        return modificationService.getModificationId(id);
    }

}
