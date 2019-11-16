package com.legacy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ItemDaoImpl implements ItemDao {


    private Connection connection;

    PreparedStatement statement = null;


    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void saveQuality(Item item) {
        statement = null;
        try {
            statement = connection.prepareStatement("update store set quality = ? where name = ?");
            statement.setInt(1, item.quality);
            statement.setString(2, item.name);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void saveSellIn(Item item) {
        statement = null;
        try {
            statement = connection.prepareStatement("update store set sellIn = ? where name = ?");
            statement.setInt(1, item.sellIn);
            statement.setString(2, item.name);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
