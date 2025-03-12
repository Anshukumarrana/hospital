
package ee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class addAppointment {
    Connection con;
    Scanner s1;
    PreparedStatement ps;
 // Constructor to initialize connection, scanner, and prepared statement
    public addAppointment(Connection con,Scanner s1,PreparedStatement ps) {
        this.con = con;
        this.s1 = s1;
        this.ps=ps;
       AddAppointment(); // Calls method to add an appointment
    }

     // Method to take user input and add an appointment
    public void AddAppointment() {
        
            s1.nextLine(); 
            System.out.print("Enter the appointment_id :- ");
            String appointmentid = s1.nextLine();
            System.out.print("Enter the patient_id :- ");
            String patientid = s1.nextLine();
            System.out.print("Enter the doctor_id :- ");
            String doctorid = s1.nextLine();
          
            
            try {
                // SQL query to insert the appointment details
            String query = "INSERT INTO appointments (appointment_id,patient_id,doctor_id) VALUES (?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, appointmentid);
            ps.setString(2, patientid);
            ps.setString(3, doctorid );
          
             
            // Execute the query
            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("Appointment added successfully!");
            } else {
                System.out.println("Failed to add Appointment.");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
