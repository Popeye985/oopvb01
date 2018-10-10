package org.beta.vzw.db;

import java.sql.SQLException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
    TestDBDAO dao = new TestDBDAO("jdbc:mysql://localhost/testdb?useSSL=false&serverTimezone=Europe/Brussels", "root", "Vdab");
    try{
        List<Persoon> personen = dao.getPersonen();
        for (Persoon p: personen){
            System.out.printf("%d) %s %s%n",p.getId(), p.getVoornaam(), p.getAchternaam());
        }

    }catch (SQLException ex){
        System.out.println(ex.getMessage());
    }

    }
}
