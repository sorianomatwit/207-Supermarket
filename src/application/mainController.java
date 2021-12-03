package application;

import java.util.ArrayList;

import dsApp.FilterController;
import dsApp.ProjectSort;
import dsApp.Storage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class mainController {

    @FXML
    private ListView<CheckBox> FilterView;

    @FXML
    private Button addToCart;

    @FXML
    private ListView<?> cartList;

    @FXML
    private Button cartRemove;

    @FXML
    private Tab cartTab;

    @FXML
    private Label itemDescription;

    @FXML
    private Label itemDescription1;

    @FXML
    private Pane itemField;

    @FXML
    private Pane itemField1;
    
    @FXML
    private BorderPane imgViewer;
    
    @FXML
    private TextField itemSearch;
    
    @FXML
    private Button searchButton;
    
    @FXML
    private Tab shopTab;

    @FXML
    private Pane storeField;

    @FXML
    private ListView<String> storeList;

    @FXML
    private Label totalPriceView;

    @FXML
    void NextImgL(MouseEvent event) {

    }

    @FXML
    void Filterclicked(MouseEvent event) {
    	ArrayList<CheckBox> checkedBoxes = FilterController.checkFilters(filters);
    }
    
    @FXML
    void NextImgR(MouseEvent event) {

    }
    
    @FXML
    void pressSearch(ActionEvent event) {
    	 storeList.setItems(ProjectSort.searchFunc(itemSearch.getText(),items));
    }
  //none fxml stuff
    //OL for filters
    private ObservableList<CheckBox> filters = FXCollections.observableArrayList();
    //oL for list
    private ObservableList<String> items = FXCollections.observableArrayList();
    //timeline
    Timeline timeline = new Timeline(
    		new KeyFrame(Duration.millis(30), frame -> {
    			//System.out.println("frame passed");
    		})
    	);
    
    public void initialize() {
    	//listView stuff
    	FilterController.setup(filters);
    	this.FilterView.setItems(filters);
    	Storage.setup(items);
    	storeList.setItems(items);
    	
    	
    	timeline.setCycleCount(Timeline.INDEFINITE);
    	timeline.play();
    }
}
