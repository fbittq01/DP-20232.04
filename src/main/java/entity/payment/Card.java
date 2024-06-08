package entity.payment;

/**
 * @author
 */
public class Card {

    private String cardCode;
    private String owner;

    public Card(String cardCode, String owner) {
        this.cardCode = cardCode;
        this.owner = owner;
    }
}