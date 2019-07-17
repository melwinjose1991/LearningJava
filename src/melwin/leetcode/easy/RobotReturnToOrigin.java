package melwin.leetcode.easy;

public class RobotReturnToOrigin {

	public static boolean judgeCircle(String moves) {
		int x = 0, y = 0;
		for (int i = 0; i < moves.length(); i++) {
			switch (moves.charAt(i)) {
			case 'U':
				y++;
				break;
			case 'D':
				y--;
				break;
			case 'L':
				x--;
				break;
			case 'R':
				x++;
				break;
			}
		}
		if (x == 0 & y == 0)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		System.out.println(judgeCircle("UD"));
		System.out.println(judgeCircle("RRLL"));
		System.out.println(judgeCircle("LURD"));
		System.out.println(judgeCircle("LURD"));
		System.out.println(judgeCircle("LLRR"));
		
		System.out.println(judgeCircle("D"));
		System.out.println(judgeCircle("LL"));
		
		
	}

}
