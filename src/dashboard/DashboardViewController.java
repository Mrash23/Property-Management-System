package dashboard;


import java.io.IOException;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class DashboardViewController {

    @FXML
    private ImageView Custreg;

    @FXML
    private ImageView availprop;

    @FXML
    private ImageView custdemand;

    @FXML
    private ImageView custdisplay;

    @FXML
    private ImageView dealsmatured;

    @FXML
    private ImageView findprop;

    @FXML
    private ImageView picgallery;

    @FXML
    private ImageView propdisplay;

    @FXML
    void availprop(MouseEvent event) throws IOException {

    	   
    	Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("availproperty/AvailPropertyView.fxml")); 
		Scene scene = new Scene(root);
		Stage stage=new Stage();
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void custdemand(MouseEvent event) throws IOException {
    	
    	Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("customerdemand/CustomerDemandView.fxml")); 
		Scene scene = new Scene(root);
		Stage stage=new Stage();
		stage.setScene(scene);
		stage.show();
    }
    

    @FXML
    void custdisplay(MouseEvent event) throws IOException {

    	Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("customerdisplayarea/CustomerDisplayAreaView.fxml")); 
		Scene scene = new Scene(root);
		Stage stage=new Stage();
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void custreg(MouseEvent event) throws IOException {
       
    	Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("costomerreg/CostomerRegView.fxml")); 
		Scene scene = new Scene(root);
		Stage stage=new Stage();
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void dealsmatured(MouseEvent event) throws IOException {
       
    	Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("dealsmatured/DealsMaturedView.fxml")); 
		Scene scene = new Scene(root);
		Stage stage=new Stage();
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void dologout(ActionEvent event) throws IOException {
       
    	((Node) event.getSource()).getScene().getWindow().hide();
    	
    }

    @FXML
    void findprop(MouseEvent event) throws IOException {
  
    	Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("findproperty/FindPropertyView.fxml")); 
		Scene scene = new Scene(root);
		Stage stage=new Stage();
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void picgallery(MouseEvent event) throws IOException {
  
    	Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("picgallery/PicGalleryView.fxml")); 
		Scene scene = new Scene(root);
		Stage stage=new Stage();
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void propdisplay(MouseEvent event) throws IOException {

    	Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("propertydisplayarea/PropertyDisplayAreaView.fxml")); 
		Scene scene = new Scene(root);
		Stage stage=new Stage();
		stage.setScene(scene);
		stage.show();
    	
    }

}
