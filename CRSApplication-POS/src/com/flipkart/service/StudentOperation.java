package com.flipkart.service;

import com.flipkart.bean.SemRegistration;
import com.flipkart.constant.RoleConstant;
import com.flipkart.dao.StudentDaoInterface;
import com.flipkart.dao.StudentDaoOperation;
import com.flipkart.exception.StudentNotRegisteredException;
import com.flipkart.bean.Student;
import com.flipkart.client.CRSApplication;
import com.flipkart.constant.GenderConstant;

public class StudentOperation implements StudentInterface {

	private static volatile StudentOperation instance = null;

	StudentDaoInterface studentDaoInterface = StudentDaoOperation.getInstance();

	private StudentOperation() {

	}

	public static StudentOperation getInstance() {
		if (instance == null) {
			// This is a synchronized block, when multiple threads will access this instance
			synchronized (StudentOperation.class) {
				instance = new StudentOperation();
			}
		}
		return instance;
	}

	@Override
	public String register(String name, String userId, String password, GenderConstant gender, int batch, String branch,
			String address) throws StudentNotRegisteredException {
		String studentId;
		try {
			// call the DAO class, and add the student record to the DB

			Student newStudent = new Student(userId, name, RoleConstant.STUDENT, password, gender, address, branch,
					userId, batch, false);
			System.out.println("\nYour account has been created and pending for Approval by Admin.\n");
			studentId = studentDaoInterface.addStudent(newStudent);

		} catch (StudentNotRegisteredException ex) {
			throw ex;
		}
		return studentId;
	}

	public int calculateFees(String studentId) {
		return studentDaoInterface.makePayment(studentId);
	}

	@Override
	public String getStudentId(String userId) {

		return studentDaoInterface.getStudentId(userId);
	}

	@Override
	public boolean isApproved(String studentId) {
		return studentDaoInterface.isApproved(studentId);
	}

}