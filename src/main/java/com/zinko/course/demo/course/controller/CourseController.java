package com.zinko.course.demo.course.controller;

import com.zinko.course.demo.course.dao.CourseDao;
import com.zinko.course.demo.course.ds.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseDao courseDao;

    @GetMapping("/courses")
    public ModelAndView index() {
        return new ModelAndView("courses", "courses", courseDao.findAll());
    }

    @GetMapping("/course")
    public List<Course> all() {
        return courseDao.findAll();
    }

    @GetMapping("/courses/create")
    public ModelAndView create() {
        return new ModelAndView("courses-create", "courses", new Course());
    }

    @PostMapping("/courses/create")
    public void create(@ModelAttribute Course course, BindingResult bindingResult, HttpServletResponse response) throws IOException {
        if (bindingResult.hasErrors()) {
            response.sendRedirect("courses-create");

        } else {
            courseDao.save(course);
            response.sendRedirect("/courses");

        }
    }

    @PutMapping("/courses/update/{id}")
    public void update(@RequestBody Course course, @PathVariable int id,HttpServletResponse  response) throws IOException {
         courseDao.findById(id)
                .map(c -> {
                    c.setName(course.getName());
                    c.setContent(course.getContent());
                    c.setStart_date(course.getStart_date());
                    c.setDuration(course.getDuration());
                    c.setImage(course.getImage());
                    c.setFees(course.getFees());
                    return courseDao.save(c);


                }).orElseGet(() -> {
                    course.setId(id);
                    return courseDao.save(course);
                });
        response.sendRedirect("/courses");
    }

    @DeleteMapping("/courses/delete/{id}")
    public void delete(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        courseDao.deleteById(id);
        response.sendRedirect("/courses");
    }

}
