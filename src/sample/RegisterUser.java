package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RegisterUser implements Initializable {
    private Label label;
    @FXML
    TextField regisname;
    @FXML
    TextField regispass;
    @FXML
    TextField regispass1;
    ObservableList<Account> listAccounts = FXCollections.observableArrayList();

    public void registerUser() throws IOException {
        if (regispass.getText().equals(regispass1.getText())){
            listAccounts.add(new Account(String.valueOf(regisname.getText()),String.valueOf(regispass.getText())));
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Đăng kí thành công");
            alert.show();
            WriteFileAccount.writeFileAccount("D:\\hackathon1\\hackathon\\src\\sample\\account.csv",listAccounts);
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Mật khẩu không trùng khớp");
            alert.show();
        }

    }

    public List<Account> accounts(){
        return listAccounts;
    }

    public void back(javafx.event.ActionEvent event) throws IOException {
        Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader =new FXMLLoader(getClass().getResource("UserLogin.fxml"));
        Pane myPane = (Pane) loader.load();
        Scene scene = new Scene(myPane);
        stage.setScene(scene);
//        System.out.println(accounts());;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}
