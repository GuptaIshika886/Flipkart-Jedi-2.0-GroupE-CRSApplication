/**
 * 
 */
package com.flipkart.dao;

import java.sql.SQLException;

import com.flipkart.bean.Student;
import com.flipkart.exception.StudentNotRegisteredException;

/**
 * 
 * Group -E rahul.kumar ishika.gupta nishant.singh sri.vyshnavi kartik.garg
 */

public interface StudentDaoInterface {

	/**
	 * Method to add student to database
	 * 
	 * @param student: student object containing all the fields
	 * @return true if student is added, else false
	 * @throws StudentNotRegisteredException
	 */
	public String addStudent(Student student) throws StudentNotRegisteredException;

	public int makePayment(String studentId);

	/**
	 * Method to retrieve Student Id from User Id
	 * 
	 * @param userId
	 * @return Student Id
	 */
	public String getStudentId(String userId);

	/**
	 * Method to check if Student is approved
	 * 
	 * @param studentId
	 * @return boolean indicating if student is approved
	 */
	public boolean isApproved(String studentId);
}