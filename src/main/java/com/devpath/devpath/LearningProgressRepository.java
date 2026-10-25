
package com.devpath.devpath;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LearningProgressRepository
        extends JpaRepository<LearningProgress, Long> {

    List<LearningProgress> findByLearnerNameIgnoreCaseOrderByLessonIdAsc(
            String learnerName);

    Optional<LearningProgress>
            findByLearnerNameIgnoreCaseAndLessonIdIgnoreCase(
                    String learnerName, String lessonId);
}
