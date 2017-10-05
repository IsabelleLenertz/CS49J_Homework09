import java.util.ArrayList;

public class Staff {
	private ArrayList<String> names;

	/**
	 * Default constructor
	 */
	public Staff(){
		this.names = new ArrayList<String>();
	}
	/**
	 * uses the list to populate the names of the Staff
	 * @param newList
	 */
	public Staff(ArrayList<String> newList) {
		this.names = newList;
		// This should be better, the the teacher's tester requires the PRIVATE list to be accessible from the outside !!!
		//this.names = new ArrayList<String>();
		//for(int i = 0; i < newList.size(); i++) {
		//	this.names.add(newList.get(i));
		//}
	}
	
	/**
	 * Determines if the other Staff contains all the same elements in the same order as this Staff
	 * @param other : an other staff to compare to
	 * @return : true if the Staffs are identical
	 */
	public boolean equals(Staff other) {
		boolean identical = true;
		if(this.names.size() != other.names.size()) {
			identical = false;
		} else {
			for(int i = 0; i < this.names.size(); i++) {
				if(!this.names.get(i).equals(other.names.get(i))) {
					identical = false;
				}
			}
		}
		return identical;
	}
	
	/**
	 * Private function used by sameContents
	 * @param element : name to search in the list
	 * @return the number of times the element was found
	 */
	private int contains(String element) {
		int count = 0;
		for(int i = 0; i < this.names.size(); i++) {
			if(this.names.get(i).equals(element)) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Determines if the other Staff and this Staff contain exactly the same elements but in any order
	 * @param other
	 * @return
	 */
	public boolean sameContents(Staff other) {
		boolean identical = true;
		
		for(int i = 0; i < this.names.size(); i++) {
			if (this.names.contains(this.names.get(i)) != other.names.contains(this.names.get(i))) {
				identical = false;
			}
		}
		return identical;
	}
	/**
	 * Replace each vowel in every ArrayList element with the replacement value text. Assume the vowels are aeiouyAEIOUY
	 * @param text : text to put instead of the vowels
	 */
	public void replaceVowelsWith(String text) {
		// Check in every name
		for(int i = 0; i < this.names.size(); i++) {
			// Check every letter
			String temp = this.names.get(i);
			for(int j = 0; j < temp.length(); j++) {
				String letter = temp.substring(j, j+1).toUpperCase();
				if (letter.equals("A") || letter.equals("E")|| letter.equals("I") || letter.equals("O") || letter.equals("U") || letter.equals("Y") ) {
					temp = temp.substring(0, j) + text + temp.substring(j+1);
				}
			}
			this.names.set(i, temp);
		}

	}
	/**
	 * Gets the staff member whose name has the most vowels.
	 * If more than one has that number of vowels, return the first.
	 * Return null if the list is empty. Assume the vowels are aeiouAEIOU
	 * @return : the staff member with the most vowels
	 */
	public String mostVowels() {
		int maxCount = 0;
		String maxName = "null";
		
		// Check in every name
		for(int i = 0; i < this.names.size(); i++) {
			// Check every letter
			String temp = this.names.get(i);
			int count = 0;
			for(int j = 0; j < temp.length(); j++) {
				String letter = temp.substring(j, j+1).toUpperCase();
				if (letter.equals("A") || letter.equals("E")|| letter.equals("I") || letter.equals("O") || letter.equals("U") || letter.equals("Y") ) {
					count++;
				}
			}
			if(count > maxCount) {
				maxCount = count;
				maxName = temp;
			}
			
		}
		
		return maxName;
	}
	public String toString() {
		//gets a string represent ion using ArrayList's toString method
		return this.names.toString();
	}
}
