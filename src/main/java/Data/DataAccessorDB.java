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
public class DataAccessorDB {
    
    static public recipe getRecipe(String name) {
        recipe res = null;
        try {
            DBConnector c = new DBConnector();

            String query = "SELECT Instructions, ingredients FROM db_recipes.recipes WHERE Recipe_name = '" + name + "';";

            Connection connection = c.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String inst = rs.getString("Instructions");
                String ingred = rs.getString("ingredients");
                res = new recipe(name, inst, ingred);
            }
            System.out.println(res);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(res);
        return res;
    }
}
