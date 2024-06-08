package subsystem.interbank;

import common.exception.*;
import entity.payment.Card;
import entity.payment.PaymentTransaction;
import subsystem.converterstrategy.extractingpaymenttransaction.ExtractingCreditCard;
import utils.MyMap;
import subsystem.converterstrategy.extractingpaymenttransactions.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author
 */
public class InterbankPayloadCreditCardConverter extends InterbankPayloadConverter{

    public InterbankPayloadCreditCardConverter() {
        setExtractingPaymentTransaction(new ExtractingCreditCard());
    }
}