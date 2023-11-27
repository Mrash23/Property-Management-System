package customerdisplayarea;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.ResourceBundle;

import com.mysql.jdbc.PreparedStatement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import jdbcc.DataBaseConnector;
import propertydisplayarea.PropertyDisplayBean;


public class CustomerDisplayAreaViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> combocustomertype;

    @FXML
    private ComboBox<String> combocity;

    @FXML
    private TableView<CustomerDisplayBean> tblshowall;

   
    
    PreparedStatement pst;
    Connection con;
    ObservableList<CustomerDisplayBean> list;
    int key;
    @FXML
    void dofetch(ActionEvent event) {
      addcolumnscity();
      try {
    		list=FXCollections.observableArrayList();//creation of object
  			pst=(PreparedStatement)con.prepareStatement("select * from form1 where city=?");
  			pst.setString(1, combocity.getEditor().getText());
  			ResultSet table=pst.executeQuery();//data bulaya onu use krna (result set de through use hougz)
  			while(table.next())//next is a function ki jithe tk rows hage a otho tk check kruga
  			{
  				String Name=table.getString("name");
  				String Address=table.getString("address");
  				String Picpath=table.getString("picpath");
  				String Idproof=table.getString("IDproof");
  				String Idproofno=table.getString("proofnum");
  				String Contactno=table.getString("contact");
  				String Dor=table.getString("DOR");
  				String Utype=table.getString("utype");
    				//System.out.println(Contactno+" "+Picpath);
  			    CustomerDisplayBean obj=new CustomerDisplayBean(Name,Address,Picpath,Idproof,Idproofno,Contactno,Dor,Utype,2);
  				list.add(obj);
  			}
  			tblshowall.setItems(list);
  		} catch (SQLException e) {
  			
  			e.printStackTrace();
  		}
    }

    @FXML
    void doshow(ActionEvent event) {
        addcolumsutype();
        try {
      		list=FXCollections.observableArrayList();//creation of object
    			pst=(PreparedStatement)con.prepareStatement("select * from form1 where utype=?");
    			pst.setString(1, combocustomertype.getEditor().getText());
    			ResultSet table=pst.executeQuery();//data bulaya onu use krna (result set de through use hougz)
    			while(table.next())//next is a function ki jithe tk rows hage a otho tk check kruga
    			{
    				String Name=table.getString("name");
    				String Address=table.getString("address");
    				String City=table.getString("city");
    				String Picpath=table.getString("picpath");
    				String Idproof=table.getString("IDproof");
    				String Idproofno=table.getString("proofnum");
    				String Contactno=table.getString("contact");
    				String Dor=table.getString("DOR");
    				//String Utype=table.getString("utyper");
      			//	System.out.println(Contact+" "+Proptype+" "+Percentage+" "+Date+" "+Branch);
    			    CustomerDisplayBean obj=new CustomerDisplayBean(Name,Address,City,Picpath,Idproof,Idproofno,Contactno,Dor);
    				list.add(obj);
    			}
    			tblshowall.setItems(list);
    		} catch (SQLException e) {
    			
    			e.printStackTrace();
    		}
    }
    
    void addcolumnscity()
    {
    	key=2;
    	tblshowall.getColumns().clear();
    	TableColumn<CustomerDisplayBean, String> nameCol=new TableColumn<CustomerDisplayBean, String>("Name");  
        nameCol.setCellValueFactory(new PropertyValueFactory<CustomerDisplayBean, String>("name"));//field name in bean  
    	nameCol.setMinWidth(100);  

    	TableColumn<CustomerDisplayBean, String> addressCol=new TableColumn<CustomerDisplayBean, String>("Address");  
    	addressCol.setCellValueFactory(new PropertyValueFactory<CustomerDisplayBean, String>("address"));//field name in bean  
    	addressCol.setMinWidth(100);  

    	TableColumn<CustomerDisplayBean, String> picpathCol=new TableColumn<CustomerDisplayBean, String>("Pic Path"); 
    	picpathCol.setCellValueFactory(new PropertyValueFactory<CustomerDisplayBean, String>("picpath"));//field name in bean  
    	picpathCol.setMinWidth(100);  

    	TableColumn<CustomerDisplayBean, String> idproofCol=new TableColumn<CustomerDisplayBean, String>("ID Proof");  
    	idproofCol.setCellValueFactory(new PropertyValueFactory<CustomerDisplayBean, String>("idproof"));//field name in bean  
    	idproofCol.setMinWidth(100);  

    	TableColumn<CustomerDisplayBean, String> idproofnoCol=new TableColumn<CustomerDisplayBean, String>("ID Proof No.");  
    	idproofnoCol.setCellValueFactory(new PropertyValueFactory<CustomerDisplayBean, String>("idproofno"));//field name in bean  
    	idproofnoCol.setMinWidth(100); 

    	TableColumn<CustomerDisplayBean, Integer> contactnoCol=new TableColumn<CustomerDisplayBean, Integer>("Contact No.");  
    	contactnoCol.setCellValueFactory(new PropertyValueFactory<CustomerDisplayBean, Integer>("contactno"));//field name in bean  
    	contactnoCol.setMinWidth(100);  

    	TableColumn<CustomerDisplayBean, String> dorCol=new TableColumn<CustomerDisplayBean, String>("Dor");  
    	dorCol.setCellValueFactory(new PropertyValueFactory<CustomerDisplayBean, String>("dor"));//field name in bean  
    	dorCol.setMinWidth(100);  

    	TableColumn<CustomerDisplayBean, String> utypeCol=new TableColumn<CustomerDisplayBean, String>("Customer Type");  
    	utypeCol.setCellValueFactory(new PropertyValueFactory<CustomerDisplayBean, String>("utyper"));//field name in bean  
    	utypeCol.setMinWidth(100);  

    	 
      	tblshowall.getColumns().addAll(nameCol,addressCol,picpathCol,idproofCol,idproofnoCol,contactnoCol,dorCol,utypeCol);  
    }
    
    void addcolumsutype()
    {
    	key=1;
    	tblshowall.getColumns().clear();
    	TableColumn<CustomerDisplayBean, String> nameCol=new TableColumn<CustomerDisplayBean, String>("Name");  
        nameCol.setCellValueFactory(new PropertyValueFactory<CustomerDisplayBean, String>("name"));//field name in bean  
    	nameCol.setMinWidth(100);  

    	TableColumn<CustomerDisplayBean, String> addressCol=new TableColumn<CustomerDisplayBean, String>("Address");  
    	addressCol.setCellValueFactory(new PropertyValueFactory<CustomerDisplayBean, String>("address"));//field name in bean  
    	addressCol.setMinWidth(100);  

    	TableColumn<CustomerDisplayBean, String> cityCol=new TableColumn<CustomerDisplayBean, String>("City");  
    	cityCol.setCellValueFactory(new PropertyValueFactory<CustomerDisplayBean, String>("city"));//field name in bean  
    	cityCol.setMinWidth(100);  

    	TableColumn<CustomerDisplayBean, String> picpathCol=new TableColumn<CustomerDisplayBean, String>("Pic Path"); 
    	picpathCol.setCellValueFactory(new PropertyValueFactory<CustomerDisplayBean, String>("picpath"));//field name in bean  
    	picpathCol.setMinWidth(100);  

    	TableColumn<CustomerDisplayBean, String> idproofCol=new TableColumn<CustomerDisplayBean, String>("ID Proof");  
    	idproofCol.setCellValueFactory(new PropertyValueFactory<CustomerDisplayBean, String>("idproof"));//field name in bean  
    	idproofCol.setMinWidth(100);  

    	TableColumn<CustomerDisplayBean, String> idproofnoCol=new TableColumn<CustomerDisplayBean, String>("ID Proof No.");  
    	idproofnoCol.setCellValueFactory(new PropertyValueFactory<CustomerDisplayBean, String>("idproofno"));//field name in bean  
    	idproofnoCol.setMinWidth(100); 

    	TableColumn<CustomerDisplayBean, Integer> contactnoCol=new TableColumn<CustomerDisplayBean, Integer>("Contact No.");  
    	contactnoCol.setCellValueFactory(new PropertyValueFactory<CustomerDisplayBean, Integer>("contactno"));//field name in bean  
    	contactnoCol.setMinWidth(100);  

    	TableColumn<CustomerDisplayBean, String> dorCol=new TableColumn<CustomerDisplayBean, String>("Dor");  
    	dorCol.setCellValueFactory(new PropertyValueFactory<CustomerDisplayBean, String>("dor"));//field name in bean  
    	dorCol.setMinWidth(100);  
    	 
      	tblshowall.getColumns().addAll(nameCol,addressCol,cityCol,picpathCol,idproofCol,idproofnoCol,contactnoCol,dorCol);  
    }

    public void writeExcel() throws Exception {
        Writer writer = null;
        try {
        	File file = new File("Customers.csv");
            writer = new BufferedWriter(new FileWriter(file));
            if (key==0) {
            String text="Name,Address,Contact,Picpath,City,Idproof,Utype,Dor\n";
            writer.write(text);
            for (CustomerDisplayBean p : list)
            {
				text = p.getName()+ "," + p.getAddress()+","+p.getContactno() +"," +p.getPicpath()+ "," + p.getCity()+ ","+p.getIdproof()
				+","+p.getUtyper()+","+p.getDor()+"\n";
                writer.write(text);
            }
            }
            else if(key==1) {
            	String text="Name,Address,Contact,Picpath,City,Idproof,Dor\n";
                writer.write(text);
                for (CustomerDisplayBean p : list)
                {
    				text = p.getName()+ "," + p.getAddress()+","+p.getContactno() +"," +p.getPicpath()+ "," + p.getCity()+ ","+p.getIdproof()
    				+","+p.getDor()+"\n";
                    writer.write(text);
                }
            }
            else if(key==2) {
            	String text="Name,Address,Contact,Picpath,Idproof,Utype,Dor\n";
                writer.write(text);
                for (CustomerDisplayBean p : list)
                {
    				text = p.getName()+ "," + p.getAddress()+","+p.getContactno() +"," +p.getPicpath()+ ","+p.getIdproof()
    				+","+p.getUtyper()+","+p.getDor()+"\n";
                    writer.write(text);
                }
            }
            System.out.println("Exported Successfully");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
           
            writer.flush();
             writer.close();
        }
    }
    @FXML
    void doshowall(ActionEvent event) throws Exception {
    	  doaddcolums();
          try {
      		list=FXCollections.observableArrayList();//creation of object
    			pst=(PreparedStatement)con.prepareStatement("select * from form1");
    			ResultSet table=pst.executeQuery();//data bulaya onu use krna (result set de through use hougz)
    			while(table.next())//next is a function ki jithe tk rows hage a otho tk check kruga
    			{
    				String Name=table.getString("name");
    				String Address=table.getString("address");
    				String City=table.getString("city");
    				String Picpath=table.getString("picpath");
    				String Idproof=table.getString("IDproof");
    				String Idproofno=table.getString("proofnum");
    				String Contactno=table.getString("contact");
    				String Dor=table.getString("DOR");
    				String Utype=table.getString("utype");
      			//	System.out.println(Contact+" "+Proptype+" "+Percentage+" "+Date+" "+Branch);
    			    CustomerDisplayBean obj=new CustomerDisplayBean(Name,Address,City,Picpath,Idproof,Idproofno,Contactno,Dor,Utype);
    				list.add(obj);
    			}
    			tblshowall.setItems(list);
    			
    		} catch (SQLException e) {
    			
    			e.printStackTrace();
    		}
    }
    
    @FXML
    void doexp(ActionEvent event) throws Exception {
        
    	writeExcel();
    }
    
    void doaddcolums() 
    { 
    	key=0;
    	tblshowall.getColumns().clear();
    	TableColumn<CustomerDisplayBean, String> nameCol=new TableColumn<CustomerDisplayBean, String>("Name");  
        nameCol.setCellValueFactory(new PropertyValueFactory<CustomerDisplayBean, String>("name"));//field name in bean  
    	nameCol.setMinWidth(100);  

    	TableColumn<CustomerDisplayBean, String> addressCol=new TableColumn<CustomerDisplayBean, String>("Address");  
    	addressCol.setCellValueFactory(new PropertyValueFactory<CustomerDisplayBean, String>("address"));//field name in bean  
    	addressCol.setMinWidth(100);  

    	TableColumn<CustomerDisplayBean, String> cityCol=new TableColumn<CustomerDisplayBean, String>("City");  
    	cityCol.setCellValueFactory(new PropertyValueFactory<CustomerDisplayBean, String>("city"));//field name in bean  
    	cityCol.setMinWidth(100);  

    	TableColumn<CustomerDisplayBean, String> picpathCol=new TableColumn<CustomerDisplayBean, String>("Pic Path"); 
    	picpathCol.setCellValueFactory(new PropertyValueFactory<CustomerDisplayBean, String>("picpath"));//field name in bean  
    	picpathCol.setMinWidth(100);  

    	TableColumn<CustomerDisplayBean, String> idproofCol=new TableColumn<CustomerDisplayBean, String>("ID Proof");  
    	idproofCol.setCellValueFactory(new PropertyValueFactory<CustomerDisplayBean, String>("idproof"));//field name in bean  
    	idproofCol.setMinWidth(100);  

    	TableColumn<CustomerDisplayBean, String> idproofnoCol=new TableColumn<CustomerDisplayBean, String>("ID Proof No.");  
    	idproofnoCol.setCellValueFactory(new PropertyValueFactory<CustomerDisplayBean, String>("idproofno"));//field name in bean  
    	idproofnoCol.setMinWidth(100); 

    	TableColumn<CustomerDisplayBean, Integer> contactnoCol=new TableColumn<CustomerDisplayBean, Integer>("Contact No.");  
    	contactnoCol.setCellValueFactory(new PropertyValueFactory<CustomerDisplayBean, Integer>("contactno"));//field name in bean  
    	contactnoCol.setMinWidth(100);  

    	TableColumn<CustomerDisplayBean, String> dorCol=new TableColumn<CustomerDisplayBean, String>("Dor");  
    	dorCol.setCellValueFactory(new PropertyValueFactory<CustomerDisplayBean, String>("dor"));//field name in bean  
    	dorCol.setMinWidth(100);  

    	TableColumn<CustomerDisplayBean, String> utypeCol=new TableColumn<CustomerDisplayBean, String>("Customer Type");  
    	utypeCol.setCellValueFactory(new PropertyValueFactory<CustomerDisplayBean, String>("utyper"));//field name in bean  
    	utypeCol.setMinWidth(100);  

    	 
      	tblshowall.getColumns().addAll(nameCol,addressCol,cityCol,picpathCol,idproofCol,idproofnoCol,contactnoCol,dorCol,utypeCol);  

    } 

    @FXML
    void initialize() {
    	con=DataBaseConnector.getConnection();
    	  try {
  			pst=(PreparedStatement)con.prepareStatement("select distinct(utype) from form1");//distinct means we only want to selsect only from city
  			ResultSet table1=pst.executeQuery();//we have to use data by using this
  			while(table1.next())//next is a function ki jithe tk rows hage a otho tk check kruga
    			{
    				String type2=table1.getString("utype");
    				combocustomertype.getItems().addAll(Arrays.asList(type2));
    			}
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
      	
    	try {
  			pst=(PreparedStatement)con.prepareStatement("select distinct(city) from form1");//distinct means we only want to selsect only from city
  			ResultSet table=pst.executeQuery();//we have to use data by using this
  			while(table.next())//next is a function ki jithe tk rows hage a otho tk check kruga
  			{
  				String type1=table.getString("city");
  				combocity.getItems().addAll(Arrays.asList(type1));
  			}
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
    }
}
