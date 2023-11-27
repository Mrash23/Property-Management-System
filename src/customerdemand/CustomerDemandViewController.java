package customerdemand;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.ResourceBundle;

import com.mysql.jdbc.PreparedStatement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import jdbcc.DataBaseConnector;

public class CustomerDemandViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtcontact;

    @FXML
    private ComboBox<String> comborecordid;

    @FXML
    private TextField txtmaxbudget;

    @FXML
    private ComboBox<String> combopropertytype;

    @FXML
    private TextField txtlocation;

    @FXML
    private TextField txtto;

    @FXML
    private TextField txtsize;

    @FXML
    private TextField txtotherdemands;

    @FXML
    private TextField txtrecordid;
    
    PreparedStatement pst;
    Connection con;
    int newID=2;
    @FXML
    void doadd(ActionEvent event) {
    	try {
			pst=(PreparedStatement) con.prepareStatement("insert into form3 values(null,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1,Integer.parseInt(txtcontact.getText()) );
			pst.setString(2, combopropertytype.getEditor().getText());
			pst.setString(3, txtmaxbudget.getText());
			pst.setString(4, txtlocation.getText());
			pst.setString(5, txtsize.getText());
			pst.setString(6, txtto.getText());
			
			pst.setString(7, txtotherdemands.getText());
			//pst.setString(8, txtrecordid.getText());
			//pst.setString(9, comborecordid.getEditor().getText());

			 int res=pst.executeUpdate();
				ResultSet id= pst.getGeneratedKeys();
				
				if(res>0)
				{
					if(id.next())
					{
						newID=id.getInt(1);
					}
					
					showMsg("Property save successfully.  "+" ' "+newID  +  " ' " + " is your Reference id. Kindly save it for future reference.");
					txtrecordid.setText(newID+"");//to show it in the text box that is the record id
					
				} 
				System.out.println("DATA SAVED");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
   
    void 	showMsg(String msg)
    {
    	
    			Alert alert = new Alert(AlertType.INFORMATION);
    			
    			alert.setTitle("Information Dialog");
    		 			
    			alert.setHeaderText("Look, an Information Dialog");
    			alert.setContentText(msg);

    			alert.showAndWait();
    }
  
    @FXML
    void dodelete(ActionEvent event) {
    	try {
			pst=(PreparedStatement) con.prepareStatement("delete from form3 where rid=?");
		    pst.setString(1, comborecordid.getEditor().getText());

        	int count=pst.executeUpdate();
        	if(count==0)
        		System.out.println("Invalid Id");
        	else
        		System.out.println(count+" Records Deleted");
			
	       } catch (SQLException e) 
    	    {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
    }

    @FXML
    void initialize() {
    	con=DataBaseConnector.getConnection();
    	String proptype[]= {"Select","Residence Plot","Commercial Plot","Flat"};
    	combopropertytype.getItems().addAll(Arrays.asList(proptype));
    	//this is to write the record id in the combo box
    	try {
			pst=(PreparedStatement) con.prepareStatement("select rid from form3");
ResultSet table=pst.executeQuery();//stores every single value
      		
      		while(table.next())//jdo tk table ch next value hagi a odo tk loop chlle
      		{
      			int Pid=table.getInt("rid");//eh oh value accept krda 
      			comborecordid.getItems().add(String.valueOf(Pid));//we're inserting pid in the combo box
      		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     
    }
}
