package jdbcc;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import com.mysql.jdbc.PreparedStatement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class EmployeeViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> comboid;

    @FXML
    private TextField txtnaam;

    @FXML
    private TextField txtsalary;
    
    @FXML
    private DatePicker dateofbirth;

    @FXML
    void doShowAll(ActionEvent event) {
    	  try {
			pst=(PreparedStatement)con.prepareStatement("select * from employee");
			ResultSet table=pst.executeQuery();
			while(table.next())
			{
				int id=table.getInt("ID");
				String name=table.getString("Name");
				float salary=table.getFloat("Salary");
				String date=table.getString("Date");
				System.out.println(id+" "+name+" "+salary+" "+date);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    }
  
    @FXML
    void doDelete(ActionEvent event) {
       try {
    	   pst=(PreparedStatement)con.prepareStatement("delete from employee where ID=?");
    	   pst.setInt(1, Integer.parseInt(comboid.getEditor().getText()));
    	   int count=pst.executeUpdate();
    	   if(count==0)
    	   System.out.println("Invalid ID");
    	   else
    	   System.out.println(count+" records deleted");
       }
       catch(Exception exp)
       {
    	   exp.printStackTrace();
       }
    }
    
   PreparedStatement pst;
    @FXML
    void doSave(ActionEvent event) {
       try {
		pst=(PreparedStatement) con.prepareStatement("insert into employee values(?,?,?,?)");
		pst.setInt(1,Integer.parseInt(comboid.getEditor().getText()) );
		pst.setString(2,txtnaam.getText());
		pst.setFloat(3, Float.parseFloat(txtsalary.getText()));
		pst.setString(4,String.valueOf(dateofbirth.getEditor().getText()));
		
		pst.executeUpdate();
		System.out.println("Saved baby girl");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();		
	  }
    }
	
    @FXML
    void doUpdate(ActionEvent event) {
    	  try {
    	   pst=(PreparedStatement) con.prepareStatement("update employee set ID=?,Name=?,Salary=?");
       	   pst.setInt(1, Integer.parseInt(comboid.getEditor().getText()));
       	   pst.setString(2,txtnaam.getText());
		   pst.setFloat(3, Float.parseFloat(txtsalary.getText()));
       	   int count=pst.executeUpdate();
       	   if(count==0)
       	   System.out.println("Invalid ID");
       	   else
       	   System.out.println(count+" records updated");
          }
          catch(Exception exp)
          {
       	   exp.printStackTrace();
          }
    }
    
    @FXML
    void doSearch(ActionEvent event) {
    	  try {
  			pst=(PreparedStatement)con.prepareStatement("select * from employee where ID=?");
  			 pst.setInt(1, Integer.parseInt(comboid.getEditor().getText()));//when you click on anyone of the id's then automatically name and salary will
  			 //appear
  			ResultSet table=pst.executeQuery();
  			while(table.next())
  			{
  				int id=table.getInt("ID");
  				String name=table.getString("Name");
  				float salary=table.getFloat("Salary");
  				String date=table.getString("Date");
  				System.out.println(id+" "+name+" "+salary+" "+date);
  				txtnaam.setText(name);
  				txtsalary.setText(String.valueOf(salary));
  			}
  		} catch (SQLException e) {
  			e.printStackTrace();
  		}
    }
    
    Connection con;
    void doFill()
    {
    	 try {
 			pst=(PreparedStatement)con.prepareStatement("select distinct ID from employee");//distinct here means that like there is salary same of 4 to 5 people 
 			//so it will pick up only one value and suppose that the id of 2 people is 20 and salary of 40 people is 10000 then it will pickup only
 			//2 values i.e. 20 and 10000 once only,but we can also use the primary key instead of this
 			ResultSet table=pst.executeQuery();
 			while(table.next())
 			{
 				int id=table.getInt("ID");
 				comboid.getItems().add(String.valueOf(id));
 				System.out.println(id);
 			}
 		} catch (SQLException e) {
 			
 			e.printStackTrace();
 		}
    }
    @FXML
    void initialize() {
     con=DataBaseConnector.getConnection();
     doFill();
    }
}
