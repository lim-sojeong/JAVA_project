import java.io.*;
import java.util.*;

class Player{
	
	BufferedReader m_key;
	
	public Player(){
		m_key=new BufferedReader(new InputStreamReader(System.in));
	}
	
	int myInput(){
		String msg;
		int a;
		
		msg="";
		a=0;
		
		try{
			System.out.println("0~9 사이의 값을 입력하시오");
			msg=m_key.readLine();
		}
		
		catch(IOException err){
			
		}
		
		a=Integer.parseInt(msg);
		
		return a;
	}
}
public class Test_9{
	
	int[] m_data;
	Player m_player;
	
	public Test_9(){
		m_data=new int[3];
		m_player=new Player();
	}
	
	void makeData(){
		Random rand;
		rand=new Random();
		
		for(int i=0;i<m_data.length;i++){
			m_data[i]=rand.nextInt(10);
			
			for(int j=0;j<i;j++){
				if(m_data[i]==m_data[j])
					i--;
			}
		}
	}
	
	void showMsg(String msg){
		System.out.println(msg);
	}
	
	void showPlay(int[] data){
		System.out.println("***결과: " + data[1] + "스트라이크, " + data[0] + "볼***\n");
	}
	
	void showGameEnd(boolean win){
		if(win==true)
			System.out.println("정답입니다!");
		else
			System.out.println("10번의 기회를 모두 사용하였습니다.");
		
		System.out.println("3개의 숫자는");
		
		for(int i=0;i<m_data.length;i++)
			System.out.println(m_data[i]);
	}
	
	int check(int index, int a){
		int b=0;
		
		for(int i=0;i<m_data.length;i++){
			if(m_data[i]==a){
				if(i==index)
					b=2;
				else
					b=1;
			}
		}
		
		return b;
	}
	
	void onePlay(int[] result){
		int input;
		int r;
		
		for(int i=0;i<result.length;i++)
			result[i]=0;
		
		for(int i=0;i<3;i++){
			input=m_player.myInput();
			r=check(i, input);
			
			if(r==1)
				result[0]++;
			else if(r==2)
				result[1]++;
		}
	}
	
	void run(){
		int[] result;
		boolean win;
		
		result=new int[2];
		win=false;
		
		makeData();
		
		for(int i=0;i<9;i++){
		showMsg((i+1) + "번째 시도");
		onePlay(result);
		showPlay(result);
		if(result[1]==3){
			win=true;
			break;
		}
		}
		
		showGameEnd(win);
	}
	
	public static void main(String[] args){
		Test_9 m;
		m=new Test_9();
		m.run();
	}
}