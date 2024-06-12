package application;

import java.sql.Date;
import java.sql.Timestamp;

public class Effproduct {
   
    private String Area;
    private String Project;
    private String Family;
    private String Crew;
    private String TL;
    private String Sh_Leader;
    private String Coordinator;
    private Double Output;
   
    private Double ME;
    private Double Efficiency;
    private Double T_Efficiency;
    private Double WSD;
    private Double T_WSD;
    private Double T_HC;
    private Double HC;
   
   private Timestamp  date;

    public Effproduct( String Area, String Project, String Family, String Crew, String TL, String Sh_Leader, String Coordinator, Double Output,   Double ME, Double T_Efficiency, Double Efficiency,Double T_HC, Double HC, Double T_WSD, Double WSD, Timestamp  date) {
        
        this.Area = Area;
        this.Project = Project;
        this.Family = Family;
        this.Crew = Crew;
        this.TL = TL;
        this.Sh_Leader = Sh_Leader;
        this.Coordinator = Coordinator;
       
        this.ME = ME;
        this.T_Efficiency = T_Efficiency;
        this.T_HC = T_HC;
        this.HC = HC;
        this.WSD = WSD;
        this.T_WSD = T_WSD;
        this.Efficiency = Efficiency;
        this.Output = Output;
      
        this.date = date;
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

    public Double getOutput() {
        return Output;
    }

   

    
    public Double getME() {
        return ME;
    }
    public Double getT_Efficiency() {
        return T_Efficiency;
    }

    public Double getEfficiency() {
        return Efficiency;
    }

    public Double getT_HC() {
        return T_HC;
    }

    public Double getHC() {
        return HC;
    }

    public Double getWSD() {
        return WSD;
    }

    public Double getT_WSD() {
        return T_WSD;
    }

   
    public Timestamp  getDate() {
        return date;
    }
}
