
package dd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class adddoctor {
    Connection con;
    Scanner s1;
    PreparedStatement ps;
 // Constructor to initialize doctor addition process
    public adddoctor(Connection con,Scanner s1,PreparedStatement ps) {
        this.con = con;
        this.s1 = s1;
        this.ps=ps;
        Adddoctor();
    }
 // Method to add a new doctor
    public void Adddoctor() {
        
            s1.nextLine();  // Consume newline left in buffer
             System.out.print("Enter the doctor_id :- ");
            String doctor_id = s1.nextLine();
            System.out.print("Enter the first name :- ");
            String firstName = s1.nextLine();
            System.out.print("Enter the last name :- ");
            String lastName = s1.nextLine();
            System.out.print("Enter the specialization :- ");
            String specialization = s1.nextLine();
            
            try {
                 // SQL query to insert a new doctor
             String query = "INSERT INTO doctors (doctor_id,first_name,last_name,specialization) VALUES (?,?,?,?)";
            ps = con.prepareStatement(query);
             // Setting parameters for the query
            ps.setString(1, doctor_id);
            ps.setString(2, firstName);
            ps.setString(3, lastName);
            ps.setString(4, specialization);
            
            // Executing the query
            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("Doctor added successfully!");
            } else {
                System.out.println("Failed to add Doctor.");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
