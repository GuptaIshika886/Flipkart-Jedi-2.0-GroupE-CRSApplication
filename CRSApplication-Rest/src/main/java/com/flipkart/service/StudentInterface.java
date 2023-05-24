package com.flipkart.service;

import com.flipkart.constant.GenderConstant;

import com.flipkart.exception.StudentNotRegisteredException;
import com.flipkart.bean.*;

/**
 * 
 * Group -E rahul.kumar ishika.gupta nishant.singh sri.vyshnavi kartik.garg
 */

public interface StudentInterface {

	/**
	 * Method to register a student, although student can't login until it's
	 * approved by admin
	 * 
	 * @param name
	 * @param userID
	 * @param password
	 * @param gender
	 * @param batch
	 * @param branch
	 * @param address
	 * @param country
	 * @return Student ID
	 * @throws StudentNotRegisteredException
	 */
	public String register(Student student) throws StudentNotRegisteredException;

	/**
	 * Method to get Student ID from User ID
	 * 
	 * @param userId
	 * @return Student ID
	 */
	public String getStudentId(String userId);

	public int calculateFees(String studentId);

	/**
	 * >>>>>>> 09eebac02dc52570ccfa1b523f636ed363e95aa6 Method to check if student
	 * is approved by Admin or not
	 * 
	 * @param studentId
	 * @return boolean indicating if student is approved
	 */
	public boolean isApproved(String studentId);
}