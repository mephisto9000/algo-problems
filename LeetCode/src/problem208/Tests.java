package problem208;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	@Test
	public void test1() {
		
		Trie t = new Trie();
	
		t.insert("a");
		t.search("a");
		assertFalse(t.startsWith("a"));
	}

}
