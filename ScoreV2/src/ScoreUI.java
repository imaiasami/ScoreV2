import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ScoreUI {
	private Scanner scanner =  new Scanner(System.in);
	
	private ScoreManager manager;
	
	public ScoreUI() {
		manager = new ScoreManagerImp();
		
		while(true) {
			System.out.println("학사정보관리시스템");
			System.out.println("1. 학생정보 등록");
			System.out.println("2. 학번으로 학생검색");
			System.out.println("3. 학생정보 삭제");
			System.out.println("4. 전체학생 및 점수정보");
			System.out.println("5. 점수 갱신");
			System.out.println("6. 각 학생 평균");
			System.out.println("7. 평균 점수로 학생 등수 보기");
			System.out.print("선택> ");
			try {
				int input = scanner.nextInt();
				switch (input) {
				case 1 : 
					addStudent();
					break;
				case 2 :
					searchStudent();
					break;
				case 3 :
					removeStudent();
					break;
				case 4 :
					getAllStudents();
					break;
				case 5 :
					updateStudent();
					break;
				case 6 :
					avg();
					break;	
				case 7 :
					rank();
					break;	
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//학생등록
	public void addStudent() {
		System.out.println("학생 추가");
		System.out.print("학번 : ");
		String stdno = scanner.next();
		System.out.print("이름 : ");
		String name = scanner.next();
		System.out.print("국어점수 : ");
		int kor_score = scanner.nextInt();
		System.out.print("영어점수 : ");
		int eng_score = scanner.nextInt();
		System.out.print("수학점수 : ");
		int math_score = scanner.nextInt();
		Score score = new Score(kor_score, eng_score, math_score);
		Student s = new Student(stdno, name, score);
		manager.addStudent(s);
	}
	

	public void searchStudent() {
		System.out.println("학번 입력 : ");
		String stdno = scanner.next();
		Student s= manager.searchStudent(stdno);
		System.out.println(s.toString());
	}
	
	//점수수정
	public void updateStudent() {
		System.out.println("학번 입력 : ");
		String stdno = scanner.next();
		Student s= manager.searchStudent(stdno);
		System.out.print("국어점수 : ");
		int kor_score = scanner.nextInt();
		System.out.print("영어점수 : ");
		int eng_score = scanner.nextInt();
		System.out.print("수학점수 : ");
		int math_score = scanner.nextInt();
		Score score = new Score(kor_score, eng_score, math_score);
		s.setScore(score);
	}
	
	//학생삭제
	public void removeStudent() {
		System.out.println("학번 입력");
		String stdno = scanner.next();
		Student s= manager.searchStudent(stdno);
		manager.removeStudent(s.getStdno());
	}
	
	//전체 학생정보 출력
	public void getAllStudents() {
		List<Student> s = manager.getAllStudents();
		for(Student student : s) {
			System.out.println(student);
		}
	}
	
	// ForEach는 처음부터 끝까지 도는 것은 맞으나, 순서를 알 수는 없다. 순서를 알려면 배열로 돌면된다.
	// 각 학생 평균 성적 구하기
	public void avg() {
		
		List<Student> students = manager.getAllStudents();
		for(Student student : students) {
			System.out.println(student.getName() + " : " + student.getScore().getAvg());
		}
//		for(int i=0; i<students.size(); i++) {
//			Student student = students.get(i);
//			System.out.println(student.getName() + " : " + student.getScore().getAvg());
//		}
		
	}
	
	// 평균 점수로 학생 등수 별로 정렬하여 출력하기
	public void rank() {
		List<Student> students = manager.getAllStudents();
		List<Student> avgSco = new ArrayList<>(); // 참조형 타입이 들어있어서 sort를 시킬 수 없다.
		for(int i = 0; i < students.size(); i++) {
			Student student = students.get(i);
			double avg = student.getScore().getAvg();
			if (i == 0) {
				avgSco.add(student);
				continue;
			}
			for(int j = 0; j < avgSco.size(); j++) {
				if (avgSco.get(j).getScore().getAvg() >= avg) {
					avgSco.add(j, student);
					break;
				} else if (j == avgSco.size() - 1) {
					avgSco.add(student);
					break;
				}
			}
		}
		for(Student rank : avgSco) {
			System.out.println(rank.getName() + "\t" + rank.getScore().getAvg());
		}
	}

	public static void main(String[] args) {
		new ScoreUI();

	}

}
