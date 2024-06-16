
public class Player implements Decisions{
	
	protected int playerNum;
	protected int treasury = 0;
	protected Hand hand = new Hand();
	protected Field[] fields = new Field[2];
	protected Market[] markets = new Market[2];
	protected Field[][] allFields = new Field[4][2]; //first index is player num  //Second index is fieldnum
	protected Deck deck;
	
	public Player(int playerNum, Deck deck){
		setPlayerNum(playerNum);
		setPile(deck);
		for(int n = 0; n < 2; n++){
			fields[n] = new Field(n);
			markets[n] = new Market(n);
		}
			
	}
	
	/** getters and setters **/
	public Deck getPile() {
		return deck;
	}

	public void setPile(Deck deck) {
		this.deck = deck;
	}

	public Field[][] getAllFields() {
		return allFields;
	}

	public void setAllFields(Field[][] allFields) {
		this.allFields = allFields;
	}

	public int getPlayerNum() {
		return playerNum;
	}

	public void setPlayerNum(int playerNum) {
		this.playerNum = playerNum;
	}

	public int getTreasury() {
		return treasury;
	}

	public void setTreasury(int treasury) {
		this.treasury = treasury;
	}
	
	public void addTreasury(int treasury) {
		this.treasury = this.treasury + treasury;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public Field[] getFields() {
		return fields;
	}

	public void setFields(Field[] fields) {
		this.fields = fields;
	}

	public Market[] getTradingArea() {
		return markets;
	}

	public void setTradingArea(Market[] markets) {
		this.markets = markets;
	}

	
	/** methods **/
	public boolean plantDecide(Card card) {
		return false;
	}
	
	public Field pickFieldToPlant(Card card) {
		return null;
	}
	
	public boolean sendTradeRequest(Card card) {
		return false;
	}

	public int acceptTradeRequest(Card[][] tradeCards) {
		return 0;
	}


	public boolean sendTradeRequest(Card card, Player player) {
		// TODO Auto-generated method stub
		return false;
	}

	public Card pickCardToTrade(Player player) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean plantDecideTA(Card card) {
		// TODO Auto-generated method stub
		return false;
	}

}
	





