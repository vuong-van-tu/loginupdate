package sample;


import javafx.collections.ObservableList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileAccount {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FUND_FILE_HEADER = "user name , password";

    public static void writeFileAccount(String path, ObservableList<Account> listAccount) throws IOException {
        FileWriter fw = new FileWriter(path,true);
        BufferedWriter bf = new BufferedWriter(fw);
        fw.append(NEW_LINE_SEPARATOR);
        for (Account account:listAccount) {
            fw.append(account.getUsername());
            fw.append(COMMA_DELIMITER);
            fw.append(account.getPassword());
        }
        fw.flush();
        fw.close();
        bf.close();
    }

}
