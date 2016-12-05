package ru.sbt.lesson9;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Task {
    public Set<Course> courses(List<Lecture> lectures) {
        return lectures.stream()
                .map(Lecture::getCourse)
                .collect(Collectors.toSet());
    }

    //course.length < 20
    public Set<String>  lecturersForShortCourse(List<Lecture> lectures) {
        return lectures.stream()
                .filter(lecture -> lecture.getCourse().getLength() < 20)
                .map(lecture -> lecture.getCourse().getLecturer())
                .collect(Collectors.toSet());
    }

    public Course mostBoring(List<Lecture> lectures) {
        int max = lectures.stream().map(lecture -> lecture.getCourse().getLength()).max(Integer::compare).get();
        return lectures.stream()
                .map(Lecture::getCourse)
                .filter(course -> course.getLength() == max)
                .findAny().get();

    }

    public Map<Course, List<Lecture>> courseToLectures(List<Lecture> lectures){
        return lectures.stream()
                .collect(Collectors.groupingBy(Lecture::getCourse));
    }
}
