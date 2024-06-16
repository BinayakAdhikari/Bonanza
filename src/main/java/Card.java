public class Card {

	private String cardName;
	private int numberOfCards;
	private int[] coin;

	// Constructor
	public Card(int cardType) {
		setCardDetails(cardType);
	}

	// Sets card details using the Beanometer
	private void setCardDetails(int cardType) {
		Object[] beanDetails = Beanometer.getBeanDetails(cardType);
		this.cardName = (String) beanDetails[0];
		this.numberOfCards = (Integer) beanDetails[1];
		this.coin = (int[]) beanDetails[2];
	}

	// Getters
	public String getCardName() {
		return cardName;
	}

	public int getNumberOfCards() {
		return numberOfCards;
	}

	public int[] getCoin() {
		return coin;
	}
}
