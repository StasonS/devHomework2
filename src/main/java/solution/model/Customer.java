package solution.model;

import solution.dao.interfaces.DBObject;

public class Customer implements DBObject{

    private Long id;
    private String customer_name;

    public Customer() {
    }

    public Customer(Long id, String customer_name) {
        this.id = id;
        this.customer_name = customer_name;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return customer_name;
    }

    @Override
    public void setName(String name) {
        this.customer_name = customer_name;
    }

//    public String getCustomer_name() {
//        return customer_name;
//    }
//
//    public void setCustomer_name(String customer_name) {
//        this.customer_name = customer_name;
//    }

    public Customer withId(Long id){
        this.setId(id);
        return this;
    }

    public Customer withCustomerName(String customer_name){
        this.setName(customer_name);
        return this;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customer_name='" + customer_name + '\'' +
                '}';
    }
}
