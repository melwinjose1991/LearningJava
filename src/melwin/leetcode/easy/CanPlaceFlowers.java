package melwin.leetcode.easy;

public class CanPlaceFlowers {

	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
		int planted = 0;
		for (int i = 0; i < flowerbed.length; i++) {
			if ((flowerbed[i] == 0) && (i == 0 || flowerbed[i - 1] == 0)
					&& (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
				flowerbed[i] = 1;
				planted++;
			}
		}
		if (planted >= n)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		int[] f = { 1, 0, 0, 0, 1 };
		System.out.println(canPlaceFlowers(f, 1));

		f = new int[] { 1, 0, 0, 0, 1 };
		System.out.println(canPlaceFlowers(f, 2));
	}

}
