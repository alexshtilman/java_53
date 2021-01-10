package telran.spring.jpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.spring.jpa.repo.SubjectRepository;
import telran.spring.jpa.service.interfaces.Subjects;

@Service
public class SubjectsJpaImpl implements Subjects {

	@Autowired
	SubjectRepository subjects;

	@Override
	public List<String> getSubjectsHighestMarks() {
		return subjects.findSubjectsHighestMarks();
	}

	@Override
	public List<String> getTopSubjectsHighestMarks(int nSubjects) {
		return subjects.findTopSubjectsHighestMarks(nSubjects);
	}

}
