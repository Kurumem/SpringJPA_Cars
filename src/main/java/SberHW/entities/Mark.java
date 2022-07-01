package SberHW.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Marks")
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long uid;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CAPTION")
    private String caption;



    @Column(name = "IsACTIVE")
    private boolean isActive;


    @JsonManagedReference
    @OneToMany
    private List<ModelAuto> modelAutoList = new ArrayList<>();


    public List<ModelAuto> getModelAutoList() {
        return modelAutoList;
    }

    public void setModelAutoList(List<ModelAuto> modelAutoList) {
        this.modelAutoList = modelAutoList;
    }


    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public List<ModelAuto> getModels() {
        return modelAutoList;
    }

    public void setModels(List<ModelAuto> modelAutos) {
        this.modelAutoList = modelAutos;
    }



}
