package com.jxl.springboot.LibraryMS.Entity;

import jakarta.persistence.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class Users {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "user_id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;
    @Column(name = "dob")
    private String dateObBirth;
    @Column(name = "email")
    private String email;
    @Column(name = "mobile_number")
    private String mobileNumber;
    @Column(name = "is_premium")
    private boolean isPremium;

    @Column(name = "is_enabled")
    private boolean isEnabled;

    @Column(name = "date_added")
    private String dateAdded;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "address")
    private Address address;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_roles")
    private List<Roles> rolesList = new ArrayList<>();


    //Constructor

    public Users() {
    }

    public Users(String firstName, String lastName
            , String userName, String password
            , String dateObBirth, String email
            , String mobileNumber, boolean isPremium,boolean isEnabled) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.dateObBirth = dateObBirth;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.isPremium = isPremium;
        this.isEnabled = isEnabled;
    }

    //Getters and setters


    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded() {
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        this.dateAdded = simpleDateFormat.format(new Date());
    }

    public List<Roles> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<Roles> rolesList) {
        this.rolesList = rolesList;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateObBirth() {
        return dateObBirth;
    }

    public void setDateObBirth(String dateObBirth) {
        this.dateObBirth = dateObBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", dateObBirth=" + dateObBirth +
                ", email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", address='" + address + '\'' +
                ", isPremium=" + isPremium +
                ", isEnabled=" + isEnabled +
                ", rolesList=" + rolesList +
                '}';
    }

}
