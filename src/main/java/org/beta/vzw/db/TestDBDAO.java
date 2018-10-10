package org.beta.vzw.db;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestDBDAO {
    private String connectionString;
    private String username;
    private String paswoord;
    private static final String SELECT = "SELECT * from persoon";
    private static final String SELECT_BY_ID = "SELECT * from persoon where id = ?";

    public TestDBDAO(String connectionString, String username, String paswoord) {
        this.connectionString = connectionString;
        this.username = username;
        this.paswoord = paswoord;
    }
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionString, username, paswoord);

    }
    public Persoon getPersoon (int id) throws SQLException{
        Persoon p = null;
        try(Connection conn = getConnection()){
            PreparedStatement stm = conn.prepareStatement(SELECT_BY_ID);
            stm.setInt(1, id);
            try(ResultSet rs = stm.executeQuery()){
                if (rs.next()){
                    p=parsePersoon(rs);
                }
            }
        }
        return p;
    }

    public List <Persoon> getPersonen() throws SQLException{
        List <Persoon> personen = new ArrayList<>();
        try(Connection conn = getConnection();
            Statement stat = conn.createStatement();
            ResultSet rs = ((Statement) stat).executeQuery(SELECT)){
            while (rs.next()){
                Persoon p = parsePersoon(rs);
                personen.add(p);
            }
        }

        return personen;
    }

    private Persoon parsePersoon(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String voornaam = rs.getString("voornaam");
        String achternaam = rs.getString("achternaam");
        LocalDate geboortedatum = rs.getDate("geboortedatum").toLocalDate();
        return new Persoon(id, voornaam, achternaam, geboortedatum);
    }
}
