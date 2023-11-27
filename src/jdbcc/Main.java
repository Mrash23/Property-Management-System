package jdbcc;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;


public class Main extends Application {
	public void start(Stage primaryStage) {
		try {
			Parent root =(Parent)FXMLLoader.load(getClass().getResource("EmployeeView.fxml"));
			Scene scene = new Scene(root,500,500);
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
