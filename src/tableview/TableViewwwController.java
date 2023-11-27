package tableview;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mysql.jdbc.PreparedStatement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import jdbcc.DataBaseConnector;

public class TableViewwwController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<TraineeBean> tblRecord;
    PreparedStatement pst;
    Connection con;
    ObservableList<TraineeBean> list;
    @FXML
    void doShowAll(ActionEvent event) {
    	  try {
    		list=FXCollections.observableArrayList();//creation of object
  			pst=(PreparedStatement)con.prepareStatement("select * from trainees");
  			ResultSet table=pst.executeQuery();
  			while(table.next())
  			{
  				int RollNo=table.getInt("RollNo");
  				String Name=table.getString("Name");
  				float Percentage=table.getFloat("Percentage");
  				String Date=table.getString("Date");
  				String Branch=table.getString("Branch");
  				System.out.println(RollNo+" "+Name+" "+Percentage+" "+Date+" "+Branch);
  				TraineeBean obj=new TraineeBean(RollNo,Name,Percentage,Date.toString(),Branch);
  				list.add(obj);
  			}
  			tblRecord.setItems(list);
  		} catch (SQLException e) {
  			
  			e.printStackTrace();
  		}
    }
    void addcolumns()
    {
    	TableColumn<TraineeBean, Integer> rollCol=new TableColumn<TraineeBean, Integer>("RollNo.");
    	rollCol.setCellValueFactory(new PropertyValueFactory<TraineeBean, Integer>("rollNo"));//field name in bean
    	rollCol.setMinWidth(100);
    	
    	TableColumn<TraineeBean, String> nameCol=new TableColumn<TraineeBean, String>("Name");
    	nameCol.setCellValueFactory(new PropertyValueFactory<TraineeBean, String>("name"));//field name in bean
    	nameCol.setMinWidth(100);
    	
    	TableColumn<TraineeBean, Float> perCol=new TableColumn<TraineeBean, Float>("Percentage");
    	perCol.setCellValueFactory(new PropertyValueFactory<TraineeBean, Float>("percentage"));//field name in bean
    	perCol.setMinWidth(100);
    	
    	TableColumn<TraineeBean, String> dateCol=new TableColumn<TraineeBean, String>("Date");
    	dateCol.setCellValueFactory(new PropertyValueFactory<TraineeBean, String>("date"));//field name in bean
    	dateCol.setMinWidth(100);
    	
    	TableColumn<TraineeBean, String> branchCol=new TableColumn<TraineeBean, String>("Branch");
    	branchCol.setCellValueFactory(new PropertyValueFactory<TraineeBean, String>("branch"));//field name in bean
    	branchCol.setMinWidth(100);
    	
    	tblRecord.getColumns().addAll(rollCol,nameCol,perCol,dateCol,branchCol); 
    	
    }

    @FXML
    void initialize() {
       con=DataBaseConnector.getConnection();
       addcolumns();
    }
}
