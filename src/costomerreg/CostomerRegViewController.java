package costomerreg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.ResourceBundle;
import javax.swing.JFileChooser;
import com.mysql.jdbc.PreparedStatement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import jdbcc.DataBaseConnector;

public class CostomerRegViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtaddress;

    @FXML
    private TextField txtcity;

    @FXML
    private TextField txtcontactno;

    @FXML
    private TextField txtidproofno;

    @FXML
    private ToggleGroup grp1;

    @FXML
    private RadioButton radsell;
    
    @FXML
    private ImageView imgpic;
    
    @FXML
    private ComboBox<String> comboid;
    
    @FXML
    private RadioButton radbuy;

    @FXML
    private RadioButton radboth;
    
    JFileChooser filechoose;
    File file;
    String path;
    @FXML
    void dobrowse(ActionEvent event) {
    	filechoose = new JFileChooser();
     	int res=filechoose.showOpenDialog(null);
     	if(res==0)
     	{ 
     		file=new File(filechoose.getSelectedFile().getAbsolutePath());
     		path=filechoose.getSelectedFile().getAbsolutePath();
     		
     		InputStream stream = null;
 			try {
 				stream = new FileInputStream(file);
 			} catch (FileNotFoundException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}          	   	
     	    javafx.scene.image.Image image = new javafx.scene.image.Image(stream);
     	     imgpic.setImage(image);
     	}
    }
 
    PreparedStatement pst;
    @FXML
    void docancelreg(ActionEvent event) {
    	try {
			pst=(PreparedStatement) con.prepareStatement("delete from form1 where contact=?");
			pst.setString(1, txtcontactno.getText());

        	int count=pst.executeUpdate();
        	if(count==0)
        		System.out.println("Invalid Id");
        	else
        		System.out.println(count+" Records Deleted");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    } 

    @FXML
    void domodify(ActionEvent event) {
    	try {
			pst=(PreparedStatement) con.prepareStatement("update form1 set name=?,address=?,city=?,picpath=?,utype=?,IDproof=?,proofnum=?,DOR=CURRENT_DATE() where contact=?");
			pst.setString(1,txtname.getText());
			pst.setString(2,txtaddress.getText());
			pst.setString(3,txtcity.getText());
			pst.setString(4,filechoose.getSelectedFile().getAbsolutePath());
			if(radbuy.isSelected())
	    	{
	    		pst.setString(5,"buyer");
	    	}
			else if(radsell.isSelected())
	    	{
	    		pst.setString(5,"seller");
	    	}
			else if(radboth.isSelected())
	    	{
	    		pst.setString(5,"both");
	    	}
	        pst.setString(6, comboid.getEditor().getText());
	        pst.setString(7,txtidproofno.getText());
	        pst.setString(8,txtcontactno.getText());
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
    void donew() {
    	txtaddress.clear();
        txtcity.clear();
        txtcontactno.clear();
        txtidproofno.clear();
        txtidproofno.clear();
        txtname.clear();
        comboid.getItems().clear();
        file.delete();
    }

    @FXML
    void doregister(ActionEvent event) {
    	try {
			pst=(PreparedStatement) con.prepareStatement("insert into form1 values(?,?,?,?,?,?,?,?,current_date())");
			pst.setString(1,txtname.getText());
	    	pst.setString(2,txtaddress.getText());
	    	pst.setString(3,txtcity.getText());
	    	pst.setString(4,txtcontactno.getText());
	    	pst.setString(5, filechoose.getSelectedFile().getAbsolutePath());
	    	
	    	if(radbuy.isSelected())
	    	{
	    		pst.setString(6,"buyer");
	    	}
	    	if(radsell.isSelected())
	    	{
	    		pst.setString(6,"seller");
	    	}
	    	if(radboth.isSelected())
	    	{
	    		pst.setString(6,"both");
	    	}
	        pst.setString(7, comboid.getEditor().getText());
	        pst.setString(8,txtidproofno.getText());
			
			
			int count1=pst.executeUpdate();
			
			 if(count1==0)
					System.out.println("No Data Saved");
				else
					System.out.println(count1+" Records Saved");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	donew();
    }

    Connection con;
    @FXML
    void initialize() {
       String items[]= {"Select","Aadhar Card","PAN Card","License"};//this is to fill the combo box
       comboid.getItems().addAll(Arrays.asList(items));
       con=DataBaseConnector.getConnection();
    }
}
