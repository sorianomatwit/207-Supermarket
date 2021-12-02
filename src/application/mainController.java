package application;

import dsApp.Storage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

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
    private ScrollPane itemList;

    @FXML
    private TextField itemSearch;

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
    void NextImgR(MouseEvent event) {

    }
  //none fxml stuff
    //OL for filters
    private ObservableList<CheckBox> filters = FXCollections.observableArrayList();
    //oL for list
    private ObservableList<String> items = FXCollections.observableArrayList();
    public void initialize() {
    	filters.add(new CheckBox("filter 1"));
    	this.FilterView.setItems(filters);
    	Storage.setup(items);
    	storeList.setItems(items);
    }
}
