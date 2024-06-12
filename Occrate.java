package application;

import java.sql.Date;
import java.sql.Timestamp;

public class Occrate {
   
    private String Area;
    private String Project;
    private String Family;
    private String Crew;
    private String TL;
    private String Sh_Leader;
    private String Coordinator;
    
    private Double Oc_Rate;
   
   private Timestamp  date;

    public Occrate( String Area, String Project, String Family, String Crew, String TL, String Sh_Leader, String Coordinator, Double Oc_Rate,Timestamp  date) {
        
        this.Area = Area;
        this.Project = Project;
        this.Family = Family;
        this.Crew = Crew;
        this.TL = TL;
        this.Sh_Leader = Sh_Leader;
        this.Coordinator = Coordinator;
       
       
        
        this.date = date;
        this.Oc_Rate = Oc_Rate;
    }
  
    // Getters avec la convention JavaBeans

  
    public String getArea() {
        return Area;
    }

    public String getProject() {
        return Project;
    }

    public String getFamily() {
        return Family;
    }

    public String getCrew() {
        return Crew;
    }

    public String getTL() {
        return TL;
    }

    public String getSh_Leader() {
        return Sh_Leader;
    }

    public String getCoordinator() {
        return Coordinator;
    }

    

  
    public Double getOc_Rate() {
        return Oc_Rate;
    }

   
    public Timestamp  getDate() {
       return date;
    }
}
