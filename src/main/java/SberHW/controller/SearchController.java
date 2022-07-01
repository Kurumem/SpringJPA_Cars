
package SberHW.controller;

import SberHW.entities.Mark;
import SberHW.entities.ModelAuto;
import SberHW.entities.Modification;
import SberHW.entities.Search;
import SberHW.services.MarkService;
import SberHW.services.ModelService;
import SberHW.services.ModificationService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class SearchController {
    @Autowired
    MarkService markService;

    @Autowired
    ModelService modelService;

    @Autowired
    ModificationService modificationService;

    //Поиск
    @GetMapping("/search")
    public Search search(@RequestParam(name = "mark") Optional<String> markName,
                               @RequestParam(name = "model") Optional<String> modelName,
                               @RequestParam(name = "modification") Optional<String> modificationName,
                               @RequestParam(name = "perBegin") Optional<Integer> periodBegin,
                               @RequestParam(name = "perEnd") Optional<Integer> periodEnd) {
        List<Mark> resultMarks = new ArrayList<>();
        List<ModelAuto> resultModels = new ArrayList<>();
        List<Modification> resultModifications = new ArrayList<>();
        Search search = new Search();

        //Поиск по нескольким парамтерам
        if (modificationName.isPresent() && periodBegin.isPresent() && periodEnd.isPresent()) {
            resultModifications = modificationService.getNameBeginEnd(modificationName.get(), periodBegin.get(), periodEnd.get());
        } else if (modificationName.isPresent() && periodBegin.isPresent()) {
            resultModifications = modificationService.getNameBeginToNow(modificationName.get(), periodBegin.get());
        } else if (modificationName.isPresent() && periodEnd.isPresent()) {
            resultModifications = modificationService.getNameToEnd(modificationName.get(), periodEnd.get());
        }  else if (modificationName.isPresent()) {
            resultModifications = modificationService.getByNameIn(modificationName.get());
        } else { //Поиск по модели
            if (modelName.isPresent()) {
                resultModels = modelService.getByNameIn(modelName.get());
            } else { //Поиск по марке
                if (markName.isPresent()) {
                    resultMarks = markService.getByNameIn(markName.get());
                }
            }
        }

        //Cписок марок
        if (!resultMarks.isEmpty()) {
            search.setMarkList(resultMarks);

        } else if (!resultModels.isEmpty()) {
            for (ModelAuto modelAuto : resultModels) {
                if (markName.isPresent()) {
                    if (markName.get().equalsIgnoreCase(modelAuto.getMark().getName())) {
                        search.getMarkList().add(modelAuto.getMark());
                    }
                } else {
                    search.getMarkList().add(modelAuto.getMark());
                }
            }
        } else if (!resultModifications.isEmpty()) {
            for (Modification modification : resultModifications) {

                if (markName.isPresent() && modelName.isPresent()) {
                    if (markName.get().equalsIgnoreCase(modification.getModel().getMark().getName()) &&
                            modelName.get().equalsIgnoreCase(modification.getModel().getName())) {
                        if (!search.getMarkList().contains(modification.getModel().getMark())) {
                            search.getMarkList().add(modification.getModel().getMark());
                        }
                    }

                } else if (modelName.isPresent()) {
                    if (modelName.get().equalsIgnoreCase(modification.getModel().getName())) {
                        if (!search.getMarkList().contains(modification.getModel().getMark())) {
                            search.getMarkList().add(modification.getModel().getMark());
                        }
                    }

                } else if (markName.isPresent()) {
                    if (markName.get().equalsIgnoreCase(modification.getModel().getMark().getName())) {
                        if (!search.getMarkList().contains(modification.getModel().getMark())) {
                            search.getMarkList().add(modification.getModel().getMark());
                        }
                    }

                } else {
                    if (!search.getMarkList().contains(modification.getModel().getMark())) {
                        search.getMarkList().add(modification.getModel().getMark());
                    }
                }
            }
        }



        return search;


        }
}

