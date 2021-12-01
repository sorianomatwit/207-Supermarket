package dsApp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;

public class mainController {

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
    private TextField itemSearch;

    @FXML
    private ListView<?> itemsList;

    @FXML
    private Tab shopTab;

    @FXML
    private Label totalProce;

}

