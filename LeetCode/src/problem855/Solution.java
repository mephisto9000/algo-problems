package problem855;

class ExamRoom {

    int n;
    TreeSet<Integer> seats;
    
    public ExamRoom(int N) {
        this.n = N;
        seats = new TreeSet();
        
    }
    
    public int seat() {
        if (seats.size() == 0) {
            seats.add(0);
            return 0;
        } else {
            
            int lastPlace = seats.last();            
            int newPlace =  n-1; 
            int diff = (lastPlace == n-1)?0:(n-1 - lastPlace);

            while(seats.lower(lastPlace)!=null ) {                                 
                int id = seats.lower(lastPlace);
                if ((lastPlace - id)/2  >= diff) {
                    newPlace = (id + lastPlace)/2;
                    diff = (lastPlace - id)/2;                    
                }
                lastPlace = id;
            }
            if (lastPlace > 0 && diff <= lastPlace) {
                newPlace = 0;
            }            
            seats.add(newPlace);
            return newPlace;
        }                
    }
    
    public void leave(int p) {
        seats.remove(p);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */