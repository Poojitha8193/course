package university.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import university.course.entity.Course;
import university.course.repository.Repository;

import java.util.List;

@RestController
@RequestMapping("/course")
@CrossOrigin(origins = "*")
public class Controller {
    @Autowired
    private Repository repo;

    @GetMapping("/all")
    public List<Course> getAllCourses() {
        return repo.findAll();
    }

    @PostMapping("/add")
    public Course createCourse(@RequestBody Course course) {
        return repo.save(course);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course course) {
        course.setId(id);
        return repo.save(course);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Course> getById(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCourse(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
