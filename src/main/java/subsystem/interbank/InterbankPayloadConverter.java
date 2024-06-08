package subsystem.interbank;

import common.exception.*;
import entity.payment.Card;
import entity.payment.PaymentTransaction;
import utils.MyMap;
import subsystem.converterstrategy.extractingpaymenttransactions.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author
 */
public class InterbankPayloadConverter {

    /**
     * Convert from native entity into interbank required format
     * @param card
     * @param amount
     * @param contents
     * @return
     */
    private ExtractingPaymentTransaction extractingPaymentTransaction;

    public InterbankPayloadConverter(ExtractingPaymentTransaction extractingPaymentTransaction) {
        this.extractingPaymentTransaction = extractingPaymentTransaction;
    }

    public InterbankPayloadConverter() {
    }

    public void setExtractingPaymentTransaction(ExtractingPaymentTransaction extractingPaymentTransaction) {
        this.extractingPaymentTransaction = extractingPaymentTransaction;
    }

    String convertToRequestPayload(Card card, int amount, String contents) {
        Map<String, Object> transaction = new MyMap();

        try {
            transaction.putAll(MyMap.toMyMap(card));
        } catch (IllegalArgumentException | IllegalAccessException e) {
            // TODO Auto-generated catch block
            throw new InvalidCardException();
        }
        transaction.put("command", InterbankConfigs.PAY_COMMAND);
        transaction.put("transactionContent", contents);
        transaction.put("amount", amount);
        transaction.put("createdAt", getToday());

        Map<String, Object> requestMap = new MyMap();
        requestMap.put("version", InterbankConfigs.VERSION);
        requestMap.put("transaction", transaction);

        return ((MyMap) requestMap).toJSON();
    }

    /**
     * Read the response from interbank server
     * @param responseText
     * @return
     */
    PaymentTransaction extractPaymentTransaction(String responseText) {
        extractingPaymentTransaction.extractPaymentTransaction(responseText);
    }

    /**
     * Convert response from interbank server as JSON-formatted String into a proper Map
     * @param responseText
     * @return
     */
    private MyMap convertJSONResponse(String responseText) {
        MyMap response = null;
        try {
            response = MyMap.toMyMap(responseText, 0);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            throw new UnrecognizedException();
        }
        return response;
    }

    /**
     * Return a {@link String String} that represents the current time in the format of yyyy-MM-dd HH:mm:ss.
     *
     * @author hieudm
     * @return the current time as {@link String String}.
     */
    private String getToday() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}