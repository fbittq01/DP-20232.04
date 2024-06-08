package subsystem.converterstrategy.extractingpaymenttransaction;

import entity.payment.*;
import common.exception.*;
import utils.MyMap;

public class ExtractingCreditCard extends ExtractingPaymentTransaction{
    public PaymentTransaction extractPaymentTransaction(String responseText) {
        MyMap response = convertJSONResponse(responseText);

        if (response == null)
            return null;
        MyMap transaction = (MyMap) response.get("transaction");
        CreditCard card = new CreditCard(
                (String) transaction.get("cardCode"),
                (String) transaction.get("owner"),
                (String) transaction.get("dateExpired"),
                Integer.parseInt((String) transaction.get("cvvCode")));

        PaymentTransaction trans = new PaymentTransaction(
                (String) response.get("errorCode"),
                card,
                (String) transaction.get("transactionId"),
                (String) transaction.get("transactionContent"),
                Integer.parseInt((String) transaction.get("amount")),
                (String) transaction.get("createdAt"));

        switch (trans.getErrorCode()) {
            case "00":
                break;
            case "01":
                throw new InvalidCardException();
            case "02":
                throw new NotEnoughBalanceException();
            case "03":
                throw new InternalServerErrorException();
            case "04":
                throw new SuspiciousTransactionException();
            case "05":
                throw new NotEnoughTransactionInfoException();
            case "06":
                throw new InvalidVersionException();
            case "07":
                throw new InvalidTransactionAmountException();
            default:
                throw new UnrecognizedException();
        }

        return trans;
    }
}