package telran.spring.jpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import telran.spring.jpa.dto.IntervalMarks;
import telran.spring.jpa.service.interfaces.Marks;

@RestController
public class MarksController {

	@Autowired
	Marks marks;

	@GetMapping("/marks/widespread/{subject}")
	public List<Integer> getMarksWideSpred(@RequestParam(name = "n_marks") int nMarks,
			@PathVariable("subject") String subject) {
		return marks.getTopMarksEncountered(nMarks, subject);
	}

	@GetMapping("/marks/distribution")
	public List<IntervalMarks> getDistribution(@RequestParam(name = "interval", defaultValue = "10") int interval) {
		return marks.getIntervalsMarks(interval);
	}
}
