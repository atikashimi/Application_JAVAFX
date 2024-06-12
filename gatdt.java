package application;

import java.sql.Timestamp;

public class gatdt {
	private String DP;
    private String IMPACT;
    private Double DT;
    private Timestamp  date;
 
    
    public gatdt(String DP, String IMPACT, Double DT,  Timestamp date) {
        this.DP = DP;
        this.IMPACT = IMPACT;
        this.DT = DT;
        this.date = date;
        
}
    public String getDP() {
        return DP;
    }

    public String getIMPACT() {
        return IMPACT;
    }

    public Double getDT() {
        return DT;
    }

    public Timestamp getDate() {
        return date;
    }
    }
