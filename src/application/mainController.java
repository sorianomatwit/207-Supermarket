package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import dsApp.CartItem;
import dsApp.FilterController;
import dsApp.ProjectSort;
import dsApp.ShoppingItem;
import dsApp.Storage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
    private Button clearButtonNo;

    @FXML
    private Button clearButtonYes;

    @FXML
    private Button clearCart;

    @FXML
    private Label clearLabel;

    @FXML
    private Pane clearPane;

    @FXML
    private BorderPane imgViewer;
    
    @FXML
    private BorderPane imgViewer1;
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
    void clearCart(ActionEvent event) {
    	clearPane.setVisible(true);
    }

    @FXML
    void clearNo(ActionEvent event) {
    	clearPane.setVisible(false);
    }

    @FXML
    void clearYes(ActionEvent event) {
    	cart.removeAll(cart);
    	cartItems.removeAll(cartItems);
    	cartList.setItems(cart);
    	clearPane.setVisible(false);
    	this.totalPriceView.setText(String.format("Total Price: $%.2f",CartItem.calcTotal(cartItems)));
    }

    @FXML
    void searchKeyPress(KeyEvent event) {
    	if(event.getCode() == KeyCode.ENTER) {
    		ProjectSort.searchFunc(itemSearch.getText(),items);
    	}
    }
    
    @FXML
    void ShopClicked(MouseEvent event) {
    	this.itemField.setVisible(true);
    	String sel = storeList.getSelectionModel().getSelectedItem();
    	int indexOf = storeList.getItems().indexOf(sel);
    	if(indexOf >= 0) {
	    	ShoppingItem selI = stock.getItemFromString(sel);
	    	itemDescription.setText(String.format("%1s $%.2f",selI.getDescription(), selI.getPrice()));

	    	/*
	    	 * Setting the imgViewer to the proper image
	    	 */
	    	ImageView imgView = new ImageView();
	    	//both of these work so plan a is to read an image from the excel sheet. Plan B is read a url of where the image is
	    	Image img = stock.getItemFromString(sel).getPic();
	    	imgView.setImage(img);
	    	imgView.setFitWidth(imgViewer.getPrefWidth() - 28);
	    	imgView.setFitHeight(imgViewer.getPrefHeight() - 25);
	    	imgViewer.setCenter(imgView);
	    	/*
	    	 * end of setting imgViewer
	    	 */
	    	
    	}
    }
    

    @FXML
    void CartClicked(MouseEvent event) {
    	
    	if(cartList.getSelectionModel().isEmpty() == false) {
    		this.itemField1.setVisible(true);
        	String sel = cartList.getSelectionModel().getSelectedItem();
        	int indexOf = cart.indexOf(sel);
        	if(indexOf >= 0) {
    	    	itemDescription1.setText(String.format("%1s $%.2f", cartItems.get(indexOf).getDescription(), cartItems.get(indexOf).getPrice()));
        	}
        	this.totalPriceView.setText(String.format("Total Price: $%.2f",CartItem.calcTotal(cartItems)));
        	
        	ImageView imgView = new ImageView();
        	//both of these work so plan a is to read an image from the excel sheet. Plan B is read a url of where the image is
        	Image img = cartItems.get(indexOf).getPic();
        	imgView.setImage(img);
        	imgView.setFitWidth(imgViewer1.getPrefWidth() - 28);
        	imgView.setFitHeight(imgViewer1.getPrefHeight() - 25);
        	imgViewer1.setCenter(imgView);
    	}
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
    	this.totalPriceView.setText(String.format("Total Price: $%.2f",CartItem.calcTotal(cartItems)));
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
    	this.totalPriceView.setText(String.format("Total Price: $%.2f",CartItem.calcTotal(cartItems)));
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
	    	CartItem newItem = new CartItem(stock.getItemFromString(sel),1);
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
	    	
    	}
    	
    	this.totalPriceView.setText(String.format("Total Price: $%.2f",CartItem.calcTotal(cartItems)));
    } 

    @FXML
    void pressSearch(ActionEvent  event) {
    	ProjectSort.searchFunc(itemSearch.getText(),items);
    }

    @FXML
    void Filterclicked(MouseEvent event) { 
    	//fix it to whre now the checkbox check off even if you dont click the box
    	CheckBox sel = FilterView.getSelectionModel().getSelectedItem();
    	if(sel != null) {
	    	sel.setSelected(!sel.isSelected());
	    	this.itemField.setVisible(true);
	    	ArrayList<CheckBox> checkedBoxes = FilterController.allCheckFilters(filters);
	    	items.setAll(stock.getAllItemsNames());
	    	for(CheckBox c: checkedBoxes) {
	    		FilterController.filterItems(c.getText(), items, stock);
	    	}
    	}
    	
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
    //storage
    Storage stock = new Storage();
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
    	
    	cartList.setItems(cart);
    	
    	stock.setup(items);
    	storeList.setItems(items);
    	
    	
    	timeline.setCycleCount(Timeline.INDEFINITE);
    	timeline.play();
    }
}
