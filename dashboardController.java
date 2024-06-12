package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.scene.chart.XYChart;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.collections.ObservableList;
import javafx.util.Callback;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.util.Callback;
import javafx.beans.property.*;
import javafx.beans.binding.*;
import javafx.beans.value.*;
import javafx.scene.chart.XYChart.*;
import javafx.scene.chart.XYChart.Data.*;
import javafx.scene.input.ScrollEvent;
import javafx.scene.transform.Scale;

public  class dashboardController  implements Initializable{
	    @FXML
	    private TableColumn<Effproduct, String> data_wsd1;

	    @FXML
	    private TableColumn<Effproduct, String> data_twsd1;
	    
	    @FXML
	    private TableColumn<Effproduct, String> data_tl1;

	    @FXML
	    private TableColumn<Effproduct, String> data_thc1;
	    
	    @FXML
	    private TableColumn<Effproduct, String> data_tefficiency1;

	    @FXML
	    private TableColumn<Effproduct, String> data_shleader1;
	    
	    @FXML
	    private TableColumn<Effproduct, String> data_project1;

	    @FXML
	    private TableColumn<Effproduct, String> data_output1;
	    
	    @FXML
	    private TableColumn<Effproduct, String> data_me1;
	    
	    @FXML
	    private AnchorPane zeff;

	    @FXML
	    private TableColumn<Effproduct, String> data_hc1;
	    
	    @FXML
	    private TableColumn<Effproduct, String> data_family1;

	    @FXML
	    private TableColumn<Effproduct, String> data_efficiency1;

	    @FXML
	    private TableColumn<Effproduct, String> data_crew1;

	    @FXML
	    private TableColumn<Effproduct, String> data_coordinator1;
	    
	    @FXML
	    private TableColumn<Effproduct, String> eff_date;

	    @FXML
	    private TableColumn<Effproduct, String> data_area1;
	    
	    @FXML
	    private AnchorPane zabs;

	    @FXML
	    private AnchorPane zabsno;

	    @FXML
	    private AnchorPane zdt;

	    @FXML
	    private AnchorPane zhc;

	    @FXML
	    private AnchorPane zooccrate;
	    
	    @FXML
	    private LineChart<String, Number> zoomabs;

	    @FXML
	    private LineChart<String, Number> zoomabsno;

	    @FXML
	    private LineChart<String, Number> zoomdt;

	    @FXML
	    private BarChart<String, Number> zoomhc;

	    @FXML
	    private BarChart<String, Number> zoomoccrate;

	    @FXML
	    private LineChart<String, Number> zoomoutput;

	    @FXML
	    private LineChart<String, Number> zoomtabs;

	    @FXML
	    private LineChart<String, Number> zoomwsd;
	    
	    @FXML
	    private Button buttonzo_eff121;
	    
	    @FXML
	    private AnchorPane zooutput;

	    @FXML
	    private AnchorPane ztabs;

	    @FXML
	    private AnchorPane zwsd;

        @FXML
        private TextField area;

        @FXML
        private TextField crew;

        @FXML
        private TextField family;

        @FXML
        private TextField plant;

        @FXML
        private TextField project;

        @FXML
        private TextField absenteism;

        @FXML
        private TextField absnop;

        @FXML
        private TextField tabsnopla;
        
        @FXML
        private TableColumn<Dataproduct, String> data_efficiency;
   
        @FXML
        private TableColumn<Dataproduct, String> data_hc;

        @FXML
        private TableColumn<Dataproduct, String> data_me;
        
        @FXML
        private TableColumn<Dataproduct, String> data_tdt;

        @FXML
        private TableColumn<Dataproduct, String> data_occrate;
        
        @FXML
        private TableColumn<Dataproduct, String> data_tefficiency;

        @FXML
        private TableColumn<Dataproduct, String> data_thc;
    
        @FXML
        private TableColumn<Dataproduct, String> data_twsd;
        
        @FXML
        private TableColumn<Dataproduct, String> data_wsd;
  
        @FXML
        private TableColumn<Dataproduct, String> data_absno;
        
        @FXML
        private TableColumn<Dataproduct, String> data_tabsno;
        
        @FXML
        private Button button_occ;
        
        @FXML
        private Button buttonzo_eff;
        
        @FXML
        private LineChart<String, Number> zoom_eff;
        
        @FXML
        private RadioButton button_tst;

        @FXML
        private Button close;

        @FXML
        private TextField coordinator;

        @FXML
        private BarChart<?, ?> d_abs;

        @FXML
        private LineChart<?, ?> d_abs_follo;

        @FXML
        private StackedBarChart<?, ?> d_area;

        @FXML
        private BarChart<?, ?> d_avg;

        @FXML
        private LineChart<?, ?> d_dt_follo;

        @FXML
        private BarChart<?, ?> d_eff;

        @FXML
        private LineChart<String, Number> d_eff_follo;

        @FXML
        private BarChart<?, ?> d_fa_wee;

        @FXML
        private BarChart<?, ?> d_hc_follo; 
        
        @FXML
        private BarChart<?, ?> d_occ_rate_follo;

        @FXML
        private LineChart<?, ?> d_total_abs_follo;

        @FXML
        private LineChart<?, ?> d_total_abs_non_planned;

        @FXML
        private LineChart<?, ?> d_total_output;

        @FXML
        private BarChart<?, ?> d_wee_abs;

        @FXML
        private BarChart<?, ?> d_wee_avrg;

        @FXML
        private LineChart<?, ?> d_wsd_follo;

        @FXML
        private StackedBarChart<?, ?> daily_dt;

        @FXML
        private AnchorPane daily_form;

        @FXML
        private Button daily_kpis;

        @FXML
        private Button data;

        @FXML
        private TableColumn<Dataproduct, String> data_absenteism;

        @FXML
        private Button data_add;

        @FXML
        private TableColumn<Dataproduct, String> data_area;
 
        @FXML
        private TableColumn<Dataproduct, String> data_coordinator;

        @FXML
        private TableColumn<Dataproduct, String> data_crew;

        @FXML
        private Button data_delete;

        @FXML
        private TableColumn<Dataproduct, String> data_dt;

        @FXML
        private TableColumn<Dataproduct, String> data_family;

        @FXML
        private AnchorPane data_form;

        @FXML
        private TableColumn<Dataproduct, String> data_output;

        @FXML
        private TableColumn<Dataproduct, String> data_payed;

        @FXML
        private TableColumn<Dataproduct, String> data_plant;

        @FXML
        private TableColumn<Dataproduct, String> data_prod;

        @FXML
        private TableColumn<Dataproduct, String> data_project;

        @FXML
        private Button data_reset;

        @FXML
        private TextField data_search;

        @FXML
        private TableColumn<Dataproduct, String> data_shleader;

        @FXML
        private TableColumn<Dataproduct, String> data_tl;

        @FXML
        private Button data_update;

        @FXML
        private TableColumn<Dataproduct, String> data_uptime;
        
        @FXML
        private TableColumn<Dataproduct, String> data_date;

        @FXML
        private BarChart<?, ?> deu_fa_dt;

        @FXML
        private RadioButton deux_p;

        @FXML
        private RadioButton deux_trois;

        @FXML
        private Button downtime;

        @FXML
        private TextField dt;

        @FXML
        private Button dt_add;

       @FXML
       private Button dt_delete;

       @FXML
       private TextField dt_dp;

       @FXML
       private TextField dt_dt;
       
       @FXML
       private TextField tdt;

       @FXML
       private AnchorPane dt_form;

       @FXML
       private ComboBox<?> dt_impact;

       @FXML
       private Button dt_reset;

       @FXML
       private TextField dt_search;
       
       @FXML
       private TextField data_search1;

       @FXML
       private TableView<gatdt> dt_table;

       @FXML
       private Label dt_target;

       @FXML
       private Button dt_update;

       @FXML
       private Label eff_dt;

      @FXML
      private Label eff_eff;

      @FXML
      private AnchorPane eff_form;

      @FXML
      private Label eff_hc;

      @FXML
      private Label eff_output;

      @FXML
      private TextField eff_search;

      @FXML
      private Label eff_target;

      @FXML
      private TableView<Effproduct> eff_tb;

      @FXML
      private Label eff_wsd;

      @FXML
      private Button efficiency;

      @FXML
      private Label hc_target;

      @FXML
      private Button logout;

      @FXML
      private StackedBarChart<?, ?> m_area;

      @FXML
      private BarChart<?, ?> m_eff;

      @FXML
      private AnchorPane man_orm;

     @FXML
     private Button minimize;

     @FXML
     private StackedBarChart<?, ?> monthly_dt;

     @FXML
     private Button monthly_kpis;

     @FXML
     private AnchorPane monthly_premier;

     @FXML
     private Button occ_add;

    @FXML
    private TableColumn<Occrate, String> occ_area;

    @FXML
    private TableColumn<Occrate, String> occ_coo;

    @FXML
    private TableColumn<Occrate, String> occ_crew;
    @FXML
    private TableColumn<Occrate, String> occ_date;


    @FXML
    private Button occ_delete;

    @FXML
    private TableColumn<Occrate, String> occ_family;

    @FXML
    private AnchorPane occ_form;

    @FXML
    private TableColumn<Occrate, String> occ_projet;

    @FXML
    private TableColumn<Occrate, String> occ_rate;

    @FXML
    private Button occ_reset;

    @FXML
    private TextField occ_search;

    @FXML
    private TableColumn<Occrate, String> occ_sh;

    @FXML
    private TableColumn<Occrate, String> occ_tl;

    @FXML
    private Button occ_update;

    @FXML
    private TextField output;

    @FXML
    private Label output_target;

    @FXML
    private RadioButton permier_trois;

    @FXML
    private TextField shleader;

    @FXML
    private TableView<Dataproduct> tb_add_data;

    @FXML
    private TableColumn<gatdt, String> tb_dp;

    @FXML
    private TableColumn<gatdt, String> tb_dt;

    @FXML
    private TableColumn<gatdt, String> tb_impact;
    @FXML
    private TableColumn<gatdt, String> tb_date;

    @FXML
    private TableView<Occrate> tb_occ;

    @FXML
    private AnchorPane test_button;

    @FXML
    private TextField tl;

    @FXML
    private RadioButton troix_deux;

    @FXML
    private AnchorPane troix_monthly;

    @FXML
    private RadioButton troix_p;

    @FXML
    private TextField up_time;

    @FXML
    private Label wsd_target;
   
    @FXML
    private Button data_clean;
    @FXML
    private Button print;

    @FXML
    private TextField hc;

    @FXML
    private TextField me;

    @FXML
    private TextField occrate;
    
    @FXML
    private TextField payed;
    
    @FXML
    private TextField prod;

    @FXML
    private TextField tefficiency;
    
    @FXML
    private TextField efficiencyy;

    @FXML
    private TextField thc;
    
    @FXML
    private TextField twsd;

    @FXML
    private TextField uptime;

    @FXML
    private TextField wsd;
    
    @FXML
    private AnchorPane saisie_form;
    
    @FXML
    private ImageView iconeImageView;

  @FXML
  private Label gapLabel;
  @FXML
  private ImageView iconeImageView1;

  @FXML
  private Label gapLabel1;
  @FXML
  private ImageView iconeImageView2;

  @FXML
  private Label gapLabel2;
  @FXML
  private ImageView iconeImageView3;

  @FXML
  private Label gapLabel3;
  @FXML
  private ImageView iconeImageView4;

  @FXML
  private Label gapLabel4;
  @FXML
  private Button plus;
  @FXML
  private BarChart<?, ?> m_m_eff;
  
  @FXML
  private LineChart<?, ?> m_m_out;
  @FXML
  private LineChart<?, ?> d_d_occ;
  @FXML
  private LineChart<?, ?> d_d_ocdaily;
  @FXML
  private LineChart<?, ?>  m_weeout;
  @FXML
  private BarChart<?, ?> m_weeeff;
  @FXML
  private BarChart<?, ?> m_weeocc;
  @FXML
  private BarChart<?, ?> m_avgnopalnned;
  @FXML
  private BarChart<?, ?> wee_avgnoplanned;
  @FXML
  private BarChart<?, ?> m_oc;
 
  private Statement statement;
  private ResultSet result, result2, result3;
   Connection connection = null;
	    PreparedStatement statement_tb_data = null;
	    PreparedStatement statement_eff_tb = null;
	    PreparedStatement statement_occrate = null;
	    PreparedStatement statement_dt = null;
	    public void dtadd() {
	        String sql = "INSERT INTO tb_dt (DP, DT, IMPACT, date) VALUES (?, ?, ?, NOW())";
	        connection = Database.connectDb();
	        try {
	            // Pas besoin de vérifier chaque champ individuellement ici

	            // Préparer la déclaration SQL
	            statement_dt = connection.prepareStatement(sql);

	            // Remplacer les champs vides par des valeurs par défaut ou nulles
	            String dpValue = dt_dp.getText().isEmpty() ? null : dt_dp.getText();
	            String dtValue = dt_dt.getText().isEmpty() ? null : dt_dt.getText();
	            String impactValue = dt_impact.getSelectionModel().getSelectedItem() == null ?
	                    null : (String) dt_impact.getSelectionModel().getSelectedItem();

	            // Paramètres pour la déclaration préparée
	            statement_dt.setString(1, dpValue);
	            statement_dt.setString(2, dtValue);
	            statement_dt.setString(3, impactValue);

	            // Exécuter la mise à jour
	            statement_dt.executeUpdate();

	            // Afficher la liste mise à jour
	            adddtShowList();

	            // Réinitialiser les champs
	            dtreset();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public void dtUpdate() {
	    	  String sql = "UPDATE `tb_dt` SET  DT= '"+dt_dt.getText()
				+"', IMPACT= '"+dt_impact.getSelectionModel().getSelectedItem()
				+ "', date= CURRENT_TIMESTAMP WHERE DP= '"+dt_dp.getText()+"'";
		    
		   try {
		    		connection = Database.connectDb();
		    		if (dt_dp.getText().isEmpty() 
			            		|| dt_dt.getText().isEmpty() 
			            		||dt_impact.getSelectionModel().getSelectedItem() == null) {
			                Alert alert = new Alert(AlertType.ERROR);
			                alert.setTitle("Erreur");
			                alert.setHeaderText(null);
			                alert.setContentText("Please Fill All Blank Fields");
			                alert.showAndWait();
			            } else {
			            	   Alert alert = new Alert(AlertType.CONFIRMATION);
				                alert.setTitle("Confirmation Message");
				                alert.setHeaderText(null);
				                alert.setContentText("Are You Sure You Want To UPDATE DP : "+dt_dp.getText() +"?");
				              Optional<ButtonType> option = alert.showAndWait();
				              
				              if(option.get().equals(ButtonType.OK)) {
				            	  statement = connection.createStatement();
				            	  statement.executeUpdate(sql);
				            	  
						                alert = new Alert(AlertType.INFORMATION);
						                alert.setTitle("Information Message");
						                alert.setHeaderText(null);
						                alert.setContentText("Operation Completed Successfully");
						                alert.showAndWait();
						                adddtShowList();
						                addProductsReset();
				              }
			            	
			            }
		    		
		    		 
		    		
		    	}catch(Exception e) {e.printStackTrace();}
		    }
		    public void dtDelete() {
		    	//effList();
		    	String sql="DELETE FROM  tb_dt WHERE DP= '"+dt_dp.getText()+"'";
		    	 
		    	try {
		    		connection = Database.connectDb();
		    		
		    		 if (dt_dp.getText().isEmpty()
			    				|| dt_dt.getText().isEmpty()
			    				||dt_impact.getSelectionModel().getSelectedItem()==null) {
			                Alert alert = new Alert(AlertType.ERROR);
			                alert.setTitle("Erreur");
			                alert.setHeaderText(null);
			                alert.setContentText("Please Fill All Blank Fields");
			                alert.showAndWait();
			            } else {
			            	   Alert alert = new Alert(AlertType.CONFIRMATION);
				                alert.setTitle("Confirmation Message");
				                alert.setHeaderText(null);
				                alert.setContentText("Are You Sure You Want To Delete DP : "+dt_dp.getText() +"?");
				              Optional<ButtonType> option = alert.showAndWait();
				              
				              if(option.get().equals(ButtonType.OK)) {
				            	  statement = connection.createStatement();
				            	  statement.executeUpdate(sql);
				            	  
						                alert = new Alert(AlertType.INFORMATION);
						                alert.setTitle("Information Message");
						                alert.setHeaderText(null);
						                alert.setContentText("Successfully Deleted");
						                alert.showAndWait();
						                adddtShowList();
						                dtselected();
						                dtreset();
				              }}
			            	
			            
		    		
		    	}catch(Exception e) {e.printStackTrace();}
		    }

	    public void dtreset() {
	    	dt_dp.setText("");
	    	 dt_dt.setText("");
	    	 dt_impact.getSelectionModel().clearSelection();
	    }
	    
	    private String[] Listimpact = {"WL","RM", "Cutt", "Plan", "Prcss", "Ing.CH", "DL Cutt", "ABS", "US", "Incident Qualité", "DL MPC", "IT","ROB","M.Autre", "ME.Autre", "MPC Autre", "Wire's Quality","LS", "Printing", "Tab", "Unknown DT", "VM & Tork"};
	    public void dtListImpact() {
	    	List<String> listimpact = new ArrayList();
	    	for (String data: Listimpact) {
	    		listimpact.add(data);
	    	}
	    	ObservableList listData = FXCollections.observableArrayList(listimpact);
	    	dt_impact.setItems(listData);
	    }
	    
	    public ObservableList<gatdt> addDtData(){
	    	ObservableList <gatdt> DtList = FXCollections.observableArrayList();
	    	String sql = "SELECT * FROM tb_dt";
	    	connection = Database.connectDb();
	    	try {
	    		statement_dt=connection.prepareStatement(sql);
	    		result = statement_dt.executeQuery();
	    		gatdt dtid;
	    		while(result.next()) {
	    			dtid = new gatdt(result.getString("DP")
	    					,result.getString("IMPACT")
	    					,result.getDouble("DT")
	    					,result.getTimestamp("date")
	    					);
	    			DtList.add(dtid);
	    		}
	    		
	    	}catch(Exception e) {e.printStackTrace();}
	    		return DtList;	
	    }
	    private void sortByDateDescending3(ObservableList<gatdt> list) {
	        list.sort(Comparator.comparing(gatdt::getDate).reversed());
	    }
	    private ObservableList<gatdt> adddtList;
	    public void adddtShowList() {
	        adddtList = addDtData();
	        sortByDateDescending3(adddtList);
	        tb_dp.setCellValueFactory(new PropertyValueFactory<>("DP"));
	        tb_dt.setCellValueFactory(new PropertyValueFactory<>("DT"));
	        tb_impact.setCellValueFactory(new PropertyValueFactory<>("IMPACT"));
	        tb_date.setCellValueFactory(new PropertyValueFactory<>("date")); // Assurez-vous que la propriété dans gatdt est "date" et non "getdate()"
	        
	        dt_table.setItems(adddtList);
	    }
	    public void dtselected() {
	    	gatdt dtid = dt_table.getSelectionModel().getSelectedItem();
	    	int num = dt_table.getSelectionModel().getSelectedIndex();
	    	if((num - 1) < -1) {return;}
	    	dt_dp.setText(String.valueOf(dtid.getDP()));
	    	dt_dt.setText(String.valueOf(dtid.getDT()));
	    	
	    }
	    public void dtSearch() {
            FilteredList<gatdt> filter = new FilteredList<>(adddtList, e -> true);
            dt_search.textProperty().addListener((observable, oldValue, newValue)->{
    		filter.setPredicate(predicategatdt ->{
    			if(newValue == null || newValue.isEmpty()) { 
    				return true;
    			}
    			String searchkey =newValue.toLowerCase();
    			if(predicategatdt.getDP().toLowerCase
    					().contains(searchkey)) {
    				return true;
    			}else if (predicategatdt.getIMPACT().toLowerCase().contains(searchkey)){
    				return true;
    				
    			}else if (predicategatdt.getDate().toString().toLowerCase().contains(searchkey)) {
                    return true; // Ajoutez cette condition pour rechercher par date
                }
    			return false;});
    	});
            SortedList<gatdt> sortListt = new SortedList<>(filter);
	    	sortListt.comparatorProperty().bind(dt_table.comparatorProperty());
	    	dt_table.setItems(sortListt);
	    	
	    }
	    public void mettreAJourGAP() {
	        double sommeEfficiency = gapEfficiency();
	        double sommeTarget = gapEfficiency1();
	        double sommeout = gapOutput();
	        double sommeTout = gapOutput2();
	        double sommehc = gapHc();
	        double sommeThc = gapHc2();
	        double sommewsd = gapWsd();
	        double sommeTwsd = gapWsd2();
	        double sommedt = gapDt();
	        
	        double GAP2 = sommehc - sommeThc;
	        double GAP3 = sommewsd- sommeTwsd;
	        double GAP = (sommeEfficiency - sommeTarget);

	        if (GAP >= 0) {
	            gapLabel.setTextFill(Color.web("#B0FC38"));
	            URL imageUrl = getClass().getResource("/application/up.png");
	            if (imageUrl != null) {
	                iconeImageView.setImage(new Image(imageUrl.toExternalForm()));
	            } else {
	                System.out.println("Image arrow_up.png not found!");
	            }
	        } else {
	            gapLabel.setTextFill(Color.web("#FF0800"));
	            URL imageUrl = getClass().getResource("/application/dow.png");
	            if (imageUrl != null) {
	                iconeImageView.setImage(new Image(imageUrl.toExternalForm()));
	            } else {
	                System.out.println("Image arrow_down.png not found!");
	            }
	        }
	        DecimalFormat df = new DecimalFormat("#.##");
   	     String formattedEfficiency = df.format(GAP);
	        gapLabel.setText(formattedEfficiency + "%");
	    }	
	    public void mettreAJourGAP1() {
	        double sommeout = gapOutput();
	        double sommeTout = gapOutput2();
	        double GAP1 = (sommeout- sommeTout);
	      if (GAP1 >= 0) {
	            gapLabel1.setTextFill(Color.web("#B0FC38"));
	            URL imageUrl1 = getClass().getResource("/application/up.png");
	            if (imageUrl1 != null) {
	                iconeImageView1.setImage(new Image(imageUrl1.toExternalForm()));
	            } else {
	                System.out.println("Image arrow_up.png not found!");
	            }
	        } else {
	            gapLabel1.setTextFill(Color.web("#FF0800"));
	            URL imageUrl1 = getClass().getResource("/application/dow.png");
	            if (imageUrl1 != null) {
	                iconeImageView1.setImage(new Image(imageUrl1.toExternalForm()));
	            } else {
	                System.out.println("Image arrow_down.png not found!");
	            }
	        }
	        DecimalFormat df = new DecimalFormat("#.##");
   	     String formattedEfficiency = df.format(GAP1);
	        gapLabel1.setText(formattedEfficiency + "%");
	    }
	    public void mettreAJourGAP2() {
	      double sommehc = gapHc();
	        double sommeThc = gapHc2();
	      double GAP2 = (sommehc - sommeThc);
	       if (GAP2 >= 0) {
	    	   gapLabel2.setTextFill(Color.web("#B0FC38"));
	            URL imageUrl2 = getClass().getResource("/application/up.png");
	            if (imageUrl2 != null) {
	                iconeImageView2.setImage(new Image(imageUrl2.toExternalForm()));
	            } else {
	                System.out.println("Image arrow_up.png not found!");
	            }
	        } else {
	            gapLabel2.setTextFill(Color.web("#FF0800"));
	            URL imageUrl2 = getClass().getResource("/application/dow.png");
	            if (imageUrl2 != null) {
	                iconeImageView2.setImage(new Image(imageUrl2.toExternalForm()));
	            } else {
	                System.out.println("Image arrow_down.png not found!");
	            }
	        }
	        DecimalFormat df = new DecimalFormat("#.##");
   	     String formattedEfficiency = df.format(GAP2);
	        gapLabel2.setText(formattedEfficiency + "%");
	    }	
	    public void mettreAJourGAP3() {
	     double sommewsd = gapWsd();
	        double sommeTwsd = gapWsd2();
	       double GAP3 = (sommewsd- sommeTwsd);
	       if (GAP3 >= 0) {
	            gapLabel3.setTextFill(Color.web("#B0FC38"));
	            URL imageUrl3 = getClass().getResource("/application/up.png");
	            if (imageUrl3 != null) {
	                iconeImageView3.setImage(new Image(imageUrl3.toExternalForm()));
	            } else {
	                System.out.println("Image arrow_up.png not found!");
	            }
	        } else {
	        	gapLabel3.setTextFill(Color.web("#FF0800"));
	            URL imageUrl3 = getClass().getResource("/application/dow.png");
	            if (imageUrl3 != null) {
	                iconeImageView3.setImage(new Image(imageUrl3.toExternalForm()));
	            } else {
	                System.out.println("Image arrow_down.png not found!");
	            }
	        }
	        DecimalFormat df = new DecimalFormat("#.##");
   	     String formattedEfficiency = df.format(GAP3);
	        gapLabel3.setText(formattedEfficiency + "%");
	    }	
	    public void mettreAJourGAP4() {
		     double sommedt = gapDt();
		        double sommeTdt = gapDt2();
		       double GAP4 = (sommedt- sommeTdt);
		       if (GAP4 >= 0) {
		            gapLabel4.setTextFill(Color.web("#B0FC38"));
		            URL imageUrl4 = getClass().getResource("/application/up.png");
		            if (imageUrl4 != null) {
		                iconeImageView4.setImage(new Image(imageUrl4.toExternalForm()));
		            } else {
		                System.out.println("Image arrow_up.png not found!");
		            }
		        } else {
		        	gapLabel4.setTextFill(Color.web("#FF0800"));
		            URL imageUrl4 = getClass().getResource("/application/dow.png");
		            if (imageUrl4 != null) {
		                iconeImageView4.setImage(new Image(imageUrl4.toExternalForm()));
		            } else {
		                System.out.println("Image arrow_down.png not found!");
		            }
		        }
		        DecimalFormat df = new DecimalFormat("#.##");
	   	     String formattedEfficiency = df.format(GAP4);
		        gapLabel4.setText(formattedEfficiency + "%");
		    }
	    
	    public  double gapEfficiency() {
	    	String sql_tb_data = "SELECT SUM(Efficiency) FROM tb_data  ";
	    	connection = Database.connectDb();
	    	double countEff= 0;
	    	try {
	    		statement_tb_data = connection.prepareStatement(sql_tb_data);
	    		result = statement_tb_data.executeQuery();
	    		while(result.next()) {
	    			countEff = result.getDouble("SUM(Efficiency)");
	    		}
	    		  double percentageEfficiency = countEff ;
	    		 DecimalFormat df = new DecimalFormat("#.##");
	    	     String formattedEfficiency = df.format(percentageEfficiency);
	    	     eff_eff.setText(formattedEfficiency + "%");
	    		
	    	}catch(Exception e) {e.printStackTrace();}
	    	return countEff;
	    	
	    }
	    public double gapEfficiency1() {
	    	String sql_tb_data = "SELECT SUM(T_Efficiency) FROM tb_data";
	    	connection = Database.connectDb();
	    	double counttEff= 0;
	    	try {
	    		statement_tb_data = connection.prepareStatement(sql_tb_data);
	    		result = statement_tb_data.executeQuery();
	    		while(result.next()) {
	    			counttEff = result.getDouble("SUM(T_Efficiency)");
	    		}
	    		  double percentageEfficiency = counttEff ;
	    		 DecimalFormat df = new DecimalFormat("#.##");
	    	     String formattedEfficiency = df.format(percentageEfficiency);
	    		eff_target.setText(formattedEfficiency + "%");
	    		
	    	}catch(Exception e) {e.printStackTrace();}
	    	return counttEff;
	    }
	    public double gapOutput() {
	    	String sql_tb_data = "SELECT SUM(Output) FROM tb_data";
	    	connection = Database.connectDb();
	    	double countOutput= 0;
	    	try {
	    		statement_tb_data = connection.prepareStatement(sql_tb_data);
	    		result = statement_tb_data.executeQuery();
	    		while(result.next()) {
	    			countOutput = result.getDouble("SUM(Output)");
	    		}
	    		double percentageEfficiency = countOutput ;
	    		 DecimalFormat df = new DecimalFormat("#.##");
	    	     String formattedEfficiency = df.format(percentageEfficiency);
	    		eff_output.setText(formattedEfficiency + "%");
	    		
	    	}catch(Exception e) {e.printStackTrace();}
	    	return countOutput;
	    }
	    public double gapOutput2() {
	    	String sql_tb_data = "SELECT SUM(ME) FROM tb_data";
	    	connection = Database.connectDb();
	    	double countMe= 0;
	    	try {
	    		statement_tb_data = connection.prepareStatement(sql_tb_data);
	    		result = statement_tb_data.executeQuery();
	    		while(result.next()) {
	    			countMe = result.getDouble("SUM(ME)");
	    		}
	    		double percentageEfficiency = countMe ;
	    		 DecimalFormat df = new DecimalFormat("#.##");
	    	     String formattedEfficiency = df.format(percentageEfficiency);
	    		output_target.setText(formattedEfficiency + "%");
	    		
	    	}catch(Exception e) {e.printStackTrace();}
	    	return countMe;
	    }
	    public double gapHc() {
	    	String sql_tb_data = "SELECT SUM(HC) FROM tb_data";
	    	connection = Database.connectDb();
	    	double counthc= 0;
	    	try {
	    		statement_tb_data = connection.prepareStatement(sql_tb_data);
	    		result = statement_tb_data.executeQuery();
	    		while(result.next()) {
	    			counthc = result.getDouble("SUM(HC)");
	    		}
	    		double percentageEfficiency = counthc ;
	    		DecimalFormat df = new DecimalFormat("#.##");
	    	     String formattedEfficiency = df.format(percentageEfficiency );
	    		eff_hc.setText(formattedEfficiency + "%");
	    		
	    	}catch(Exception e) {e.printStackTrace();}
	    	return counthc;
	    }
	    public double gapHc2() {
	    	String sql_tb_data = "SELECT SUM(T_HC) FROM tb_data";
	    	connection = Database.connectDb();
	    	double countthc= 0;
	    	try {
	    		statement_tb_data = connection.prepareStatement(sql_tb_data);
	    		result = statement_tb_data.executeQuery();
	    		while(result.next()) {
	    			countthc = result.getDouble("SUM(T_HC)");
	    		}
	    		double percentageEfficiency = countthc ;
	    		DecimalFormat df = new DecimalFormat("#.##");
	    	     String formattedEfficiency = df.format(percentageEfficiency );
	    		hc_target.setText(formattedEfficiency + "%");
	    		
	    	}catch(Exception e) {e.printStackTrace();}
	    	return countthc;
	    }
	    public double gapWsd() {
	    	String sql_tb_data = "SELECT SUM(WSD) FROM tb_data";
	    	connection = Database.connectDb();
	    	double countwsd= 0;
	    	try {
	    		statement_tb_data = connection.prepareStatement(sql_tb_data);
	    		result = statement_tb_data.executeQuery();
	    		while(result.next()) {
	    			countwsd = result.getDouble("SUM(WSD)");
	    		}
	    		double percentageEfficiency = countwsd ;
	    		DecimalFormat df = new DecimalFormat("#.##");
	    	     String formattedEfficiency = df.format(percentageEfficiency );
	    		eff_wsd.setText(formattedEfficiency + "%");
	    		
	    	}catch(Exception e) {e.printStackTrace();}
	    	return countwsd;
	    }
	    public double gapWsd2() {
	    	String sql_tb_data = "SELECT SUM(T_WSD) FROM tb_data";
	    	connection = Database.connectDb();
	    	double counttwsd= 0;
	    	try {
	    		statement_tb_data = connection.prepareStatement(sql_tb_data);
	    		result = statement_tb_data.executeQuery();
	    		while(result.next()) {
	    			counttwsd = result.getDouble("SUM(T_WSD)");
	    		}
	    		double percentageEfficiency = counttwsd ;
	    		DecimalFormat df = new DecimalFormat("#.##");
	    	     String formattedEfficiency = df.format(percentageEfficiency );
	    		wsd_target.setText(formattedEfficiency + "%");
	    		
	    	}catch(Exception e) {e.printStackTrace();}
	    	return counttwsd;
	    }
	    public double gapDt() {
	    	String sql_tb_data = "SELECT SUM(DT) FROM tb_data";
	    	connection = Database.connectDb();
	    	double countdt= 0;
	    	try {
	    		statement_tb_data = connection.prepareStatement(sql_tb_data);
	    		result = statement_tb_data.executeQuery();
	    		while(result.next()) {
	    			countdt = result.getDouble("SUM(DT)");
	    		}
	    		double percentageEfficiency = countdt ;
	    		DecimalFormat df = new DecimalFormat("#.##");
	    	     String formattedEfficiency = df.format(percentageEfficiency );
	    		eff_dt.setText(formattedEfficiency + "%");
	    		
	    	}catch(Exception e) {e.printStackTrace();}
	    	return countdt;
	    }
	    public double gapDt2() {
	    	String sql_tb_data = "SELECT SUM(T_DT) FROM tb_data";
	    	connection = Database.connectDb();
	    	double counttdt= 0;
	    	try {
	    		statement_tb_data = connection.prepareStatement(sql_tb_data);
	    		result = statement_tb_data.executeQuery();
	    		while(result.next()) {
	    			counttdt = result.getDouble("SUM(T_DT)");
	    		}
	    		double percentageEfficiency = counttdt ;
	    		DecimalFormat df = new DecimalFormat("#.##");
	    	     String formattedEfficiency = df.format(percentageEfficiency );
	    	     dt_target.setText(formattedEfficiency + "%");
	    		
	    	}catch(Exception e) {e.printStackTrace();}
	    	return counttdt;
	    }
	    public void calculateAndSetEfficiency() {
	        try {
	            String outputText = output.getText();
	            String wsdText = wsd.getText();
	            String hcText = hc.getText();
	            
	            // Vérifier si les champs de texte sont vides
	            if(outputText.isEmpty() || wsdText.isEmpty() || hcText.isEmpty()) {
	                efficiencyy.setText(""); // Si l'un des champs est vide, effacer le champ d'efficacité
	                return; // Sortir de la méthode
	            }
	            
	            double outputValue = Double.parseDouble(outputText);
	            double wsdValue = Double.parseDouble(wsdText);
	            double hcValue = Double.parseDouble(hcText);
	            
	            // Calcul de l'efficacité
	            double dataEfficiency = ((outputValue * wsdValue) / (hcValue * 460)) * 100;

	            // Affichage de l'efficacité calculée dans le champ de texte
	            efficiencyy.setText(String.valueOf(dataEfficiency));
	        } catch (NumberFormatException e) {
	            // Gérer les exceptions si les valeurs ne peuvent pas être converties en double
	            e.printStackTrace();
	            efficiencyy.setText(""); // Effacer le champ si une exception se produit
	        }
	    }

	    public void calculateAndSetOccrate() {
	        try {
	            String outputText = output.getText();
	            String meText = me.getText();
	            
	            // Vérifier si les champs de texte sont vides
	            if(outputText.isEmpty() || meText.isEmpty()) {
	                occrate.setText(""); // Si l'un des champs est vide, effacer le champ de taux d'occupation
	                return; // Sortir de la méthode
	            }
	            
	            double outputValue = Double.parseDouble(outputText);
	            double meValue = Double.parseDouble(meText);
	            
	            // Calcul du taux d'occupation
	            double dataOccrate = (outputValue / meValue) * 100;

	            // Affichage du taux d'occupation calculé dans le champ de texte
	            occrate.setText(String.valueOf(dataOccrate));
	        } catch (NumberFormatException e) {
	            // Gérer les exceptions si les valeurs ne peuvent pas être converties en double
	            e.printStackTrace();
	            occrate.setText(""); // Effacer le champ si une exception se produit
	        }
	    }

	    public void Monthlyeff() {
	        d_eff.getData().clear();
	        
	        // Modifier la requête SQL pour sélectionner les six dernières lignes de données
	        String sql_tb_data = "SELECT DATE(date), SUM(Efficiency), SUM(T_Efficiency) " +
	                             "FROM (SELECT * FROM `tb_data` ORDER BY date DESC LIMIT 7) AS recent_data " +
	                             "GROUP BY DATE(date) " +
	                             "ORDER BY DATE(date) ASC";

	        connection = Database.connectDb();
	        try {
	            XYChart.Series chart = new XYChart.Series();
	            XYChart.Series chart1 = new XYChart.Series();
	            statement_tb_data = connection.prepareStatement(sql_tb_data);
	            result = statement_tb_data.executeQuery();

	            while (result.next()) {
	                String formattedDate = result.getString(1);
	                chart.getData().add(new XYChart.Data(formattedDate, result.getDouble(2)));
	                chart1.getData().add(new XYChart.Data(formattedDate, result.getDouble(3)));
	            }

	            d_eff.getData().addAll(chart, chart1);
	            for (Node bar : d_eff.lookupAll(".series0")) {
	                bar.setStyle("-fx-bar-fill: #1E90FF;"); // Couleur pour la première série (Efficiency)
	            }

	            for (Node bar : d_eff.lookupAll(".series1")) {
	                bar.setStyle("-fx-bar-fill: #FF0000;"); // Couleur pour la deuxième série (AnotherColumn)
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }


	    public void daileff() {
	        m_eff.getData().clear();
	        
	        // Construire la requête SQL pour sélectionner les données des 7 derniers mois
	        String sql_tb_data = "SELECT YEAR(date), MONTH(date), SUM(Efficiency), SUM(T_Efficiency) " +
	                             "FROM `tb_data` " +
	                             "WHERE DATE >= DATE_SUB(CURDATE(), INTERVAL 7 MONTH) " +
	                             "GROUP BY YEAR(date), MONTH(date) " +
	                             "ORDER BY YEAR(date) ASC, MONTH(date) ASC";

	        connection = Database.connectDb();
	        try {
	            XYChart.Series chart = new XYChart.Series();
	            XYChart.Series chart1 = new XYChart.Series();
	            statement_tb_data = connection.prepareStatement(sql_tb_data);
	            result = statement_tb_data.executeQuery();
	            while (result.next()) {
	                // Obtenir l'année et le mois à partir du résultat de la requête
	                int year = result.getInt(1);
	                int month = result.getInt(2);
	                
	                // Formater la date (mois et année)
	                String formattedDate = String.format("%02d", month) + "-" + year;
	                
	                // Ajouter les données à la série du graphique
	                chart.getData().add(new XYChart.Data(formattedDate, result.getDouble(3)));
	                chart1.getData().add(new XYChart.Data(formattedDate, result.getDouble(4)));
	            }
	            
	            // Ajouter la série de données au graphique
	            m_eff.getData().addAll(chart,chart1);
	            
	            // Appliquer les styles aux barres du graphique
	            for (Node bar : m_eff.lookupAll(".series0")) {
	                bar.setStyle("-fx-bar-fill: #1E90FF;"); // Couleur pour la série
	            }
	            for (Node bar : m_eff.lookupAll(".series1")) {
	                bar.setStyle("-fx-bar-fill: #FF0000;"); // Couleur pour la série
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public void monthyoccrate() {
	    	d_d_occ.getData().clear();
	        String sql_tb_data = " SELECT YEAR(date),  MONTH(date), SUM(Oc_Rate), SUM(ME) "
	        		                  + "  FROM `tb_data` "
	        		                   + "	WHERE DATE >= DATE_SUB(CURDATE(), INTERVAL 7 MONTH) "
	        		                  + "	GROUP BY YEAR(date), MONTH(date) "
	        		               + "	    ORDER BY YEAR(date) ASC, MONTH(date) ASC";

	        connection = Database.connectDb();
	        try {
	            XYChart.Series Series = new XYChart.Series<>();
	            XYChart.Series meSeries = new XYChart.Series<>();
	            statement_tb_data = connection.prepareStatement(sql_tb_data);
	            result = statement_tb_data.executeQuery();
	            while (result.next()) {
	            	int year = result.getInt(1);
	                int month = result.getInt(2);
	                
	                String formattedMonth  = String.format("%02d", month) + "-" + year;
	                Series.getData().add(new XYChart.Data<>(formattedMonth, result.getDouble(3)));
	                meSeries.getData().add(new XYChart.Data<>(formattedMonth, result.getDouble(4)));
	            }
	            d_d_occ.getData().addAll(Series, meSeries);
	            d_d_occ.setLegendVisible(false);
	            // Appliquer le style bleu à la série "Output"
	            applyNodeStyle(Series, "#1E90FF"); // Bleu pour la série chart
	            applyNodeStyle(meSeries, "#FF0000"); // Rouge pour la série chart1

	            applyLineStyle(d_d_occ, Series, "#1E90FF"); // Bleu pour la série chart
	            applyLineStyle(d_d_occ, meSeries, "#FF0000"); // Rouge pour la série chart1
	            hideDataPoints(d_d_occ);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public void dailyoccrate() {
	        d_d_ocdaily.getData().clear();
	        
	        // Modifier la requête SQL pour sélectionner les sept derniers jours de données
	        String sql_tb_data = "SELECT DATE(date), SUM(Oc_Rate), SUM(ME) " +
	                             "FROM (SELECT * FROM `tb_data` ORDER BY date DESC LIMIT 7) AS recent_data " +
	                             "GROUP BY DATE(date) " +
	                             "ORDER BY DATE(date) ASC";

	        connection = Database.connectDb();
	        try {
	            XYChart.Series chart = new XYChart.Series();
	            XYChart.Series chart1 = new XYChart.Series();
	            statement_tb_data = connection.prepareStatement(sql_tb_data);
	            result = statement_tb_data.executeQuery();

	            while (result.next()) {
	                String formattedDate = result.getString(1);
	                chart.getData().add(new XYChart.Data(formattedDate, result.getDouble(2)));
	                chart1.getData().add(new XYChart.Data(formattedDate, result.getDouble(3)));
	            }

	            d_d_ocdaily.getData().addAll(chart, chart1);
	            d_d_ocdaily.setLegendVisible(false);
	            applyNodeStyle(chart, "#1E90FF"); // Bleu pour la série chart
	            applyNodeStyle(chart1, "#FF0000"); // Rouge pour la série chart1

	            applyLineStyle(d_d_ocdaily, chart, "#1E90FF"); // Bleu pour la série chart
	            applyLineStyle(d_d_ocdaily, chart1, "#FF0000"); // Rouge pour la série chart1
	            hideDataPoints(d_d_ocdaily);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }


	    public void weeklymonth() {
	        m_weeeff.getData().clear();
	        String sql_tb_data = "SELECT YEAR(date), WEEK(date, 1), SUM(Efficiency),SUM(T_Efficiency) " +
                    "FROM `tb_data` " +
                    "GROUP BY YEAR(date), WEEK(date, 1) " +
                    "ORDER BY YEAR(date) DESC, WEEK(date, 1) DESC LIMIT 7";

connection = Database.connectDb();
try {
   XYChart.Series chart = new XYChart.Series<>();
   XYChart.Series chart1 = new XYChart.Series<>();
   
   statement_tb_data = connection.prepareStatement(sql_tb_data);
   result = statement_tb_data.executeQuery();
   
   while (result.next()) {
       int year = result.getInt(1);
       int week = result.getInt(2);
       double ocrate = result.getDouble(3);
       double me = result.getDouble(4);

       // Format the label with the separator "-"
       String xAxisLabel = String.format("%d-%02d", year, week);

       // Add data to the series
       chart.getData().add(new XYChart.Data<>(xAxisLabel, ocrate));
       chart1.getData().add(new XYChart.Data<>(xAxisLabel, me));
   }
        m_weeeff.getData().addAll(chart,chart1);
         m_weeeff.setLegendVisible(false);

	            for (Node bar : m_weeeff.lookupAll(".series0")) {
	                bar.setStyle("-fx-bar-fill: #1E90FF;"); // Couleur pour la première série (Efficiency)
	            }

	            for (Node bar : m_weeeff.lookupAll(".series1")) {
	                bar.setStyle("-fx-bar-fill: #FF0000;"); // Couleur pour la deuxième série (AnotherColumn)
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	            
	               
	  public void monthyeffmonth() {
	    	m_m_eff.getData().clear();
	        String sql_tb_data = " SELECT YEAR(date),  MONTH(date), SUM(Efficiency), SUM(T_Efficiency) "
	        		+ "	       FROM `tb_data` "
	        		+ "	         WHERE DATE >= DATE_SUB(CURDATE(), INTERVAL 7 MONTH) "
	        		+ "	            GROUP BY YEAR(date), MONTH(date) "
	        		+ "	            ORDER BY YEAR(date) ASC, MONTH(date) ASC";

	        connection = Database.connectDb();
	        try {
	            XYChart.Series chart = new XYChart.Series();
	            XYChart.Series chart1 = new XYChart.Series();
	            statement_tb_data = connection.prepareStatement(sql_tb_data);
	            result = statement_tb_data.executeQuery();
	            while (result.next()) {
	                // Obtenir le mois à partir du résultat de la requête
	                int year = result.getInt(1);
	                int month = result.getInt(2);
	                // Formater le mois
	                String formattedMonth = String.format("%02d", month) + "-" + year;
	                chart.getData().add(new XYChart.Data(formattedMonth, result.getDouble(3)));
	                chart1.getData().add(new XYChart.Data<>(formattedMonth, result.getDouble(4)));
	            }
	            
	            m_m_eff.getData().addAll(chart, chart1);
	            for (Node bar : m_m_eff.lookupAll(".series0")) {
	                bar.setStyle("-fx-bar-fill: #1E90FF;"); // Couleur pour la première série (Efficiency)
	            }

	            for (Node bar : m_m_eff.lookupAll(".series1")) {
	                bar.setStyle("-fx-bar-fill: #FF0000;"); // Couleur pour la deuxième série (AnotherColumn)
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    public void monthyoutmonth() {
	        m_m_out.getData().clear();
	        String sql_tb_data = "SELECT YEAR(date),  MONTH(date), SUM(Output), SUM(ME) "
	        		+ "	      FROM `tb_data` "
	        		+ "	WHERE DATE >= DATE_SUB(CURDATE(), INTERVAL 7 MONTH) "
	        		+ "	 GROUP BY YEAR(date), MONTH(date) "
	        		+ "	  ORDER BY YEAR(date) ASC, MONTH(date) ASC";

	        connection = Database.connectDb();
	        try {
	            XYChart.Series outputSeries = new XYChart.Series<>();
	            XYChart.Series meSeries = new XYChart.Series<>();
	            statement_tb_data = connection.prepareStatement(sql_tb_data);
	            result = statement_tb_data.executeQuery();
	            while (result.next()) {
	            	  int year = result.getInt(1);
		                int month = result.getInt(2);
		                // Formater le mois
		                String formattedMonth = String.format("%02d", month) + "-" + year;
	                outputSeries.getData().add(new XYChart.Data<>(formattedMonth, result.getDouble(3)));
	                meSeries.getData().add(new XYChart.Data<>(formattedMonth, result.getDouble(4)));
	            }
	            m_m_out.getData().addAll(outputSeries, meSeries);

	            // Appliquer le style bleu à la série "Output"
	            applyNodeStyle(outputSeries, "#1E90FF"); // Bleu pour la série chart
	            applyNodeStyle(meSeries, "#FF0000"); // Rouge pour la série chart1

	            applyLineStyle(m_m_out, outputSeries, "#1E90FF"); // Bleu pour la série chart
	            applyLineStyle(m_m_out, meSeries, "#FF0000"); // Rouge pour la série chart1
	            hideDataPoints(m_m_out);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    public void weeklyoutput() {
	        m_weeout.getData().clear();
	        String sql_tb_data = "SELECT YEAR(date), WEEK(date, 1), SUM(Output),SUM(ME) " +
                    "FROM `tb_data` " +
                    "GROUP BY YEAR(date), WEEK(date, 1) " +
                    "ORDER BY YEAR(date) DESC, WEEK(date, 1) DESC LIMIT 7";

 connection = Database.connectDb();
  try {
   XYChart.Series chart = new XYChart.Series<>();
   XYChart.Series chart1 = new XYChart.Series<>();
   
   statement_tb_data = connection.prepareStatement(sql_tb_data);
   result = statement_tb_data.executeQuery();
   
   while (result.next()) {
       int year = result.getInt(1);
       int week = result.getInt(2);
       double ocrate = result.getDouble(3);
       double me = result.getDouble(4);

       // Format the label with the separator "-"
       String xAxisLabel = String.format("%d-%02d", year, week);

       // Add data to the series
       chart.getData().add(new XYChart.Data<>(xAxisLabel, ocrate));
       chart1.getData().add(new XYChart.Data<>(xAxisLabel, me));
   }
   m_weeout.getData().addAll(chart,chart1);
   m_weeout.setLegendVisible(false);

	            applyNodeStyle(chart, "#1E90FF"); // Bleu pour la série chart
	            applyNodeStyle(chart1, "#FF0000"); // Rouge pour la série chart1

	            applyLineStyle(m_weeout, chart, "#1E90FF"); // Bleu pour la série chart
	            applyLineStyle(m_weeout, chart1, "#FF0000"); // Rouge pour la série chart1
	            hideDataPoints(m_weeout);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    public void monthyoccmonth() {
	    	m_oc.getData().clear();
	    	
	        String sql_tb_data = "  SELECT YEAR(date), MONTH(date), SUM(Oc_Rate), SUM(ME) "
	        		+ "	            FROM `tb_data` "
	        		+ "	        WHERE DATE >= DATE_SUB(CURDATE(), INTERVAL 7 MONTH) "
	        		+ "	        GROUP BY YEAR(date), MONTH(date) "
	        		+ "	      ORDER BY YEAR(date) ASC, MONTH(date) ASC";

	        connection = Database.connectDb();
	        try {
	            XYChart.Series chart = new XYChart.Series();
	            XYChart.Series chart1 = new XYChart.Series();
	            statement_tb_data = connection.prepareStatement(sql_tb_data);
	            result = statement_tb_data.executeQuery();
	            while (result.next()) {
	            	  int year = result.getInt(1);
		                int month = result.getInt(2);
		                // Formater le mois
		                String formattedMonth = String.format("%02d", month) + "-" + year;
	                chart.getData().add(new XYChart.Data(formattedMonth, result.getDouble(3)));
	                chart1.getData().add(new XYChart.Data<>(formattedMonth, result.getDouble(4)));
	            }
	            
	            m_oc.getData().addAll(chart, chart1);
	            for (Node bar : m_oc.lookupAll(".series0")) {
	                bar.setStyle("-fx-bar-fill: #1E90FF;"); // Couleur pour la première série (Efficiency)
	            }

	            for (Node bar : m_oc.lookupAll(".series1")) {
	                bar.setStyle("-fx-bar-fill: #FF0000;"); // Couleur pour la deuxième série (AnotherColumn)
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    public void weeklyocc() {
	    	m_weeocc.getData().clear();
	    	String sql_tb_data = "SELECT YEAR(date), WEEK(date, 1), SUM(Oc_Rate),SUM(ME) " +
                    "FROM `tb_data` " +
                    "GROUP BY YEAR(date), WEEK(date, 1) " +
                    "ORDER BY YEAR(date) DESC, WEEK(date, 1) DESC LIMIT 7";

connection = Database.connectDb();
try {
   XYChart.Series absSeries = new XYChart.Series<>();
   XYChart.Series tEfficiencySeries = new XYChart.Series<>();
   
   statement_tb_data = connection.prepareStatement(sql_tb_data);
   result = statement_tb_data.executeQuery();
   
   while (result.next()) {
       int year = result.getInt(1);
       int week = result.getInt(2);
       double ocrate = result.getDouble(3);
       double me = result.getDouble(4);

       // Format the label with the separator "-"
       String xAxisLabel = String.format("%d-%02d", year, week);

       // Add data to the series
       absSeries.getData().add(new XYChart.Data<>(xAxisLabel, ocrate));
       tEfficiencySeries.getData().add(new XYChart.Data<>(xAxisLabel, me));
   }
   m_weeocc.getData().addAll(absSeries,tEfficiencySeries);
   m_weeocc.setLegendVisible(false);
   for (Node bar : m_weeocc.lookupAll(".series0")) {
       bar.setStyle("-fx-bar-fill: #1E90FF;"); // Couleur pour la série d'absentéisme
   }
   for (Node bar : m_weeocc.lookupAll(".series1")) {
       bar.setStyle("-fx-bar-fill: #FF0000;"); // Couleur pour la deuxième série (AnotherColumn)
   }

} catch (Exception e) {
   e.printStackTrace();
}
}private void addZoomFunctionality(LineChart<String, Number> lineChart) {
    Scale scaleTransform = new Scale(1, 1, 0, 0);
    lineChart.getTransforms().add(scaleTransform);

    lineChart.setOnScroll((ScrollEvent event) -> {
        double deltaY = event.getDeltaY();
        double zoomFactor = 1.1;
        if (deltaY < 0) {
            zoomFactor = 1 / zoomFactor;
        }

        scaleTransform.setX(scaleTransform.getX() * zoomFactor);
        scaleTransform.setY(scaleTransform.getY() * zoomFactor);

        event.consume();
    });}
	    public void dailyKPIeff() {
    d_eff_follo.getData().clear();
    String sql_tb_data = "SELECT DATE(date), SUM(Efficiency), SUM(T_Efficiency) " +
    		                         "FROM (SELECT * FROM `tb_data` ORDER BY date DESC LIMIT 7) AS recent_data " +
    		                         "GROUP BY DATE(date) " +
    		                       "ORDER BY DATE(date) ASC";

    connection = Database.connectDb();
    try {
        XYChart.Series chart = new XYChart.Series();
        XYChart.Series chart1 = new XYChart.Series();
        statement_tb_data = connection.prepareStatement(sql_tb_data);
        result = statement_tb_data.executeQuery();
        while (result.next()) {
            // Formater la date pour ne conserver que la partie date
            String formattedDate = result.getDate(1).toString();
            chart.getData().add(new XYChart.Data(formattedDate, result.getDouble(2)));
            chart1.getData().add(new XYChart.Data(formattedDate, result.getDouble(3)));
        }
        d_eff_follo.getData().addAll(chart, chart1);
        applyNodeStyle(chart, "#1E90FF"); // Bleu pour la série chart
        applyNodeStyle(chart1, "#FF0000"); // Rouge pour la série chart1

        applyLineStyle(d_eff_follo, chart, "#1E90FF"); // Bleu pour la série chart
        applyLineStyle(d_eff_follo, chart1, "#FF0000"); // Rouge pour la série chart1
        hideDataPoints(d_eff_follo);
        addZoomFunctionality(d_eff_follo);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
	    public void dailyKPIeffzom() {
	        zoom_eff.getData().clear();
	        String sql_tb_data = "SELECT DATE(date), SUM(Efficiency), SUM(T_Efficiency) " +
	        		                         "FROM (SELECT * FROM `tb_data` ORDER BY date DESC LIMIT 7) AS recent_data " +
	        		                         "GROUP BY DATE(date) " +
	        		                       "ORDER BY DATE(date) ASC";

	        connection = Database.connectDb();
	        try {
	            XYChart.Series chart = new XYChart.Series();
	            XYChart.Series chart1 = new XYChart.Series();
	            statement_tb_data = connection.prepareStatement(sql_tb_data);
	            result = statement_tb_data.executeQuery();
	            while (result.next()) {
	                // Formater la date pour ne conserver que la partie date
	                String formattedDate = result.getDate(1).toString();
	                chart.getData().add(new XYChart.Data(formattedDate, result.getDouble(2)));
	                chart1.getData().add(new XYChart.Data(formattedDate, result.getDouble(3)));
	            }
	            zoom_eff.getData().addAll(chart, chart1);
	            applyNodeStyle(chart, "#1E90FF"); // Bleu pour la série chart
	            applyNodeStyle(chart1, "#FF0000"); // Rouge pour la série chart1
	            zoom_eff.setLegendVisible(false);
	            applyLineStyle(zoom_eff, chart, "#1E90FF"); // Bleu pour la série chart
	            applyLineStyle(zoom_eff, chart1, "#FF0000"); // Rouge pour la série chart1
	            hideDataPoints(zoom_eff);
	            addZoomFunctionality(zoom_eff);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    public void dailyKPIabs() {
	    	d_abs_follo.getData().clear();
	    	 String sql_tb_data = "SELECT DATE(date), SUM(ABSENTEISM),SUM(T_ABS) " 
	    	 		+ "    		                         FROM (SELECT * FROM `tb_data` ORDER BY date DESC LIMIT 7) AS recent_data "
	    	 		+ "    		                         GROUP BY DATE(date) " 
	    	 		+ "    		                       ORDER BY DATE(date) ASC";

		        connection = Database.connectDb();
		        try {
		            XYChart.Series chart = new XYChart.Series();
		            XYChart.Series chart1 = new XYChart.Series();
		            statement_tb_data = connection.prepareStatement(sql_tb_data);
		            result = statement_tb_data.executeQuery();
		            while (result.next()) {
		                // Formater la date pour ne conserver que la partie date
		                String formattedDate = result.getDate(1).toString();
		                chart.getData().add(new XYChart.Data(formattedDate, result.getDouble(2)));
		                chart1.getData().add(new XYChart.Data(formattedDate, result.getDouble(3)));
		            }
		            d_abs_follo.getData().addAll(chart, chart1);
		            applyNodeStyle(chart, "#1E90FF"); // Bleu pour la série chart
		            applyNodeStyle(chart1, "#FF0000"); // Rouge pour la série chart1
		            applyLineStyle(d_abs_follo, chart, "#1E90FF"); // Bleu pour la série chart
		            applyLineStyle(d_abs_follo, chart1, "#FF0000"); // Rouge pour la série chart1
		            hideDataPoints(d_abs_follo);

		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
	    public void dailyKPIabszoom() {
	    	zoomtabs.getData().clear();
	    	 String sql_tb_data = "SELECT DATE(date), SUM(ABSENTEISM),SUM(T_ABS) " 
	    	 		+ "    		                         FROM (SELECT * FROM `tb_data` ORDER BY date DESC LIMIT 7) AS recent_data "
	    	 		+ "    		                         GROUP BY DATE(date) " 
	    	 		+ " ORDER BY DATE(date) ASC";

		        connection = Database.connectDb();
		        try {
		            XYChart.Series chart = new XYChart.Series();
		            XYChart.Series chart1 = new XYChart.Series();
		            statement_tb_data = connection.prepareStatement(sql_tb_data);
		            result = statement_tb_data.executeQuery();
		            while (result.next()) {
		                // Formater la date pour ne conserver que la partie date
		                String formattedDate = result.getDate(1).toString();
		                chart.getData().add(new XYChart.Data(formattedDate, result.getDouble(2)));
		                chart1.getData().add(new XYChart.Data(formattedDate, result.getDouble(3)));
		            }
		            zoomtabs.getData().addAll(chart, chart1);
		            zoomtabs.setLegendVisible(false);
		            applyNodeStyle(chart, "#1E90FF"); // Bleu pour la série chart
		            applyNodeStyle(chart1, "#FF0000"); // Rouge pour la série chart1
		            applyLineStyle(zoomtabs, chart, "#1E90FF"); // Bleu pour la série chart
		            applyLineStyle(zoomtabs, chart1, "#FF0000"); // Rouge pour la série chart1
		            hideDataPoints(zoomtabs);
		            addZoomFunctionality(zoomtabs);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
	    public void dailyKPIout() {
	    	d_total_output.getData().clear();
	        String sql_tb_data = "SELECT DATE(date), SUM(Output),SUM(ME) "
	        		+ "	FROM (SELECT * FROM `tb_data` ORDER BY date DESC LIMIT 7) AS recent_data "
	        		+ "	 GROUP BY DATE(date) "
	        		+ "	ORDER BY DATE(date) ASC";

	        connection = Database.connectDb();
	        try {
	            XYChart.Series chart = new XYChart.Series();
	            XYChart.Series chart1 = new XYChart.Series();
	            statement_tb_data = connection.prepareStatement(sql_tb_data);
	            result = statement_tb_data.executeQuery();
	            while (result.next()) {
	                // Formater la date pour ne conserver que la partie date
	                String formattedDate = result.getDate(1).toString();
	                chart.getData().add(new XYChart.Data(formattedDate, result.getDouble(2)));
	                chart1.getData().add(new XYChart.Data(formattedDate, result.getDouble(3)));
	            }
	            d_total_output.getData().addAll(chart, chart1);
	            applyNodeStyle(chart, "#1E90FF"); // Bleu pour la série chart
	            applyNodeStyle(chart1, "#FF0000"); // Rouge pour la série chart1
	            applyLineStyle(d_total_output, chart, "#1E90FF"); // Bleu pour la série chart
	            applyLineStyle(d_total_output, chart1, "#FF0000"); // Rouge pour la série chart1
	            hideDataPoints(d_total_output);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    public void dailyKPIoutzoom() {
	    	 System.out.println("dailyKPIoutzoom appelé");
	    	zoomoutput.getData().clear();
	        String sql_tb_data = "SELECT DATE(date), SUM(Output),SUM(ME) "
	        		+ "	FROM (SELECT * FROM `tb_data` ORDER BY date DESC LIMIT 7) AS recent_data "
	        		+ "	 GROUP BY DATE(date) "
	        		+ "	ORDER BY DATE(date) ASC";

	        connection = Database.connectDb();
	        try {
	            XYChart.Series chart = new XYChart.Series();
	            XYChart.Series chart1 = new XYChart.Series();
	            statement_tb_data = connection.prepareStatement(sql_tb_data);
	            result = statement_tb_data.executeQuery();
	            while (result.next()) {
	                // Formater la date pour ne conserver que la partie date
	                String formattedDate = result.getDate(1).toString();
	                chart.getData().add(new XYChart.Data(formattedDate, result.getDouble(2)));
	                chart1.getData().add(new XYChart.Data(formattedDate, result.getDouble(3)));
	            }
	            zoomoutput.getData().addAll(chart, chart1);
	            zoomoutput.setLegendVisible(false);
	            applyNodeStyle(chart, "#1E90FF"); // Bleu pour la série chart
	            applyNodeStyle(chart1, "#FF0000"); // Rouge pour la série chart1
	            applyLineStyle(zoomoutput, chart, "#1E90FF"); // Bleu pour la série chart
	            applyLineStyle(zoomoutput, chart1, "#FF0000"); // Rouge pour la série chart1
	            hideDataPoints(zoomoutput);
	            addZoomFunctionality(zoomoutput);
	        } catch (Exception e) {
	        	
	            e.printStackTrace();
	        }
	        finally {
	            try {
	                if (result != null) result.close();
	                if (statement_tb_data != null) statement_tb_data.close();
	                if (connection != null) connection.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    public void dailyKPIhc() {
	    	d_hc_follo.getData().clear();
	        String sql_tb_data = "SELECT DATE(date), SUM(HC),SUM(T_HC) "
	        		
	        		+ "	FROM (SELECT * FROM `tb_data` ORDER BY date DESC LIMIT 7) AS recent_data "
	        		+ "	 GROUP BY DATE(date) "
	        		+ "	ORDER BY DATE(date) ASC";

	        connection = Database.connectDb();
	        try {
	            XYChart.Series chart = new XYChart.Series();
	            XYChart.Series chart1 = new XYChart.Series();
	            statement_tb_data = connection.prepareStatement(sql_tb_data);
	            result = statement_tb_data.executeQuery();
	            while (result.next()) {
	                // Formater la date pour ne conserver que la partie date
	                String formattedDate = result.getDate(1).toString();
	                chart.getData().add(new XYChart.Data(formattedDate, result.getDouble(2)));
	                chart1.getData().add(new XYChart.Data(formattedDate, result.getDouble(3)));
	            }
	            d_hc_follo.getData().addAll(chart, chart1);
	            for (Node bar : d_hc_follo.lookupAll(".series0")) {
	                bar.setStyle("-fx-bar-fill: #1E90FF;"); // Couleur pour la première série (Efficiency)
	            }

	            for (Node bar : d_hc_follo.lookupAll(".series1")) {
	                bar.setStyle("-fx-bar-fill: #FF0000;"); // Couleur pour la deuxième série (AnotherColumn)
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    public void dailyKPIhczoom() {
	    	zoomhc.getData().clear();
	        String sql_tb_data = "SELECT DATE(date), SUM(HC),SUM(T_HC) "
	        		
	        		+ "	FROM (SELECT * FROM `tb_data` ORDER BY date DESC LIMIT 7) AS recent_data "
	        		+ "	 GROUP BY DATE(date) "
	        		+ "	ORDER BY DATE(date) ASC";

	        connection = Database.connectDb();
	        try {
	            XYChart.Series chart = new XYChart.Series();
	            XYChart.Series chart1 = new XYChart.Series();
	            statement_tb_data = connection.prepareStatement(sql_tb_data);
	            result = statement_tb_data.executeQuery();
	            while (result.next()) {
	                // Formater la date pour ne conserver que la partie date
	                String formattedDate = result.getDate(1).toString();
	                chart.getData().add(new XYChart.Data(formattedDate, result.getDouble(2)));
	                chart1.getData().add(new XYChart.Data(formattedDate, result.getDouble(3)));
	            }
	            zoomhc.getData().addAll(chart, chart1);
	            zoomhc.setLegendVisible(false);
	            for (Node bar : zoomhc.lookupAll(".series0")) {
	                bar.setStyle("-fx-bar-fill: #1E90FF;"); // Couleur pour la première série (Efficiency)
	            }

	            for (Node bar : zoomhc.lookupAll(".series1")) {
	                bar.setStyle("-fx-bar-fill: #FF0000;"); // Couleur pour la deuxième série (AnotherColumn)
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    public void dailyKPIocc() {
	    	d_occ_rate_follo.getData().clear();
	        String sql_tb_data = "SELECT DATE(date), SUM(Oc_Rate),SUM(ME) "
	        		
	        		+ "	FROM (SELECT * FROM `tb_data` ORDER BY date DESC LIMIT 7) AS recent_data "
	        		+ "	 GROUP BY DATE(date) "
	        		+ "	 ORDER BY DATE(date) ASC";

	        connection = Database.connectDb();
	        try {
	            XYChart.Series chart = new XYChart.Series();
	            XYChart.Series chart1 = new XYChart.Series();
	            statement_tb_data = connection.prepareStatement(sql_tb_data);
	            result = statement_tb_data.executeQuery();
	            while (result.next()) {
	                // Formater la date pour ne conserver que la partie date
	                String formattedDate = result.getDate(1).toString();
	                chart.getData().add(new XYChart.Data(formattedDate, result.getDouble(2)));
	                chart1.getData().add(new XYChart.Data(formattedDate, result.getDouble(3)));
	            }
	            d_occ_rate_follo.getData().addAll(chart, chart1);
	            for (Node bar :  d_occ_rate_follo.lookupAll(".series0")) {
	                bar.setStyle("-fx-bar-fill: #1E90FF;"); // Couleur pour la première série (Efficiency)
	            }

	            for (Node bar : d_occ_rate_follo.lookupAll(".series1")) {
	                bar.setStyle("-fx-bar-fill: #FF0000;"); // Couleur pour la deuxième série (AnotherColumn)
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    public void dailyKPIocczoom() {
	    	zoomoccrate.getData().clear();
	        String sql_tb_data = "SELECT DATE(date), SUM(Oc_Rate),SUM(ME) "
	        		
	        		+ "	FROM (SELECT * FROM `tb_data` ORDER BY date DESC LIMIT 7) AS recent_data "
	        		+ "	 GROUP BY DATE(date) "
	        		+ "	 ORDER BY DATE(date) ASC";

	        connection = Database.connectDb();
	        try {
	            XYChart.Series chart = new XYChart.Series();
	            XYChart.Series chart1 = new XYChart.Series();
	            statement_tb_data = connection.prepareStatement(sql_tb_data);
	            result = statement_tb_data.executeQuery();
	            while (result.next()) {
	                // Formater la date pour ne conserver que la partie date
	                String formattedDate = result.getDate(1).toString();
	                chart.getData().add(new XYChart.Data(formattedDate, result.getDouble(2)));
	                chart1.getData().add(new XYChart.Data(formattedDate, result.getDouble(3)));
	            }
	            zoomoccrate.getData().addAll(chart, chart1);
	            zoomoccrate.setLegendVisible(false);
	            for (Node bar :  zoomoccrate.lookupAll(".series0")) {
	                bar.setStyle("-fx-bar-fill: #1E90FF;"); // Couleur pour la première série (Efficiency)
	            }

	            for (Node bar : zoomoccrate.lookupAll(".series1")) {
	                bar.setStyle("-fx-bar-fill: #FF0000;"); // Couleur pour la deuxième série (AnotherColumn)
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    public void dailyKPIabstt() {
	    	d_total_abs_follo.getData().clear();
	    	 String sql_tb_data = "SELECT DATE(date), SUM(ABSENTEISM),SUM(T_ABS) "
	    	 		
	    	 		+ "	FROM (SELECT * FROM `tb_data` ORDER BY date DESC LIMIT 7) AS recent_data "
	    	 		+ "	 GROUP BY DATE(date) "
	    	 		+ "	ORDER BY DATE(date) ASC";

		        connection = Database.connectDb();
		        try {
		            XYChart.Series chart = new XYChart.Series();
		            XYChart.Series chart1 = new XYChart.Series();
		            statement_tb_data = connection.prepareStatement(sql_tb_data);
		            result = statement_tb_data.executeQuery();
		            while (result.next()) {
		                // Formater la date pour ne conserver que la partie date
		                String formattedDate = result.getDate(1).toString();
		                chart.getData().add(new XYChart.Data(formattedDate, result.getDouble(2)));
		                chart1.getData().add(new XYChart.Data(formattedDate, result.getDouble(3)));
		            }
		            d_total_abs_follo.getData().addAll(chart, chart1);
		            applyNodeStyle(chart, "#1E90FF"); // Bleu pour la série chart
		            applyNodeStyle(chart1, "#FF0000"); // Rouge pour la série chart1
		            applyLineStyle(d_total_abs_follo, chart, "#1E90FF"); // Bleu pour la série chart
		            applyLineStyle(d_total_abs_follo, chart1, "#FF0000"); // Rouge pour la série chart1
		            hideDataPoints(d_total_abs_follo);

		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
	    public void dailyKPIabsttzoom() {
	    	zoomabs.getData().clear();
	    	 String sql_tb_data = "SELECT DATE(date), SUM(ABSENTEISM),SUM(T_ABS) "

	    	 		+ "	FROM (SELECT * FROM `tb_data` ORDER BY date DESC LIMIT 7) AS recent_data "
	    	 		+ "	  GROUP BY DATE(date) "
	    	 		+ "ORDER BY DATE(date) ASC";

		        connection = Database.connectDb();
		        try {
		            XYChart.Series chart = new XYChart.Series();
		            XYChart.Series chart1 = new XYChart.Series();
		            statement_tb_data = connection.prepareStatement(sql_tb_data);
		            result = statement_tb_data.executeQuery();
		            while (result.next()) {
		                // Formater la date pour ne conserver que la partie date
		                String formattedDate = result.getDate(1).toString();
		                chart.getData().add(new XYChart.Data(formattedDate, result.getDouble(2)));
		                chart1.getData().add(new XYChart.Data(formattedDate, result.getDouble(3)));
		            }
		            zoomabs.getData().addAll(chart, chart1);
		            zoomabs.setLegendVisible(false);
		            applyNodeStyle(chart, "#1E90FF"); // Bleu pour la série chart
		            applyNodeStyle(chart1, "#FF0000"); // Rouge pour la série chart1
		            applyLineStyle(zoomabs, chart, "#1E90FF"); // Bleu pour la série chart
		            applyLineStyle(zoomabs, chart1, "#FF0000"); // Rouge pour la série chart1
		            hideDataPoints(zoomabs);

		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
	    public void dailyKPIabstnoplanned() {
	    	d_total_abs_non_planned.getData().clear();
	    	 String sql_tb_data = "SELECT DATE(date), SUM(Abs_No_Planned),SUM(T_Abs_NoPlanned) "

	    	 		+ "	FROM (SELECT * FROM `tb_data` ORDER BY date DESC LIMIT 7) AS recent_data "
	    	 		+ "	  GROUP BY DATE(date) "
	    	 		+ "ORDER BY DATE(date) ASC";

		        connection = Database.connectDb();
		        try {
		            XYChart.Series chart = new XYChart.Series();
		            XYChart.Series chart1 = new XYChart.Series();
		            statement_tb_data = connection.prepareStatement(sql_tb_data);
		            result = statement_tb_data.executeQuery();
		            while (result.next()) {
		                // Formater la date pour ne conserver que la partie date
		                String formattedDate = result.getDate(1).toString();
		                chart.getData().add(new XYChart.Data(formattedDate, result.getDouble(2)));
		                chart1.getData().add(new XYChart.Data(formattedDate, result.getDouble(3)));
		            }
		            d_total_abs_non_planned.getData().addAll(chart, chart1);
		            applyNodeStyle(chart, "#1E90FF"); // Bleu pour la série chart
		            applyNodeStyle(chart1, "#FF0000"); // Rouge pour la série chart1
		            applyLineStyle(d_total_abs_non_planned, chart, "#1E90FF"); // Bleu pour la série chart
		            applyLineStyle(d_total_abs_non_planned, chart1, "#FF0000"); // Rouge pour la série chart1
		            hideDataPoints(d_total_abs_non_planned);

		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
	    public void dailyKPIabstnoplannedzoom() {
	    	zoomabsno.getData().clear();
	    	 String sql_tb_data = "SELECT DATE(date), SUM(Abs_No_Planned),SUM(T_Abs_NoPlanned) "

	    	 		+ "	FROM (SELECT * FROM `tb_data` ORDER BY date DESC LIMIT 7) AS recent_data "
	    	 		+ "	  GROUP BY DATE(date) "
	    	 		+ "ORDER BY DATE(date) ASC";

		        connection = Database.connectDb();
		        try {
		            XYChart.Series chart = new XYChart.Series();
		            XYChart.Series chart1 = new XYChart.Series();
		            statement_tb_data = connection.prepareStatement(sql_tb_data);
		            result = statement_tb_data.executeQuery();
		            while (result.next()) {
		                // Formater la date pour ne conserver que la partie date
		                String formattedDate = result.getDate(1).toString();
		                chart.getData().add(new XYChart.Data(formattedDate, result.getDouble(2)));
		                chart1.getData().add(new XYChart.Data(formattedDate, result.getDouble(3)));
		            }
		            zoomabsno.getData().addAll(chart, chart1);
		            zoomabsno.setLegendVisible(false);
		            applyNodeStyle(chart, "#1E90FF"); // Bleu pour la série chart
		            applyNodeStyle(chart1, "#FF0000"); // Rouge pour la série chart1
		            applyLineStyle(zoomabsno, chart, "#1E90FF"); // Bleu pour la série chart
		            applyLineStyle(zoomabsno, chart1, "#FF0000"); // Rouge pour la série chart1
		            hideDataPoints(zoomabsno);
		            addZoomFunctionality(zoomabsno);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
	    public void dailyKPIwsd() {
	    	d_wsd_follo.getData().clear();
	        String sql_tb_data = "SELECT DATE(date), SUM(WSD),SUM(T_WSD) "
	        		
	        		+ "	FROM (SELECT * FROM `tb_data` ORDER BY date DESC LIMIT 7) AS recent_data "
	        		+ "	GROUP BY DATE(date) "
	        		+ "	ORDER BY DATE(date) ASC";

	        connection = Database.connectDb();
	        try {
	            XYChart.Series chart = new XYChart.Series();
	            XYChart.Series chart1 = new XYChart.Series();
	            statement_tb_data = connection.prepareStatement(sql_tb_data);
	            result = statement_tb_data.executeQuery();
	            while (result.next()) {
	                // Formater la date pour ne conserver que la partie date
	                String formattedDate = result.getDate(1).toString();
	                chart.getData().add(new XYChart.Data(formattedDate, result.getDouble(2)));
	                chart1.getData().add(new XYChart.Data(formattedDate, result.getDouble(3)));
	            }
	            d_wsd_follo.getData().addAll(chart, chart1);
	            applyNodeStyle(chart, "#1E90FF"); // Bleu pour la série chart
	            applyNodeStyle(chart1, "#FF0000"); // Rouge pour la série chart1
	            applyLineStyle(d_wsd_follo, chart, "#1E90FF"); // Bleu pour la série chart
	            applyLineStyle(d_wsd_follo, chart1, "#FF0000"); // Rouge pour la série chart1
	            hideDataPoints(d_wsd_follo);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    public void dailyKPIwsdzoom() {
	    	zoomwsd.getData().clear();
	        String sql_tb_data = "SELECT DATE(date), SUM(WSD),SUM(T_WSD) "
	        		
	        		+ "	FROM (SELECT * FROM `tb_data` ORDER BY date DESC LIMIT 7) AS recent_data "
	        		+ "	GROUP BY DATE(date) "
	        		+ "	ORDER BY DATE(date) ASC";

	        connection = Database.connectDb();
	        try {
	            XYChart.Series chart = new XYChart.Series();
	            XYChart.Series chart1 = new XYChart.Series();
	            statement_tb_data = connection.prepareStatement(sql_tb_data);
	            result = statement_tb_data.executeQuery();
	            while (result.next()) {
	                // Formater la date pour ne conserver que la partie date
	                String formattedDate = result.getDate(1).toString();
	                chart.getData().add(new XYChart.Data(formattedDate, result.getDouble(2)));
	                chart1.getData().add(new XYChart.Data(formattedDate, result.getDouble(3)));
	            }
	            zoomwsd.getData().addAll(chart, chart1);
	            zoomwsd.setLegendVisible(false);
	            applyNodeStyle(chart, "#1E90FF"); // Bleu pour la série chart
	            applyNodeStyle(chart1, "#FF0000"); // Rouge pour la série chart1
	            applyLineStyle(zoomwsd, chart, "#1E90FF"); // Bleu pour la série chart
	            applyLineStyle(zoomwsd, chart1, "#FF0000"); // Rouge pour la série chart1
	            hideDataPoints(zoomwsd);
	            addZoomFunctionality(zoomwsd);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    private void applyNodeStyle(XYChart.Series<Number, Number> series, String color) {
	        for (XYChart.Data<Number, Number> data : series.getData()) {
	            Node node = data.getNode();
	            if (node != null) {
	                node.setStyle("-fx-background-color: " + color + ", white; -fx-background-radius: 5px;");
	                node.setVisible(false); 
	            }
	        }
	    }

	    private void hideDataPoints(LineChart<?, ?> chart) {
	        for (XYChart.Series<?, ?> series : chart.getData()) {
	            for (XYChart.Data<?, ?> data : series.getData()) {
	                Node node = data.getNode();
	                node.setVisible(false);
	            }
	        }
	    }

	    private void applyLineStyle(LineChart chart, XYChart.Series series, String color) {
	        for (Node line : chart.lookupAll(".series" + chart.getData().indexOf(series))) {
	            line.setStyle("-fx-stroke: " + color + ";");
	        }
	    }

	    public void dailyKPIdt() {
	        d_dt_follo.getData().clear();
	        String sql_tb_data = "SELECT DATE(date), SUM(DT), SUM(T_DT)"
	        	
	        		+ "FROM (SELECT * FROM `tb_data` ORDER BY date DESC LIMIT 7) AS recent_data "
	        		+ "	GROUP BY DATE(date) "
	        		+ "	ORDER BY DATE(date) ASC";

	        connection = Database.connectDb();
	        try {
	            XYChart.Series chart = new XYChart.Series<>();
	            XYChart.Series chart1 = new XYChart.Series<>();
	            statement_tb_data = connection.prepareStatement(sql_tb_data);
	            result = statement_tb_data.executeQuery();
	            while (result.next()) {
	                // Formater la date pour ne conserver que la partie date
	                String formattedDate = result.getDate(1).toString();
	                chart.getData().add(new XYChart.Data<>(formattedDate, result.getDouble(2)));
	                chart1.getData().add(new XYChart.Data<>(formattedDate, result.getDouble(3)));
	            }
	            d_dt_follo.getData().addAll(chart, chart1);

	            // Appliquer le style aux nœuds de chaque série
	           applyNodeStyle(chart, "#1E90FF"); // Bleu pour la série chart
	            applyNodeStyle(chart1, "#FF0000"); // Rouge pour la série chart1

	            // Colorer les lignes des séries
	            applyLineStyle(d_dt_follo, chart, "#1E90FF"); // Bleu pour la série chart
	            applyLineStyle(d_dt_follo, chart1, "#FF0000"); // Rouge pour la série chart1
	            hideDataPoints(d_dt_follo);

	        } catch (Exception e) {
	            e.printStackTrace();
	        } 
	    }
	    public void dailyKPIdtzoom() {
	        zoomdt.getData().clear();
	        String sql_tb_data = "SELECT DATE(date), SUM(DT), SUM(T_DT)"
	        	
	        		+ "FROM (SELECT * FROM `tb_data` ORDER BY date DESC LIMIT 7) AS recent_data "
	        		+ "	GROUP BY DATE(date) "
	        		+ "	ORDER BY DATE(date) ASC";

	        connection = Database.connectDb();
	        try {
	            XYChart.Series chart = new XYChart.Series<>();
	            XYChart.Series chart1 = new XYChart.Series<>();
	            statement_tb_data = connection.prepareStatement(sql_tb_data);
	            result = statement_tb_data.executeQuery();
	            while (result.next()) {
	                // Formater la date pour ne conserver que la partie date
	                String formattedDate = result.getDate(1).toString();
	                chart.getData().add(new XYChart.Data<>(formattedDate, result.getDouble(2)));
	                chart1.getData().add(new XYChart.Data<>(formattedDate, result.getDouble(3)));
	            }
	            zoomdt.getData().addAll(chart, chart1);
	            zoomdt.setLegendVisible(false);
	            // Appliquer le style aux nœuds de chaque série
	           applyNodeStyle(chart, "#1E90FF"); // Bleu pour la série chart
	            applyNodeStyle(chart1, "#FF0000"); // Rouge pour la série chart1

	            // Colorer les lignes des séries
	            applyLineStyle(zoomdt, chart, "#1E90FF"); // Bleu pour la série chart
	            applyLineStyle(zoomdt, chart1, "#FF0000"); // Rouge pour la série chart1
	            hideDataPoints(zoomdt);
	            addZoomFunctionality(zoomdt);
	        } catch (Exception e) {
	            e.printStackTrace();
	        } 
	    }

	    public void DTdAILY() {
	    	daily_dt.getData().clear();
	        String sql_tb_data = " SELECT  DATE(date), SUM(DT),SUM(T_DT) "
	        		+ "FROM (SELECT * FROM `tb_data` ORDER BY date DESC LIMIT 7) AS recent_data "
	        		+ "	GROUP BY DATE(date) "
	        		+ "	ORDER BY DATE(date) ASC";
	        		

	        connection = Database.connectDb();
	        try {
	            XYChart.Series chart = new XYChart.Series();
	            XYChart.Series chart1 = new XYChart.Series();
	            statement_tb_data = connection.prepareStatement(sql_tb_data);
	            result = statement_tb_data.executeQuery();
	            while (result.next()) {
	                Date date = result.getDate(1);
	                
	                // Formater la date avec le format spécifié
	                SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.FRENCH);
	                String formattedDate = sdf.format(date);

	                chart.getData().add(new XYChart.Data(formattedDate, result.getDouble(2)));
	                chart1.getData().add(new XYChart.Data(formattedDate, result.getDouble(3)));
	            }
	            daily_dt.getData().addAll(chart, chart1);
	            for (Node bar : daily_dt.lookupAll(".series0")) {
	                bar.setStyle("-fx-bar-fill: #1E90FF;"); // Couleur pour la première série (Efficiency)
	            }

	            for (Node bar : daily_dt.lookupAll(".series1")) {
	                bar.setStyle("-fx-bar-fill: #FF0000;"); // Couleur pour la deuxième série (AnotherColumn)
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    public void dtmonth() {
	    	monthly_dt.getData().clear();
	    	
	        String sql_tb_data = "SELECT YEAR(date), MONTH(date), SUM(DT), SUM(T_DT) "
	        		+ "FROM `tb_data` "
	        		+ "	WHERE DATE >= DATE_SUB(CURDATE(), INTERVAL 7 MONTH) "
	        		+ "	  GROUP BY YEAR(date), MONTH(date) "
	        		+ "	  ORDER BY YEAR(date) ASC, MONTH(date) ASC";

	        connection = Database.connectDb();
	        try {
	            XYChart.Series chart = new XYChart.Series();
	            XYChart.Series chart1 = new XYChart.Series();
	            statement_tb_data = connection.prepareStatement(sql_tb_data);
	            result = statement_tb_data.executeQuery();
	            
	            while (result.next()) {
	            	 int year = result.getInt(1);
		                int month = result.getInt(2);
		              
		                String formattedMonth = String.format("%02d", month) + "-" + year;
	             
	                chart.getData().add(new XYChart.Data(formattedMonth, result.getDouble(3)));
	                chart1.getData().add(new XYChart.Data<>(formattedMonth, result.getDouble(4)));
	            }
	            
	            monthly_dt.getData().addAll(chart, chart1);
	            for (Node bar : monthly_dt.lookupAll(".series0")) {
	                bar.setStyle("-fx-bar-fill: #1E90FF;"); // Couleur pour la première série (Efficiency)
	            }

	            for (Node bar : monthly_dt.lookupAll(".series1")) {
	                bar.setStyle("-fx-bar-fill: #FF0000;"); // Couleur pour la deuxième série (AnotherColumn)
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	   
	    public void monthdtmonth() {
	    	deu_fa_dt.getData().clear();
	    	
	        String sql_tb_data = "SELECT YEAR(date),  MONTH(date), SUM(DT), SUM(T_DT) "
	        + "FROM `tb_data`"
	        		+ "	  WHERE DATE >= DATE_SUB(CURDATE(), INTERVAL 7 MONTH) "
	        		+ "	 GROUP BY YEAR(date), MONTH(date) "
	        		+ "	   ORDER BY YEAR(date) ASC, MONTH(date) ASC";

	        connection = Database.connectDb();
	        try {
	            XYChart.Series chart = new XYChart.Series();
	            XYChart.Series chart1 = new XYChart.Series();
	            statement_tb_data = connection.prepareStatement(sql_tb_data);
	            result = statement_tb_data.executeQuery();
	            while (result.next()) {
	            	int year = result.getInt(1);
	            	int month = result.getInt(2);
	                String formattedMonth = String.format("%02d", month) + "-" + year;
	                chart.getData().add(new XYChart.Data(formattedMonth, result.getDouble(3)));
	                chart1.getData().add(new XYChart.Data<>(formattedMonth, result.getDouble(4)));
	            }
	            
	            deu_fa_dt.getData().addAll(chart, chart1);
	            for (Node bar : deu_fa_dt.lookupAll(".series0")) {
	                bar.setStyle("-fx-bar-fill: #1E90FF;"); // Couleur pour la première série (Efficiency)
	            }

	            for (Node bar : deu_fa_dt.lookupAll(".series1")) {
	                bar.setStyle("-fx-bar-fill: #FF0000;"); // Couleur pour la deuxième série (AnotherColumn)
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    public void monthabsmonth() {
	    	d_abs.getData().clear();
	    	
	        String sql_tb_data = "SELECT YEAR(date),  MONTH(date), SUM(ABSENTEISM), SUM(T_ABS)"
	        + "	            FROM `tb_data` "
	        		+ "	  WHERE DATE >= DATE_SUB(CURDATE(), INTERVAL 7 MONTH) "
	        		+ "	  GROUP BY YEAR(date), MONTH(date) "
	        		+ "  ORDER BY YEAR(date) ASC, MONTH(date) ASC";

	        connection = Database.connectDb();
	        try {
	            XYChart.Series chart = new XYChart.Series();
	            XYChart.Series chart1 = new XYChart.Series();
	            
	            statement_tb_data = connection.prepareStatement(sql_tb_data);
	            result = statement_tb_data.executeQuery();
	            while (result.next()) {
	            	int year = result.getInt(1);
	            	int month = result.getInt(2);
	                String formattedMonth = String.format("%02d", month) + "-" + year;
	                chart.getData().add(new XYChart.Data(formattedMonth, result.getDouble(3)));
	                chart1.getData().add(new XYChart.Data(formattedMonth, result.getDouble(4)));
	                
	            }
	            
	            d_abs.getData().addAll(chart,chart1);
	            for (Node bar : d_abs.lookupAll(".series0")) {
	                bar.setStyle("-fx-bar-fill: #1E90FF;"); // Couleur pour la première série (Efficiency)
	            }

	            for (Node bar : d_abs.lookupAll(".series1")) {
	                bar.setStyle("-fx-bar-fill: #FF0000;"); // Couleur pour la deuxième série (AnotherColumn)
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public void weeklymonocc() {
	    	d_fa_wee.getData().clear();
	    	String sql_tb_data = "SELECT YEAR(date), WEEK(date, 1), SUM(Oc_Rate),SUM(ME) " +
		                             "FROM `tb_data` " +
		                             "GROUP BY YEAR(date), WEEK(date, 1) " +
		                             "ORDER BY YEAR(date) DESC, WEEK(date, 1) DESC LIMIT 7";

		        connection = Database.connectDb();
		        try {
		            XYChart.Series absSeries = new XYChart.Series<>();
		            XYChart.Series tEfficiencySeries = new XYChart.Series<>();
		            
		            statement_tb_data = connection.prepareStatement(sql_tb_data);
		            result = statement_tb_data.executeQuery();
		            
		            while (result.next()) {
		                int year = result.getInt(1);
		                int week = result.getInt(2);
		                double ocrate = result.getDouble(3);
		                double me = result.getDouble(4);

		                // Format the label with the separator "-"
		                String xAxisLabel = String.format("%d-%02d", year, week);

		                // Add data to the series
		                absSeries.getData().add(new XYChart.Data<>(xAxisLabel, ocrate));
		                tEfficiencySeries.getData().add(new XYChart.Data<>(xAxisLabel, me));
		            }
		            d_fa_wee.getData().addAll(absSeries,tEfficiencySeries);
		            d_fa_wee.setLegendVisible(false);
		            for (Node bar : d_fa_wee.lookupAll(".series0")) {
		                bar.setStyle("-fx-bar-fill: #1E90FF;"); // Couleur pour la série d'absentéisme
		            }
		            for (Node bar : d_fa_wee.lookupAll(".series1")) {
		                bar.setStyle("-fx-bar-fill: #FF0000;"); // Couleur pour la deuxième série (AnotherColumn)
		            }

		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
	        
	    public void weeklymonabs() {
	    	d_wee_abs.getData().clear();
	    	 String sql_tb_data = "SELECT YEAR(date), WEEK(date, 1), SUM(ABSENTEISM), SUM(T_ABS) " +
		                             "FROM `tb_data` " +
		                             "GROUP BY YEAR(date), WEEK(date, 1) " +
		                             "ORDER BY YEAR(date) DESC, WEEK(date, 1) DESC LIMIT 7";

		        connection = Database.connectDb();
		        try {
		            XYChart.Series absSeries = new XYChart.Series<>();
		            XYChart.Series absSeries1 = new XYChart.Series<>();
		            
		            statement_tb_data = connection.prepareStatement(sql_tb_data);
		            result = statement_tb_data.executeQuery();
		            
		            while (result.next()) {
		                int year = result.getInt(1);
		                int week = result.getInt(2);
		                double Absenteeism = result.getDouble(3);
		                double  tabs= result.getDouble(4);

		                // Format the label with the separator "-"
		                String xAxisLabel = String.format("%d-%02d", year, week);

		                // Add data to the series
		                absSeries.getData().add(new XYChart.Data<>(xAxisLabel, Absenteeism));
		                absSeries1.getData().add(new XYChart.Data<>(xAxisLabel, tabs));
		            }
		            d_wee_abs.getData().addAll(absSeries, absSeries1);
		            d_wee_abs.setLegendVisible(false);
		            for (Node bar : d_wee_abs.lookupAll(".series0")) {
		                bar.setStyle("-fx-bar-fill: #1E90FF;"); // Couleur pour la série d'absentéisme
		            }
		            for (Node bar : d_wee_abs.lookupAll(".series1")) {
		                bar.setStyle("-fx-bar-fill: #FF0000;"); // Couleur pour la série d'absentéisme
		            }

		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
	    public void monthlyFA_DT_Split_Per_Area() {
	    	System.out.println("La méthode monthlyFA_DT_Split_Per_Area() est appelée.");
	    	m_area.getData().clear();
	        
	        // Modifier la requête SQL pour regrouper les données par zone et mois
	        String sql_tb_data = "SELECT CONCAT(YEAR(date), '-', MONTH(date)), Area, SUM(DT),SUM(T_DT) " +
	                             "FROM `tb_data` " +
	                             "GROUP BY CONCAT(YEAR(date), '-', MONTH(date)), Area";

	        connection = Database.connectDb();
	        try {
	            // Créer une série pour les données d'absentéisme
	            XYChart.Series absSeries = new XYChart.Series<>();
	            XYChart.Series Series = new XYChart.Series<>();

	            statement_tb_data = connection.prepareStatement(sql_tb_data);
	            result = statement_tb_data.executeQuery();

	            while (result.next()) {
	                // Obtenir le mois et l'année formatés et le nom de la zone
	                String monthYear = result.getString(1);
	                String area = result.getString(2);
	                double sumAbsenteeism = result.getDouble(3);
	                double tdt = result.getDouble(4);
	                // Convertir la chaîne de caractères en un objet Timestamp
	                Timestamp timestamp = Timestamp.valueOf(monthYear + "-01 00:00:00");

	                // Formater la date au format "AVRIL-2024"
	                SimpleDateFormat sdf = new SimpleDateFormat("MMMM-yyyy");
	                String formattedDate = sdf.format(timestamp);

	                // Ajouter les données à la série
	                absSeries.getData().add(new XYChart.Data<>(formattedDate + " - " + area, sumAbsenteeism));
	                Series.getData().add(new XYChart.Data<>(formattedDate + " - " + area, tdt));
	            }

	            // Ajouter la série au graphique
	            m_area.getData().addAll(absSeries,Series);

	            m_area.setLegendVisible(false);

	            // Appliquer la couleur pour la série
	            for (Node bar : m_area.lookupAll(".series0")) {
	                bar.setStyle("-fx-bar-fill: #1E90FF;"); // Couleur pour la série d'absentéisme
	            }
	            for (Node bar : m_area.lookupAll(".series1")) {
	                bar.setStyle("-fx-bar-fill: #FF0000;"); // Couleur pour la série d'absentéisme
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    public void DAILYFA_DT_Split_Per_Area() {
	        d_area.getData().clear();
	        
	        // Modifier la requête SQL pour regrouper les données par zone et mois
	        String sql_tb_data = "SELECT DATE(date), Area, SUM(DT),SUM(T_DT) " +
	                "FROM `tb_data` " +
	                "GROUP BY DATE(date), Area";

	        connection = Database.connectDb();
	        try {
	            // Créer une série pour les données d'absentéisme
	            XYChart.Series absSeries = new XYChart.Series<>();
	            XYChart.Series Series = new XYChart.Series<>();

	            statement_tb_data = connection.prepareStatement(sql_tb_data);
	            result = statement_tb_data.executeQuery();

	            while (result.next()) {
	            	Timestamp timestamp = result.getTimestamp(1);
	                String area = result.getString(2);
	                double sumAbsenteeism = result.getDouble(3);
	                double sumtdt = result.getDouble(4);

	                // Convertir Timestamp en java.util.Date
	                java.util.Date date = new java.util.Date(timestamp.getTime());

	                // Formater la date au format souhaité
	                SimpleDateFormat sdfOutput = new SimpleDateFormat("dd-MMMM-yyyy");
	                String formattedDate = sdfOutput.format(date);

	                // Construire le label avec le format souhaité
	                String yAxisLabel = formattedDate + "-" + area;
	                // Ajouter les données à la série avec le nouveau label
	                absSeries.getData().add(new XYChart.Data<>(yAxisLabel, sumAbsenteeism));
	                Series.getData().add(new XYChart.Data<>(yAxisLabel, sumtdt));
	            }

	            // Ajouter la série au graphique
	            d_area.getData().addAll(absSeries, Series);
	            d_area.setLegendVisible(false);
	            // Appliquer la couleur pour la série
	            for (Node bar : d_area.lookupAll(".series0")) {
	                bar.setStyle("-fx-bar-fill: #1E90FF;"); // Couleur pour la série d'absentéisme
	            }
	            for (Node bar : d_area.lookupAll(".series1")) {
	                bar.setStyle("-fx-bar-fill: #FF0000;"); // Couleur pour la série d'absentéisme
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public void monthlyweeklABS() {
	    	d_wee_avrg.getData().clear();
	    	String sql_tb_data = "SELECT YEAR(date), WEEK(date, 1), AVG(ABSENTEISM), AVG(T_ABS)"
	    	
	    			+ "	   FROM `tb_data` "
	    			+ "	  GROUP BY YEAR(date), WEEK(date, 1) "
	    			+ "	   ORDER BY YEAR(date) DESC, WEEK(date, 1) DESC LIMIT 7";

		        connection = Database.connectDb();
		        try {
		            XYChart.Series absSeries = new XYChart.Series<>();
		            XYChart.Series absSeries1 = new XYChart.Series<>();
		            
		            statement_tb_data = connection.prepareStatement(sql_tb_data);
		            result = statement_tb_data.executeQuery();
		            
		            while (result.next()) {
		                int year = result.getInt(1);
		                int week = result.getInt(2);
		                double avgAbsenteeism = result.getDouble(3);
		                double avgtabs = result.getDouble(4);

		                // Format the label with the separator "-"
		                String xAxisLabel = String.format("%d-%02d", year, week);

		                // Add data to the series
		                absSeries.getData().add(new XYChart.Data<>(xAxisLabel, avgAbsenteeism));
		                absSeries1.getData().add(new XYChart.Data<>(xAxisLabel, avgtabs));
		            }
		            d_wee_avrg.getData().addAll(absSeries, absSeries1);
		            d_wee_avrg.setLegendVisible(false);
		            for (Node bar : d_wee_avrg.lookupAll(".series0")) {
		                bar.setStyle("-fx-bar-fill: #1E90FF;"); // Couleur pour la série d'absentéisme
		            }
		            for (Node bar : d_wee_avrg.lookupAll(".series1")) {
		                bar.setStyle("-fx-bar-fill: #FF0000;"); // Couleur pour la série d'absentéisme
		            }

		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
	    public void monthlyAvgAbs() {
	    	
	    	d_avg.getData().clear();
          String sql_tb_data = "SELECT YEAR(date),  MONTH(date), AVG(ABSENTEISM), AVG(T_ABS) "
	    	+ "	            FROM `tb_data` "
          		+ "	       WHERE DATE >= DATE_SUB(CURDATE(), INTERVAL 7 MONTH) "
          		+ "	              GROUP BY YEAR(date), MONTH(date) "
          		+ "	     ORDER BY YEAR(date) ASC, MONTH(date) ASC";

	        connection = Database.connectDb();
	        try {
	            XYChart.Series chart = new XYChart.Series();
	            XYChart.Series chart1 = new XYChart.Series();
	            statement_tb_data = connection.prepareStatement(sql_tb_data);
	            result = statement_tb_data.executeQuery();
	            while (result.next()) {
	            	int year = result.getInt(1);
	            	int month = result.getInt(2);
	                String formattedMonth = String.format("%02d", month) + "-" + year;
	                chart.getData().add(new XYChart.Data(formattedMonth, result.getDouble(3)));
	                chart1.getData().add(new XYChart.Data<>(formattedMonth, result.getDouble(4)));
	            }
	            
	            d_avg.getData().addAll(chart, chart1);
	            d_avg.setLegendVisible(false);
	            for (Node bar : d_avg.lookupAll(".series0")) {
	                bar.setStyle("-fx-bar-fill: #1E90FF;"); // Couleur pour la première série (Efficiency)
	            }

	            for (Node bar : d_avg.lookupAll(".series1")) {
	                bar.setStyle("-fx-bar-fill: #FF0000;"); // Couleur pour la deuxième série (AnotherColumn)
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
   
	    public void monthlyAvgNoPlannedAbs() {
	    	
                 m_avgnopalnned.getData().clear();
               String sql_tb_data = "SELECT YEAR(date), MONTH(date), AVG(Abs_No_Planned), AVG(T_Abs_NoPlanned) "
                 + "	            FROM `tb_data` "
               		+ "	          GROUP BY YEAR(date), MONTH(date) "
               		+ "	     ORDER BY YEAR(date) ASC, MONTH(date) ASC";

     	        connection = Database.connectDb();
     	        try {
     	            XYChart.Series chart = new XYChart.Series();
     	            XYChart.Series chart1 = new XYChart.Series();
     	            statement_tb_data = connection.prepareStatement(sql_tb_data);
     	            result = statement_tb_data.executeQuery();
     	            while (result.next()) {
     	            	int year = result.getInt(1);
    	            	int month = result.getInt(2);
    	                String formattedMonth = String.format("%02d", month) + "-" + year;
     	                chart.getData().add(new XYChart.Data(formattedMonth, result.getDouble(3)));
     	                chart1.getData().add(new XYChart.Data<>(formattedMonth, result.getDouble(4)));
     	            }
     	            
                    m_avgnopalnned.getData().addAll(chart,chart1);
                    m_avgnopalnned.setLegendVisible(false);
     	            for (Node bar : m_avgnopalnned.lookupAll(".series0")) {
     	                bar.setStyle("-fx-bar-fill: #1E90FF;"); // Couleur pour la première série (Efficiency)
     	            }

     	            for (Node bar : m_avgnopalnned.lookupAll(".series1")) {
     	                bar.setStyle("-fx-bar-fill: #FF0000;"); // Couleur pour la deuxième série (AnotherColumn)
     	            }

     	        } catch (Exception e) {
     	            e.printStackTrace();
     	        }
     	    }
	    

	    public void monthlyweeklnoplanned() {
	        wee_avgnoplanned.getData().clear();
	        
	        // Construction de la requête SQL pour sélectionner les données des 5 dernières semaines
	        String sql_tb_data = "SELECT YEAR(date), WEEK(date, 1), AVG(Abs_No_Planned), AVG(T_Abs_NoPlanned) " +
	                             "FROM `tb_data` " +
	                             "GROUP BY YEAR(date), WEEK(date, 1) " +
	                             "ORDER BY YEAR(date) DESC, WEEK(date, 1) DESC LIMIT 7";

	        connection = Database.connectDb();
	        try {
	            XYChart.Series absSeries = new XYChart.Series<>();
	            XYChart.Series chart1 = new XYChart.Series<>();
	            
	            statement_tb_data = connection.prepareStatement(sql_tb_data);
	            result = statement_tb_data.executeQuery();
	            
	            while (result.next()) {
	                int year = result.getInt(1);
	                int week = result.getInt(2);
	                double avgAbsenteeism = result.getDouble(3);

	                // Formatage du libellé avec le séparateur "-"
	                String xAxisLabel = String.format("%d-%02d", year, week);

	                // Ajout des données à la série
	                absSeries.getData().add(new XYChart.Data<>(xAxisLabel, avgAbsenteeism));
	                chart1.getData().add(new XYChart.Data<>(xAxisLabel, result.getDouble(4)));
	            }
	            
	            // Ajout des séries de données au graphique
	            wee_avgnoplanned.getData().addAll(absSeries, chart1);
	            wee_avgnoplanned.setLegendVisible(false);
	            
	            // Application des styles aux barres du graphique
	            for (Node bar : wee_avgnoplanned.lookupAll(".series0")) {
	                bar.setStyle("-fx-bar-fill: #1E90FF;"); // Couleur pour la série d'absentéisme
	            }
	            for (Node bar : wee_avgnoplanned.lookupAll(".series1")) {
	                bar.setStyle("-fx-bar-fill: #FF0000;"); // Couleur pour la deuxième série
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    private void printTableView(TableView tb_add_data) {
	        PrinterJob printerJob = PrinterJob.createPrinterJob();
	        if (printerJob != null && printerJob.showPrintDialog(tb_add_data.getScene().getWindow())) {
	            PageLayout pageLayout = printerJob.getPrinter().createPageLayout(Paper.A3, PageOrientation.PORTRAIT, Printer.MarginType.DEFAULT);
	            printerJob.getJobSettings().setPageLayout(pageLayout);

	            boolean success = printerJob.printPage(tb_add_data);
	            if (success) {
	                printerJob.endJob();
	            }
	        }
	    }


	    
	    public void addProductsAdd() {
	        String sql_tb_occrate = "INSERT INTO `tb-occrate`(Area, Project, Family, Crew, TL, Sh_Leader, Coordinator, Oc_Rate, date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, NOW())";
	        String sql_tb_data = "INSERT INTO `tb_data`(Plant, Area, Project, Family, Crew, TL, Sh_Leader, Coordinator, Output, T_ABS, DT, ABSENTEISM, Prod_H, Payed_H, ME, Efficiency, T_Efficiency, HC, T_HC, WSD, T_WSD, Oc_Rate, T_DT, Abs_No_Planned,T_Abs_NoPlanned, date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?, NOW())";
	        String sql_eff_tb = "INSERT INTO tb_eff(Area, Project, Family, Crew, TL, Sh_Leader, Coordinator, Output, ME, T_Efficiency, Efficiency, T_HC, HC, T_WSD, WSD, date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW())";

	        try {
	            connection = Database.connectDb();
	            connection.setAutoCommit(false); // Démarre la transaction

	            // Vérifier si le crew existe déjà
	            String existingCrewQuery = "SELECT COUNT(*) FROM tb_data WHERE Crew = ?";
	            PreparedStatement existingCrewStatement = connection.prepareStatement(existingCrewQuery);
	            existingCrewStatement.setString(1, crew.getText());
	            ResultSet existingCrewResult = existingCrewStatement.executeQuery();
	            existingCrewResult.next();
	            int rowCount = existingCrewResult.getInt(1);

	            if (rowCount > 0) {
	                // Le crew existe déjà, afficher un message d'erreur et arrêter le processus
	                Alert alert = new Alert(Alert.AlertType.ERROR);
	                alert.setTitle("Erreur");
	                alert.setHeaderText(null);
	                alert.setContentText("Le crew existe déjà.");
	                alert.showAndWait();
	                return;
	            }

	            // Préparer la requête pour tb_data
	            PreparedStatement statement_tb_data = connection.prepareStatement(sql_tb_data);
	            statement_tb_data.setString(1, "M5");
	            statement_tb_data.setString(2, area.getText());
	            statement_tb_data.setString(3, project.getText());
	            statement_tb_data.setString(4, family.getText());
	            statement_tb_data.setString(5, crew.getText());
	            statement_tb_data.setString(6, tl.getText());
	            statement_tb_data.setString(7, shleader.getText());
	            statement_tb_data.setString(8, coordinator.getText());
	            statement_tb_data.setString(9, output.getText().isEmpty() ? null : output.getText());
	            statement_tb_data.setString(10, uptime.getText().isEmpty() ? null : uptime.getText());
	            statement_tb_data.setString(11, dt.getText().isEmpty() ? null : dt.getText());
	            statement_tb_data.setString(12, absenteism.getText().isEmpty() ? null : absenteism.getText());
	            statement_tb_data.setString(13, prod.getText().isEmpty() ? null : prod.getText());
	            statement_tb_data.setString(14, payed.getText().isEmpty() ? null : payed.getText());
	            statement_tb_data.setString(15, me.getText().isEmpty() ? null : me.getText());
	            statement_tb_data.setString(16, efficiencyy.getText().isEmpty() ? null : efficiencyy.getText());
	            statement_tb_data.setString(17, tefficiency.getText().isEmpty() ? null : tefficiency.getText());
	            statement_tb_data.setString(18, hc.getText().isEmpty() ? null : hc.getText());
	            statement_tb_data.setString(19, thc.getText().isEmpty() ? null : thc.getText());
	            statement_tb_data.setString(20, wsd.getText().isEmpty() ? null : wsd.getText());
	            statement_tb_data.setString(21, twsd.getText().isEmpty() ? null : twsd.getText());
	            statement_tb_data.setString(22, occrate.getText().isEmpty() ? null : occrate.getText());
	            statement_tb_data.setString(23, tdt.getText().isEmpty() ? null : tdt.getText());
	            statement_tb_data.setString(24, absnop.getText().isEmpty() ? null : absnop.getText());
	            statement_tb_data.setString(25, tabsnopla.getText().isEmpty() ? null : tabsnopla.getText());

	            // Exécuter la requête pour tb_data
	            statement_tb_data.executeUpdate();

	            // Préparer la requête pour eff_tb
	            PreparedStatement statement_eff_tb = connection.prepareStatement(sql_eff_tb);
	            statement_eff_tb.setString(1, area.getText());
	            statement_eff_tb.setString(2, project.getText());
	            statement_eff_tb.setString(3, family.getText());
	            statement_eff_tb.setString(4, crew.getText());
	            statement_eff_tb.setString(5, tl.getText());
	            statement_eff_tb.setString(6, shleader.getText());
	            statement_eff_tb.setString(7, coordinator.getText());
	            statement_eff_tb.setString(8, output.getText().isEmpty() ? null : output.getText());
	            statement_eff_tb.setString(9, me.getText().isEmpty() ? null : me.getText());
	            statement_eff_tb.setString(10, tefficiency.getText().isEmpty() ? null : tefficiency.getText());
	            statement_eff_tb.setString(11, efficiencyy.getText().isEmpty() ? null : efficiencyy.getText());
	            statement_eff_tb.setString(12, thc.getText().isEmpty() ? null : thc.getText());
	            statement_eff_tb.setString(13, hc.getText().isEmpty() ? null : hc.getText());
	            statement_eff_tb.setString(14, twsd.getText().isEmpty() ? null : twsd.getText());
	            statement_eff_tb.setString(15, wsd.getText().isEmpty() ? null : wsd.getText());

	            statement_eff_tb.executeUpdate();

	            // Préparer la requête pour tb-occrate
	            PreparedStatement statement_occrate = connection.prepareStatement(sql_tb_occrate);
	            statement_occrate.setString(1, area.getText());
	            statement_occrate.setString(2, project.getText());
	            statement_occrate.setString(3, family.getText());
	            statement_occrate.setString(4, crew.getText());
	            statement_occrate.setString(5, tl.getText());
	            statement_occrate.setString(6, shleader.getText());
	            statement_occrate.setString(7, coordinator.getText());
	            statement_occrate.setString(8, occrate.getText().isEmpty() ? null : occrate.getText());

	            statement_occrate.executeUpdate();

	            connection.commit();
	            // Réinitialiser les champs de texte
	            addProductsReset();

	            // Actualiser les données dans les tableaux
	            addProductsShowListData();
	            addProductsShowListData1();
	            addProductsShowListData2();

	            // Afficher un message de succès
	            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
	            successAlert.setTitle("Succès");
	            successAlert.setHeaderText(null);
	            successAlert.setContentText("Données ajoutées avec succès.");
	            successAlert.showAndWait();

	        } catch (SQLException e) {
	            efficiencyy.setText("");
	            // En cas d'erreur, annuler la transaction
	            if (connection != null) {
	                try {
	                    connection.rollback();
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
	            }
	            e.printStackTrace();
	            // Afficher un message d'erreur
	            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
	            errorAlert.setTitle("Erreur");
	            errorAlert.setHeaderText(null);
	            errorAlert.setContentText("Une erreur s'est produite lors de l'ajout des données.");
	            errorAlert.showAndWait();
	        } finally {
	            // Fermer les ressources
	            if (connection != null) {
	                try {
	                    connection.setAutoCommit(true);
	                    connection.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }




	    
	    public void addProductUpdate() {
	    	
	        

	    String sql = "UPDATE `tb_data` SET Project= '"+project.getText()
			+"', Family= '"+family.getText()
			+"', Area= '"+area.getText()
			+"', TL= '"+tl.getText()
			+"', Sh_Leader= '"+shleader.getText()
			+"', Coordinator= '"+coordinator.getText()
			+"', Output= '"+output.getText()
			+"', T_ABS= '"+uptime.getText()
			+"', DT= '"+dt.getText()
			+"', ABSENTEISM= '"+absenteism.getText()
			+"', Prod_H= '"+prod.getText()
			+"', Payed_H= '"+payed.getText()
			+"', ME= '"+me.getText()
			+"', Efficiency= '"+efficiencyy.getText()
			+"', T_Efficiency= '"+tefficiency.getText()
			+"', HC= '"+hc.getText()
			+"', t_HC= '"+thc.getText()
			+"', WSD= '"+wsd.getText()
			+"', T_WSD= '"+twsd.getText()
			+"', Oc_Rate= '"+occrate.getText()
			+"', T_DT= '"+tdt.getText()
			+ "',  Abs_NO_Planned= '"+absnop.getText()
			+"',  T_Abs_NoPlanned= '"+tabsnopla.getText()
			+ "	',date= CURRENT_TIMESTAMP WHERE Crew= '"+crew.getText()+"'";
	    
	    String sql_eff_tb = "UPDATE tb_eff SET  Family= '"+family.getText()
		+"', Area= '"+area.getText()
		+"', TL= '"+tl.getText()
		+"', Sh_Leader= '"+shleader.getText()
		+"', Coordinator= '"+coordinator.getText()
		+"', Output= '"+output.getText()
		+"',ME= '"+me.getText()
		+"', Efficiency= '"+efficiencyy.getText()
		+"', T_Efficiency= '"+tefficiency.getText()
		+"', T_HC= '"+thc.getText()
		+"', HC= '"+hc.getText()
		+"', T_WSD= '"+twsd.getText()
		+"', WSD= '"+wsd.getText()
		+"',date= CURRENT_TIMESTAMP WHERE Crew= '"+crew.getText()+"'";
	    
	    String sql_tb_occrate = "UPDATE `tb-occrate` SET  Area= '"+area.getText()
	    +"', Project= '"+project.getText()
		+"', Family= '"+family.getText()
		+"',TL= '"+tl.getText()
		+"', Sh_Leader= '"+shleader.getText()
		+"', Coordinator= '"+coordinator.getText()
		+"',  Oc_Rate= '"+occrate.getText()
	    +"' , date= CURRENT_TIMESTAMP WHERE Crew= '"+crew.getText()+ "'";
	   
	    	try {
	    		connection = Database.connectDb();
	    		
	    		
	    		 if ( area.getText().isEmpty() 
		            		|| project.getText().isEmpty() 
		            		|| family.getText().isEmpty() 
		            		|| crew.getText().isEmpty() 
		            		|| tl.getText().isEmpty() 
		            		|| shleader.getText().isEmpty() 
		            		|| coordinator.getText().isEmpty() 
		            		|| output.getText().isEmpty() 
		            		|| uptime.getText().isEmpty()
		            		|| dt.getText().isEmpty() 
		            		|| absenteism.getText().isEmpty() 
		            		|| prod.getText().isEmpty()
		            		|| payed.getText().isEmpty() 
		            		|| me.getText().isEmpty() 
		            		|| efficiencyy.getText().isEmpty() 
		            		|| tefficiency.getText().isEmpty() 
		            		|| hc.getText().isEmpty()
		            		|| thc.getText().isEmpty() 
		            		|| wsd.getText().isEmpty() 
		            		|| twsd.getText().isEmpty()
		            		||occrate.getText().isEmpty()
		            		||tdt.getText().isEmpty()
		            		||absnop.getText().isEmpty()
		            		||tabsnopla.getText().isEmpty()) {
		                Alert alert = new Alert(AlertType.ERROR);
		                alert.setTitle("Erreur");
		                alert.setHeaderText(null);
		                alert.setContentText("Veuillez remplir tous les champs.");
		                alert.showAndWait();
		            } else {
		            	   Alert alert = new Alert(AlertType.CONFIRMATION);
			                alert.setTitle("Confirmation Message");
			                alert.setHeaderText(null);
			                alert.setContentText("are you sure to want Crew : "+crew.getText() +"?");
			              Optional<ButtonType> option = alert.showAndWait();
			              
			              if(option.get().equals(ButtonType.OK)) {
			            	  statement = connection.createStatement();
			            	  statement.executeUpdate(sql);
			            	  statement.executeUpdate(sql_eff_tb);
			            	  statement.executeUpdate(sql_tb_occrate);
					                alert = new Alert(AlertType.INFORMATION);
					                alert.setTitle("Information Message");
					                alert.setHeaderText(null);
					                alert.setContentText("Successfully areaed");
					                alert.showAndWait();
					                
				     	               addProductsShowListData1();

					                addProductsShowListData();
					                addProductsReset();
			              }
		            	
		            }
	    		
	    		 
	    		
	    	}catch(Exception e) {e.printStackTrace();}
	    }
	    public void addProductDelete() {
	        String sql_tb_data = "DELETE FROM  tb_eff WHERE Crew= '" + crew.getText() + "'";
	        String sql_eff_tb = "DELETE FROM  `tb_data` WHERE Crew= '" + crew.getText() + "'";
	        String sql_tb_occrate = "DELETE FROM  `tb-occrate` WHERE Crew= '" + crew.getText() + "'";
	        
	        try {
	            connection = Database.connectDb();
	            
	            if ( area.getText().isEmpty() 
	                    || project.getText().isEmpty() 
	                    || family.getText().isEmpty() 
	                    || crew.getText().isEmpty() 
	                    || tl.getText().isEmpty() 
	                    || shleader.getText().isEmpty() 
	                    || coordinator.getText().isEmpty() 
	                    || output.getText().isEmpty() 
	                    || absenteism.getText().isEmpty() 
	                    || prod.getText().isEmpty() 
	                    || dt.getText().isEmpty() 
	                    || payed.getText().isEmpty() 
	                    || uptime.getText().isEmpty()
	                    || me.getText().isEmpty() 
	                    || tefficiency.getText().isEmpty() 
	                    || efficiencyy.getText().isEmpty() 
	                    || thc.getText().isEmpty() 
	                    || hc.getText().isEmpty() 
	                    || wsd.getText().isEmpty() 
	                    || twsd.getText().isEmpty()
	                    || occrate.getText().isEmpty()
	                    || tdt.getText().isEmpty()
	                    ||absnop.getText().isEmpty()
			            ||tabsnopla.getText().isEmpty()) {
	                Alert alert = new Alert(AlertType.ERROR);
	                alert.setTitle("Erreur");
	                alert.setHeaderText(null);
	                alert.setContentText("Veuillez remplir tous les champs.");
	                alert.showAndWait();
	            } else {
	                Alert alert = new Alert(AlertType.CONFIRMATION);
	                alert.setTitle("Confirmation Message");
	                alert.setHeaderText(null);
	                alert.setContentText("are you sure to want Delete : " + crew.getText() + "?");
	                Optional<ButtonType> option = alert.showAndWait();
	                
	                if (option.get().equals(ButtonType.OK)) {
	                    Statement statement = connection.createStatement();
	                    statement.executeUpdate(sql_tb_data);
	                    statement.executeUpdate(sql_eff_tb);
	                    statement.executeUpdate(sql_tb_occrate);
	                    
	                    alert = new Alert(AlertType.INFORMATION);
	                    alert.setTitle("Information Message");
	                    alert.setHeaderText(null);
	                    alert.setContentText("Successfully Deleted");
	                    alert.showAndWait();
	                    
	                    addProductsShowListData1();
	                    addProductsShowListData2();
	                    addProductsShowListData();
	                    addProductsSelect();
	                    addProductsReset();
	                }
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Fermer la connexion
	            try {
	                if (connection != null) {
	                    connection.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }


	   public void addProductsReset() {
		   //effList();
	    	
	    	 area.setText("");
	    	 project.setText("");
	    	 family.setText("");
	    	 crew.setText("");
	    	 tl.setText("");
	    	shleader.setText("");
	    	 coordinator.setText("");
	    	 output.setText("");
	    	 absenteism.setText("");
	    	prod.setText("");
	    	 dt.setText("");
	    	payed.setText("");
	    	 uptime.setText("");
	    	me.setText("");
	    	 tefficiency.setText("");
	    	efficiencyy.setText("");
	    	 thc.setText("");
	    	 hc.setText("");
	    	 twsd.setText("");
	    	 wsd.setText("");
	    	occrate.setText("");
	    	tdt.setText("");
	    	absnop.setText("");
	    	tabsnopla.setText("");
	    	 
	    }
	    public void addProductSearch() {
	            FilteredList<Dataproduct> filter = new FilteredList<>(addProductsList, e -> true);
	    	    data_search.textProperty().addListener((observable, oldValue, newValue)->{
	    		filter.setPredicate(predicateDataproduct ->{
	    			if(newValue == null || newValue.isEmpty()) { 
	    				return true;
	    			}
	    			String searchkey =newValue.toLowerCase();
	    			if(predicateDataproduct.getArea().toLowerCase
	    					().contains(searchkey)) {
	    				return true;
	    			}else if (predicateDataproduct.getProject().toLowerCase().contains(searchkey)){
	    				return true;
	    				
	    			}else if (predicateDataproduct.getFamily().toLowerCase().contains(searchkey)){
	    				return true;
	    				
	    			}
	    			else if (predicateDataproduct.getCrew().toLowerCase().contains(searchkey)){
	    				return true;
	    				
	    			}
	    			else if (predicateDataproduct.getTL().toLowerCase().contains(searchkey)){
	    				return true;
	    				
	    			}
	    			else if (predicateDataproduct.getSh_Leader().toLowerCase().contains(searchkey)){
	    				return true;
	    				
	    			}
	    			else if (predicateDataproduct.getCoordinator().toLowerCase().contains(searchkey)){
	    				return true;
	    				
	    			} else if (predicateDataproduct.getDate().toString().toLowerCase().contains(searchkey)) {
	                    return true; // Ajoutez cette condition pour rechercher par date
	                }
	    			return false;
	    			
	    			
	    			
	    		});
	    	});
	    	
	    	SortedList<Dataproduct> sortList = new SortedList<>(filter);
	    	sortList.comparatorProperty().bind(tb_add_data.comparatorProperty());
	    	
	    	tb_add_data.setItems(sortList);
	    	
	    }
	    
	    public void addProductSearch2() {
            FilteredList<Occrate> filter2 = new FilteredList<>(addProductsListtt, e -> true);
            occ_search.textProperty().addListener((observable, oldValue, newValue)->{
    		filter2.setPredicate(predicateOccrate ->{
    			if(newValue == null || newValue.isEmpty()) { 
    				return true;
    			}
    			String searchkey =newValue.toLowerCase();
    			if(predicateOccrate.getArea().toLowerCase
    					().contains(searchkey)) {
    				return true;
    			}else if (predicateOccrate.getProject().toLowerCase().contains(searchkey)){
    				return true;
    				
    			}else if (predicateOccrate.getFamily().toLowerCase().contains(searchkey)){
    				return true;
    				
    			}
    			else if (predicateOccrate.getCrew().toLowerCase().contains(searchkey)){
    				return true;
    				
    			}
    			else if (predicateOccrate.getTL().toLowerCase().contains(searchkey)){
    				return true;
    				
    			}
    			else if (predicateOccrate.getSh_Leader().toLowerCase().contains(searchkey)){
    				return true;
    				
    			}
    			else if (predicateOccrate.getCoordinator().toLowerCase().contains(searchkey)){
    				return true;
    				
    			}
    			else if (predicateOccrate.getDate().toString().toLowerCase().contains(searchkey)){
    				return true;
    			}return false;
    			
    			
    		});
    	});
    	
    	SortedList<Occrate> sortListtt = new SortedList<>(filter2);
    	sortListtt.comparatorProperty().bind(tb_occ.comparatorProperty());
    	
    	tb_occ.setItems(sortListtt);
    	
    }
    
	    public void addProductSearch1() {
	        FilteredList<Effproduct> filter1 = new FilteredList<>(addProductsListt, e -> true);

	        data_search1.textProperty().addListener((observable, oldValue, newValue) -> {
	            filter1.setPredicate(predicateEffproduct -> {
	                if (newValue == null || newValue.isEmpty()) {
	                    return true;
	                }
	                String searchKey = newValue.toLowerCase();
	                return predicateEffproduct.getArea().toLowerCase().contains(searchKey)
	                        || predicateEffproduct.getProject().toLowerCase().contains(searchKey)
	                        || predicateEffproduct.getFamily().toLowerCase().contains(searchKey)
	                        || predicateEffproduct.getCrew().toLowerCase().contains(searchKey)
	                        || predicateEffproduct.getTL().toLowerCase().contains(searchKey)
	                        || predicateEffproduct.getSh_Leader().toLowerCase().contains(searchKey)
	                        || predicateEffproduct.getCoordinator().toLowerCase().contains(searchKey)
	                        || predicateEffproduct.getDate().toString().toLowerCase().contains(searchKey);
	            });
	        });

	        SortedList<Effproduct> sortedListt = new SortedList<>(filter1);
	        sortedListt.comparatorProperty().bind(eff_tb.comparatorProperty());

	        // Rendez chaque colonne triable
	        eff_tb.getColumns().forEach(column -> column.setSortable(true));

	        // Ajoutez un écouteur pour gérer le tri lorsque l'utilisateur clique sur l'en-tête de colonne
	        eff_tb.getSortOrder().addListener((ListChangeListener<TableColumn<Effproduct, ?>>) change -> {
	            while (change.next()) {
	                if (change.wasAdded()) {
	                    TableColumn<Effproduct, ?> column = change.getAddedSubList().get(0);
	                    eff_tb.sort();
	                }
	            }
	        });

	        eff_tb.setItems(sortedListt);
	    }
	    
	    public ObservableList<Occrate> addProductsListData2() {
	    	//ffList();
	        ObservableList<Occrate> productListtt = FXCollections.observableArrayList();
	       
	        String sql_tb_occrate = "SELECT * FROM `tb-occrate`";
	        connection = Database.connectDb();
	        try {
	        	 
	        	statement_occrate = connection.prepareStatement(sql_tb_occrate);
	            result3 = statement_occrate.executeQuery();
	            Occrate prodIDd;
	            while (result3.next()) {
	                prodIDd = new Occrate(
	                        result3.getString("Area")
	                        ,result3.getString("Project")
	                        ,result3.getString("Family")
	                        ,result3.getString("Crew")
	                        ,result3.getString("TL")
	                        ,result3.getString("Sh_Leader")
	                        ,result3.getString("Coordinator")
	                       ,result3.getDouble("Oc_Rate")                
	                        ,result3.getTimestamp ("date"));
	                    
	                productListtt.add(prodIDd);
	            }
	            
	        } catch (Exception e) {e.printStackTrace(); }
	        
	        return productListtt;
	    }
	    
	    
	    

	    public ObservableList<Dataproduct> addProductsListData() {
	    	//ffList();
	        ObservableList<Dataproduct> productList = FXCollections.observableArrayList();
	       
	        String sql_tb_data = "SELECT * FROM tb_data";
	        connection = Database.connectDb();
	        try {
	        	 
	        	statement_tb_data = connection.prepareStatement(sql_tb_data);
	            result = statement_tb_data.executeQuery();
	            Dataproduct prodID;
	            while (result.next()) {
	                prodID = new Dataproduct(result.getString("Plant")
	                        ,result.getString("Area")
	                        ,result.getString("Project")
	                        ,result.getString("Family")
	                        ,result.getString("Crew")
	                        ,result.getString("TL")
	                        ,result.getString("Sh_Leader")
	                        ,result.getString("Coordinator")
	                        ,result.getDouble("Output")
	                        ,result.getDouble("Efficiency")
	                        ,result.getDouble("T_Efficiency")
	                        ,result.getDouble("Prod_H")
	                        ,result.getDouble("Payed_H")
	                        ,result.getDouble("ABSENTEISM")
	                        ,result.getDouble("ME")
	                        ,result.getDouble("T_ABS")
	                        ,result.getDouble("DT")
	                       ,result.getDouble("HC")
                            ,result.getDouble("T_HC") 
                            ,result.getDouble("WSD")
	                        ,result.getDouble("T_WSD")
	                        ,result.getDouble("Oc_Rate")
	                        ,result.getDouble("T_DT")                
	                        ,result.getDouble("Abs_No_Planned")
	                        ,result.getDouble("T_Abs_NoPlanned") 
	                        ,result.getTimestamp ("date"));
	                    
	                productList.add(prodID);
	            }
	            
	        } catch (Exception e) {e.printStackTrace(); }
	        
	        return productList;
	    }

	    public ObservableList<Effproduct> addProductsListData1() {
	    	//ffList();
	        ObservableList<Effproduct> productListt = FXCollections.observableArrayList();
	       
	        String sql_eff_tb = "SELECT * FROM tb_eff";
	        connection = Database.connectDb();
	        
	        try {
	        	 
	        	statement_eff_tb = connection.prepareStatement(sql_eff_tb);
	            result2 = statement_eff_tb.executeQuery();
	            Effproduct prodIDD;
	            while (result2.next()) {
	                prodIDD = new Effproduct(result2.getString("Area")
	                        ,result2.getString("Project")
	                        ,result2.getString("Family")
	                        ,result2.getString("Crew")
	                        ,result2.getString("TL")
	                        ,result2.getString("Sh_Leader")
	                        ,result2.getString("Coordinator")
	                        ,result2.getDouble("Output")
	                        ,result2.getDouble("ME")
	                        ,result2.getDouble("T_Efficiency")
	                        ,result2.getDouble("Efficiency")
	                        ,result2.getDouble("T_HC")
	                        ,result2.getDouble("HC")
	                        ,result2.getDouble("T_WSD")
	                        ,result2.getDouble("WSD")
	                        ,result2.getTimestamp("date")
	                        );                
	                //,result.getTimestamp ("date"));
	                    
	                productListt.add(prodIDD);
	            }
	            
	        } catch (Exception e) {e.printStackTrace(); }
	        
	        return productListt;
	    }
	    
	    private ObservableList<Occrate> addProductsListtt;
	    public void addProductsShowListData2() {
	    	
	    	    addProductsListtt = addProductsListData2();
	    	    sortByDateDescending2(addProductsListtt);

	    	    occ_area.setCellValueFactory(new PropertyValueFactory<>("Area"));
	    	    occ_projet.setCellValueFactory(new PropertyValueFactory<>("Project"));
	    	    occ_family.setCellValueFactory(new PropertyValueFactory<>("Family"));
	    	    occ_crew.setCellValueFactory(new PropertyValueFactory<>("Crew"));
	    	    occ_tl.setCellValueFactory(new PropertyValueFactory<>("TL"));
	    	    occ_sh.setCellValueFactory(new PropertyValueFactory<>("Sh_Leader"));
	    	    occ_coo.setCellValueFactory(new PropertyValueFactory<>("Coordinator"));
	    	    occ_rate.setCellValueFactory(cellData -> {
		            Double efficiency = cellData.getValue().getOc_Rate();
		            if (efficiency != null) {
		                String formattedEfficiency = String.format("%.2f%%", efficiency);
		                return new SimpleStringProperty(formattedEfficiency);
		            } else {
		                return new SimpleStringProperty("");
		            }
		        });
	    	    occ_date.setCellValueFactory(new PropertyValueFactory<>("date"));
	    	    tb_occ.setItems(addProductsListtt);
		       
	    }
	    
	    private ObservableList<Effproduct> addProductsListt;
	    public void addProductsShowListData1() {
	    	
	    	    addProductsListt = addProductsListData1();
	    	    sortByDateDescending1(addProductsListt);
	    	    data_area1.setCellValueFactory(new PropertyValueFactory<>("Area"));
		        data_project1.setCellValueFactory(new PropertyValueFactory<>("Project"));
		        data_family1.setCellValueFactory(new PropertyValueFactory<>("Family"));
		        data_crew1.setCellValueFactory(new PropertyValueFactory<>("Crew"));
		        data_tl1.setCellValueFactory(new PropertyValueFactory<>("TL"));
		        data_shleader1.setCellValueFactory(new PropertyValueFactory<>("Sh_Leader"));
		        data_coordinator1.setCellValueFactory(new PropertyValueFactory<>("Coordinator"));
		        data_output1.setCellValueFactory(new PropertyValueFactory<>("Output"));
		        data_me1.setCellValueFactory(new PropertyValueFactory<>("ME"));
		        data_tefficiency1.setCellValueFactory(cellData -> {
		            Double efficiency = cellData.getValue().getT_Efficiency();
		            if (efficiency != null) {
		                String formattedEfficiency = String.format("%.2f%%", efficiency);
		                return new SimpleStringProperty(formattedEfficiency);
		            } else {
		                return new SimpleStringProperty("");
		            }
		        });
		        data_efficiency1.setCellValueFactory(cellData -> {
		            Double efficiency = cellData.getValue().getEfficiency();
		            if (efficiency != null) {
		                String formattedEfficiency = String.format("%.2f%%", efficiency);
		                return new SimpleStringProperty(formattedEfficiency);
		            } else {
		                return new SimpleStringProperty("");
		            }
		        });
		        data_thc1.setCellValueFactory(new PropertyValueFactory<>("T_HC"));
		        data_hc1.setCellValueFactory(new PropertyValueFactory<>("HC"));
		        data_twsd1.setCellValueFactory(new PropertyValueFactory<>("T_WSD"));
		        data_wsd1.setCellValueFactory(new PropertyValueFactory<>("WSD"));
		        eff_date.setCellValueFactory(new PropertyValueFactory<>("date"));
		        addProductSearch1();
		        eff_tb.setItems(addProductsListt);
		       
	    }
	    private void sortByDateDescending2(ObservableList<Occrate> list) {
	        list.sort(Comparator.comparing(Occrate::getDate).reversed());
	    }
	    private void sortByDateDescending1(ObservableList<Effproduct> list) {
	        list.sort(Comparator.comparing(Effproduct::getDate).reversed());
	    }
	    private void sortByDateDescending(ObservableList<Dataproduct> list) {
	        list.sort(Comparator.comparing(Dataproduct::getDate).reversed());
	    }

	    private ObservableList<Dataproduct> addProductsList;
	    
	    public void addProductsShowListData() {
	        
	        addProductsList = addProductsListData();
	        sortByDateDescending(addProductsList);
	        data_plant.setCellValueFactory(new PropertyValueFactory<>("Plant"));
	        data_area.setCellValueFactory(new PropertyValueFactory<>("Area"));
	        data_project.setCellValueFactory(new PropertyValueFactory<>("Project"));
	        data_family.setCellValueFactory(new PropertyValueFactory<>("Family"));
	        data_crew.setCellValueFactory(new PropertyValueFactory<>("Crew"));
	        data_tl.setCellValueFactory(new PropertyValueFactory<>("TL"));
	        data_shleader.setCellValueFactory(new PropertyValueFactory<>("Sh_Leader"));
	        data_coordinator.setCellValueFactory(new PropertyValueFactory<>("Coordinator"));
	        data_output.setCellValueFactory(new PropertyValueFactory<>("Output"));
	       data_efficiency.setCellValueFactory(cellData -> {
	            Double efficiency = cellData.getValue().getEfficiency();
	            if (efficiency != null) {
	                String formattedEfficiency = String.format("%.2f%%", efficiency);
	                return new SimpleStringProperty(formattedEfficiency);
	            } else {
	                return new SimpleStringProperty("");
	            }
	        });
	       data_tefficiency.setCellValueFactory(cellData -> {
	            Double efficiency = cellData.getValue().getT_Efficiency();
	            if (efficiency != null) {
	                String formattedEfficiency = String.format("%.2f%%", efficiency);
	                return new SimpleStringProperty(formattedEfficiency);
	            } else {
	                return new SimpleStringProperty("");
	            }
	        });
	        data_prod.setCellValueFactory(new PropertyValueFactory<>("Prod_H"));
	        data_payed.setCellValueFactory(new PropertyValueFactory<>("Payed_H"));
	        data_absenteism.setCellValueFactory(cellData -> {
	            Double efficiency = cellData.getValue().getABSENTEISM();
	            if (efficiency != null) {
	                String formattedEfficiency = String.format("%.2f%%", efficiency);
	                return new SimpleStringProperty(formattedEfficiency);
	            } else {
	                return new SimpleStringProperty("");
	            }
	        });
	        data_me.setCellValueFactory(new PropertyValueFactory<>("ME"));
	        data_uptime.setCellValueFactory(cellData -> {
	            Double efficiency = cellData.getValue().getT_ABS();
	            if (efficiency != null) {
	                String formattedEfficiency = String.format("%.2f%%", efficiency);
	                return new SimpleStringProperty(formattedEfficiency);
	            } else {
	                return new SimpleStringProperty("");
	            }
	        });
	        data_dt.setCellValueFactory(new PropertyValueFactory<>("DT"));
	        data_hc.setCellValueFactory(new PropertyValueFactory<>("HC"));
	        data_thc.setCellValueFactory(new PropertyValueFactory<>("T_HC"));
	        data_wsd.setCellValueFactory(new PropertyValueFactory<>("WSD"));
	        data_twsd.setCellValueFactory(new PropertyValueFactory<>("T_WSD"));
	        data_occrate.setCellValueFactory(cellData -> {
	            Double efficiency = cellData.getValue().getOc_Rate();
	            if (efficiency != null) {
	                String formattedEfficiency = String.format("%.2f%%", efficiency);
	                return new SimpleStringProperty(formattedEfficiency);
	            } else {
	                return new SimpleStringProperty("");
	            }
	        });
	        data_tdt.setCellValueFactory(new PropertyValueFactory<>("T_DT"));
	        data_absno.setCellValueFactory(cellData -> {
	            Double efficiency = cellData.getValue().getAbs_No_Planned();
	            if (efficiency != null) {
	                String formattedEfficiency = String.format("%.2f%%", efficiency);
	                return new SimpleStringProperty(formattedEfficiency);
	            } else {
	                return new SimpleStringProperty("");
	            }
	        });
	        data_tabsno.setCellValueFactory(cellData -> {
	            Double efficiency = cellData.getValue().getT_Abs_NoPlanned();
	            if (efficiency != null) {
	                String formattedEfficiency = String.format("%.2f%%", efficiency);
	                return new SimpleStringProperty(formattedEfficiency);
	            } else {
	                return new SimpleStringProperty("");
	            }
	        });
	        data_date.setCellValueFactory(new PropertyValueFactory<>("date"));
	        
	     
	        tb_add_data.setItems(addProductsList);
	        //addProductsSelect();
	    }
	    // Méthode pour initialiser le TableView
	    private void addProductsSelect() {
	    	//effList();
	        // Configurez votre TableView, par exemple
	        tb_add_data.setOnMouseClicked(event -> {
	            // Récupérez l'élément sélectionné dans le TableView
	            Dataproduct prodID = tb_add_data.getSelectionModel().getSelectedItem();
	            int num = tb_add_data.getSelectionModel().getSelectedIndex();
                 if((num -1) < -1) {return;}
	           
		    	area.setText(prodID.getArea());
		    	project.setText(prodID.getProject());
		    	family.setText(prodID.getFamily());
		    	crew.setText(prodID.getCrew());
		    	tl.setText(prodID.getTL());
		    	shleader.setText(prodID.getSh_Leader());
		    	coordinator.setText(prodID.getCoordinator());
		    	output.setText(String.valueOf(prodID.getOutput()));
		    	uptime.setText(String.valueOf(prodID.getT_ABS()));
		    	dt.setText(String.valueOf(prodID.getDT()));
		    	absenteism.setText(String.valueOf(prodID.getABSENTEISM()));
		    	prod.setText(String.valueOf(prodID.getProd_H()));
		    	payed.setText(String.valueOf(prodID.getPayed_H()));
		    	me.setText(String.valueOf(prodID.getME()));
		    	efficiencyy.setText(String.valueOf(prodID.getEfficiency()));
		    	tefficiency.setText(String.valueOf(prodID.getT_Efficiency()));
		    	hc.setText(String.valueOf(prodID.getHC()));
		    	thc.setText(String.valueOf(prodID.getT_HC()));
		    	wsd.setText(String.valueOf(prodID.getWSD()));
		    	twsd.setText(String.valueOf(prodID.getT_WSD()));
		    	occrate.setText(String.valueOf(prodID.getOc_Rate()));
		    	absnop.setText(String.valueOf(prodID.getAbs_No_Planned()));
		    	tabsnopla.setText(String.valueOf(prodID.getT_Abs_NoPlanned()));
		    	tdt.setText(String.valueOf(prodID.getT_DT()));
	            
	        });
	    }
	

	    
	    public void switchForm(ActionEvent event) {
	        if(event.getSource() == data) {
	            System.out.println("Switching to add data form...");
	            data_form.setVisible(true);
	            eff_form.setVisible(false);
	            dt_form.setVisible(false);
	            occ_form.setVisible(false);
	            daily_form.setVisible(false);
	            monthly_premier.setVisible(false);
	            test_button.setVisible(false);
	            troix_monthly.setVisible(false);
	            saisie_form.setVisible(false);
	            zwsd.setVisible(false);
	   	    	zdt.setVisible(false);
	   	    	zabsno.setVisible(false);
	   	    	zabs.setVisible(false);
	   	    	zhc.setVisible(false);
	   	    	ztabs.setVisible(false);
	   	    	zooccrate.setVisible(false);
	   	    	 zooutput.setVisible(false);
	   	           zeff.setVisible(false);
	            data.setStyle("-fx-background-color: linear-gradient(to bottom right, #466be4,#6b7aeb)");
	            efficiency.setStyle("-fx-background-color: transparent");
	            downtime.setStyle("-fx-background-color: transparent");
	            button_occ.setStyle("-fx-background-color: transparent");
	            daily_kpis.setStyle("-fx-background-color: transparent");
	            monthly_kpis.setStyle("-fx-background-color: transparent");
	            
	            addProductsShowListData();
	            addProductSearch();
	            //printTableView(tb_add_data);
	           
	        } else if (event.getSource() == efficiency) {
	            System.out.println("Switching to efficiency form...");
	            data_form.setVisible(false);
	            eff_form.setVisible(true);
	            dt_form.setVisible(false);
	            occ_form.setVisible(false);
	            daily_form.setVisible(false);
	            monthly_premier.setVisible(false);
	            test_button.setVisible(false);
	            troix_monthly.setVisible(false);
	            saisie_form.setVisible(false);
	            zwsd.setVisible(false);
	   	    	zdt.setVisible(false);
	   	    	zabsno.setVisible(false);
	   	    	zabs.setVisible(false);
	   	    	zhc.setVisible(false);
	   	    	ztabs.setVisible(false);
	   	    	zooccrate.setVisible(false);
	   	    	 zooutput.setVisible(false);
	   	           zeff.setVisible(false);
	            efficiency.setStyle("-fx-background-color: linear-gradient(to bottom right, #466be4,#6b7aeb)");
	            data.setStyle("-fx-background-color: transparent");
	            downtime.setStyle("-fx-background-color: transparent");
	            button_occ.setStyle("-fx-background-color: transparent");
	            daily_kpis.setStyle("-fx-background-color: transparent");
	            monthly_kpis.setStyle("-fx-background-color: transparent");
	            Monthlyeff();
	            daileff();
	            mettreAJourGAP();
	            mettreAJourGAP1();
	            mettreAJourGAP2();
	            mettreAJourGAP3();
	            mettreAJourGAP4();
	            gapDt2();
	    	    gapDt();
	    	    gapWsd2();
	    	    gapWsd();
	    	    gapHc2();
	    	    gapHc();
	    	    gapOutput2();
	    	    gapOutput();
	    	    gapEfficiency1();
	    	    gapEfficiency();
	    	   addProductsShowListData1();
	            addProductSearch1();
	       } else if(event.getSource() == downtime) {
	    	   System.out.println("Changement de formulaire. Appel de monthlyFA_DT_Split_Per_Area().");
	    	   monthlyFA_DT_Split_Per_Area();
	            System.out.println("Switching to downtime form...");
	            data_form.setVisible(false);
	            eff_form.setVisible(false);
	            dt_form.setVisible(true);
	            occ_form.setVisible(false);
	            daily_form.setVisible(false);
	            monthly_premier.setVisible(false);
	            test_button.setVisible(false);
	            troix_monthly.setVisible(false);
	            saisie_form.setVisible(false);
	            zwsd.setVisible(false);
	   	    	zdt.setVisible(false);
	   	    	zabsno.setVisible(false);
	   	    	zabs.setVisible(false);
	   	    	zhc.setVisible(false);
	   	    	ztabs.setVisible(false);
	   	    	zooccrate.setVisible(false);
	   	    	 zooutput.setVisible(false);
	   	           zeff.setVisible(false);
	            dtmonth();
	    	    DTdAILY();
	    	    dtListImpact();
	    	    adddtShowList();
	    	    DAILYFA_DT_Split_Per_Area();
	    	    dtSearch();
	            downtime.setStyle("-fx-background-color: linear-gradient(to bottom right, #466be4,#6b7aeb)");
	            data.setStyle("-fx-background-color: transparent");
	            efficiency.setStyle("-fx-background-color: transparent");
	            button_occ.setStyle("-fx-background-color: transparent");
	            daily_kpis.setStyle("-fx-background-color: transparent");
	            monthly_kpis.setStyle("-fx-background-color: transparent");
	            
	        }else if(event.getSource() == button_occ) {
	        	 System.out.println("Switching to add data form...");
		            data_form.setVisible(false);
		            eff_form.setVisible(false);
		            dt_form.setVisible(false);
		            occ_form.setVisible(true);
		            daily_form.setVisible(false);
		            monthly_premier.setVisible(false);
		            test_button.setVisible(false);
		            troix_monthly.setVisible(false);
		            saisie_form.setVisible(false);
		            zwsd.setVisible(false);
		   	    	zdt.setVisible(false);
		   	    	zabsno.setVisible(false);
		   	    	zabs.setVisible(false);
		   	    	zhc.setVisible(false);
		   	    	ztabs.setVisible(false);
		   	    	zooccrate.setVisible(false);
		   	    	 zooutput.setVisible(false);
		   	           zeff.setVisible(false);
		            button_occ.setStyle("-fx-background-color: linear-gradient(to bottom right, #466be4,#6b7aeb)");
		            data.setStyle("-fx-background-color: transparent");
		            efficiency.setStyle("-fx-background-color: transparent");
		            downtime.setStyle("-fx-background-color: transparent");
		            daily_kpis.setStyle("-fx-background-color: transparent");
		            monthly_kpis.setStyle("-fx-background-color: transparent");
		            
		            addProductsShowListData2();
		            addProductSearch2();
		            dailyoccrate();
		    	    monthyoccrate();
		            
		            }else if(event.getSource() == daily_kpis) {
			        	 System.out.println("Switching to add data form...");
				            data_form.setVisible(false);
				            eff_form.setVisible(false);
				            dt_form.setVisible(false);
				            occ_form.setVisible(false);
				            daily_form.setVisible(true);
				            monthly_premier.setVisible(false);
				            test_button.setVisible(false);
				            troix_monthly.setVisible(false);
				            saisie_form.setVisible(false);
				            zwsd.setVisible(false);
				   	    	zdt.setVisible(false);
				   	    	zabsno.setVisible(false);
				   	    	zabs.setVisible(false);
				   	    	ztabs.setVisible(false);
				   	    	zhc.setVisible(false);
				   	    	zabs.setVisible(false);
				   	    	zooccrate.setVisible(false);
				   	    	 zooutput.setVisible(false);
				   	           zeff.setVisible(false);
                            dailyKPIdt();
				    	    dailyKPIwsd();
				    	    dailyKPIabstt();
				    	    dailyKPIocc();
				    	    dailyKPIhc();
				    	    dailyKPIout();
				    	    dailyKPIeff();
				    	    dailyKPIabs();
				    	    dailyKPIabstnoplanned();
				    	    dailyKPIoutzoom();
				            daily_kpis.setStyle("-fx-background-color: linear-gradient(to bottom right, #466be4,#6b7aeb)");
				            data.setStyle("-fx-background-color: transparent");
				            efficiency.setStyle("-fx-background-color: transparent");
				            button_occ.setStyle("-fx-background-color: transparent");
				            downtime.setStyle("-fx-background-color: transparent");
				            monthly_kpis.setStyle("-fx-background-color: transparent");
				            
				            }else if(event.getSource() == monthly_kpis) {
					        	 System.out.println("Switching to add data form...");
						            data_form.setVisible(false);
						            eff_form.setVisible(false);
						            dt_form.setVisible(false);
						            occ_form.setVisible(false);
						            daily_form.setVisible(false);
						            monthly_premier.setVisible(true);
						            test_button.setVisible(false);
						            troix_monthly.setVisible(false);
						            saisie_form.setVisible(false);
						            zwsd.setVisible(false);
						   	    	zdt.setVisible(false);
						   	    	zabsno.setVisible(false);
						   	    	ztabs.setVisible(false);
						   	    	zhc.setVisible(false);
						   	    	zabs.setVisible(false);
						   	    	zooccrate.setVisible(false);
						   	    	 zooutput.setVisible(false);
						   	           zeff.setVisible(false);
						            monthyeffmonth();
						            weeklymonth();
						            monthyoutmonth();
						            weeklyoutput();
						            weeklyocc();
						    	    monthyoccmonth();
						            monthly_kpis.setStyle("-fx-background-color: linear-gradient(to bottom right, #466be4,#6b7aeb)");
						            data.setStyle("-fx-background-color: transparent");
						            efficiency.setStyle("-fx-background-color: transparent");
						            button_occ.setStyle("-fx-background-color: transparent");
						            daily_kpis.setStyle("-fx-background-color: transparent");
						            downtime.setStyle("-fx-background-color: transparent");
						           
				            }
				           
	        
	    }

	    public void switchToTestButton(ActionEvent event) {
	        if (button_tst.isSelected()) {
	            test_button.setVisible(true);
	            monthly_premier.setVisible(false);
	            troix_monthly.setVisible(false);
	            data_form.setVisible(false);
	            eff_form.setVisible(false);
	            dt_form.setVisible(false);
	            occ_form.setVisible(false);
	            daily_form.setVisible(false);
	            saisie_form.setVisible(false);
	            zwsd.setVisible(false);
	   	    	zdt.setVisible(false);
	   	    	zabsno.setVisible(false);
	   	    	zabs.setVisible(false);
	   	    	zhc.setVisible(false);
	   	    	ztabs.setVisible(false);
	   	    	zooccrate.setVisible(false);
	   	    	 zooutput.setVisible(false);
	   	           zeff.setVisible(false);
	            monthdtmonth();
	    	    monthabsmonth();
	    	    weeklymonocc();
	    	    weeklymonabs();
	    	    monthlyAvgAbs();
	    	    monthlyweeklABS();
	            
	        }}
	    public void switchForm1(ActionEvent event) {
	     if(permier_trois.isSelected()) {
	        	 test_button.setVisible(false);
		            monthly_premier.setVisible(false);
		            troix_monthly.setVisible(true);
		            data_form.setVisible(false);
		            eff_form.setVisible(false);
		            dt_form.setVisible(false);
		            occ_form.setVisible(false);
		            daily_form.setVisible(false);
		            saisie_form.setVisible(false);
		            zwsd.setVisible(false);
		   	    	zdt.setVisible(false);
		   	    	zabsno.setVisible(false);
		   	    	zabs.setVisible(false);
		   	    	zhc.setVisible(false);
		   	    	ztabs.setVisible(false);
		   	    	zooccrate.setVisible(false);
		   	    	 zooutput.setVisible(false);
		   	           zeff.setVisible(false);
		            monthlyAvgNoPlannedAbs();
		            monthlyweeklnoplanned();
	        }}
             
	    public void switchForm2(ActionEvent event) {
	             if(deux_p.isSelected()) {
	        	 test_button.setVisible(false);
		            monthly_premier.setVisible(true);
		            troix_monthly.setVisible(false);
		            data_form.setVisible(false);
		            eff_form.setVisible(false);
		            dt_form.setVisible(false);
		            occ_form.setVisible(false);
		            daily_form.setVisible(false);
		            saisie_form.setVisible(false);
		            zwsd.setVisible(false);
		   	    	zdt.setVisible(false);
		   	    	zabsno.setVisible(false);
		   	    	zabs.setVisible(false);
		   	    	zhc.setVisible(false);
		   	    	ztabs.setVisible(false);
		   	    	zooccrate.setVisible(false);
		   	    	 zooutput.setVisible(false);
		   	           zeff.setVisible(false);
		            }}
	    public void switchForm3(ActionEvent event) {
	                if(deux_trois.isSelected()) {
			        	 test_button.setVisible(false);
				            monthly_premier.setVisible(false);
				            troix_monthly.setVisible(true);
				            data_form.setVisible(false);
				            eff_form.setVisible(false);
				            dt_form.setVisible(false);
				            occ_form.setVisible(false);
				            daily_form.setVisible(false);
				            saisie_form.setVisible(false);
				            zwsd.setVisible(false);
				   	    	zdt.setVisible(false);
				   	    	zabsno.setVisible(false);
				   	    	zabs.setVisible(false);
				   	    	zhc.setVisible(false);
				   	    	ztabs.setVisible(false);
				   	    	zooccrate.setVisible(false);
				   	    	 zooutput.setVisible(false);
				   	           zeff.setVisible(false);
				            
				            }}
	    public void switchForm4(ActionEvent event) {
	                   if(troix_p.isSelected()) {
					        	 test_button.setVisible(false);
						            monthly_premier.setVisible(true);
						            troix_monthly.setVisible(false);
						            data_form.setVisible(false);
						            eff_form.setVisible(false);
						            dt_form.setVisible(false);
						            occ_form.setVisible(false);
						            daily_form.setVisible(false);
						            saisie_form.setVisible(false);
						            zwsd.setVisible(false);
						   	    	zdt.setVisible(false);
						   	    	zabsno.setVisible(false);
						   	    	zabs.setVisible(false);
						   	    	zhc.setVisible(false);
						   	    	ztabs.setVisible(false);
						   	    	zooccrate.setVisible(false);
						   	    	 zooutput.setVisible(false);
						   	           zeff.setVisible(false);
						            }}
	    public void switchForm5(ActionEvent event) {
				           if(troix_deux.isSelected()) {
					        	 test_button.setVisible(true);
						            monthly_premier.setVisible(false);
						            troix_monthly.setVisible(false);
						            data_form.setVisible(false);
						            eff_form.setVisible(false);
						            dt_form.setVisible(false);
						            occ_form.setVisible(false);
						            daily_form.setVisible(false);
						            saisie_form.setVisible(false);
						            zwsd.setVisible(false);
						   	    	zdt.setVisible(false);
						   	    	zabsno.setVisible(false);
						   	    	zabs.setVisible(false);
						   	    	zhc.setVisible(false);
						   	    	ztabs.setVisible(false);
						   	    	zooccrate.setVisible(false);
						   	    	 zooutput.setVisible(false);
						   	           zeff.setVisible(false);
						            }}
	    public void switchForm6(ActionEvent event) {
	           
	        	   saisie_form.setVisible(true);
	        	   zwsd.setVisible(false);
	   	    	zdt.setVisible(false);
	   	    	zabsno.setVisible(false);
	   	    	zabs.setVisible(false);
	   	    	zhc.setVisible(false);
	   	    	ztabs.setVisible(false);
	   	    	zooccrate.setVisible(false);
	   	    	 zooutput.setVisible(false);
	   	           zeff.setVisible(false);
		        	 test_button.setVisible(false);
			            monthly_premier.setVisible(false);
			            troix_monthly.setVisible(false);
			            data_form.setVisible(false);
			            eff_form.setVisible(false);
			            dt_form.setVisible(false);
			            occ_form.setVisible(false);
			            daily_form.setVisible(false);
			            
			            addProductsShowListData();
			            addProductsShowListData1();
			            addProductsShowListData2();
			            addProductsSelect();
			           }
	    public void switchForm7(ActionEvent event) {
	           zeff.setVisible(true);
	           zdt.setVisible(false);
		    	zwsd.setVisible(false);
		    	zabsno.setVisible(false);
		    	ztabs.setVisible(false);
		    	zhc.setVisible(false);
		    	zabs.setVisible(false);
		    	zooccrate.setVisible(false);
		    	 zooutput.setVisible(false);
     	   saisie_form.setVisible(false);
	        	 test_button.setVisible(false);
		            monthly_premier.setVisible(false);
		            troix_monthly.setVisible(false);
		            data_form.setVisible(false);
		            eff_form.setVisible(false);
		            dt_form.setVisible(false);
		            occ_form.setVisible(false);
		            daily_form.setVisible(false);
		            dailyKPIeffzom();
		       
		           }
	    public void switchForm8(ActionEvent event) {
	    	 System.out.println("switchForm8 appelé");
	    	 zooutput.setVisible(true);
	    	 zdt.setVisible(false);
		    	zwsd.setVisible(false);
		    	zabsno.setVisible(false);
		    	ztabs.setVisible(false);
		    	zhc.setVisible(false);
		    	zabs.setVisible(false);
		    	zooccrate.setVisible(false);
		    	 zooutput.setVisible(false);
	           zeff.setVisible(false);
  	   saisie_form.setVisible(false);
	        	 test_button.setVisible(false);
		            monthly_premier.setVisible(false);
		            troix_monthly.setVisible(false);
		            data_form.setVisible(false);
		            eff_form.setVisible(false);
		            dt_form.setVisible(false);
		            occ_form.setVisible(false);
		            daily_form.setVisible(false);
		            //zoomoutput.setVisible(true);
		            dailyKPIoutzoom();
		            if (zooutput != null) {
		            	zooutput.setVisible(true);
		                dailyKPIoutzoom();
		            } else {
		                System.out.println("zooutput est null");
		            }
		        }
		       
		           
	    public void switchForm9(ActionEvent event) {
	    	zooccrate.setVisible(true);
	    	zdt.setVisible(false);
	    	zwsd.setVisible(false);
	    	zabsno.setVisible(false);
	    	zabs.setVisible(false);
	    	zhc.setVisible(false);
	    	ztabs.setVisible(false);
	    	 zooutput.setVisible(false);
	           zeff.setVisible(false);
 	   saisie_form.setVisible(false);
	        	 test_button.setVisible(false);
		            monthly_premier.setVisible(false);
		            troix_monthly.setVisible(false);
		            data_form.setVisible(false);
		            eff_form.setVisible(false);
		            dt_form.setVisible(false);
		            occ_form.setVisible(false);
		            daily_form.setVisible(false);
		            dailyKPIocczoom();
		       
		           }
	    public void switchForm10(ActionEvent event) {
	    	ztabs.setVisible(true);
	    	zdt.setVisible(false);
	    	zwsd.setVisible(false);
	    	zabsno.setVisible(false);
	    	zabs.setVisible(false);
	    	zhc.setVisible(false);
	    	zooccrate.setVisible(false);
	    	 zooutput.setVisible(false);
	           zeff.setVisible(false);
 	   saisie_form.setVisible(false);
	        	 test_button.setVisible(false);
		            monthly_premier.setVisible(false);
		            troix_monthly.setVisible(false);
		            data_form.setVisible(false);
		            eff_form.setVisible(false);
		            dt_form.setVisible(false);
		            occ_form.setVisible(false);
		            daily_form.setVisible(false);
		            dailyKPIabszoom();
		       
		           }
	    public void switchForm11(ActionEvent event) {
	    	zhc.setVisible(true);
	    	zdt.setVisible(false);
	    	zwsd.setVisible(false);
	    	zabsno.setVisible(false);
	    	ztabs.setVisible(false);
	    	zabs.setVisible(false);
	    	zooccrate.setVisible(false);
	    	 zooutput.setVisible(false);
	           zeff.setVisible(false);
 	   saisie_form.setVisible(false);
	        	 test_button.setVisible(false);
		            monthly_premier.setVisible(false);
		            troix_monthly.setVisible(false);
		            data_form.setVisible(false);
		            eff_form.setVisible(false);
		            dt_form.setVisible(false);
		            occ_form.setVisible(false);
		            daily_form.setVisible(false);
		            dailyKPIhczoom();
		       
		           }
	    public void switchForm12(ActionEvent event) {
	    	zabs.setVisible(true);
	    	zdt.setVisible(false);
	    	zwsd.setVisible(false);
	    	zabsno.setVisible(false);
	    	ztabs.setVisible(false);
	    	zhc.setVisible(false);
	    	zabs.setVisible(false);
	    	zooccrate.setVisible(false);
	    	 zooutput.setVisible(false);
	           zeff.setVisible(false);
 	   saisie_form.setVisible(false);
	        	 test_button.setVisible(false);
		            monthly_premier.setVisible(false);
		            troix_monthly.setVisible(false);
		            data_form.setVisible(false);
		            eff_form.setVisible(false);
		            dt_form.setVisible(false);
		            occ_form.setVisible(false);
		            daily_form.setVisible(false);
		            dailyKPIabsttzoom();
		            if (zabs != null) {
		            	zabs.setVisible(true);
		                dailyKPIoutzoom();
		            } else {
		                System.out.println("zabs est null");
		            }
		        }
		       
		             
	    public void switchForm13(ActionEvent event) {
	    	zabsno.setVisible(true);
	    	zdt.setVisible(false);
	    	zwsd.setVisible(false);
	    	ztabs.setVisible(false);
	    	zhc.setVisible(false);
	    	zabs.setVisible(false);
	    	zooccrate.setVisible(false);
	    	 zooutput.setVisible(false);
	           zeff.setVisible(false);
 	   saisie_form.setVisible(false);
	        	 test_button.setVisible(false);
		            monthly_premier.setVisible(false);
		            troix_monthly.setVisible(false);
		            data_form.setVisible(false);
		            eff_form.setVisible(false);
		            dt_form.setVisible(false);
		            occ_form.setVisible(false);
		            daily_form.setVisible(false);
		            dailyKPIabsnoplannedttzoom();
		           }
	    public void switchForm14(ActionEvent event) {
	    	zdt.setVisible(true);
	    	zwsd.setVisible(false);
	    	zabsno.setVisible(false);
	    	zabs.setVisible(false);
	    	zhc.setVisible(false);
	    	zabs.setVisible(false);
	    	zooccrate.setVisible(false);
	    	 zooutput.setVisible(false);
	           zeff.setVisible(false);
 	   saisie_form.setVisible(false);
	        	 test_button.setVisible(false);
		            monthly_premier.setVisible(false);
		            troix_monthly.setVisible(false);
		            data_form.setVisible(false);
		            eff_form.setVisible(false);
		            dt_form.setVisible(false);
		            occ_form.setVisible(false);
		            daily_form.setVisible(false);
		            zwsd.setVisible(false);
		            dailyKPIdtzoom();
		           }
	    public void switchForm15(ActionEvent event) {
	    	zwsd.setVisible(true);
	    	zdt.setVisible(false);
	    	zabsno.setVisible(false);
	    	zabs.setVisible(false);
	    	zhc.setVisible(false);
	    	zabs.setVisible(false);
	    	zooccrate.setVisible(false);
	    	 zooutput.setVisible(false);
	           zeff.setVisible(false);
 	   saisie_form.setVisible(false);
	        	 test_button.setVisible(false);
		            monthly_premier.setVisible(false);
		            troix_monthly.setVisible(false);
		            data_form.setVisible(false);
		            eff_form.setVisible(false);
		            dt_form.setVisible(false);
		            occ_form.setVisible(false);
		            daily_form.setVisible(false);
		            dailyKPIwsdzoom();
		           }
	  
	    private void dailyKPIabsnoplannedttzoom() {
			// TODO Auto-generated method stub
			
		}
	    private void dailyKPIabttzoom() {
			// TODO Auto-generated method stub
			
		}

		private double x=0;
	    private double y= 0;
	    
	    public void logout () {
	    	try {
	    	    Alert alert = new Alert(AlertType.CONFIRMATION);
	    	    alert.setTitle("Confirmation Message");
	    	    alert.setHeaderText(null);
	    	    alert.setContentText("Are you sure to want logouT ?");
	    	    
	    		Optional <ButtonType> Option = alert.showAndWait();
	    		
	    		if(Option.get().equals(ButtonType.OK)) {
	    			logout.getScene().getWindow().hide();
	    			Parent root = FXMLLoader.load(getClass().getResource("MainScence.fxml"));
	    			Stage stage = new Stage();
	    			Scene scene = new Scene(root);
	    			
	    			root.setOnMousePressed ((MouseEvent event) -> {
	    				
	    				  x= event.getSceneX();
	    				  y = event.getSceneX();
	    				
	    					
	    				});
	    				
	    				root.setOnMouseDragged((MouseEvent event) -> {
	    					
	    					 
	    					stage.setX(event.getScreenX() - x) ;                       ;
	    					stage.setY(event.getScreenY() - y);
	    					
	    					
	    					stage.setOpacity(.8);
	    						
	    					});
	    				
	    				root.setOnMouseReleased((MouseEvent event) -> {
	    					stage.setOpacity(1);});
	    				
	    				stage.initStyle(StageStyle.TRANSPARENT);
	    				stage.setScene(scene);
	    				stage.show();
	    				
	    			
	    		}else return;
	    	  
	    		
	    		
	    	}catch(Exception e) {e.printStackTrace();}
	    }
	    
	    public void minimize() {
	    	Stage stage = (Stage)man_orm.getScene().getWindow();
	    	stage.setIconified(true);
	    }
	    
	    public void close() {
	    	System.exit(0);
	    }
	    @Override
		public void initialize(URL arg0, ResourceBundle arg1) {
	    	adddtShowList();
	    	dailyKPIeffzom();
	    	dailyKPIoutzoom();
	    	dailyKPIoccratezom();
	    	dailyKPIabszoom();
	    	dailyKPIabsttzoom();
	    	dailyKPIabstnoplannedzoom();
	    	dailyKPIdtzoom();
	    	dailyKPIhczoom();
	    	dailyKPIwsdzoom();
	    	dtListImpact();
	    	mettreAJourGAP();
	    	mettreAJourGAP1();
            mettreAJourGAP2();
            mettreAJourGAP3();
            mettreAJourGAP4();
            gapDt2();
            gapDt();
		    gapWsd2();
		    gapWsd();
		    gapHc2();
		    gapHc();
		    gapOutput2();
		    gapOutput();
		    gapEfficiency1();
		    gapEfficiency();
		    Monthlyeff();
		    daileff();
		    dailyoccrate();
		    monthyoccrate();
		    monthyeffmonth();
			plus.setOnAction(event -> switchForm6(event));
			buttonzo_eff121.setOnAction(event -> switchForm8(event));
			weeklymonth();
			monthyoutmonth();
			addProductsSelect();
			 addProductsShowListData();
			 addProductsShowListData1();
			 addProductsShowListData2();
			 weeklyoutput();
			 weeklyocc();
     	    monthyoccmonth();
            dailyKPIdt();
    	    dailyKPIwsd();
    	    dailyKPIabstt();
    	    dailyKPIocc();
    	    dailyKPIhc();
    	    dailyKPIout();
    	    dailyKPIeff();
    	    dailyKPIabs();
    	    dtmonth();
    	    DTdAILY();
    	    monthdtmonth();
    	    monthabsmonth();
    	    weeklymonocc();
    	    weeklymonabs();
    	    DAILYFA_DT_Split_Per_Area();
    	    monthlyFA_DT_Split_Per_Area();
    	    monthlyAvgNoPlannedAbs();
    	    monthlyweeklnoplanned();
    	    monthlyAvgAbs();
    	    monthlyweeklABS();
    	    dailyKPIabstnoplanned();
    	    output.textProperty().addListener(( outputValue, wsdValue, hcValue) -> { calculateAndSetEfficiency();});
                wsd.textProperty().addListener((outputValue, wsdValue, hcValue) -> {calculateAndSetEfficiency(); });
                hc.textProperty().addListener((outputValue, wsdValue, hcValue) -> { calculateAndSetEfficiency(); });
                
                output.textProperty().addListener((textProperty, old, value) -> {
                    calculateAndSetOccrate();
                });

                me.textProperty().addListener((textProperty, old, value) -> {
                    calculateAndSetOccrate();});
                
                print.setOnAction(event -> {
                
                    printTableView(tb_add_data);
                });
              
			}

		private void dailyKPIoccratezom() {
			// TODO Auto-generated method stub
			
		}
			
		
}