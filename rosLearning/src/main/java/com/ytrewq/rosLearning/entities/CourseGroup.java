package com.ytrewq.rosLearning.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "course_group")
public class CourseGroup extends BaseEntity {
    private Group group;
    private Course course;

    public CourseGroup(Group group, Course course) {
        this.group = group;
        this.course = course;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
