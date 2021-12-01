import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class GroceryBagApp extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage pStage) throws Exception {

		try
    	{
    	Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("dsfinal.fxml"));
    	
    	Scene scene = new Scene(root);
    	pStage.setScene(scene);
    	pStage.show();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();	
    	}
	}
}
