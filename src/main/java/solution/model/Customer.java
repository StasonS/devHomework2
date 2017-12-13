package solution.model;

public class Customer {

    private Long id;
    private String customer_name;

    public Customer() {
    }

    public Customer(Long id, String customer_name) {
        this.id = id;
        this.customer_name = customer_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public Customer withId(Long id){
        this.setId(id);
        return this;
    }

    public Customer withCustomerName(String customer_name){
        this.setCustomer_name(customer_name);
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
