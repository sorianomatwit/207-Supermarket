package application;

import java.util.ArrayList;

import dsApp.CartItem;
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
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

public class mainController {

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
    private BorderPane imgViewer;

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
    private Polygon lTri;

    @FXML
    private Pane questionBar;

    @FXML
    private Button questionNoBar;

    @FXML
    private Button questionyesBar;

    @FXML
    private Polygon rTri;

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
    void NextImgR(MouseEvent event) {

    }


    @FXML
    void questionHitYes(ActionEvent event) {
    	String sel = cartList.getSelectionModel().getSelectedItem();
    	int indexOf = cartList.getItems().indexOf(sel);
    	if(indexOf >= 0) {
    		cartItems.remove(indexOf);
    		cart.remove(indexOf);
    	}
    	
    	cartList.setItems(cart);
    	questionBar.setVisible(false);
    }

    @FXML
    void questionHitNo(ActionEvent event) {
    	String sel = cartList.getSelectionModel().getSelectedItem();
    	int indexOf = cart.indexOf(sel);
    	if(indexOf >= 0) {
    		cartItems.get(indexOf).subItem();
    		cart.set(indexOf, cartItems.get(indexOf).getName());
    	}
    	cartList.setItems(cart);
    	questionBar.setVisible(false);
    }

    
    @FXML
    void removeFromCart(ActionEvent  event) {
    	String sel = cartList.getSelectionModel().getSelectedItem();
    	int indexOf = cartList.getItems().indexOf(sel);
    	if(indexOf >= 0) {
    		questionBar.setVisible(true);
    	}
    }

    @FXML
    void toCart(ActionEvent  event) {
    	
    	String sel = storeList.getSelectionModel().getSelectedItem();
    	int indexOf = storeList.getItems().indexOf(sel);
    	if(indexOf >= 0) {
	    	CartItem newItem = new CartItem(Storage.getItemIndex(sel),1);
	    	boolean isThere = false;
	    	for(CartItem c: cartItems) {
	    		if(c.equals(newItem)) {
	    			isThere = true;
	    			newItem = c;
	    			break;
	    		}
	    	}
	    	if(isThere) {
	    		cartItems.get(cartItems.indexOf(newItem)).addItem();
	    	} else {
	    		cartItems.add(newItem);
	    	}
	    	cart.clear();
	    	for(CartItem g: cartItems) {
	    		cart.add(g.getName());
			}
	    	cartList.setItems(cart);
    	}
    	
    }

    @FXML
    void pressSearch(ActionEvent  event) {
    	storeList.setItems(ProjectSort.searchFunc(itemSearch.getText(),items));
    }

    @FXML
    void Filterclicked(MouseEvent event) {
    	ArrayList<CheckBox> checkedBoxes = FilterController.checkFilters(filters);
    }
  //none fxml stuff
  //These store the items and amount of times they're added to cart for the toCart button
    ObservableList<CartItem> cartItems = FXCollections.observableArrayList();
    //OL for items in cart
    private ObservableList<String> cart = FXCollections.observableArrayList();
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
