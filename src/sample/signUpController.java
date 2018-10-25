package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class signUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_field;

    @FXML
    private TextField password_field;

    @FXML
    private Button SignUpButton;

    @FXML
    private TextField signUpName;

    @FXML
    private TextField signUpSurname;

    @FXML
    private TextField signUpCountry;

    @FXML
    private CheckBox signUpCheckboxMale;

    @FXML
    private CheckBox signUpCheckboxFemale;

    @FXML
    void initialize() {

        SignUpButton.setOnAction(event -> {
              signUpNewUser();

        } );
    }

    private void signUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String firstName = signUpName.getText();
        String lastName = signUpSurname.getText();
        String userName = login_field.getText();
        String password = password_field.getText();
        String location = signUpCountry.getText();
        String gender;
        if(signUpCheckboxMale.isSelected())
            gender = "Male";
        else gender = "Famale";

        User user = new User(firstName,lastName,userName,password,location,gender);

        dbHandler.signUpUser(user);
    }
}
