import com.kane.restaurant.db.DBHelper;
import com.kane.restaurant.models.Booking;
import com.kane.restaurant.models.Customer;
import com.kane.restaurant.models.Table;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Runner {
    public static void main(String[] args) {
        DBHelper.deleteAll(Table.class);
        DBHelper.deleteAll(Booking.class);
        DBHelper.deleteAll(Customer.class);

        Customer customer1 = new Customer("Ally", "ally@codeclan.com");
        DBHelper.save(customer1);
        Customer customer2 = new Customer("Alan", "alan@codeclan.com");
        DBHelper.save(customer2);
        Customer customer3 = new Customer("Upul", "upul@codeclan.com");
        DBHelper.save(customer3);

        Table table1 = new Table(4);
        DBHelper.save(table1);
        Table table2 = new Table(4);
        DBHelper.save(table2);
        Table table3 = new Table(2);
        DBHelper.save(table3);
        Table table4 = new Table(4);
        DBHelper.save(table4);
        Table table5 = new Table(4);
        DBHelper.save(table5);
        Table table6 = new Table(6);
        DBHelper.save(table6);
        Table table7 = new Table(12);
        DBHelper.save(table7);

        GregorianCalendar date1 = new GregorianCalendar();
        date1.set(2018, Calendar.OCTOBER, 20);

        GregorianCalendar date2 = new GregorianCalendar();
        date1.set(2018, Calendar.OCTOBER, 22);

        GregorianCalendar date3 = new GregorianCalendar();
        date1.set(2018, Calendar.OCTOBER, 12);
//
        Booking booking1 = new Booking(customer1, 5, date1);
        DBHelper.save(booking1);
//        Booking booking2 = new Booking(customer2, 8, date2);
//        Booking booking3 = new Booking(customer3, 2, date3);
    }
}