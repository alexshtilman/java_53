package telran.spring.jpa.service.interfaces;

import java.util.List;

import telran.spring.jpa.dto.MarkDto;
import telran.spring.jpa.dto.StudentDto;
import telran.spring.jpa.dto.StudentsMarksCount;
import telran.spring.jpa.dto.SubjectDto;

public interface Students {

	void addStudent(StudentDto studentDto);

	void addSubject(SubjectDto subjectDto);

	void addMark(MarkDto markDto);

	String generateRandomData(int nStudents, int nSubjects, int nMarks, boolean uniqueMarks, int minMark, int maxMark);

	List<String> bestStudents();

	List<String> bestStudents(int nStudents);

	List<String> studentsSubject(String subject);

	List<String> bestStudentsSubect(int nStudents, String subject);

	List<StudentsMarksCount> getStudentsMarksCount();
}
