package SberHW.controller;

import SberHW.entities.Mark;
import SberHW.entities.ModelAuto;
import SberHW.entities.Modification;
import SberHW.services.MarkService;
import SberHW.services.ModelService;
import SberHW.services.ModificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class MarkController {

    @Autowired
    MarkService markService;

    @Autowired
    ModelService modelService;

    @Autowired
    ModificationService modificationService;

    //Выводит на экран все марки
    @GetMapping("/marks")
    private List<Mark> getAllMarks(){
        return markService.getAllMarks();
    }

    //получает марку по введенному айди
    @GetMapping("/mark/{id}")
    private Mark getMarkId(@PathVariable Long id) {
        return markService.getMarkId(id);
    }

    //Выводит модели определенной марки
    @GetMapping("mark/{id}/model")
    public List<ModelAuto> getAllModels(@PathVariable Long id) {
        return markService.getMarkId(id).getModels();
    }

    //Поиск по айди модели определенной марки
    @GetMapping("mark/{markId}/model/{modelId}")
    public ModelAuto getModelId(@PathVariable Long markId, @PathVariable Long modelId) {
        for (ModelAuto modelAuto : markService.getMarkId(markId).getModels()) {
            if (modelAuto.getUid() == modelId) {
                return modelAuto;
            }
        }
        throw new NoSuchElementException();

    }
    //Выводит модификации моделей
    @GetMapping("mark/{markId}/model/{modelId}/modification")
    public List<Modification> getAllModifications(@PathVariable long markId, @PathVariable long modelId) {
            for (ModelAuto model : markService.getMarkId(markId).getModels()) {
                if (model.getUid() == modelId) {
                    return model.getModificationList();
                }
            }
            throw new NoSuchElementException();
    }
    //выводит модификации авто по айди марки, модели и модификации
    @GetMapping("mark/{markId}/model/{modelId}/modification/{modificationId}")
    public Modification getModificationById(@PathVariable long markId, @PathVariable long modelId, @PathVariable long modificationId) {

            for (ModelAuto model : markService.getMarkId(markId).getModels()) {
                if (model.getUid() == modelId) {
                    for (Modification modification : model.getModificationList()) {
                        if (modification.getUid() == modificationId) {
                            return modification;
                        }
                    }
                }
        }
        throw new NoSuchElementException();
    }

    //Добавить марку
    @PostMapping("/mark")
    public Mark saveMark(@RequestBody Mark mark) {
        markService.saveOrUpdateMark(mark);
        return mark;
    }

    //Добавить модель для марки
    @PostMapping("/mark/{id}/model")
    public ModelAuto saveModel(@PathVariable long id, @RequestBody ModelAuto model) {
            markService.getMarkId(id).getModels().add(model);
            model.setMark(markService.getMarkId(id));
            modelService.saveOrUpdateModel(model);
            return model;
    }

    //Добавить модификацию для модели марки
    @PostMapping("/mark/{markId}/model/{modelId}/modification")
    public Modification saveModification(@PathVariable long markId, @PathVariable long modelId, @RequestBody Modification modification) {
            modelService.getModelId(modelId).getModificationList().add(modification);
            modification.setModel(modelService.getModelId(modelId));
            modificationService.saveOrUpdateModification(modification);
            return modification;

    }



}
