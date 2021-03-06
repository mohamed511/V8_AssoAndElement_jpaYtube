package entity;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Embedded
    @AssociationOverride(name = "professors",
            joinTable = @JoinTable(name = "student_prof",
                    joinColumns = @JoinColumn(name = "student"),
                    inverseJoinColumns = @JoinColumn(name = "prof")))
    private ProfessorDetail professorDetail;

    public Student() {
    }

    public Student(String name, ProfessorDetail professorDetail) {
        this.name = name;
        this.professorDetail = professorDetail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProfessorDetail getProfessorDetail() {
        return professorDetail;
    }

    public void setProfessorDetail(ProfessorDetail professorDetail) {
        this.professorDetail = professorDetail;
    }
}
