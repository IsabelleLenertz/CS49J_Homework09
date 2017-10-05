import java.util.ArrayList;
/**
 * Manages the students in a classroom
 * @author Isabelle Delmas
 *
 */
public class Classroom {
	private ArrayList<Student> list;

	/**
	 * Default constructor
	 */
	public Classroom() {
		this.list = new ArrayList<Student>();
	}
	/**
	 *  Add the student to this Classroom (to an ArrayList
	 * @param s : student to add to the list
	 */
	public void add(Student s) {
		this.list.add(s);
	}
	/**
	 * Get the name of the first student in the Classroom who has an average greater than the target 
	 * or the empty string. Do not use break. 
	 * Do not return from the middle of the loop. Use a boolean flag if you need to terminate early.
	 * @param target : minimum grade to look for
	 * @return : the name of the first student with a grade above target
	 */
	public String hasAverageGreaterThan(double target){
		String s="";
		boolean found = false;
		
		for(int i = 0; i < this.list.size(); i++) {
			if(this.list.get(i).getAverage() > target && !found) {
				s = this.list.get(i).getName();
				found = true;
			}
		}
		return s;
	}
	/**
	 * Get an ArrayList<String> containing the names of all the Students in this Classroom.
	 * @return : list with all the names in the class
	 */
	public ArrayList<String> getStudents(){
		//
		ArrayList<String> names = new ArrayList<String>();
		for(int i = 0; i < this.list.size(); i++) {
			names.add(this.list.get(i).getName());
		}
		return names;
	}
	/**
	 * Get the Student with the highest average in this classroom or null there are no students
	 * @return : the best Student, null if no students
	 */
	public Student bestStudent(){
		Student best = null;
		double max = 0.0;
		if(this.list.size() > 0) {
			max = this.list.get(0).getAverage();
		}
		for(int i = 1; i < this.list.size(); i++) {
			if (this.list.get(i).getAverage() > max) {
				best = this.list.get(i);
			}
		} 
		return best;
	}
	/**
	 * 	gets a string representation using ArrayList's toString method
	 * @return : a string with all the info about all the students in the class
	 */
	public String toString() {
		return this.list.toString();
	}
}
