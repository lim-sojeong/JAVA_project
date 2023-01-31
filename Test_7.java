import java.util.*;
public class Test_7{
	int[] result;
	Random random_number;
	
	public Test_7(){
		result = new int[6];
		random_number = new Random();
	}
	
	void showNumber(){
		System.out.println("1부터 50 사이의 난수 6개");
		for(int i=0;i<6;i++){
			System.out.println(result[i]);
		}
	}
	
	boolean checkSame(int index, int value){
		for(int i=0;i<index;i++){
			if(result[i] == value)
				return false;
		}
		return true;
	}
	
	void makeNumber(){
		int a;
		
		for(int i=0;i<6;i++){
			a = random_number.nextInt(50) + 1; 
			if(checkSame(i,a) == true)
				result[i] = a;
			else
				i--;
		}
	}
	
	public void run(){
		makeNumber();
		showNumber();
	}
	
	public static void main(String[] args){
		Test_7 m;
		m = new Test_7();
		m.run();
	}
}