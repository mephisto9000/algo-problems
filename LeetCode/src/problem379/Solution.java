package problem379;

class PhoneDirectory {
    
    Set<Integer> st;
    int cnt;
    int max;
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        max = maxNumbers;
        st = new HashSet();
        cnt = 0;
        
        
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (st.isEmpty()) {
            if (cnt < max) {
                return cnt++;
            } else
                return -1;
        } else {
            Iterator<Integer> it = st.iterator();
            int v = it.next();
            st.remove(v);
            return v;
        }
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        if (number >= cnt && number < max)
            return true;
        
        if (st.contains(number))
            return true;
        return false;
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if (number < cnt)
            st.add(number);
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */