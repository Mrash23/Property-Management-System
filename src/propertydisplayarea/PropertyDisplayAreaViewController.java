package propertydisplayarea;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import com.mysql.jdbc.PreparedStatement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import jdbcc.DataBaseConnector;

public class PropertyDisplayAreaViewController {

    @FXML
    private ComboBox<String> comboarea;

    @FXML
    private ComboBox<String> combocity;

    @FXML
    private ComboBox<String> combocustomertype;

    @FXML
    private TableView<PropertyDisplayBean> tblshowall;

    @FXML
    private TextField txtmax;

    @FXML
    private TextField txtmin;

    @FXML
    private TextField txtrs;

    @FXML
    private TextField txtrsto;
    PreparedStatement pst;
    Connection con;
    ObservableList<PropertyDisplayBean> list;

    @FXML
    void dofetchall(ActionEvent event) {
    	doaddcolums();
        try {
       		list=FXCollections.observableArrayList();//creation of object
     			pst=(PreparedStatement)con.prepareStatement("select * from form2 where city=? and ctype=? and location=?");
     			pst.setString(1, combocity.getEditor().getText());
     			pst.setString(2, combocustomertype.getEditor().getText());
     			pst.setString(3, comboarea.getEditor().getText());
     			//if(txtmaxsize.getText()>txtminsize.getText())
     			//pst.setString(4, txtmaxsize.getEditor().getText());
     			//pst.setString(5, combocity.getEditor().getText());
     			ResultSet table=pst.executeQuery();//data bulaya onu use krna (result set de through use hougz)
     			while(table.next())//next is a function ki jithe tk rows hage a otho tk check kruga
     			{
     				String Contact=table.getString("contact");
     				String Proptype=table.getString("ctype");
     				String Size=table.getString("size");
     				String Width=table.getString("width");
     				String Depth=table.getString("depth");
     				String Leftside=table.getString("lenleft");
     				String Rightside=table.getString("lenright");
     				String Location=table.getString("location");
     				String City=table.getString("city");
     				String Amount=table.getString("amount");
     				String Direction=table.getString("direction");
     				String OtherDetails=table.getString("details");
     				String Picpath=table.getString("filepath");
     				String Dor=table.getString("date");
     				Integer Pid=table.getInt("pid");
     				
     				if(Integer.parseInt(Size)>Integer.parseInt(txtmin.getText())&&Integer.parseInt(Size)<Integer.parseInt(txtmax.getText())&&Integer.parseInt(Amount)
     						>Integer.parseInt(txtrs.getText())&&Integer.parseInt(Amount)<Integer.parseInt(txtrsto.getText()))
     				{
     					 PropertyDisplayBean obj=new PropertyDisplayBean(Contact, Proptype, Size, Width, Depth, Leftside, Rightside,
          			    		Location,City, Amount, Direction, OtherDetails, Picpath, Dor, Pid);
          				list.add(obj);
     				}
     				else
     				{
     					System.out.println("No property found according to entered parameters");
     				}
     		   
     			}
     			tblshowall.setItems(list);
     		} catch (SQLException e) {
     			
     			e.printStackTrace();
     		}
   }

    @SuppressWarnings("unchecked")
	void doaddcolums() 

    { 

    	TableColumn<PropertyDisplayBean, String> contactCol=new TableColumn<PropertyDisplayBean, String>("Contact No."); 
    	contactCol.setCellValueFactory(new PropertyValueFactory<PropertyDisplayBean, String>("contact"));//field name in bean 
    	contactCol.setMinWidth(100); 
    	TableColumn<PropertyDisplayBean, String> proptypeCol=new TableColumn<PropertyDisplayBean, String>("Property Type"); 
    	proptypeCol.setCellValueFactory(new PropertyValueFactory<PropertyDisplayBean, String>("proptype"));//field name in bean 
    	proptypeCol.setMinWidth(100); 
    	TableColumn<PropertyDisplayBean, String> sizeCol=new TableColumn<PropertyDisplayBean, String>("Size"); 
    	sizeCol.setCellValueFactory(new PropertyValueFactory<PropertyDisplayBean, String>("size"));//field name in bean 
    	sizeCol.setMinWidth(100); 
    	TableColumn<PropertyDisplayBean, String> widthCol=new TableColumn<PropertyDisplayBean, String>("Width"); 
    	widthCol.setCellValueFactory(new PropertyValueFactory<PropertyDisplayBean, String>("width"));//field name in bean 
    	widthCol.setMinWidth(100); 
    	TableColumn<PropertyDisplayBean, String> depthCol=new TableColumn<PropertyDisplayBean, String>("Depth"); 
    	depthCol.setCellValueFactory(new PropertyValueFactory<PropertyDisplayBean, String>("depth"));//field name in bean 
    	depthCol.setMinWidth(100); 
    	TableColumn<PropertyDisplayBean, String> leftsideCol=new TableColumn<PropertyDisplayBean, String>("Left Side"); 
    	leftsideCol.setCellValueFactory(new PropertyValueFactory<PropertyDisplayBean, String>("leftside"));//field name in bean 
    	leftsideCol.setMinWidth(100); 
    	TableColumn<PropertyDisplayBean, String> righttsideCol=new TableColumn<PropertyDisplayBean, String>("Rightside Side"); 
    	righttsideCol.setCellValueFactory(new PropertyValueFactory<PropertyDisplayBean, String>("rightside"));//field name in bean 
    	righttsideCol.setMinWidth(100); 
    	TableColumn<PropertyDisplayBean, String> locationCol=new TableColumn<PropertyDisplayBean, String>("Location"); 
    	locationCol.setCellValueFactory(new PropertyValueFactory<PropertyDisplayBean, String>("location"));//field name in bean 
    	locationCol.setMinWidth(100); 
    	TableColumn<PropertyDisplayBean, String> cityCol=new TableColumn<PropertyDisplayBean, String>("City"); 
    	cityCol.setCellValueFactory(new PropertyValueFactory<PropertyDisplayBean, String>("city"));//field name in bean 
    	cityCol.setMinWidth(100); 
    	TableColumn<PropertyDisplayBean, String> amountCol=new TableColumn<PropertyDisplayBean, String>("Amount"); 
    	amountCol.setCellValueFactory(new PropertyValueFactory<PropertyDisplayBean, String>("amount"));//field name in bean 
    	amountCol.setMinWidth(100); 
    	TableColumn<PropertyDisplayBean, String> directionCol=new TableColumn<PropertyDisplayBean, String>("Direction"); 
    	directionCol.setCellValueFactory(new PropertyValueFactory<PropertyDisplayBean, String>("direction"));//field name in bean 
    	directionCol.setMinWidth(100); 
    	TableColumn<PropertyDisplayBean, String> otherdetailsCol=new TableColumn<PropertyDisplayBean, String>("Other Details"); 
    	otherdetailsCol.setCellValueFactory(new PropertyValueFactory<PropertyDisplayBean, String>("direction"));//field name in bean 
    	otherdetailsCol.setMinWidth(100); 
    	TableColumn<PropertyDisplayBean, String> picpathCol=new TableColumn<PropertyDisplayBean, String>("Pic Path"); 
    	picpathCol.setCellValueFactory(new PropertyValueFactory<PropertyDisplayBean, String>("picpath"));//field name in bean 
    	picpathCol.setMinWidth(100); 
    	TableColumn<PropertyDisplayBean, String> dorCol=new TableColumn<PropertyDisplayBean, String>("Date of Registeration"); 
    	dorCol.setCellValueFactory(new PropertyValueFactory<PropertyDisplayBean, String>("dor"));//field name in bean 
    	dorCol.setMinWidth(100); 
    	TableColumn<PropertyDisplayBean, Integer> pidCol=new TableColumn<PropertyDisplayBean, Integer>("Property ID"); 
    	pidCol.setCellValueFactory(new PropertyValueFactory<PropertyDisplayBean, Integer>("pid"));//field name in bean 
    	pidCol.setMinWidth(100); 
    	tblshowall.getColumns().addAll(contactCol,proptypeCol,sizeCol,widthCol,depthCol,leftsideCol,righttsideCol,locationCol,cityCol,amountCol,directionCol, 
    			otherdetailsCol,picpathCol,dorCol,pidCol);  

    } 
    
    String type1 = null;
	String type2 = null;
	String type3 = null;
    
    @FXML
    void initialize() {
    	con=DataBaseConnector.getConnection();
  	  try {
			pst=(PreparedStatement)con.prepareStatement("select distinct(ctype) from form2");//distinct means we only want to selsect only from city
			ResultSet table1=pst.executeQuery();//we have to use data by using this
			while(table1.next())//next is a function ki jithe tk rows hage a otho tk check kruga
  		
  				type2=table1.getString("ctype");
  				combocustomertype.getItems().addAll(Arrays.asList(type2));
  	  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	 try {
 			pst=(PreparedStatement)con.prepareStatement("select distinct(location) from form2");//distinct means we only want to selsect only from city
 		//	if(combocity.getEditor())
 		//	pst.setString(1, combocity.getEditor().getText());
 			ResultSet table2=pst.executeQuery();//we have to use data by using this
 			while(table2.next())//next is a function ki jithe tk rows hage a otho tk check kruga
   			{
   				type3=table2.getString("location");
   				comboarea.getItems().addAll(Arrays.asList(type3));
   			}
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
  	 try {
			pst=(PreparedStatement)con.prepareStatement("select distinct(city) from form2");//distinct means we only want to selsect only from city
		//	if(combocity.getEditor())
		//	pst.setString(1, combocity.getEditor().getText());
			ResultSet table2=pst.executeQuery();//we have to use data by using this
			while(table2.next())//next is a function ki jithe tk rows hage a otho tk check kruga
			{
				type1=table2.getString("city");
				combocity.getItems().addAll(Arrays.asList(type1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    @FXML
    void dofetcharea(MouseEvent event) {
    	try {
    		pst=(PreparedStatement)con.prepareStatement("select distinct(location) from availproperty where city=?");//distinct means we only want to selsect only from city
    			pst.setString(1, combocity.getEditor().getText());
    			ResultSet table=pst.executeQuery();//we have to use data by using this
    			while(table.next())//next is a function ki jithe tk rows hage a otho tk check kruga
    			{
    				type1=table.getString("location");
    				comboarea.getItems().addAll(Arrays.asList(type1));
    			}
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

    }

    @FXML
    void dofetchcity(MouseEvent event) {
    	
    	try {
    		pst=(PreparedStatement)con.prepareStatement("select distinct(city) from availproperty where ctype=?");//distinct means we only want to selsect only from city
    			pst.setString(1, combocustomertype.getEditor().getText());
    			ResultSet table=pst.executeQuery();//we have to use data by using this
    			while(table.next())//next is a function ki jithe tk rows hage a otho tk check kruga
    			{
    				type1=table.getString("city");
    				combocity.getItems().addAll(Arrays.asList(type1));
    			}
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        }
    }


