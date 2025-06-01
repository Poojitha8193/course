package university.course.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import university.course.entity.Course;

@Component
public interface Repository extends JpaRepository<Course, Long> {

}
