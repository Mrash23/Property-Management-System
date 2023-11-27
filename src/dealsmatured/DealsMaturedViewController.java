 package dealsmatured;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mysql.jdbc.PreparedStatement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import jdbcc.DataBaseConnector;

public class DealsMaturedViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txttotalamount;

    @FXML
    private TextField txtxadvpaid;

    @FXML
    private TextField txtbalamount;

    @FXML
    private DatePicker dateofreg;

    @FXML
    private ComboBox<String> combobuyerid;

    @FXML
    private ComboBox<String> combosellerid;

    @FXML
    private ComboBox<String> combopropertyid;

    PreparedStatement pst;
    Connection con;
    @FXML
    void dobalamount(MouseEvent event) {
    	 int bal=Integer.parseInt(txttotalamount.getText())-Integer.parseInt(txtxadvpaid.getText());
         txtbalamount.setText(String.valueOf(bal));
    }

    @FXML
    void donew(ActionEvent event) {
    	combobuyerid.getEditor().clear();
    	combopropertyid.getEditor().clear();
    	txtbalamount.clear();
    	combosellerid.getEditor().clear();
    	txttotalamount.clear();
    	txtxadvpaid.clear();
    	dateofreg.getEditor().clear();


    }

    @FXML
    void dosave(ActionEvent event) {
    	try {
    		pst=(PreparedStatement) con.prepareStatement("insert into dealsmatured values(?,?,?,?,?,?,?)");
    		pst.setString(1, combobuyerid.getEditor().getText());
    		pst.setString(2,combobuyerid.getEditor().getText());
    		pst.setString(3, combosellerid.getEditor().getText());
    		pst.setString(4, txttotalamount.getText());
    		pst.setString(5, txtxadvpaid.getText());
    		pst.setString(6, txtbalamount.getText());
    		pst.setDate(7, Date.valueOf(dateofreg.getValue()));
    		int count=pst.executeUpdate();
    		if(count==0)
    		
    			System.out.println("Invalid Id");	
    		else
    			System.out.println(count+"Records Updated");
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}

    }

    @FXML
    void initialize() {
    	 con=DataBaseConnector.getConnection();
    	 try {
 			pst=(PreparedStatement) con.prepareStatement("select rid from form3");
 ResultSet table=pst.executeQuery();//stores every single value
       		
       		while(table.next())//jdo tk table ch next value hagi a odo tk loop chlle
       		{
       			int Pid=table.getInt("rid");//eh oh value accept krda 
       			combobuyerid.getItems().add(String.valueOf(Pid));//we're inserting pid in the combo box
       		}
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
    	 try {
  			pst=(PreparedStatement) con.prepareStatement("select pid from form2");
  ResultSet table=pst.executeQuery();//stores every single value
        		
        		while(table.next())//jdo tk table ch next value hagi a odo tk loop chlle
        		{
        			int Pid1=table.getInt("pid");//eh oh value accept krda 
        			combopropertyid.getItems().add(String.valueOf(Pid1));//we're inserting pid in the combo box
        		}
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
    	 try {
  			pst=(PreparedStatement) con.prepareStatement("select contact from form1");
  ResultSet table=pst.executeQuery();//stores every single value
        		
        		while(table.next())//jdo tk table ch next value hagi a odo tk loop chlle
        		{
        			int Pid2=table.getInt("contact");//eh oh value accept krda 
        			combosellerid.getItems().add(String.valueOf(Pid2));//we're inserting pid in the combo box
        		}
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
    }
}
