package es.ifoundthatx.db;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static final String URL = "jdbc:sqlite:data/game.db";

    static {
        try {
            try (Connection conn = getConnection()) {
                InputStream is = Database.class.getClassLoader().getResourceAsStream("db/schema.sql");
                if (is == null) throw new RuntimeException("[ERROR]: \"schema.db\" not found!");

                String schema = new String(is.readAllBytes(), StandardCharsets.UTF_8);
                try (Statement stmt = conn.createStatement()) {
                    stmt.executeUpdate(schema);
                }
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL);
    }
}
