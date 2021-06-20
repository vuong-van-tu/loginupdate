package sample;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserLogin implements Initializable {
    @FXML
    Button login;
    @FXML
    TextField ipname;
    @FXML
    TextField ippassword;
    RegisterUser register = new RegisterUser();

    public void setUser(ActionEvent event) throws IOException {
        Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("register.fxml"));
        Parent scene = loader1.load();
        Scene scene1 = new Scene(scene);
        stage1.setScene(scene1);
    }

    public void getLogin(ActionEvent event) throws IOException {
        ObservableList<Account> list = ReadFileAccount.readAccountCSVFile("account.csv");
        Boolean check = false;
        for (Account accounts : list) {
            if (String.valueOf(ipname.getText()).equals(accounts.getUsername()) && String.valueOf(ippassword.getText()).equals(accounts.getPassword())) {
                check=true;
            }

        }
        if (check){
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
            Pane myPane = (Pane) loader.load();
            Scene scene = new Scene(myPane);
            stage.setScene(scene);
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Sai tài khoản hoặc mật khẩu!");
            alert.show();
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

