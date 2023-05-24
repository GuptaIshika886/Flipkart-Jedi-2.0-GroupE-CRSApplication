package com.flipkart.restController;

import java.util.*;

import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.validator.constraints.Email;

import com.flipkart.bean.*;

import com.flipkart.exception.*;

import com.flipkart.service.*;

import org.hibernate.validator.constraints.Email;

@Path("/professor")
public class ProfessorController {
	ProfessorInterface professorInterface = ProfessorOperation.getInstance();

	@GET
	@Path("/getEnrolledStudents/{profId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EnrolledStudent> viewEnrolledStudents(@NotNull

	@PathParam("profId") String profId) throws ValidationException {

		List<EnrolledStudent> students = new ArrayList<EnrolledStudent>();
		try {
			students = professorInterface.viewEnrolledStudents(profId);
		} catch (Exception ex) {
			return null;
		}
		return students;
	}

	@GET
	@Path("/getCourses/{profId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> getCourses(@NotNull

	@PathParam("profId") String profId) throws ValidationException {

		List<Course> courses = new ArrayList<Course>();
		try {
			courses = professorInterface.viewCourses(profId);
		} catch (Exception ex) {
			return null;
		}
		return courses;

	}

	@POST
	@Path("/addGrade/{studentId}/{courseCode}/{profId}/{grade}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addGrade(@NotNull

	@PathParam("studentId") String studentId,

			@NotNull

			@PathParam("courseCode") String courseCode,

			@NotNull

			@PathParam("profId") String profId,

			@QueryParam("grade") String grade) throws ValidationException {

		try {
			List<EnrolledStudent> enrolledStudents = new ArrayList<EnrolledStudent>();
			enrolledStudents = professorInterface.viewEnrolledStudents(profId);
			List<Course> coursesEnrolled = new ArrayList<Course>();
			coursesEnrolled = professorInterface.viewCourses(profId);
			professorInterface.addGrade(studentId, courseCode, grade);

		} catch (Exception ex) {
			return Response.status(500).entity("Something went wrong, Please Try Again ! ").build();
		}
		return Response.status(200).entity("Grade updated for student: " + studentId).build();

	}

}