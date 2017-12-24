package solution.model;

import solution.dao.interfaces.DBObject;

public class Developer implements DBObject{

    private Long id;
    private String first_name;
    private String last_name;

    public Developer() {
    }

    public Developer(Long id, String first_name, String last_name) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
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
        return getFirst_name() + " " + getLast_name();
    }

    @Override
    public void setName(String name) {
        String[] fullName = name.split(" ");
        setFirst_name(fullName[0]);
        try {
            setLast_name(fullName[1]);
        } catch (Exception e){
            setLast_name("no last name");
        }
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Developer withId(Long id){
        this.id = id;
        return this;
    }

    public Developer withFirstName(String first_name){
        this.first_name = first_name;
        return this;
    }

    public Developer withLastName(String last_name){
        this.last_name = last_name;
        return this;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }
}
