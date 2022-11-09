package com.pcwk.ehr.ed01;

public class Ex02Multi {

	public static void main(String[] args) {
        int score[][] = {								
                {100,100,100},								
                {20,20,20},								
                {30,30},								
                {40,40},								
                {50,50,50}								
        };								
		
		for(int i=0;i<score.length;i++) {
			for(int j=0;j<score[i].length;j++) {
				System.out.printf("score[%d][%d]=%3d",i,j,score[i][j]);
			}
			System.out.println();
			
		}
//		score[0][0]=100score[0][1]=100score[0][2]=100
//		score[1][0]= 20score[1][1]= 20score[1][2]= 20
//		score[2][0]= 30score[2][1]= 30
//		score[3][0]= 40score[3][1]= 40
//		score[4][0]= 50score[4][1]= 50score[4][2]= 50

	}

}
