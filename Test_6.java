public class Test_6{
	public static void main(String[] args){
		int[] kor = {70,90,50,60,80};
		int[] eng = {30,50,80,90,70};
		int[] math = {20,30,70,90,90};
		
		int[] total = {0,0,0,0,0};
		float[] average = {0.0f,0.0f,0.0f,0.0f,0.0f};
		int max_index = 0;
		int n;
		
		for(int i=0;i<5;i++)
		{
			total[i] = kor[i] + eng[i] + math[i];
			average[i] = total[i] / (float)3.0;
		}
		
		for(n=1;n<5;n++) {
			if(average[max_index] < average[n])
				max_index = n;
		}
		
		System.out.println("--------------------------------");
		System.out.println("번호  총점  평균");
		System.out.println("--------------------------------");
		for(int i=0;i<5;i++)
		{
			System.out.println(i + "        " + total[i] + "      " + average[i]);
		}
		System.out.println("--------------------------------");
		System.out.println("최고득점자 번호: " + max_index);
		System.out.println("--------------------------------");
	}
}