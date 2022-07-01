
package SberHW.entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Search {

    private List<Mark> markList = new ArrayList<>();


    public List<Mark> getMarkList() {
        return markList;
    }

    public void setMarkList(List<Mark> markList) {
        this.markList = markList;
    }
}

