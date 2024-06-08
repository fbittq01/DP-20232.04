package subsystem.interbank;

import common.exception.*;
import entity.payment.Card;
import entity.payment.PaymentTransaction;
import subsystem.converterstrategy.extractingpaymenttransaction.ExtractingDomesticCard;
import utils.MyMap;
import subsystem.converterstrategy.extractingpaymenttransactions.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author
 */
public class InterbankPayloadDomesticCardConverter extends InterbankPayloadConverter{

    public InterbankPayloadDomesticCardConverter() {
        setExtractingPaymentTransaction(new ExtractingDomesticCard());
    }
}