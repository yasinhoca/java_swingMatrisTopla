package matrisTopla;

import java.util.Random;

public class Matris {
	
	static int[][] uret(int satir,int sutun,int alt,int ust){
		int[][] m = new int[satir][sutun];
		int i,j;
		Random r = new Random();
		
		for(i=0;i<satir;i++) {
			for(j=0;j<sutun;j++) {
				m[i][j] = r.nextInt(ust-alt)+alt;
			}
		}
		
		return m;
		
	}
	
	
	
	

}
