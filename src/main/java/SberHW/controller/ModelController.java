package SberHW.controller;

import SberHW.entities.ModelAuto;
import SberHW.entities.Modification;
import SberHW.services.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.NoSuchElementException;

public class ModelController {
    @Autowired
    ModelService modelService;

    //Список моделей
    @GetMapping("/model")
    public List<ModelAuto> getAllModels(){
        return modelService.getAllModels();
    }

    //Поиск модели по айди
    @GetMapping("/model/{id}")
    public ModelAuto getModelId(@PathVariable long id){
        return modelService.getModelId(id);
    }

    //Поиск модификаций модели по айди
    @GetMapping("model/{id}/modification")
    public List<Modification> getAllModifications(@PathVariable long id){
        return modelService.getModelId(id).getModificationList();
    }

    //Поиск модификации айди по модели
    @GetMapping("model/{modelId}/modification/{modificationId}")
    public Modification getModificationId(@PathVariable long modelId, @PathVariable long modificationId)
    {
        for (Modification modification : modelService.getModelId(modelId).getModificationList()){
            if(modification.getUid() == modificationId){
                return modification;
            }
        }
        throw new NoSuchElementException();
    }


}
