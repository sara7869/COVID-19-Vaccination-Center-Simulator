package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ReceiptController 
{
    public Label fNameLabel,surnameLabel,ageLabel,cityLabel,nicOrPassportLabel,vaccineLabel,boothLabel,dateLabel,timeLabel;

    //adds values to the empty labels in receipt window
    //@param firstname,surname,age,city,nicPassport,vaccine,booth,date,time- the data entered in the form
    //@return none
    @FXML
    void addValuesToLabels(String firstname, String surname, String age, String city, String nicPassport, String vaccine, String booth, String date, String time) 
    {
        fNameLabel.setText(firstname);
        surnameLabel.setText(surname);
        ageLabel.setText(age);
        cityLabel.setText(city);
        nicOrPassportLabel.setText(nicPassport);
        vaccineLabel.setText(vaccine);
        boothLabel.setText(booth);
        dateLabel.setText(date);
        timeLabel.setText(time);
    }
}
