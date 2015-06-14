/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MazeOefenMeuk;

import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Aaik
 */
public class ScoreDatabase {

    public static void main(String[] args) {

    }

    public ScoreDatabase() {

    }

    public void insertScore(String naam, int stappen, int score) {
        try {

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String datum = dateFormat.format(date);

            Sql_connect.doConnect();
            String prepSqlStatement
                    = "INSERT INTO blokD (naam, stappen, score, datum) "
                    + "VALUES (?, ?, ?, ?)";
            PreparedStatement stat = Sql_connect.getConnection().prepareStatement(prepSqlStatement);
            stat.setString(1, naam);
            stat.setInt(2, stappen);
            stat.setInt(3, score);
            stat.setString(4, datum);
            stat.executeUpdate();

        } catch (Exception e) {
        }
    }
    
}
