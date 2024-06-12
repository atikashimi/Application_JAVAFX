package application;

import java.sql.Date;
import java.sql.Timestamp;

public class Dataproduct {
    private String Plant;
    private String Area;
    private String Project;
    private String Family;
    private String Crew;
    private String TL;
    private String Sh_Leader;
    private String Coordinator;
    private Double Output;
    private Double T_ABS;
    private Double DT;
    private Double ABSENTEISM;
    private Double Prod_H;
    private Double Payed_H;
    private Double ME;
    private Double Efficiency;
    private Double T_Efficiency;
    private Double WSD;
    private Double T_WSD;
    private Double T_HC;
    private Double HC;
    private Double Oc_Rate;
    private Double Abs_No_Planned;
    private Double T_Abs_NoPlanned;
    private Timestamp  date;
    private Double T_DT;

public Dataproduct(String Plant, String Area, String Project, String Family, String Crew, String TL, String Sh_Leader, String Coordinator, Double Output, Double Efficiency, Double T_Efficiency, Double Prod_H, Double Payed_H, Double ABSENTEISM,  Double ME, Double T_ABS, Double DT,Double HC, Double T_HC, Double WSD, Double T_WSD, Double Oc_Rate, Double T_DT, Double Abs_No_Planned
, Double T_Abs_NoPlanned,Timestamp  date) {
        this.Plant = Plant;
        this.Area = Area;
        this.Project = Project;
        this.Family = Family;
        this.Crew = Crew;
        this.TL = TL;
        this.Sh_Leader = Sh_Leader;
        this.Coordinator = Coordinator;
        this.Output = Output;
        this.Efficiency = Efficiency;
        this.T_Efficiency = T_Efficiency;
        this.Prod_H = Prod_H;
        this.Payed_H = Payed_H;
        this.ABSENTEISM = ABSENTEISM;
        this.ME = ME;
        this.T_ABS = T_ABS;
        this.DT = DT;
        this.HC = HC;
        this.T_HC = T_HC;
        this.WSD = WSD;
        this.T_WSD = T_WSD;
        this.Oc_Rate = Oc_Rate;
        this.date = date;
        this.T_DT = T_DT;
        this.Abs_No_Planned = Abs_No_Planned;
        this.T_Abs_NoPlanned = T_Abs_NoPlanned;
    }
  
    // Getters avec la convention JavaBeans

    public String getPlant() {
        return Plant;
    }

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

    public Double getT_ABS() {
        return T_ABS;
    }

    public Double getDT() {
        return DT;
    }

    public Double getABSENTEISM() {
        return ABSENTEISM;
    }

    public Double getProd_H() {
        return Prod_H;
    }

    public Double getPayed_H() {
        return Payed_H;
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

    public Double getOc_Rate() {
        return Oc_Rate;
    }
    public Double getT_DT() {
    	return T_DT;
    }

    public Double getAbs_No_Planned() {
        return Abs_No_Planned;
    }
    public Double getT_Abs_NoPlanned() {
    	return T_Abs_NoPlanned;
    }

    public Timestamp  getDate() {
       return date;
    }
}
