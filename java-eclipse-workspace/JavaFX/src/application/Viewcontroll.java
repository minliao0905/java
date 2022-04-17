package application;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Viewcontroll {

    @FXML
    private TextField userNameField;

    @FXML
    private TextField passwordfield;

    @FXML
    private Button loginButton;

    @FXML
    void login(ActionEvent event) {
    	String userName = userNameField.getText();
    	String password = passwordfield.getText();
      System.out.println("µÇÂ¼£¡"+"--"+userName+"--"+password);
    }

}
