package com.pcwk.ehr.ed01;
import java.util.Scanner;
public class Ex03Bingo {

	public static void main(String[] args) {
		final int SIZE =5;//행과 열요소
		int x=0;//좌표 x
		int y=0;//좌표 y
		int num = 0;//사용자로 부터 숫자 입력
		
		int bingo[][] =new int[SIZE][SIZE];
		Scanner scanner=new Scanner(System.in);//사용자로 부터 숫자 입력
		
		//1~25배열 값 할당!
//		bingo[0][0]= 1	bingo[0][1]= 2	bingo[0][2]= 3	bingo[0][3]= 4	bingo[0][4]= 5	
//		bingo[1][0]= 6	bingo[1][1]= 7	bingo[1][2]= 8	bingo[1][3]= 9	bingo[1][4]=10	
//		bingo[2][0]=11	bingo[2][1]=12	bingo[2][2]=13	bingo[2][3]=14	bingo[2][4]=15	
//		bingo[3][0]=16	bingo[3][1]=17	bingo[3][2]=18	bingo[3][3]=19	bingo[3][4]=20	
//		bingo[4][0]=21	bingo[4][1]=22	bingo[4][2]=23	bingo[4][3]=24	bingo[4][4]=25			
		for(int i=0;i<bingo.length;i++) {
			for(int j=0;j<bingo[i].length;j++) {
				bingo[i][j]=i*5+j+1;
				//System.out.printf("bingo[%d][%d]=%2d\t",i,j,bingo[i][j]);
			}
			//System.out.println();
		}
		
		System.out.println("==================================================");
		//shuffle
		for(int i=0;i<bingo.length;i++) {
			for(int j=0;j<bingo[i].length;j++) {
				x=(int)(Math.random()*SIZE);
				y=(int)(Math.random()*SIZE);
				
				//자리교환
				int temp = bingo[i][j];
				bingo[i][j] = bingo[x][y];
				bingo[x][y] = temp;
				//System.out.printf("bingo[%d][%d]=%2d\t",i,j,bingo[i][j]);
			}
			//System.out.println();
		}
		
		// 섞여 있는 빙고판 출력
		// 사용자로 부터 숫자 입력: 입력된 숫자는 0으로 변경
		do {
			for(int i=0;i<SIZE;i++) {
				for(int j=0;j<SIZE;j++) {
					System.out.printf("%2d ",bingo[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			
			System.out.printf("1~%d의 숫자를 입력하세요(종료:0)>",SIZE*SIZE);
			
			String tmpNum = scanner.nextLine();//문자열 입력
			num = Integer.parseInt(tmpNum);
			
			// 사용자로 부터 숫자 입력: 입력된 숫자는 0으로 변경
			outer: for(int i=0;i<SIZE;i++) {
				for(int j=0;j<SIZE;j++) {
					if(bingo[i][j]==num) {
						bingo[i][j]=0;
						break outer;//2중 for문을 벗어 난다.
					}
				}
				
			}
			
		}while(num !=0);//입력 받은 숫자가 0이 아닐때 까지 입력
		
		

	}

}
