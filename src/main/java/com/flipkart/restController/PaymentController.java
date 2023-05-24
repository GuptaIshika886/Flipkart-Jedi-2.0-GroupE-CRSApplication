package com.flipkart.restController;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import com.flipkart.bean.*;
import com.flipkart.service.*;



@Path("/payment")
public class PaymentController {
	
    private static String  makePayment(String studentId, String paymentMode) {
    	StudentInterface stdInterface = StudentOperation.getInstance();
    	RegistrationInterface regInterface = RegistrationOperation.getInstance();
        int fee = stdInterface.calculateFees(studentId);
        boolean isreg = false;
        boolean ispaid = false;
        try {
            isreg = regInterface.getRegistrationStatus(studentId);
            ispaid = regInterface.getPaymentStatus(studentId);
        } catch (Exception e) {
            return e.getMessage();
        }

        if (!isreg) {
            return "You have not registered yet";
        } else if (!ispaid) {
            try {
                Payment payment = new Payment();
                payment.setAmount(fee);
                payment.setPaymentMode(paymentMode);
                payment.setStudentId(studentId);

                PaymentServiceInterface paymentOperation = new PaymentOperationService();
                paymentOperation.processPayment(payment);
                regInterface.setPaymentStatus(studentId);
                return "Payment Successful by StudentId :" + studentId ;
            
            } catch (Exception e) {
                return e.getMessage();
            }
        }
        else {
            return "You have already paid the fees" ;
        }

    }
    
    @GET
    public static String paymentModes() {
        return "Payement Modes \n\tONLINE\n\tOFFLINE\n\tSCHOLARSHIP";
    }
    
    @GET
    @Path("/online")
    public static String onlinePaymentModes() {
        return "Payement Options \n\tCARD\n\tNET-BANKING\n";
    }
    
    @GET
    @Path("/offline")
    public static String offlinePaymentModes()  {
        return "Payement Options \n\tCASH\n\tCHEQUE\n";
    }
    
    @GET
    @Path("/scholarship")
    public static String scholarship()  {
        return "Payement Options \n\tSCHOLARSHIP\n";
    }
    

    @POST
    @Path("/online/card/{id}")
    public static Response cardPayment(@PathParam("id") String id)  {
        String res;
        try{
            // make payment funCall
            res = makePayment(id, "online");
            System.out.println(id);
        }
        catch (Exception e ){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.status(Response.Status.OK).entity(res).build();
    }


    @POST
    @Path("/online/net-banking/{id}")
    public static Response netBankingPayment(@PathParam("id") String id) {
        String res;
        try{
            // make payment funCall
            res = makePayment(id, "online");
            System.out.println(id);
        }
        catch (Exception e ){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.status(Response.Status.OK).entity(res).build();
    }

    
    @POST
    @Path("/offline/cash/{id}")
    public static Response cashPayment(@PathParam("id") String id) {
        String res;
        try{
            // make payment funCall
            res = makePayment(id, "offline");
            System.out.println(id);
        }
        catch (Exception e ){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.status(Response.Status.OK).entity(res).build();
    }

    
    @POST
    @Path("/offline/cheque/{id}")
    public static Response chequePayment(@PathParam("id") String id) {
        String res;
        try{
            // make payment funCall
            res = makePayment(id, "offline");
            System.out.println(id);
        }
        catch (Exception e ){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.status(Response.Status.OK).entity(res).build();
    }


    @POST
    @Path("/scholarship/{id}")
    public static Response scholarshipPayment(@PathParam("id") String id)  {
        String res;
        try{
            // make payment funCall
            res = makePayment(id, "scholarship");
            System.out.println(id);
        }
        catch (Exception e ){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.status(Response.Status.OK).entity(res).build();
    }
}
