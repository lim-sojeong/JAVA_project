import java.util.*;
import java.io.*;

class Computer{
	
	Random m_rand;
	
	public Computer(){
		m_rand=new Random();
	}
	
	int go(){
		int a;
		a=m_rand.nextInt(3);
		return a;
	}
}

class Player{
	
	BufferedReader m_key;
	
	public Player(){
		m_key=new BufferedReader(new InputStreamReader(System.in));
	}
	
	int go(){
		int a;
		String msg;
		
		a=0;
		msg="";
		
		try{
			System.out.println("숫자를 하나 입력하시오(-1:종료, 0:가위, 1:바위, 2:보)");
			msg=m_key.readLine(); 
		}
		
		catch(IOException err){
			a=-1;
		}
		
		a=Integer.parseInt(msg);
		
		return a;
	}
}

public class Test_8{
	
	Computer m_com;
	Player m_player;
	int m_total;
	int m_win;
	int m_lost;
	int m_error;
	
	public Test_8(){
		m_com=new Computer();
		m_player=new Player();
		m_total=0;
		m_win=0;
		m_lost=0;
		m_error=0;
	}
	
	String getValue(int a){
		String msg;
		
		if(0==a)
			msg="가위";
		else if(1==a)
			msg="바위";
		else if(2==a)
			msg="보";
		else
			msg="?";
		
		return msg;
	}
	
	void showPlay(int com, int p, int result){
		String msg;
		
		switch(result){
			case 0:
				msg="무승부";
				break;
			case 1:
				msg="승";
				break;
			case 2:
				msg="패";
				break;
			default:
				msg="오류";
				break;
		}
		
		System.out.println("컴퓨터: " + getValue(com) + "     플레이어: " + getValue(p));
		System.out.println("결과:" + msg + "\n");
	}
	
	void showEndGame(){
		int equal;
		float rate;
		
		equal=m_total - (m_win + m_lost + m_error);
		rate=(float)m_win/m_total;
		
		System.out.println("-------------------------");
		System.out.println("총 게임 횟수: " + m_total);
		System.out.println("이긴 횟수: " + m_win);
		System.out.println("비긴 횟수: " + equal);
		System.out.println("진 횟수: " + m_lost);
		System.out.println("오류 발생 횟수: " + m_error);
		System.out.println("승률: " + rate);
		System.out.println("-------------------------");
	}
	
	int checkGame(int com, int p){
		int a;
		a=0;
		
		m_total++;
		
		if(com==p)
			a=0;
		else if(0==com && 1==p){
			a=1;
			m_win++;
		}
		else if(0==com && 2==p){
			a=2;
			m_lost++;
		}
		else if(1==com && 0==p){
			a=2;
			m_lost++;
		}
		else if(1==com && 2==p){
			a=1;
			m_win++;
		}
		else if(2==com && 0==p){
			a=1;
			m_win++;
		}
		else if(2==com && 1==p){
			a=2;
			m_lost++;
		}
		else{
			a=3;
			m_error++;
		}
		
		return a;
	}
	
	void run(){
		int com;
		int p;
		int result;
		
		while(true){
			p=m_player.go();
			com=m_com.go();
			
			if(-1==p)
				break;
			
			result=checkGame(com,p);
			showPlay(com, p, result);
		}
		showEndGame();
	}
	
	public static void main(String[] args){
		Test_8 m;
		m=new Test_8();
		m.run();
	}
}
