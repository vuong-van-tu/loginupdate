package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ReadFileAccount {
    public static ObservableList<Account> readAccountCSVFile(String path) throws IOException {
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        String content ;
        ObservableList<Account> newAccountList = FXCollections.observableArrayList();
            while((content = br.readLine())!=null) {
                String[] line = content.split(",");
               newAccountList.add(new Account(line[0],line[1]));
            }

        return newAccountList;
    }
}
