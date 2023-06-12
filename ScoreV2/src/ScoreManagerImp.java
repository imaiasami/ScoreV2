import java.util.ArrayList;
import java.util.List;

public class ScoreManagerImp implements ScoreManager {
	
	private List<Student> students = new ArrayList<>();
	//어렵게 하려면 Map으로 해 private Map(String, Student> students;

	@Override
	public void addStudent(Student student) {
		students.add(student);
	}

	@Override
	public Student searchStudent(String stdno) {
		for(int i=0; i<students.size(); i++) {
			if(stdno.equals(students.get(i).getStdno())) {
				return students.get(i);
			}
		}
		return null;
	}

	@Override
	public void removeStudent(String stdno) {
		students.remove(searchStudent(stdno));
	}

	@Override
	public List<Student> getAllStudents() {
		return students;
	}

}
