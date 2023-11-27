package findproperty;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mysql.jdbc.PreparedStatement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import jdbcc.DataBaseConnector;
import propertydisplayarea.PropertyDisplayBean;

public class FindPropertyViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private RadioButton radpending;

    @FXML
    private ToggleGroup grp1;

    @FXML
    private RadioButton raddone;

    @FXML
    private RadioButton radall;
    
    @FXML
    private DatePicker date1;

    @FXML
    private TableView<FindPropertyBean> tblshowall;

    PreparedStatement pst;
    Connection con;
    ObservableList<FindPropertyBean> list;
    @FXML
    void doall(ActionEvent event) {
    	doaddcolums();
 
    	 try {
     		list=FXCollections.observableArrayList();//creation of object
   			pst=(PreparedStatement)con.prepareStatement("select * from dealsmatured");
   			ResultSet table=pst.executeQuery();//data bulaya onu use krna (result set de through use hougz)
   			while(table.next())//next is a function ki jithe tk rows hage a otho tk check kruga
   			{
   				String BuyerID=table.getString("buyer");
   				String SellerID=table.getString("seller");
   				String PropertyID=table.getString("pid");
   				String TotalAmount=table.getString("tamount");
   				String AdvanceAmount=table.getString("adv");
   				String BalanceAmount=table.getString("bal");
   				Date OwnerShipTransfer=table.getDate("doreg");
   					 FindPropertyBean obj=new FindPropertyBean(BuyerID,SellerID,PropertyID,TotalAmount,AdvanceAmount,BalanceAmount,OwnerShipTransfer);
        				list.add(obj);
   			}
   			tblshowall.setItems(list);
   		} catch (SQLException e) {
   			
   			e.printStackTrace();
   		}
    }

    
    void doaddcolums() 

    { 
//    	FindPropertyBean selectedItem = tblshowall.getSelectionModel().getSelectedItem();
//    	tblshowall.getItems().remove(selectedItem);
  //	tblshowall.getItems().clear();
    	tblshowall.getColumns().clear();
    	TableColumn<FindPropertyBean, String> buyerCol=new TableColumn<FindPropertyBean, String>("Buyer ID"); 
    	buyerCol.setCellValueFactory(new PropertyValueFactory<FindPropertyBean, String>("buyerid"));//field name in bean 
    	buyerCol.setMinWidth(100);
    	
    	TableColumn<FindPropertyBean, String> sellerCol=new TableColumn<FindPropertyBean, String>("Seller ID"); 
    	sellerCol.setCellValueFactory(new PropertyValueFactory<FindPropertyBean, String>("sellerid"));//field name in bean 
    	sellerCol.setMinWidth(100);
    	
    	TableColumn<FindPropertyBean, String> propertyidCol=new TableColumn<FindPropertyBean, String>("Property ID"); 
    	propertyidCol.setCellValueFactory(new PropertyValueFactory<FindPropertyBean, String>("propertyid"));//field name in bean 
    	propertyidCol.setMinWidth(100); 
    	
    	TableColumn<FindPropertyBean, String> totalamountCol=new TableColumn<FindPropertyBean, String>("Total Amount"); 
    	totalamountCol.setCellValueFactory(new PropertyValueFactory<FindPropertyBean, String>("totalamount"));//field name in bean 
    	totalamountCol.setMinWidth(100);
    	
    	TableColumn<FindPropertyBean, String> advamountCol=new TableColumn<FindPropertyBean, String>("Advance Amount"); 
    	advamountCol.setCellValueFactory(new PropertyValueFactory<FindPropertyBean, String>("advamount"));//field name in bean 
    	advamountCol.setMinWidth(100);
    	
    	TableColumn<FindPropertyBean, String> balamountCol=new TableColumn<FindPropertyBean, String>("Balance Amount"); 
    	balamountCol.setCellValueFactory(new PropertyValueFactory<FindPropertyBean, String>("balamount"));//field name in bean 
    	balamountCol.setMinWidth(100);
    	
    	TableColumn<FindPropertyBean, Date> ownershiptransferCol=new TableColumn<FindPropertyBean, Date>("Owner Ship Transfer"); 
    	ownershiptransferCol.setCellValueFactory(new PropertyValueFactory<FindPropertyBean, Date>("ownershiptransfer"));//field name in bean 
    	ownershiptransferCol.setMinWidth(100);
    	
    	tblshowall.getColumns().addAll(buyerCol,sellerCol,propertyidCol,totalamountCol,advamountCol,balamountCol,ownershiptransferCol);  
    }

    @FXML
    void dodone(ActionEvent event) {
    	
        doaddcolums();

   	 try {
    		list=FXCollections.observableArrayList();//creation of object
  			pst=(PreparedStatement)con.prepareStatement("select * from dealsmatured where doreg<CURRENT_DATE()");
  			ResultSet table=pst.executeQuery();//data bulaya onu use krna (result set de through use hougz)
  			while(table.next())//next is a function ki jithe tk rows hage a otho tk check kruga
  			{
  				String BuyerID=table.getString("buyer");
  				String SellerID=table.getString("seller");
  				String PropertyID=table.getString("pid");
  				String TotalAmount=table.getString("tamount");
  				String AdvanceAmount=table.getString("adv");
  				String BalanceAmount=table.getString("bal");
  				Date OwnerShipTransfer=table.getDate("doreg");
  					 FindPropertyBean obj=new FindPropertyBean(BuyerID,SellerID,PropertyID,TotalAmount,AdvanceAmount,BalanceAmount,OwnerShipTransfer);
       				list.add(obj);
  			}
  			tblshowall.setItems(list);
  		} catch (SQLException e) {
  			
  			e.printStackTrace();
  		}
        
    }

    @FXML
    void dopending(ActionEvent event) {
        doaddcolums();

      	 try {
       		list=FXCollections.observableArrayList();//creation of object
     			pst=(PreparedStatement)con.prepareStatement("select * from dealsmatured where doreg>CURRENT_DATE()");
     			ResultSet table=pst.executeQuery();//data bulaya onu use krna (result set de through use hougz)
     			while(table.next())//next is a function ki jithe tk rows hage a otho tk check kruga
     			{
     				String BuyerID=table.getString("buyer");
     				String SellerID=table.getString("seller");
     				String PropertyID=table.getString("property");
     				String TotalAmount=table.getString("tamount");
     				String AdvanceAmount=table.getString("adv");
     				String BalanceAmount=table.getString("bal");
     				Date OwnerShipTransfer=table.getDate("doreg");
     					 FindPropertyBean obj=new FindPropertyBean(BuyerID,SellerID,PropertyID,TotalAmount,AdvanceAmount,BalanceAmount,OwnerShipTransfer);
          				list.add(obj);
     			}
     			tblshowall.setItems(list);
     		} catch (SQLException e) {
     			
     			e.printStackTrace();
     		}
    }

    @FXML
    void doshow(ActionEvent event) {
    	  doaddcolums();

       	 try {
        		list=FXCollections.observableArrayList();//creation of object
      			pst=(PreparedStatement)con.prepareStatement("select * from dealsmatured where doreg<CURRENT_DATE() and doreg>? ");
      			pst.setDate(1, Date.valueOf(date1.getValue()));
      			ResultSet table=pst.executeQuery();//data bulaya onu use krna (result set de through use hougz)
      			while(table.next())//next is a function ki jithe tk rows hage a otho tk check kruga
      			{
      				String BuyerID=table.getString("buyer");
      				String SellerID=table.getString("seller");
      				String PropertyID=table.getString("pid");
      				String TotalAmount=table.getString("tamount");
      				String AdvanceAmount=table.getString("adv");
      				String BalanceAmount=table.getString("bal");
      				Date OwnerShipTransfer=table.getDate("doreg");
      					 FindPropertyBean obj=new FindPropertyBean(BuyerID,SellerID,PropertyID,TotalAmount,AdvanceAmount,BalanceAmount,OwnerShipTransfer);
           				list.add(obj);
      			}
      			tblshowall.setItems(list);
      		} catch (SQLException e) {
      			
      			e.printStackTrace();
      		}
    }

    @FXML
    void initialize() {
    	con=DataBaseConnector.getConnection();
    }
}