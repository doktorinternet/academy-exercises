package com.company.week2.day3;

public class Objects {


    public static void run(){
        Address home = new Address(), delivery = new Address(), invoice = new Address();
        //Order order = new Order(12, "Farfars kalsonger", home, delivery, invoice);

        Order order = new Order(12, "Farfars andra kalsonger", home, delivery, home, home, home);
        System.out.println(order.homeAddress.toString());

    }
}

class Order{
    private int id;
    private String product;

    Address homeAddress, deliveryAddress, invoiceAddress;

    Order(){}

    public int getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Address getInvoiceAddress() {
        return invoiceAddress;
    }

    public void setInvoiceAddress(Address invoiceAddress) {
        this.invoiceAddress = invoiceAddress;
    }

    public Address getInvoice(){
        return invoiceAddress;
    }

    Order(int id, String product, Address ... addresses){
        this.id = id;
        this.product = product;
        if (addresses.length > 0){
            if(addresses.length > 3){
                System.out.println("Too many addresses supplied! Only the first three will be registered");
            }
            for (int i = 2; i>=0; i--){
                try{
                    switch(i){
                        case 2:
                            invoiceAddress  = addresses[2];
                        case 1:
                            deliveryAddress = addresses[1];
                            System.out.println("adding delivery address..");
                        case 0:
                            homeAddress     = addresses[0];
                            System.out.println("adding home address..");
                            return;
                    }
                }catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("Error " + e + ": tried to add addresses not provided.");
                }
            }
        }
    }

    Order(int id, String product, Address homeAddress, Address deliveryAddress, Address invoiceAddress){
        this.id              = id;
        this.product         = product;
        this.homeAddress     = homeAddress;
        this.deliveryAddress = deliveryAddress;
        this.invoiceAddress  = invoiceAddress;
    }
}

class Address{

    private String name, addressLine1, addressLine2, city, country, zipcode;
    int type;

    public Address(){}

    public String getName() {
        return name;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    boolean exists(){
        return this == null;
    }

    public Address(int type, String name, String addressLine1, String addressLine2, String city, String country, String zipcode){

        // Type should be either 0, 1 or 2 for home, delivery and invoiceadddress respectively
        this.type = type;

        this.name = name;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.country = country;
        this.zipcode = zipcode;
    }
}
