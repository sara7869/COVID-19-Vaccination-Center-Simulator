package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class FormController 
{
    public Button closeFormAndGenerateReceiptButton;
    public TextField fNameTxt,surnameTxt,ageTxt,cityTxt,nicOrPassportTxt,vaccineTxt,boothTxt,dateTxt,timeTxt;
    public static String firstName, surname, age, city, nicPassport, vaccine, booth, date, time;
    public Label tempLabel;

    //close patient details form
    //create receipt window and calls function that adds the values to the empty labels
    //@param actionevent
    //@return none
    @FXML
    public void closeFormAndGenerateReceipt(ActionEvent event) throws IOException 
    {
        firstName=fNameTxt.getText();
        surname=surnameTxt.getText();
        age=ageTxt.getText();
        city=cityTxt.getText();
        nicPassport=nicOrPassportTxt.getText();
        vaccine=vaccineTxt.getText();
        booth=boothTxt.getText();
        date=dateTxt.getText();
        time=timeTxt.getText();

        Stage tempStage=(Stage) closeFormAndGenerateReceiptButton.getScene().getWindow();
        tempStage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Receipt.fxml"));
        Parent root = loader.load();
        ReceiptController receiptController = loader.getController();
        receiptController.addValuesToLabels(firstName, surname, age, city, nicPassport, vaccine, booth, date, time);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Receipt");
        stage.setScene(scene);
        stage.show();
    }

}

