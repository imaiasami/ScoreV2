import java.util.List;

public interface ScoreManager {
	//학생정보 등록
	void addStudent(Student student);
	
	//학번으로 학생검색
	Student searchStudent(String stdno);
	
	//학생정보 삭제
	void removeStudent(String stdno);
	
	//전체 학생 및 점수정보
	List<Student> getAllStudents();
}
