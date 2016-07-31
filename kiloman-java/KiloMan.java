public class KiloMan {

	public int hitsTaken(int[] pattern, String jumps) {
		int n = pattern.length, ret = 0;
		for(int i = 0; i < n; ++i) {
			if (jumps.charAt(i) == 'J') {
				if (pattern[i] > 2) ++ret;
			}else {
				if (pattern[i] == 1 || pattern[i] == 2) ++ret;
			}
		}
		return ret;
	}

}
