
package com.devpath.devpath;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
    name = "learning_progress",
    uniqueConstraints = @UniqueConstraint(
        columnNames = {"learner_name", "lesson_id"}
    )
)
public class LearningProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "learner_name", nullable = false)
    private String learnerName;

    @Column(name = "lesson_id", nullable = false)
    private String lessonId;

    @Column(nullable = false)
    private boolean completed;

    protected LearningProgress() {
    }

    public LearningProgress(
            String learnerName, String lessonId, boolean completed) {
        this.learnerName = learnerName;
        this.lessonId = lessonId;
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public String getLearnerName() {
        return learnerName;
    }

    public String getLessonId() {
        return lessonId;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
