package subsystem.interbank;

import entity.payment.*;
import entity.payment.PaymentTransaction;
import entity.subsystem.converterstrategy.extractingpaymenttransactions.*;
import subsystem.converterstrategy.extractingpaymenttransaction.ExtractingCreditCard;

public class InterbankSubsystemController {

	private static InterbankPayloadConverter interbankPayloadConverter = new InterbankPayloadConverter(new ExtractingCreditCard());
	private static InterbankBoundary interbankBoundary = new InterbankBoundary();

	public PaymentTransaction refund(Card card, int amount, String contents) {
		return null;
	}

	public PaymentTransaction payOrder(Card card, int amount, String contents) {
		String requestPayload = interbankPayloadConverter.convertToRequestPayload(card, amount, contents);
		String responseText = interbankBoundary.query(InterbankConfigs.PROCESS_TRANSACTION_URL, requestPayload);
		return interbankPayloadConverter.extractPaymentTransaction(responseText);
	}

}