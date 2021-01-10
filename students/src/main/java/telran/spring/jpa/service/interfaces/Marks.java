package telran.spring.jpa.service.interfaces;

import java.util.List;

import telran.spring.jpa.dto.IntervalMarks;

public interface Marks {
	List<Integer> getTopMarksEncountered(int nMarks, String subject);

	List<IntervalMarks> getIntervalsMarks(int interval);

}
