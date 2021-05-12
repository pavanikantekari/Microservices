package com.ojas.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.dao.PaymentDao;
import com.ojas.model.Payment;

@Service
public class PaymentService {
	@Autowired
	private PaymentDao paymentdao;
	
	public Payment doPayment(Payment payment) {
		payment.setPaymentStatus(paymentProcessing().toString());
		payment.setTransactionId(UUID.randomUUID().toString());
		return paymentdao.save(payment);
	}

	private Object paymentProcessing() {
		//api should be 3rd party payment gateway(paypal,paytm...etc)
		return new Random().nextBoolean()?"success":"false";
	}

}
