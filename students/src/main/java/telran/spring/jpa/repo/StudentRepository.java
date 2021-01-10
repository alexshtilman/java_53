package telran.spring.jpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import telran.spring.jpa.dto.StudentsMarksCount;
import telran.spring.jpa.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	@Query(value = "SELECT s.name from students s join marks m on s.stid=m.stid"
			+ " GROUP by s.name having avg(mark)> (SELECT avg(mark)"
			+ " from marks) order by round(avg(mark)) desc", nativeQuery = true)
	List<String> findBestStudents();

	@Query(value = "SELECT s.name from students s join marks m on s.stid=m.stid group by s.name "
			+ "order by round(avg(mark)) desc limit :n_students", nativeQuery = true)
	List<String> findTopBestStudents(@Param("n_students") int nStudents);

	@Query(value = "SELECT name from students_marks_subjects  where subject where subject = :subject "
			+ "GROUP by name having round(avg(mark)) > (SELECT avg(mark) from students_marks_subjects "
			+ "where subject =:subject) order by round(avg(mark)) desc", nativeQuery = true)
	List<String> findBestStudentsSubject(@Param("subject") String subject);

	@Query(value = "SELECT name from students_marks_subjects   where subject = :subject "
			+ "GROUP by name order by round(avg(mark)) desc limit :n_students", nativeQuery = true)

	List<String> findTopBestStudentsSubect(@Param("n_students") int nStudents, String subject);

	@Query(value = "SELECT s.name, count(m.mark) as marksCount from students s left join marks m on s.stid=m.stid "
			+ "GROUP by name order by marksCount desc", nativeQuery = true)
	List<StudentsMarksCount> findStudentsMarksCount();
}
