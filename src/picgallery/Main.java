package picgallery;
	
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;


public class Main extends Application {
	public void start(Stage primaryStage) {
		try {
			Parent root =(Parent)FXMLLoader.load(getClass().getResource("PicGalleryView.fxml"));
			Scene scene = new Scene(root,600,600);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

