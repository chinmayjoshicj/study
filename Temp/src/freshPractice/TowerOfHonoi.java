package freshPractice;

public class TowerOfHonoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4; // Number of disks
	    towerOfHanoi(n, 'A', 'C', 'B'); // A, B and C are names of rods
	}

	private static void towerOfHanoi(int n, char from_Tower, char to_Tower, char aux_Tower) {
		// TODO Auto-generated method stub
		
		if(n==1) {
			System.out.println("Move Disk from "+from_Tower +" to "+to_Tower);
			return;
		}
		towerOfHanoi(n-1, from_Tower, aux_Tower, to_Tower);
		System.out.println("Move Disk from "+from_Tower+" to "+to_Tower);
		towerOfHanoi(n-1, aux_Tower, to_Tower, from_Tower);
	}

}
