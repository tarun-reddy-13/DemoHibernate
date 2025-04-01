package org.tarun.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity //@Entity(name="alien_table") --> creates Entity with given name
//@Table(name="alien_table") --> creates table with given name
public class Alien {

    //POJO

    @Id //marks attribute as primary key
    private int aid;

    //@Transient --> not stored in db
    private AlienName aname;

    //@Column(name="alien_color") --> names the column with given name
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public AlienName getAname() {
        return aname;
    }

    public void setAname(AlienName aname) {
        this.aname = aname;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    @Override
    public String toString(){
        return "Alien [ aid = "+aid+", aname = "+aname+", color = "+color+" ]";
    }
}
