package cc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class addPatient {
    Connection con;
    Scanner s1;
    PreparedStatement ps;
  // Constructor initializes the class and calls AddPatient()
    public addPatient(Connection con,Scanner s1,PreparedStatement ps) {
        this.con = con;
        this.s1 = s1;
        this.ps=ps;
        AddPatient();
    }
    // Method to insert a new patient into the database
    public void AddPatient() {
        
            s1.nextLine(); 
            // Collect patient details from user input
            System.out.print("Enter patient's first name:- ");
            String firstName = s1.nextLine();
            System.out.print("Enter patient's last name:- ");
            String lastName = s1.nextLine();
            System.out.print("Enter patient's gender:- ");
            String gender = s1.nextLine();
            System.out.print("Enter date of birth :- ");
            String dobInput = s1.nextLine();
            System.out.print("Enter phone number:- ");
            String phone = s1.nextLine();
            System.out.print("Enter email:- ");
            String email = s1.nextLine();
            System.out.print("Enter address:- ");
            String address = s1.nextLine();
            System.out.print("Enter doctor ID :- ");
            int doctorid = s1.nextInt();
            System.out.print("Enter bed number :- ");
            int bednumber = s1.nextInt();
            
            try {
            // SQL query to insert a new patient record
           String query = "INSERT INTO patients (first_name,last_name,gender,dob,phone,email,address, doctor_id,bed_number) VALUES (?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
             // Setting the values for the prepared statement
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, gender);
            ps.setString(4,  dobInput);
            ps.setString(5, phone);
            ps.setString(6, email);
            ps.setString(7, address);
            ps.setInt(8, doctorid);
            ps.setInt(9, bednumber);
            // Execute the query
            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("Patient added successfully!");
            } else {
                System.out.println("Failed to add patient.");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
