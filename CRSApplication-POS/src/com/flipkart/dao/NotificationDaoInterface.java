/**
 * 
 */
package com.flipkart.dao;

import java.sql.SQLException;

import com.flipkart.constant.NotificationTypeConstant;
import com.flipkart.constant.PaymentModeConstant;

public interface NotificationDaoInterface {

	/**
	 * Send Notification using SQL commands
	 * 
	 * @param type:          type of the notification to be sent
	 * @param studentId:     student to be notified
	 * @param modeOfPayment: mode of payment used, defined in enum
	 * @param amount
	 * @return notification id for the record added in the database
	 * @throws SQLException
	 */
	public boolean sendNotification(NotificationTypeConstant type, String studentId, String referenceId)
			throws SQLException;

}
