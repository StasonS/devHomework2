package solution.model;

import solution.dao.interfaces.DBObject;

public class Project implements DBObject{

    private Long id;
    private String project_name;

    public Project() {
    }

    public Project(Long id, String project_name) {
        this.id = id;
        this.project_name = project_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return project_name;
    }

    @Override
    public void setName(String name) {
        this.project_name = project_name;
    }

//    public String getProject_name() {
//        return project_name;
//    }
//
//    public void setProject_name(String project_name) {
//        this.project_name = project_name;
//    }

    public Project withId(Long id){
        this.setId(id);
        return this;
    }

    public Project withProjectName(String project_name){
        this.setName(project_name);
        return this;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", project_name='" + project_name + '\'' +
                '}';
    }
}
