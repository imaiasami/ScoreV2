public class Student {
	// 시퀀스용 하나 추가
	private String stdno;		//학번
	private String name;		//이름
	private Score score;		//점수

	
	public Student(String stdno, String name, Score score) {
		this.stdno = stdno;
		this.name = name;
		this.score = score;
	}

	public String getStdno() {
		return stdno;
	}
	
	public void setStdno(String stdno) {
		this.stdno = stdno;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Score getScore() {
		return score;
	}
	
	public void setScore(Score score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "Student [stdno=" + stdno + ", name=" + name + ", score=" + score + "]";
	}

}
