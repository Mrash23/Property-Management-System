package loginpage;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoginViewController {

    @FXML
    private Button btnlogin;

    @FXML
    private TextField txtpassword;

    @FXML
    private TextField txtusername;

    @FXML
    void dologin(MouseEvent event) throws IOException {
    	if(txtusername.getText().equals("System") && txtpassword.getText().equals("12345678"))
		{
    		System.out.println(" Welcome Login Successfull!!!");
			Parent root = (Parent)FXMLLoader.load(getClass().getClassLoader().getResource("dashboard/DashboardView.fxml"));
			Scene scene = new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();
			((Node) event.getSource()).getScene().getWindow().hide();
	
		}
    	else
    		  System.out.println(txtusername.getText()+" "+txtpassword.getText()+" "+"Invalid Login Credentials!!!");
	         

    }

}
