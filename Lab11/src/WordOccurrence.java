
public class WordOccurrence implements Comparable<WordOccurrence>{
	private String word;
	private int count;
	
	public WordOccurrence(String word, int count) {
		this.word = word;
		this.count = count;
	}
	
	public String getWord() {
		return word;
	}
	public int getCount() {
		return count;
	}
	@Override
	public int compareTo(WordOccurrence w) {
		return count - w.getCount();
	}
}
