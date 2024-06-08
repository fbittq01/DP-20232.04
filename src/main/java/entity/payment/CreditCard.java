package entity.payment;

/**
 * @author
 */
public class CreditCard {

    private String dateExpired;
    protected int cvvCode;

    public CreditCard(String cardCode, String owner, String dateExpired, int cvvCode) {
        super(cardCode, owner);
        this.dateExpired = dateExpired;
        this.cvvCode = cvvCode;
    }
}