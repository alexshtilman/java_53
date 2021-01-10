package telran.spring.jpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.spring.jpa.dto.IntervalMarks;
import telran.spring.jpa.repo.MarkRepository;
import telran.spring.jpa.service.interfaces.Marks;

@Service
public class MarksJpaImpl implements Marks {

	@Autowired
	MarkRepository marks;

	@Override
	public List<Integer> getTopMarksEncountered(int nMarks, String subject) {
		return marks.findTopMarksEncountered(nMarks, subject);
	}

	@Override
	public List<IntervalMarks> getIntervalsMarks(int interval) {
		return marks.findIntervalsMarks(interval);
	}

}
