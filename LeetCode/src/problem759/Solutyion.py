"""
# Definition for an Interval.
class Interval:
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""
class Solution:
    def employeeFreeTime(self, schedule: 'list<list<Interval>>') -> 'list<Interval>':
        
        common,vacant,peopleHeap = [],[],[]
        for idx, guy in enumerate(schedule):            
            heapq.heappush(peopleHeap, (guy[0].start, guy[0].end, idx, 0))
        while(len(peopleHeap) > 0):
            guy = heapq.heappop(peopleHeap)
            if (len(schedule[guy[2]]) > guy[3]+1):
                heapq.heappush(peopleHeap, (schedule[guy[2]][guy[3]+1].start, schedule[guy[2]][guy[3]+1].end, guy[2], guy[3]+1))
            if (len(common) > 0 and common[-1].end >= guy[0]):
                common[-1].end = max(common[-1].end, guy[1])                            
            else:
                newSpace = Interval()
                newSpace.start, newSpace.end = guy[0], guy[1]
                common.append(newSpace)                
        
        for idx, v in enumerate(common[:-1]):
            newSpace = Interval()
            newSpace.start, newSpace.end = common[idx].end, common[idx+1].start
            vacant.append(newSpace)
                        
        return vacant
        