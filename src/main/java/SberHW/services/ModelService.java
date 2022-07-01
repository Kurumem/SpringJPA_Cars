package SberHW.services;

import SberHW.entities.ModelAuto;
import SberHW.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModelService {
    @Autowired
    private ModelRepository modelRepository;


    public List<ModelAuto> getAllModels(){
        List<ModelAuto> models = new ArrayList<>();
        modelRepository.findAll().forEach(model -> models.add(model));
        return models;
    }

    public ModelAuto getModelId(long id){ return modelRepository.findById(id).get();}



    public void saveOrUpdateModel(ModelAuto model){
        modelRepository.save(model);

    }

    public List<ModelAuto> getByNameIn(String name){return new ArrayList<>(modelRepository.findByNameIgnoreCase(name));}

}
