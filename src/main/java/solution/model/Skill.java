package solution.model;

import solution.dao.interfaces.DBObject;

public class Skill implements DBObject{

    private Long id;
    private String skill_name;

    public Skill() {
    }

    public Skill(Long id, String skill_name) {
        this.id = id;
        this.skill_name = skill_name;
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
        return skill_name;
    }

    @Override
    public void setName(String name) {
        this.skill_name = name;
    }

    public Skill withId(Long id){
        this.setId(id);
        return this;
    }

    public Skill withSkillName(String skill_name){
        this.setName(skill_name);
        return this;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", skill_name='" + skill_name + '\'' +
                '}';
    }
}
