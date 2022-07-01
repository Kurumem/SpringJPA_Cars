package SberHW.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.ui.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Modifications")
public class Modification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long uid;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CAPTION")
    private String caption;

    @Column(name = "IsACTIVE")
    private boolean isActive;

    @Column(name = "Begin")
    private int periodBegin;

    @Column(name = "End")
    private int periodEnd;

    @JsonBackReference
    @ManyToOne
    private ModelAuto model;

    public ModelAuto getModel() {
        return model;
    }

    public void setModel(ModelAuto model) {
        this.model = model;
    }



    public int getPeriodBegin() {
        return periodBegin;
    }

    public void setPeriodBegin(int periodBegin) {
        this.periodBegin = periodBegin;
    }

    public int getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(int periodEnd) {
        this.periodEnd = periodEnd;
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
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

}
