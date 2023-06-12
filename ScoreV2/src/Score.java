
public class Score {
	
	//시퀀스용 하나추가, fK로 학생 시퀀스
	private int kor_score;		//국어점수
	private int eng_score;		//영어점수
	private int math_score;		//수학점수
	
	
	public Score(int kor_score, int eng_score, int math_score) {
		this.kor_score = kor_score;
		this.eng_score = eng_score;
		this.math_score = math_score;
	}
	
	public int getKor_score() {
		return kor_score;
	}
	
	public void setKor_score(int kor_score) {
		this.kor_score = kor_score;
	}
	
	public int getEng_score() {
		return eng_score;
	}
	
	public void setEng_score(int eng_score) {
		this.eng_score = eng_score;
	}
	
	public int getMath_score() {
		return math_score;
	}
	
	public void setMath_score(int math_score) {
		this.math_score = math_score;
	}
	
	public double getAvg() {
		return (double)(math_score + eng_score + kor_score)/3;
	}
	// get 결과값을 받을 때, set은 입력하거나, 수정할 때.
	
	@Override
	public String toString() {
		return "Score [kor_score=" + kor_score + ", eng_score=" + eng_score + ", math_score=" + math_score + "]";
	}
	
}
