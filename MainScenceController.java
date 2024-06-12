package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainScenceController implements Initializable {
	@FXML
    private Label erreur;

    @FXML
    private Button closee;

    @FXML
    private Button loginbtn;

    @FXML
    private AnchorPane main_from;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;
    //database tools
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private double x=0;
    private double y = 0;
    
    
    public void loginAdmin() {
    	String sql = "SELECT * FROM tb_admin WHERE username = ? and password = ?";
    	
    	connect = Database.connectDb();
    	
    	try {
    		prepare = connect.prepareStatement(sql);
    		prepare.setString(1,username.getText());
    		prepare.setString(2,password.getText());
    	
    	    result = prepare.executeQuery();
    	    Alert alert;
    	    
    	  if(username.getText().isEmpty() || password.getText().isEmpty())  {
    		  erreur.setTextFill(Color.web("#FF0000"));
    		  erreur.setText("Please Fill All Blank Fields");
    		  erreur.setVisible(true);
    		  username.clear();
    	        password.clear();
      		  username.setStyle("-fx-border-color: #FF0000;");
      	        password.setStyle("-fx-border-color: #FF0000;");
    	  }
    	  else {
    		  if(result.next()) {
    			  //if correct username and password , then proceed to dashboard from
    			  alert = new Alert(AlertType.INFORMATION);
        		  alert.setTitle("Information Message");
        		  alert.setHeaderText(null);
        		  alert.setContentText("Successfully Login");
        		  alert.showAndWait();
        		  //design our dashboard from
        		  
        		  //hide the login from
        		  loginbtn.getScene().getWindow().hide();
        		  
        		  //link you dashboard from
        		  
        		  Parent root = FXMLLoader.load(getClass().getResource("dasshboard.fxml"));

      			
        		  Stage stage = new Stage();
        		  Scene scene = new Scene(root);
        		  
        		  root.setOnMousePressed ((MouseEvent event) -> {
      				
        			  x= event.getSceneX();
        			  y = event.getSceneX();
        			
        				
        			});
        		  
        		  root.setOnMouseDragged ((MouseEvent event ) ->{
        			  
        			  stage.setX(event.getScreenX() - x);
        			  stage.setY(event.getScreenY() - y);
        			  
        		  });
        		  
        		  stage.initStyle(StageStyle.TRANSPARENT);
        		  stage.setScene(scene);
        		 
        		  stage.show();
        		  
    			  
    		  }else {
    			  //if wrong then the error message will appear
    			  erreur.setTextFill(Color.web("#FF0000"));
        		  erreur.setText("Wrong Username/Password.");
        		  erreur.setVisible(true);
        		// Vide les TextField
      	        username.clear();
      	        password.clear();
        		  username.setStyle("-fx-border-color: #FF0000;");
        	        password.setStyle("-fx-border-color: #FF0000;");
        	        
        	        
    		  }
    	  }
    }catch(Exception e) { e.printStackTrace();}
    	
    }
	  
    public void closee() {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO Auto-generated method stub
        
    }
}
