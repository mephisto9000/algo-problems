package problem729;

class MyCalendar {

    List<Book> l;
    public MyCalendar() {
        l = new LinkedList();
    }
    
    class Book  {
        int start;
        int end;
        
        public Book(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    public boolean book(int start, int end) {
       
        Iterator<Book> it = l.iterator();
        while(it.hasNext()) {
            Book b = it.next();
            if ((b.start < start && start < b.end) ||
                (b.start < end && end < b.end) ||
                (start < b.start && b.start < end) ||
                (start < b.end && b.end < end) ||
                (start == b.start && end == b.end))
                return false;
        }
        
        Book b = new Book(start, end);
        l.add(b);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */