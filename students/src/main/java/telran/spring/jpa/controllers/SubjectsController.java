package telran.spring.jpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import telran.spring.jpa.service.interfaces.Subjects;

@RestController
public class SubjectsController {
	@Autowired
	Subjects subjects;

	@GetMapping("/subjects/marks/highest")
	public List<String> subjectsMarksHighest(@RequestParam(name = "n_subjects", defaultValue = "0") int n_Subjects) {
		if (n_Subjects == 0) {
			return subjects.getSubjectsHighestMarks();
		}
		return subjects.getTopSubjectsHighestMarks(n_Subjects);
	}

}
