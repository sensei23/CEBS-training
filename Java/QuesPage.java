package cebs_training;

import java.util.LinkedList;

public class QuesPage {
	private int q_id;
	private String question;
	private LinkedList<String> options;
	private String option_choices;
	private char answer_option;
	
	private static int count = 0;
	
	public QuesPage() {
		q_id = ++count;
	}
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public LinkedList<String> getOptions() {
		return options;
	}
	public void setOptions(LinkedList<String> options) {
		this.options = options;
	}
	public String getOption_choices() {
		return option_choices;
	}
	public void setOption_choices(String option_choices) {
		this.option_choices = option_choices;
	}
	public char getAnswer_option() {
		return answer_option;
	}
	public void setAnswer_option(char c) {
		this.answer_option = c;
	}
	public int getQ_id() {
		return q_id;
	}
	
	
}
