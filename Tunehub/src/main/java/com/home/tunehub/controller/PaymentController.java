package com.home.tunehub.controller;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.home.tunehub.entity.User;
import com.home.tunehub.service.UserService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Utils;

import jakarta.servlet.http.HttpSession;

@RestController
public class PaymentController {

	@Autowired
	UserService userService;

	@GetMapping("/pay")
	public String pay() {
		return "pay";
	}

	@SuppressWarnings("finally")
	@PostMapping("/createOrder")
	@ResponseBody
	public String createOrder(HttpSession session) {

		int  amount = 1;
		Order order=null;
		try {
			RazorpayClient razorpay=new RazorpayClient("rzp_test_Vl4y7gDqkd18nY", "FrU3g8hPTbNdnTrNX3ERW1Jy");

			JSONObject orderRequest = new JSONObject();
			orderRequest.put("amount", amount*100); // amount in the smallest currency unit
			orderRequest.put("currency", "INR");
			orderRequest.put("receipt", "order_rcptid_11");

			order = razorpay.orders.create(orderRequest);



		} catch (RazorpayException e) {
			e.printStackTrace();
		}
		finally {
			return order.toString();
		}
	}


	@PostMapping("/verify")
	@ResponseBody
	public boolean verifyPayment(@RequestParam String orderId, @RequestParam String paymentId,
	                             @RequestParam String signature, HttpSession session) {
	    try {
	        RazorpayClient razorpayClient = new RazorpayClient("rzp_test_Vl4y7gDqkd18nY", "FrU3g8hPTbNdnTrNX3ERW1Jy");
	        String verificationData = orderId + "|" + paymentId;
	        boolean isValidSignature = Utils.verifySignature(verificationData, signature, "FrU3g8hPTbNdnTrNX3ERW1Jy");

	        if (isValidSignature) {
	            String email = (String) session.getAttribute("email");
	            if (email == null) {
	                System.out.println("Session email is null");
	                return false;
	            }

	            User user = userService.getUser(email);
	            if (user == null) {
	                System.out.println("User not found for email: " + email);
	                return false;
	            }

	            user.setPremium(true);
	            userService.updateUser(user);
	            System.out.println("User membership updated to premium for email: " + email);
	            return true;
	        } else {
	            System.out.println("Invalid signature");
	            return false;
	        }
	    } catch (RazorpayException e) {
	        e.printStackTrace();
	        return false;
	    }
	}



//	@GetMapping("/payment-success")
//	public String paymentSuccess(HttpSession session) {
//		String mail =  (String) session.getAttribute("email");
//		User user = userService.getUser(mail);
//		user.setPremium(true);
//		userService.updateUser(user);
//
//		return "customer";
//	}
//
//	@GetMapping("/payment-failure")
//	public String paymentFailure() {
//
//		return "membership";
//	}
}
