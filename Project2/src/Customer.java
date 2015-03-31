/**
 * Created by Brandon Braun on 3/30/2015.
 *      ID: text
 *      CustomerName: text
 *      Address: text
 *      City: text
 *      State: text
 *      Zip: text
 *      Orders: currency
 */
public class Customer {

    String id;
    String customerName;
    String address;
    String city;
    String state;
    String zip;
    float orders;

    public Customer(String i, String cn, String a, String c, String s, String z, float o) {
        id = i;
        customerName = cn;
        address = a;
        city = c;
        state = s;
        zip = z;
        orders = o;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public float getOrders() {
        return orders;
    }

    public void setOrders(float orders) {
        this.orders = orders;
    }

    public String getCustomerInfo() {
        return  "ID: " + id + "\nCustomer Name: " + customerName + "\nAddress: " + address +
                "\nState: " + state + "\nZip: " + zip + "\nOrders: $" + String.format("%.02f", orders);
    }

}
