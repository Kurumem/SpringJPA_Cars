package SberHW.services;

import SberHW.entities.Mark;
import SberHW.repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarkService {

    @Autowired
    private MarkRepository markRepository;


    public List<Mark> getAllMarks(){
        List<Mark> marks = new ArrayList<>();
        markRepository.findAll().forEach(mark -> marks.add(mark));
        return marks;
    }

    public Mark getMarkId(long id){ return markRepository.findById(id).get();}


    public void saveOrUpdateMark(Mark mark){
        markRepository.save(mark);
    }

    public List<Mark> getByNameIn(String name){return new ArrayList<>(markRepository.findByNameIgnoreCase(name));}


}
