package com.ytrewq.rosLearning.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "course_group")
public class CourseGroup extends BaseEntity {
    private Group group;
    private Course course;

    

    public Group getGroup() {
        return group;
    }
    @ManyToOne()
    @JoinColumn(name = "group_id")
    public void setGroup(Group group) {
        this.group = group;
    }

    public Course getCourse() {
        return course;
    }
    @ManyToOne()
    @JoinColumn(name = "course_id")
    public void setCourse(Course course) {
        this.course = course;
    }
}
