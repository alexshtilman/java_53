package telran.spring.jpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import telran.spring.jpa.dto.StudentsMarksCount;
import telran.spring.jpa.service.interfaces.Students;

@RestController
public class StudentsController {

	@Autowired
	Students students;

	@GetMapping("/students/best")
	public List<String> bestStudentNames(@RequestParam(name = "n_students", defaultValue = "0") int nStudents,
			@RequestParam(name = "subject", required = false) String subject) {

		if (nStudents == 0 && subject == null) {
			return students.bestStudents();
		}
		if (nStudents != 0 && subject == null) {
			return students.bestStudents(nStudents);
		}
		if (nStudents == 0) {
			return students.studentsSubject(subject);
		}
		return students.bestStudentsSubect(nStudents, subject);

	}

	@GetMapping("/students/marks/count")
	public List<StudentsMarksCount> studentsMarksCount() {
		return students.getStudentsMarksCount();
	}

}
