class Solution:
    def maxVacationDays(self, flights: List[List[int]], days: List[List[int]]) -> int:        
        cn, wn = len(flights), len(days[0])
                       
        for w in reversed(range(wn-1)):
            for c in range(cn):
                best = days[c][w+1]
                for cc in range(cn):
                    if flights[c][cc] == 1:
                        best = max(best, days[cc][w+1])
                days[c][w] = days[c][w] + best
        
        ans = days[0][0]
        for c in range(cn):
            if flights[0][c] == 1:
                ans = max(ans, days[c][0])
        return ans                                           