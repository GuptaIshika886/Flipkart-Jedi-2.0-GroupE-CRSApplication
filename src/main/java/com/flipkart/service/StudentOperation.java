package com.flipkart.service;

import com.flipkart.constant.RoleConstant;
import com.flipkart.dao.*;
import com.flipkart.exception.StudentNotRegisteredException;
import com.flipkart.bean.Student;
import com.flipkart.client.CRSApplication;
import com.flipkart.constant.GenderConstant;

public class StudentOperation implements StudentInterface {

	private static volatile StudentOperation instance = null;

	
	

	public StudentOperation() {

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

	public String register(String name, String userId, String password, GenderConstant gender, int batch, String branch,
			String address)  {
		StudentDaoInterface studentDaoInterface = StudentDaoOperation.getInstance();
		String studentId = null;
		try {
			// call the DAO class, and add the student record to the DB

			Student newStudent = new Student(userId, name, RoleConstant.STUDENT, password, gender, address, branch,
					userId, batch, false);
			System.out.println("\nYour account has been created and pending for Approval by Admin.\n");
			studentId = studentDaoInterface.addStudent(newStudent);

		} catch (Exception ex) {
			
		}
		return studentId;
	}

	public int calculateFees(String studentId) {
		StudentDaoInterface studentDaoInterface = StudentDaoOperation.getInstance();
		return studentDaoInterface.makePayment(studentId);
	}

	@Override
	public String getStudentId(String userId) {
		StudentDaoInterface studentDaoInterface = StudentDaoOperation.getInstance();
		return studentDaoInterface.getStudentId(userId);
	}

	@Override
	public boolean isApproved(String studentId) {

		return studentDaoInterface.isApproved(studentId);
	}

	@Override
	public String register(Student student) throws StudentNotRegisteredException {
		// TODO Auto-generated method stub
		return null;
	}

}