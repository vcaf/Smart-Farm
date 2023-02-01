package com.avansb.smartfarm.gasmodule;

import android.content.Context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GasModuleDBC {

    private static final String DB_URL = "jdbc:postgresql://rogue.db.elephantsql.com:5432/xwpagpbd";
    private static final String DB_USER = "xwpagpbd";
    private static final String DB_PASS = "4Cw0k9cOwiVOcrSuN5aZ0BNP28gLPFrJ";

    public static void getTenModules() {
        try {
            // Proberen om een connectie te maken met de database
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            Statement stat = con.createStatement();

            String query = "SELECT * FROM \"smartfarm\".\"gasmodule\" LIMIT 10";
            ResultSet result = stat.executeQuery(query);
            while(result.next()) {
                GasModuleActivity.gasModuleLijst.add(new GasModuleModel(result.getInt("id"), result.getString("module_naam"), result.getInt("module_waarde"), result.getString("module_timestamp")));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}