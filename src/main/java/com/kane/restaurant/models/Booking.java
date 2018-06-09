package com.kane.restaurant.models;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

@Entity
@javax.persistence.Table(name="bookings")
public class Booking {
    private int id;
    private Customer customer;
    private int quantity;
    private Set<com.kane.restaurant.models.Table> tables;
    private Calendar time;
    private String additionalComment;

    public Booking() {
    }

    public Booking(Customer booker, int quantity, Calendar bookingTime, String additionalComment) {
        this.customer = booker;
        this.quantity = quantity;
        this.time = bookingTime;
        this.additionalComment = additionalComment;
        this.tables = new HashSet<com.kane.restaurant.models.Table>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name="customer_id", nullable = false)
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer booker) {
        this.customer = booker;
    }

    @Column(name="quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="bookings_and_tables",
        joinColumns = {@JoinColumn(name = "booking_id")},
        inverseJoinColumns = {@JoinColumn(name = "table_id")})
    public Set<com.kane.restaurant.models.Table> getTables() {
        return tables;
    }

    public void setTables(Set<com.kane.restaurant.models.Table> tables) {
        this.tables = tables;
    }

    @Column(name="time")
    public Calendar getTime() {
        return time;
    }

    public void setTime(Calendar time) {
        this.time = time;
    }

    public void addTable(com.kane.restaurant.models.Table table) {
        this.tables.add(table);
    }
}
