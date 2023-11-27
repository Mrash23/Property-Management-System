package availproperty;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.ResourceBundle;

import javax.swing.JFileChooser;
import javafx.scene.image.ImageView;
import com.mysql.jdbc.PreparedStatement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import jdbcc.DataBaseConnector;

public class AvailPropertyViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtpeopid;

    @FXML
    private TextField txtcontact;

    @FXML
    private ComboBox<String> comboproptype;

    @FXML
    private TextField txtsize;

    @FXML
    private TextField txtwidth;

    @FXML
    private TextField txtdepth;

    @FXML
    private TextField txtleftside;

    @FXML
    private TextField txtrightside;

    @FXML
    private TextField txtlocation;

    @FXML
    private TextField txtcity2;

    @FXML
    private TextField txtamountdemand;

    @FXML
    private TextField txtorderdetails;
    
    @FXML
    private ImageView imgpicc;

    @FXML
    private ComboBox<String> combodirection;
    
    JFileChooser filechoose;
    @FXML
    void dobrowse2(ActionEvent event) {
    	filechoose = new JFileChooser();
     	int res=filechoose.showOpenDialog(null);
     	if(res==0)
     	{ 
     		File file=new File(filechoose.getSelectedFile().getAbsolutePath());
     		
     		InputStream stream = null;
 			try {
 				stream = new FileInputStream(file);
 			} catch (FileNotFoundException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}          	   	
     	    javafx.scene.image.Image image = new javafx.scene.image.Image(stream);
     	     imgpicc.setImage(image);
     	}
    }
    
    int newID=2;
    Connection con;
    PreparedStatement pst;
    @FXML
    void dodeleteproperty(ActionEvent event) {
    	try {
			pst=(PreparedStatement) con.prepareStatement("delete from form2 where pid=?");
			pst.setInt(1,newID);

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
    void domodify2(ActionEvent event) {
    	try {
			pst=(PreparedStatement) con.prepareStatement("update form2 set contact=?,size=?,width=?,depth=?,lenleft=?,lenright=?,location=?,"
					+ "city=?,amount=?,direction=?,details=?,ctype=?,filepath=?,date=CURRENT_DATE() where pid=?");
			pst.setString(1,txtcontact.getText());
			pst.setString(2,txtsize.getText());
			pst.setString(3,txtwidth.getText());
			pst.setString(4,txtdepth.getText());
			pst.setString(5,txtleftside.getText());
			pst.setString(6,txtrightside.getText());
			pst.setString(7,txtlocation.getText());
			pst.setString(8,txtcity2.getText());
			pst.setString(9,txtamountdemand.getText());
			pst.setString(10,combodirection.getEditor().getText());
			pst.setString(11,txtorderdetails.getText());
			pst.setString(12,comboproptype.getEditor().getText());
			pst.setString(13,filechoose.getSelectedFile().getAbsolutePath());
			pst.setInt(14,newID);
			   int count=pst.executeUpdate();
				 if(count==0)
						System.out.println("Invalid Id");
					else
						System.out.println(count+" Records Updated");
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
    void dosaveinfo(ActionEvent event) {
    	try {
			pst=(PreparedStatement) con.prepareStatement("insert into form2 values(?,?,?,?,?,?,?,?,?,?,?,?,?,CURRENT_DATE(),null)",
			Statement.RETURN_GENERATED_KEYS);
			//RETURN_GENERATED_KEYS
			//pst.setInt(1,Integer.parseInt(txtid.getText()));
			pst.setString(1,txtcontact.getText());
			pst.setString(2,txtsize.getText());
			pst.setString(3,txtwidth.getText());
			pst.setString(4,txtdepth.getText());
			pst.setString(5,txtleftside.getText());
			pst.setString(6,txtrightside.getText());
			pst.setString(7,txtlocation.getText());
			pst.setString(8,txtcity2.getText());
			pst.setInt(9,Integer.parseInt(txtamountdemand.getText()));
			pst.setString(10,combodirection.getEditor().getText());
			pst.setString(11,txtorderdetails.getText());
			pst.setString(12,comboproptype.getEditor().getText());
			pst.setString(13,filechoose.getSelectedFile().getAbsolutePath());
			int res=pst.executeUpdate();
			ResultSet id= pst.getGeneratedKeys();
			
			if(res>0)
			{
				if(id.next())
				{
					newID=id.getInt(1);
				}
				
				showMsg("Property save successfully.  "+" ' "+newID  +  " ' " + " is your property id. Kindly save it for future reference.");
				
			} 
			
			//pst.executeUpdate();
			System.out.println("Saved data");			
		}
    catch (SQLException e) 
    {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }   

    @FXML
    void initialize() {
    	String type[]= {"Select","Residence Plot","Commercial Plot","Flat"};
    	comboproptype.getItems().addAll(Arrays.asList(type));
    	String type1[]= {"Select","North","South","East","South","NorthEast","SouthEast","SouthWest","NorthWest"};
    	combodirection.getItems().addAll(Arrays.asList(type1));
      	con=DataBaseConnector.getConnection();
    }
}
