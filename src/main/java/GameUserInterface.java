import io.bitbucket.plt.sdp.bohnanza.gui.*;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameUserInterface implements Runnable{
    private final Scanner scanner = new Scanner(System.in);

    int playerIndex = -1;
    private GUI gui;

    private Compartment field1;
    private Compartment field2;
    private Compartment field3;
    private Compartment handPile;
    private Compartment tradeOfferPile;
    private Compartment turnOverPile;
    private Compartment tradedPile;

    private Label field1Lbl;
    private Label field2Lbl;
    private Label field3Lbl;
    private Label dollarEarnedLbl;
    private Label currentPhaseLbl;
    private Label drawPileLbl;
    private Label discardPileLbl;

    public GameUserInterface(int playerIndex) {
        this.playerIndex = playerIndex;
    }

    @Override
    public void run() {
        this.gui = new GUI(new Size(825, 655), new Size(55, 90), new Size(55, 90), new Color(150,150,150), new Color(0,0,0));

        initButtons();

        //Static labels
        gui.addLabel(new Coordinate(10, 70), "Player Name: " + playerIndex);
        gui.addLabel(new Coordinate(185, 294), "Hand Pile");
        gui.addLabel(new Coordinate(565, 294), "Trade Offer");
        gui.addLabel(new Coordinate(171, 447), "Turn Over Pile");
        gui.addLabel(new Coordinate(565, 447), "Traded Pile");

        //Static Compartment for Field Image
        gui.addCompartment(new Coordinate(180, 27), new Size(440, 220), "", "BOHNENFELD_ALLE");

        // a label that will be used to show information on a dragged'n'dropped card
        field1Lbl = gui.addLabel(new Coordinate(241, 7), "None");
        field2Lbl = gui.addLabel(new Coordinate(384, 7), "None");
        field3Lbl = gui.addLabel(new Coordinate(530, 7), "None");

        dollarEarnedLbl = gui.addLabel(new Coordinate(10, 110), "Dollar Earned: ");
        currentPhaseLbl = gui.addLabel(new Coordinate(10, 150), "Current Phase: ");
        drawPileLbl = gui.addLabel(new Coordinate(10, 190), "DrawPile Count: ");
        discardPileLbl = gui.addLabel(new Coordinate(10, 230), "DiscardPile Count: ");

        field1 = gui.addCompartment(new Coordinate(180, 27), new Size(145, 220), "");
        field2 = gui.addCompartment(new Coordinate(327, 27), new Size(145, 220), "");
        field3 = gui.addCompartment(new Coordinate(474, 27), new Size(145, 220), "");
        handPile = gui.addCompartment(new Coordinate(10, 309), new Size(385, 100), "");
        tradeOfferPile = gui.addCompartment(new Coordinate(405, 309), new Size(385, 100), "");
        turnOverPile = gui.addCompartment(new Coordinate(10, 462), new Size(385, 100), "");
        tradedPile = gui.addCompartment(new Coordinate(405, 462), new Size(385, 100), "");

        // Schedule the task to run every second with an initial delay of 0 seconds
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(this::updateCards, 0, 2, TimeUnit.SECONDS);

        gui.start();
    }

    private void initButtons(){
        int btnWidth = 70;
        int btnHeight = 25;

        gui.addButton("Restart", new Coordinate(10, 14), new Size(btnWidth, btnHeight), button -> {
            System.out.println("Restart Game");
        });

        gui.addButton("Exit", new Coordinate(716, 14), new Size(btnWidth, btnHeight), button -> {
            gui.stop();
            System.exit(0);
        });

        gui.addButton("Harvest", new Coordinate(222, 252), new Size(btnWidth, btnHeight), button -> {
            System.out.println("Harvest from field 0");
        });

        gui.addButton("Harvest", new Coordinate(365, 252), new Size(btnWidth, btnHeight), button -> {
            System.out.println("Harvest from field 1");
        });

        gui.addButton("Harvest", new Coordinate(511, 252), new Size(btnWidth, btnHeight), button -> {
            System.out.println("Harvest from field 2");
        });

        gui.addButton("Plant", new Coordinate(174, 414), new Size(btnWidth, btnHeight), button -> {
            System.out.println("Plant");
        });

        gui.addButton("Draw", new Coordinate(250, 414), new Size(btnWidth, btnHeight), button -> {
            System.out.println("Draw");
        });

        gui.addButton("Trade", new Coordinate(567, 414), new Size(btnWidth, btnHeight), button -> {
            System.out.println("Restart Game");
        });

        gui.addButton("Clear", new Coordinate(644, 414), new Size(btnWidth, btnHeight), button -> {
            System.out.println("Clear Trade Offer");
        });

        gui.addButton("Plant", new Coordinate(174, 567), new Size(btnWidth, btnHeight), button -> {
            System.out.println("Restart Game");
        });

        gui.addButton("Turn", new Coordinate(250, 567), new Size(btnWidth, btnHeight), button -> {
            System.out.println("Restart Game");
        });

        gui.addButton("Plant", new Coordinate(721, 567), new Size(btnWidth, btnHeight), button -> {
            System.out.println("Restart Game");
        });
    }

    private void updateCards(){
        field1Lbl.updateLabel("new value");
        field2Lbl.updateLabel("new value");
        field3Lbl.updateLabel("new value");

        dollarEarnedLbl.updateLabel("Dollar Earned: " + 0);
        currentPhaseLbl.updateLabel("Current Phase: " + "Planting");
        drawPileLbl.updateLabel("DrawPile Count: " + 0);
        discardPileLbl.updateLabel("DiscardPile Count: " + 0);

        //Update Piles
        refreshCompartment(field1, new String[]{"AUGEN_BOHNE", "GARTEN_BOHNE"}, new Coordinate(180, 27));
        refreshCompartment(field2, new String[]{"AUGEN_BOHNE", "GARTEN_BOHNE"}, new Coordinate(327, 27));
        refreshCompartment(field3, new String[]{"AUGEN_BOHNE", "GARTEN_BOHNE"}, new Coordinate(474, 27));
        refreshCompartment(handPile, new String[]{"AUGEN_BOHNE", "GARTEN_BOHNE"}, new Coordinate(10, 309));
        refreshCompartment(tradeOfferPile, new String[]{"AUGEN_BOHNE", "GARTEN_BOHNE"}, new Coordinate(405, 309));
        refreshCompartment(turnOverPile, new String[]{"AUGEN_BOHNE", "GARTEN_BOHNE"}, new Coordinate(10, 462));
        refreshCompartment(tradedPile, new String[]{"AUGEN_BOHNE", "GARTEN_BOHNE"}, new Coordinate(405, 462));

        field1.distributeVertical(gui.getCardObjectsInCompartment(field1));
        field2.distributeVertical(gui.getCardObjectsInCompartment(field2));
        field3.distributeVertical(gui.getCardObjectsInCompartment(field3));

        handPile.distributeHorizontal(gui.getCardObjectsInCompartment(handPile));
        //tradeOfferPile.distributeHorizontal(gui.getCardObjectsInCompartment(tradeOfferPile));
        turnOverPile.distributeHorizontal(gui.getCardObjectsInCompartment(turnOverPile));
        tradedPile.distributeHorizontal(gui.getCardObjectsInCompartment(tradedPile));
    }

    private void refreshCompartment(Compartment compartment, String[] cards, Coordinate coordinate){
        //Remove current all cards from the box
        CardObject[] cardObjects = gui.getCardObjectsInCompartment(compartment);
        for(CardObject cardObject : cardObjects){
            gui.removeCard(cardObject);
        }

        //Add new cards to the box
        for(String cardName : cards){
            gui.addCard(CardType.valueOf(cardName), coordinate).flip();
        }
    }
}
