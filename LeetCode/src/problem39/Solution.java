package problem39;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution {

	List<List<Integer>> ans;
	int n;
	int[] nums;
	Set<List<Integer>> uniques;

	public List<List<Integer>> combinationSum(int[] candidates, int target) {

		ans = new LinkedList<List<Integer>>();
		if (candidates == null || candidates.length == 0)
			return ans;
		this.nums = candidates;
		n = candidates.length;

		uniques = new HashSet<List<Integer>>();

		rec(0, new LinkedList<Integer>(), target);

		return ans;

	}

	void rec(int idx, List<Integer> l, int target) {

		if (target == 0) {
			List<Integer> cpy = new LinkedList<Integer>(l);

			if (!uniques.contains(cpy)) {
				ans.add(cpy);
				uniques.add(cpy);
			}

			return;
		}

		if (idx >= n) {
			return;
		}

		rec(idx + 1, l, target); // skip current

		int x = 1;
		while (target - (x * nums[idx]) >= 0) {
			for (int i = 0; i < x; i++)
				l.add(nums[idx]);
			rec(idx + 1, l, target - (x * nums[idx]));
			for (int i = 0; i < x; i++)
				l.remove(l.size() - 1);
			x++;
		}

	}
}