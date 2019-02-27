/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruger
 */
public class DataAccessorDB{
    

    public List<recipe> getrecipes() {
        ArrayList<recipe> list = new ArrayList<>();

        try {
            DBConnector c = new DBConnector();

            String query = "SELECT * FROM frame ORDER BY price;";

            Connection connection = c.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("frame_name");
                int price = rs.getInt("price");

                list.add(new recipes(name, price));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Frame getFrame(String name) throws DataException {
        Frame frame = null;

        try {
            DBConnector c = new DBConnector();

            String query = "SELECT * FROM frame WHERE frame_name = '" + name + "';";

            Connection connection = c.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int price = rs.getInt("price");

                frame = new Frame(name, price);
            }
            return frame;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return frame;
    }

}
