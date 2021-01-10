package telran.spring.jpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import telran.spring.jpa.dto.IntervalMarks;
import telran.spring.jpa.entities.Mark;

public interface MarkRepository extends JpaRepository<Mark, Integer> {

	@Query(value = "SELECT mark FROM students_marks_subjects where subject =:subject "
			+ "and mark > (SELECT avg(mark) from marks) group by mark,subject "
			+ "order by count(*) desc, mark desc limit :n_marks", nativeQuery = true)
	List<Integer> findTopMarksEncountered(@Param("n_marks") int nMarks, @Param("subject") String subject);

//	@Query(value = 
//			 "select 60 + ((bucket-1) * (100-60)/:interval)  as min, "
//			+ "(60 + (bucket) * (100-60)/:interval) as max, " 
//			+ "countOfOccurencies from ( "
//			+ "select width_bucket(mark, 60, 100, :interval) as bucket, "
//			+ "count(*) as countOfOccurencies "
//			+ "from marks "
//			+ "group by bucket "
//			+ "order by bucket) x;", nativeQuery = true)
//	

	@Query(value = "select (m.mark/:interval)*:interval as min, "
			+ "(m.mark/:interval)*:interval+:interval-1 as max, " + "count(*) as countOfOccurencies "
			+ "from marks m group by min,max order by 1", nativeQuery = true)

	List<IntervalMarks> findIntervalsMarks(@Param("interval") int interval);
}
