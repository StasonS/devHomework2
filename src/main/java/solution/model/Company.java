package solution.model;

import solution.dao.interfaces.DBObject;

public class Company implements DBObject{

    private Long id;
    private String company_name;

    public Company() {
    }

    public Company(Long id, String company_name) {
        this.id = id;
        this.company_name = company_name;
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
        return company_name;
    }

    @Override
    public void setName(String name) {
        this.company_name = company_name;
    }

//    public String getCompany_name() {
//        return company_name;
//    }

//    public void setCompany_name(String company_name) {
//        this.company_name = company_name;
//    }

    public Company withId(Long id){
        this.setId(id);
        return this;
    }

    public Company withCompanyName(String company_name){
        this.setName(company_name);
        return this;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", company_name='" + company_name + '\'' +
                '}';
    }
}
