package application;

import java.util.ArrayList;

import dsApp.FilterController;
import dsApp.ProjectSort;
import dsApp.Storage;
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
import javafx.scene.layout.Pane;

public class mainController {
	
	String[] f = {"one","two","three","four"};
	
    @FXML
    private ListView<CheckBox> FilterView;

    @FXML
    private Button addToCart;

    @FXML
    private ListView<String> cartList;

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
    private Button searchButton;
    
    @FXML
    private Button removeNo;

    @FXML
    private Button removeYes;
    
    @FXML
    private Label removeLabel;


    @FXML
    void btnNo(ActionEvent event) {
//    	String sel = cartList.getSelectionModel().getSelectedItem();
//    	cart.set(cartList.getSelectionModel().getSelectedIndex(), cartAmount.get(cartItem.indexOf(sel)-1));
    }

    @FXML
    void btnYes(ActionEvent event) {
    }
    
    @FXML
    void removeFromCart(ActionEvent event) {

    }
    
    //These store the items and amount of times they're added to cart for the toCart button
    ArrayList<Integer> cartAmount = new ArrayList<>();
    ArrayList<String> cartItem = new ArrayList<>();
    
    @FXML
    void toCart(ActionEvent event) {
    	
    	String sel = storeList.getSelectionModel().getSelectedItem();
    	
    	if(cartItem.contains(sel)) {
    		cartAmount.set(cartItem.indexOf(sel), cartAmount.get(cartItem.indexOf(sel)) + 1);
		}
    	else {
    		cartItem.add(sel);
    		cartAmount.add(1);
    	}
    	
    	int doubles = cartAmount.get(cartItem.indexOf(sel));
    	
    	if(cart.contains(sel + " x" + (doubles-1))) {
    		cart.remove(sel + " x" + (doubles-1));
    		cart.add(sel + " x" + doubles);
    	}
    	else {
    		cart.add(sel + " x" + doubles);
    	}
    	cartList.setItems(cart);	
    }

    @FXML
    void pressSearch(ActionEvent event) {
    	storeList.setItems(ProjectSort.searchFunc(itemSearch.getText(),items));
    }
    
    
    @FXML
    void NextImgL(MouseEvent event) {

    }

    @FXML
    void NextImgR(MouseEvent event) {

    }
  //none fxml stuff
    //OL for items in cart
    private ObservableList<String> cart = FXCollections.observableArrayList();
    //OL for filters
    private ObservableList<CheckBox> filters = FXCollections.observableArrayList();
    //oL for list
    private ObservableList<String> items = FXCollections.observableArrayList();
    public void initialize() {
    	FilterController.setup(filters);
    	this.FilterView.setItems(filters);
    	Storage.setup(items);
    	storeList.setItems(items);
    }
}
