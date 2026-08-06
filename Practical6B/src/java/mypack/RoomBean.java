package mypack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.ejb.Stateless;

@Stateless
public class RoomBean {

    public boolean reserveRoom(String name,
            String room,
            String checkin,
            String checkout) {

        try {

            Class.forName("org.apache.derby.jdbc.ClientDriver");

            Connection con = DriverManager.getConnection(
                    "jdbc:derby://localhost:1527/RoomDB",
                    "root",
                    "root");

            PreparedStatement ps = con.prepareStatement(
                    "insert into reservation(name,roomtype,checkin,checkout) values(?,?,?,?)");

            ps.setString(1, name);
            ps.setString(2, room);
            ps.setDate(3, java.sql.Date.valueOf(checkin));
            ps.setDate(4, java.sql.Date.valueOf(checkout));

            int i = ps.executeUpdate();

            ps.close();
            con.close();

            if (i > 0) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

}