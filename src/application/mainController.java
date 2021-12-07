package application;

import java.util.ArrayList;

import dsApp.CartItem;
import dsApp.FilterController;
import dsApp.ProjectSort;
import dsApp.ShoppingItem;
import dsApp.Storage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private Button addToCart;

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
    private Label totalPriceView;


    @FXML
    void NextImgL(MouseEvent event) {

    }

    @FXML
    void NextImgR(MouseEvent event) {

    }
    
    @FXML
    private TableColumn<ShoppingItem, String> ShopFoodCol;

    @FXML
    private TableColumn<ShoppingItem, Double> ShopPriceCol;

    @FXML
    private TableView<ShoppingItem> ShopTableView;
    
    @FXML
    private TableView<CartItem> CartTableView;
    
    @FXML
    private TableColumn<CartItem, String> CartFoodCol;

    @FXML
    private TableColumn<CartItem, Double> CartPriceCol;
    
    @FXML
    private TableColumn<CartItem, Integer> CartAmtCol;
    
    @FXML
    private ListView<CheckBox> FilterView;
    
    
    @FXML
    private Pane tcentPane;

    @FXML
    private Pane tenPane;

    @FXML
    private Pane tfcentPane;

    @FXML
    private Pane twentyPane;
    
    @FXML
    private Pane ocentPane;

    @FXML
    private Pane onePane;
    
    @FXML
    private Pane fcentPane;

    @FXML
    private Pane fiftyPane;

    @FXML
    private Pane fivePane;

    @FXML
    private Pane hundredPane;
    
    @FXML
    private Label customerChange;

    @FXML
    private TextField customerPayed;
    
    @FXML
    private Button checkoutButton;

    @FXML
    private Pane checkoutPane;

    @FXML
    private Label checkoutTotal;
    
    @FXML
    private Label b100Label;

    @FXML
    private Label b10Label;

    @FXML
    private Label b1Label;

    @FXML
    private Label b20Label;

    @FXML
    private Label b50Label;

    @FXML
    private Label b5Label;

    @FXML
    private Label c10Label;

    @FXML
    private Label c1Label;

    @FXML
    private Label c25Label;

    @FXML
    private Label c5Label;

    
    @FXML
    void checkoutPress(ActionEvent event) {
    	checkoutPane.setVisible(true);
    	itemField1.setVisible(false);
    }
    
    @FXML
    void ShopTableClicked(MouseEvent event) {
    	this.itemField.setVisible(true);
    	ShoppingItem sel = this.ShopTableView.getSelectionModel().getSelectedItem();
    	if(sel != null) {
	    	itemDescription.setText(String.format("%1s $%.2f",sel.getDescription(), sel.getPrice()));

	    	/*
	    	 * Setting the imgViewer to the proper image
	    	 */
	    	ImageView imgView = new ImageView();
	    	//both of these work so plan a is to read an image from the excel sheet. Plan B is read a url of where the image is
	    	Image img = sel.getPic();
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
    void CartTableClicked(MouseEvent event) {
    	
    	if(CartTableView.getSelectionModel().isEmpty() == false) {
    		this.itemField1.setVisible(true);
    		checkoutPane.setVisible(false);
        	CartItem sel = CartTableView.getSelectionModel().getSelectedItem();
        	if(sel != null) {
    	    	itemDescription1.setText(String.format("%1s $%.2f", sel.getDescription(), sel.getPrice()));
        	}
        	this.totalPriceView.setText(String.format("Total Price: $%.2f",CartItem.calcTotal(cartItems)));
        	checkoutTotal.setText(String.format("Total Price: $%.2f",CartItem.calcTotal(cartItems)));
        	
        	ImageView imgView = new ImageView();
        	//both of these work so plan a is to read an image from the excel sheet. Plan B is read a url of where the image is
        	Image img = sel.getPic();
        	imgView.setImage(img);
        	imgView.setFitWidth(imgViewer1.getPrefWidth() - 28);
        	imgView.setFitHeight(imgViewer1.getPrefHeight() - 25);
        	imgViewer1.setCenter(imgView);
    	}
    }
    
    @FXML
    void clearCart(ActionEvent event) {
    	if(!questionBar.isVisible()) {
        	clearPane.setVisible(true);
    	}
    }

    @FXML
    void clearNo(ActionEvent event) {
    	clearPane.setVisible(false);
    }

    @FXML
    void clearYes(ActionEvent event) {
    	cart.removeAll(cart);
    	cartItems.removeAll(cartItems);
    	clearPane.setVisible(false);
    	this.totalPriceView.setText(String.format("Total Price: $%.2f",CartItem.calcTotal(cartItems)));
      	checkoutTotal.setText(String.format("Total Price: $%.2f",CartItem.calcTotal(cartItems)));
    }

    @FXML
    void searchKeyPress(KeyEvent event) {
    	if(event.getCode() == KeyCode.ENTER) {
    		ProjectSort.searchFunc(itemSearch.getText(),items);
    	}
    }
   
    
    @FXML
    void questionHitYes(ActionEvent event) {
    	CartItem sel = CartTableView.getSelectionModel().getSelectedItem();
    	int indexOf = CartTableView.getItems().indexOf(sel);
    	if(indexOf >= 0) {
    		cartItems.remove(indexOf);
    		cart.remove(indexOf);
    	}
    	
    	CartTableView.refresh();
    	questionBar.setVisible(false);
    	this.totalPriceView.setText(String.format("Total Price: $%.2f",CartItem.calcTotal(cartItems)));
      	checkoutTotal.setText(String.format("Total Price: $%.2f",CartItem.calcTotal(cartItems)));
    }

    @FXML
    void questionHitNo(ActionEvent event) {
    	CartItem sel = CartTableView.getSelectionModel().getSelectedItem();
    	int indexOf = cart.indexOf(sel);
    	if(indexOf >= 0) {
    		cartItems.get(indexOf).subItem();
    		cart.set(indexOf, cartItems.get(indexOf).getName());
    	}
    	CartTableView.refresh();
    	questionBar.setVisible(false);
    	this.totalPriceView.setText(String.format("Total Price: $%.2f",CartItem.calcTotal(cartItems)));
      	checkoutTotal.setText(String.format("Total Price: $%.2f",CartItem.calcTotal(cartItems)));
    }

    
    @FXML
    void removeFromCart(ActionEvent  event) {
    	
    	if(!clearPane.isVisible()) {
        	CartItem sel = CartTableView.getSelectionModel().getSelectedItem();
        	int indexOf = CartTableView.getItems().indexOf(sel);
        	if(indexOf >= 0) {
        		questionBar.setVisible(true);
        	}
    	}  
    }

    @FXML 
    void toCart(ActionEvent  event) {
    	
    	ShoppingItem sel = this.ShopTableView.getSelectionModel().getSelectedItem();
    	if(sel != null) {
	    	CartItem newItem = new CartItem(sel,1);
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
    	CartTableView.refresh();
    	this.totalPriceView.setText(String.format("Total Price: $%.2f",CartItem.calcTotal(cartItems)));
      	checkoutTotal.setText(String.format("Total Price: $%.2f",CartItem.calcTotal(cartItems)));
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
	    	ArrayList<String> filterList = new ArrayList<>();
	    	stock.setup(items);
	    	
	    	for(CheckBox c: checkedBoxes) {
	    		filterList.add(c.getText());
	    	}
	    	FilterController.filterItems(filterList, items);
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
    private ObservableList<ShoppingItem> items = FXCollections.observableArrayList();
    //storage
    Storage stock = new Storage();
    //timeline
    Timeline timeline = new Timeline(
    		new KeyFrame(Duration.millis(30), frame -> {
    			//System.out.println("frame passed");
    		})
    	);
    
    public void initialize() {
    	
    	
    	//filter intial
    	FilterController.setup(filters);
    	this.FilterView.setItems(filters);
    	
    	//cart initial
    	CartTableView.setItems(cartItems);
    	this.CartFoodCol.setCellValueFactory(new PropertyValueFactory<CartItem, String>("name"));
    	this.CartPriceCol.setCellValueFactory(new PropertyValueFactory<CartItem, Double>("price"));
    	this.CartAmtCol.setCellValueFactory(new PropertyValueFactory<CartItem, Integer>("amt"));
    	
    	//shop initial
    	stock.setup(items);
    	ShopTableView.setItems(items);
    	this.ShopFoodCol.setCellValueFactory(new PropertyValueFactory<ShoppingItem, String>("name"));
    	this.ShopPriceCol.setCellValueFactory(new PropertyValueFactory<ShoppingItem, Double>("price"));
    	
    	timeline.setCycleCount(Timeline.INDEFINITE);
    	timeline.play();
    }
}

