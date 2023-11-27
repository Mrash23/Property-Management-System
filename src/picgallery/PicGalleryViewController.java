/**
 * Sample Skeleton for 'PicGalleryView.fxml' Controller Class
 */

package picgallery;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JFileChooser;

import com.mysql.jdbc.PreparedStatement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import jdbcc.DataBaseConnector;

public class PicGalleryViewController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="img2"
    private ImageView img2; // Value injected by FXMLLoader

    @FXML // fx:id="img3"
    private ImageView img3; // Value injected by FXMLLoader

    @FXML // fx:id="img4"
    private ImageView img4; // Value injected by FXMLLoader

    @FXML // fx:id="img1"
    private ImageView img1; // Value injected by FXMLLoader
    
    @FXML // fx:id="combopropertyid"
    private ComboBox<String> combopropertyid; // Value injected by FXMLLoader

    PreparedStatement pst;
    Connection con;
    JFileChooser filechoose1;
    JFileChooser filechoose2;
    JFileChooser filechoose3;
    JFileChooser filechoose4;
    @FXML
    void dofetch(ActionEvent event) {
    	try {
			pst=(PreparedStatement) con.prepareStatement("select pic1 from picgallery where pid=?");
			pst.setString(1, combopropertyid.getEditor().getText());
ResultSet table=pst.executeQuery();//stores every single value
      		
      		while(table.next())//jdo tk table ch next value hagi a odo tk loop chlle
      		{
      			String Pid=table.getString("pic1");//eh oh value accept krda 
      			InputStream stream = new FileInputStream(Pid);
      			 javafx.scene.image.Image image = new javafx.scene.image.Image(stream);
      	      img1.setImage(image);
      		}
		} catch (SQLException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			pst=(PreparedStatement) con.prepareStatement("select pic2 from picgallery where pid=?");
			pst.setString(1, combopropertyid.getEditor().getText());
ResultSet table=pst.executeQuery();//stores every single value
      		
      		while(table.next())//jdo tk table ch next value hagi a odo tk loop chlle
      		{
      			String Pid=table.getString("pic2");//eh oh value accept krda 
      			InputStream stream = new FileInputStream(Pid);
      			 javafx.scene.image.Image image = new javafx.scene.image.Image(stream);
      	      img2.setImage(image);
      		}
		} catch (SQLException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			pst=(PreparedStatement) con.prepareStatement("select pic3 from picgallery where pid=?");
			pst.setString(1, combopropertyid.getEditor().getText());
ResultSet table=pst.executeQuery();//stores every single value
      		
      		while(table.next())//jdo tk table ch next value hagi a odo tk loop chlle
      		{
      			String Pid=table.getString("pic3");//eh oh value accept krda 
      			InputStream stream = new FileInputStream(Pid);
      			 javafx.scene.image.Image image = new javafx.scene.image.Image(stream);
      	      img3.setImage(image);
      		}
		} catch (SQLException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			pst=(PreparedStatement) con.prepareStatement("select pic4 from picgallery where pid=?");
			pst.setString(1, combopropertyid.getEditor().getText());
ResultSet table=pst.executeQuery();//stores every single value
      		
      		while(table.next())//jdo tk table ch next value hagi a odo tk loop chlle
      		{
      			String Pid=table.getString("pic4");//eh oh value accept krda 
      			InputStream stream = new FileInputStream(Pid);
      			 javafx.scene.image.Image image = new javafx.scene.image.Image(stream);
      	      img4.setImage(image);
      		}
		} catch (SQLException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }

    @FXML
    void dopic1(ActionEvent event) {
    	filechoose1 = new JFileChooser();
     	int res=filechoose1.showOpenDialog(null);
     	if(res==0)
     	{ 
     		File file=new File(filechoose1.getSelectedFile().getAbsolutePath());
     		
     		InputStream stream = null;
 			try {
 				stream = new FileInputStream(file);
 			} catch (FileNotFoundException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}          	   	
     	    javafx.scene.image.Image image = new javafx.scene.image.Image(stream);
     	     img1.setImage(image);
     	}
    }

    @FXML
    void dopic2(ActionEvent event) {
    	filechoose2 = new JFileChooser();
     	int res=filechoose2.showOpenDialog(null);
     	if(res==0)
     	{ 
     		File file=new File(filechoose2.getSelectedFile().getAbsolutePath());
     		
     		InputStream stream = null;
 			try {
 				stream = new FileInputStream(file);
 			} catch (FileNotFoundException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}          	   	
     	    javafx.scene.image.Image image = new javafx.scene.image.Image(stream);
     	     img2.setImage(image);
     	}
    }

    @FXML
    void dopic3(ActionEvent event) {
    	filechoose3 = new JFileChooser();
     	int res=filechoose3.showOpenDialog(null);
     	if(res==0)
     	{ 
     		File file=new File(filechoose3.getSelectedFile().getAbsolutePath());
     		
     		InputStream stream = null;
 			try {
 				stream = new FileInputStream(file);
 			} catch (FileNotFoundException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}          	   	
     	    javafx.scene.image.Image image = new javafx.scene.image.Image(stream);
     	     img3.setImage(image);
     	}
    }

    @FXML
    void dopic4(ActionEvent event) {
    	filechoose4 = new JFileChooser();
     	int res=filechoose4.showOpenDialog(null);
     	if(res==0)
     	{ 
     		File file=new File(filechoose4.getSelectedFile().getAbsolutePath());
     		
     		InputStream stream = null;
 			try {
 				stream = new FileInputStream(file);
 			} catch (FileNotFoundException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}          	   	
     	    javafx.scene.image.Image image = new javafx.scene.image.Image(stream);
     	     img4.setImage(image);
     	}
    }
    
    @FXML
    void dosave(ActionEvent event) {
    	try {
			pst=(PreparedStatement) con.prepareStatement("insert into picgallery values(?,?,?,?,?)");
			pst.setString(1, combopropertyid.getEditor().getText());
			pst.setString(2, filechoose1.getSelectedFile().getAbsolutePath());
			pst.setString(3, filechoose2.getSelectedFile().getAbsolutePath());
			pst.setString(4, filechoose3.getSelectedFile().getAbsolutePath());
			pst.setString(5, filechoose4.getSelectedFile().getAbsolutePath());
			int count1=pst.executeUpdate();
			
			 if(count1==0)
					System.out.println("No Data Saved");
				else
					System.out.println(count1+" Records Saved");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void doupdate(ActionEvent event) {
    	try {
			pst=(PreparedStatement) con.prepareStatement("update picgallery set pic1=?,pic2=?,pic3=?,pic4=? where pid=?");
			pst.setString(1, filechoose1.getSelectedFile().getAbsolutePath());
			pst.setString(2, filechoose2.getSelectedFile().getAbsolutePath());
			pst.setString(3, filechoose3.getSelectedFile().getAbsolutePath());
			pst.setString(4, filechoose4.getSelectedFile().getAbsolutePath());
			pst.setString(5, combopropertyid.getEditor().getText());
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

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	con=DataBaseConnector.getConnection();
    	try {
			pst=(PreparedStatement) con.prepareStatement("select pid from form2");
ResultSet table=pst.executeQuery();//stores every single value
      		
      		while(table.next())//jdo tk table ch next value hagi a odo tk loop chlle
      		{
      			int Pid=table.getInt("pid");//eh oh value accept krda 
      			combopropertyid.getItems().add(String.valueOf(Pid));//we're inserting pid in the combo box
      		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
