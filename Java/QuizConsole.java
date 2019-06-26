package cebs_training;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class QuizConsole {
	private static Scanner scan;
	private static LinkedList<QuesPage> questionBook;
	
	public char choose_yn(String ques) {
		String choices = "(" + String.join("/", "Y", "N") + ") : ";
		ques += choices;
		System.out.print(ques);
		while(true) {
			char ch = scan.nextLine().toLowerCase().charAt(0);
			if(ch == 'y' || ch == 'n')
				return ch;
			System.out.print("Invalid Choice, please select either " + choices);
		}
	}
	
	private void addQuestion() {
		System.out.println("\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n");
		while(true) {
			QuesPage page = new QuesPage();
			System.out.print("Enter the Question: ");
			String question = scan.nextLine().trim();
			if(question.charAt(question.length() - 1) != '?')
				question += "?";
			page.setQuestion(question);
			
			LinkedList<String> options = new LinkedList<>();
			String choices = "ABCDEF";
			StringBuilder strBld = new StringBuilder();
			for(int i=0; i<choices.length(); i++) {
				if(i > 1) {
					if(choose_yn("Would you like to add another option") == 'n')
						break;
				}
				System.out.print ("Enter Option "+choices.charAt(i)+": ");
				options.add(scan.nextLine().trim());
				strBld.append(choices.charAt(i));
			}
			choices = strBld.toString();
			page.setOptions(options);
			page.setOption_choices(choices);
			page.setAnswer_option(choose("Please Enter the answer option to question", choices.split("")));
			
			questionBook.add(page);
						
			if(choose_yn("Would you like to Add another Question") == 'n')
				break;
			
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		}
	}
	
	private Iterator<QuesPage> randomQuestions() {
		Random r = new Random();
		HashSet<QuesPage> ques = new HashSet<>();
		int flag = 0;
		while(ques.size() <= questionBook.size()&& ques.size() < 15 && flag < 500) {
			int q = r.nextInt(questionBook.size());
			flag++;
			ques.add(questionBook.get(q));
		}
		return ques.iterator();
	}
	
	private void playQuiz() {
		
		if(questionBook.size() == 0){
			System.out.println("\nNo Questions Available ");
			return;
		}
		
		int wrong_choices = 0;
		int correct_choices = 0;
		int total_ques = 0;
		Iterator<QuesPage> questionList = randomQuestions();
		LinkedList<QuesPage> wrong_questions = new LinkedList<>();
		System.out.println("\n###############################################################");
		
		System.out.println("\nNow Starting Quiz \n");
		while(questionList.hasNext()) {
			QuesPage question = questionList.next();
			total_ques++;
			
			System.out.println("Question_" + total_ques + " :\t" + question.getQuestion() + "\n");
			
			Iterator<String> options_iter = question.getOptions().iterator();
			for(char ch : question.getOption_choices().toCharArray()) {
				System.out.println("Option " + ch + ")   " + options_iter.next());
			}
			System.out.println();
			
			if(choose("Enter your option choice", question.getOption_choices().split("")) == question.getAnswer_option()) {
				System.out.println("You are Correct....:)");
				correct_choices++;
			}
			else {
				System.out.println("You are Wrong.....:(");
				wrong_choices++;
				wrong_questions.add(question);
			}
			
			System.out.println("\n----------------------------------------------------------------------\n");
			
		}
		
		System.out.println("Quiz End...\n");
		System.out.println("Result: ");
		System.out.println("Total Questions: " + total_ques);
		System.out.println("Correct Choices: " + correct_choices);
		System.out.println("Wrong Choices: " + wrong_choices);
		System.out.println();
		if(wrong_choices > 0)	
			if(choose_yn("would you like to see your wrong questions") == 'y') {
				for(QuesPage q: wrong_questions) {
					System.out.println("\nQuestion: " + q.getQuestion());
					System.out.println("Correct option: " + q.getAnswer_option() + ") " + q.getOptions().get(q.getAnswer_option() - 'A'));
				}
			}
		
		System.out.println("\n###############################################################\n");

	}
	
	private char choose(String ques, String[] options) {
		String choices = "(" + String.join("/", options) + ") : ";
		ques += choices;
		System.out.print(ques);
		while(true) {
			char ch = scan.nextLine().toUpperCase().charAt(0);
			for(String s: options)
				if(s.charAt(0) == ch)
					return ch;
			System.out.print("Invalid Choice, please select from " + choices);
		}
	}
	

	
	public static void main(String[] args) {
		QuizConsole console = new QuizConsole();
		 questionBook = new LinkedList<>();
		 scan = new Scanner(System.in);
		 System.out.println("\n*********************************************************************\n");
		 System.out.println(":D:D:D\tWelcome to the Quiz Console\t:D:D:D");
		 while(true) {
			 System.out.println("\nMenu: \n");
			 System.out.println("1. Add a Question ");
			 System.out.println("2. Play Quiz");
			 System.out.println("3. Exit");
			 char ch = console.choose("Enter choice: ", new String[] {"1", "2", "0"});
			 if(ch == '1')
				 console.addQuestion();
			 else if(ch == '2')
				 console.playQuiz();
			 else if(ch == '0')
				 break;
			 			 
			 System.out.println("\n*********************************************************************");
		 }
		 System.out.println("\nQuiz Now Over.... bye bye");
		 scan.close();
	}

}
