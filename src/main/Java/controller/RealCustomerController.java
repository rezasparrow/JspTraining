package controller;

import javafx.util.Pair;
import presentation.RealCustomerView;
import util.MessageBundle;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class RealCustomerController {
    public static MessageBundle save(RealCustomerView realCustomerView) {
        MessageBundle messageBundle = new MessageBundle();
        messageBundle.addError("test", "error message");
        return messageBundle;
    }

//    public static List<Pair<String, String>> save(String firstName, String lastName, String fatherName, String nationalCode, String birthday) {
//        List<Pair<String, String>> errors = validate(firstName, lastName, fatherName, nationalCode, birthday);
//        errors.addAll(validateNationalCode(nationalCode));
//        if (errors.size() == 0) {
//            DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
//            Date date;
//            try {
//                date = df.parse(birthday);
//                RealCustomer realCustomer = new RealCustomer(firstName, lastName, fatherName, date, nationalCode);
//
//                realCustomer.save();
//
//            } catch (ParseException e) {
//                e.printStackTrace();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                errors.add(new Pair<String, String>("base", "unknown error"));
//            }
//        }
//        return errors;
//    }

}
