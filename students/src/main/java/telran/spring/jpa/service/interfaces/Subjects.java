package telran.spring.jpa.service.interfaces;

import java.util.List;

public interface Subjects {

	List<String> getSubjectsHighestMarks();

	List<String> getTopSubjectsHighestMarks(int nSubjects);
}
