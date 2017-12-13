package solution.model;

public class Skill {

    private Long id;
    private String skill_name;

    public Skill() {
    }

    public Skill(Long id, String skill_name) {
        this.id = id;
        this.skill_name = skill_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkill_name() {
        return skill_name;
    }

    public void setSkill_name(String skill_name) {
        this.skill_name = skill_name;
    }

    public Skill withId(Long id){
        this.setId(id);
        return this;
    }

    public Skill withSkillName(String skill_name){
        this.setSkill_name(skill_name);
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
