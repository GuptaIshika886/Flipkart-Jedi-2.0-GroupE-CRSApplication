/**
 * 
 */
package com.flipkart.exception;

/**
 * Group -E rahul.kumar ishika.gupta nishant.singh sri.vyshnavi kartik.garg
 */

public class CourseNotDeletedException extends Exception {

	private String courseCode;

	public CourseNotDeletedException(String courseCode) {
		this.courseCode = courseCode;
	}

	/**
	 * Getter function for course code
	 * 
	 * @return
	 */
	public String getCourseCode() {
		return courseCode;
	}

	/**
	 * Message thrown by exception
	 */
	@Override
	public String getMessage() {
		return "Course with courseCode: " + courseCode + " can't be deleted.";
	}
}