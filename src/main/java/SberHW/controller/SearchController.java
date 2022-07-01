
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
    public Search search(@RequestParam(name = "mark") String markName,
                               @RequestParam(name = "model") String modelName,
                               @RequestParam(name = "modification") String modificationName,
                               @RequestParam(name = "periodBegin") Integer periodBegin,
                               @RequestParam(name = "periodEnd") Integer periodEnd) {
        List<Mark> resultMarks = new ArrayList<>();
        List<ModelAuto> resultModels = new ArrayList<>();
        List<Modification> resultModifications = new ArrayList<>();
        Search search = new Search();


            return search;
        }
}

