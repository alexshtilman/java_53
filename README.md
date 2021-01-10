1. Write all three layers (Controller-Service-Data) for the following methods
   1. Getting the subjects with the highest marks (based on the sum values for all the subject marks)
      1. Controller (think of the parameters), GET request (“/subjects/marks/highest”)
      1. Service 
         - List<String> getSubjectsHighestMarks();
         -  List<String> getTopSubjectsHighestMarks(int nSubjects);
      1. Repository (think of the annotations for both methods and parameters)
         - List<String> findSubjectsHighestMarks();
         - List<String> findTopSubjectsHighestMarks(int nSubjects);
   1. Getting the most encountered marks
      1. Controller (think of the path variable and parameter), GET request (“/marks/widespread/{subject}”)
      1. Service
         - List<Integer> getTopMarksEncountered(int nMarks, String subject)
      1. Repository (think of the annotations for both method and parameters)
         - List<Integer>findTopMarksEncountered(int nMarks, String subject)
1.3. Challenge: distribution of the marks and their occurrences (think of the type IntervalMarks)
      1. Controller (think of the parameters), GET request (“/marks/distribution”)
      1. Service
         - List<IntervalMarks> getIntervalsMarks(int interval) (default: 10)
      1. Repository (think of the annotations for both method and parameter)
         - List<IntervalMarks> findIntervalsMarks(int interval)

