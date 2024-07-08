import io.bitbucket.plt.sdp.bohnanza.gui.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class UserInterface implements Runnable{
    private final Scanner scanner = new Scanner(System.in);

    List<Player> players = new ArrayList<Player>();
    private GUI gui;

    private Compartment player1Field1;
    private Compartment player1Field2;
    private Compartment player1Field3;
    private Compartment player2Field1;
    private Compartment player2Field2;
    private Compartment player2Field3;
    private Compartment player3Field1;
    private Compartment player3Field2;
    private Compartment player3Field3;
    private Compartment player1HandPile;
    private Compartment player2HandPile;
    private Compartment player3HandPile;
    private Compartment tradeOfferPile;
    private Compartment turnOverPile;
    private Compartment tradedPile;

    private Label field1Lbl;
    private Label field2Lbl;
    private Label field3Lbl;
    private Label player1DollarEarned;
    private Label player2DollarEarned;
    private Label player3DollarEarned;
    private Label currentPhaseLbl;
    private Label drawPileLbl;
    private Label discardPileLbl;

    public UserInterface(List<Player> players) {
        this.players = players;
    }

    @Override
    public void run() {
        this.gui = new GUI(new Size(1800, 900), new Size(55, 90), new Size(55, 90), new Color(150,150,150), new Color(30,0,0));

        initButtons();

//        //Static labels
        gui.addLabel(new Coordinate(50, 820), "Player Name: " + players.get(0).getName());
        gui.addLabel(new Coordinate(600, 820), "Player Name: " + players.get(1).getName());
        gui.addLabel(new Coordinate(1150, 820), "Player Name: " + players.get(2).getName());
//        gui.addLabel(new Coordinate(110, 820), "Hand Pile");
//        gui.addLabel(new Coordinate(200, 820), "Trade Offer");
//        gui.addLabel(new Coordinate(310, 820), "Turn Over Pile");
//        gui.addLabel(new Coordinate(410, 820), "Traded Pile");
//
//        //Static Compartment for First Field Image
        gui.addCompartment(new Coordinate(50, 500), new Size(440, 220), "", "BOHNENFELD_ALLE");

        //Static Compartment for Second Field Image
        gui.addCompartment(new Coordinate(600, 500), new Size(440, 220), "", "BOHNENFELD_ALLE");

        //Static Compartment for Third Field Image
        gui.addCompartment(new Coordinate(1150, 500), new Size(440, 220), "", "BOHNENFELD_ALLE");
//
//        // a label that will be used to show information on a dragged'n'dropped card
//        field1Lbl = gui.addLabel(new Coordinate(241, 7), "None");
//        field2Lbl = gui.addLabel(new Coordinate(384, 7), "None");
//        field3Lbl = gui.addLabel(new Coordinate(530, 7), "None");
//
        // a label that shows dollar earned by the playes
        player1DollarEarned = gui.addLabel(new Coordinate(300, 820), "Dollar Earned: ");
        player2DollarEarned = gui.addLabel(new Coordinate(800, 820), "Dollar Earned: ");
        player3DollarEarned = gui.addLabel(new Coordinate(1450, 820), "Dollar Earned: ");

        // a label that shows the current phase of the game
        currentPhaseLbl = gui.addLabel(new Coordinate(10, 150), "Current Phase: ");
        drawPileLbl = gui.addLabel(new Coordinate(10, 190), "DrawPile Count: ");
        discardPileLbl = gui.addLabel(new Coordinate(10, 230), "DiscardPile Count: ");
//
        player1Field1 = gui.addCompartment(new Coordinate(50, 500), new Size(150, 220), "");
        player1Field2 = gui.addCompartment(new Coordinate(200, 500), new Size(150, 220), "");
        player1Field3 = gui.addCompartment(new Coordinate(350, 500), new Size(140, 220), "");

        //fields for player 2
        player2Field1 = gui.addCompartment(new Coordinate(600, 500), new Size(150, 220), "");
        player2Field2 = gui.addCompartment(new Coordinate(750, 500), new Size(150, 220), "");
        player2Field3 = gui.addCompartment(new Coordinate(900, 500), new Size(140, 220), "");

        //fields for player 3
        player3Field1 = gui.addCompartment(new Coordinate(1150, 500), new Size(150, 220), "");
        player3Field2 = gui.addCompartment(new Coordinate(1300, 500), new Size(150, 220), "");
        player3Field3 = gui.addCompartment(new Coordinate(1450, 500), new Size(140, 220), "");

        player1HandPile = gui.addCompartment(new Coordinate(50, 309), new Size(385, 100), "");
        player2HandPile = gui.addCompartment(new Coordinate(600, 309), new Size(385, 100), "");
        player3HandPile = gui.addCompartment(new Coordinate(1150, 309), new Size(385, 100), "");
//        tradeOfferPile = gui.addCompartment(new Coordinate(405, 309), new Size(385, 100), "");
//        turnOverPile = gui.addCompartment(new Coordinate(10, 462), new Size(385, 100), "");
//        tradedPile = gui.addCompartment(new Coordinate(405, 462), new Size(385, 100), "");

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

        gui.addButton("Exit", new Coordinate(1690, 14), new Size(btnWidth, btnHeight), button -> {
            gui.stop();
            System.exit(0);
        });

        // buttons for first field image
        gui.addButton("Harvest", new Coordinate(100, 750), new Size(btnWidth, btnHeight), button -> {
            System.out.println("Harvest from field 0");
        });

        gui.addButton("Harvest", new Coordinate(250, 750), new Size(btnWidth, btnHeight), button -> {
            System.out.println("Harvest from field 1");
        });

        gui.addButton("Harvest", new Coordinate(400, 750), new Size(btnWidth, btnHeight), button -> {
            System.out.println("Harvest from field 2");
        });

        gui.addButton("Plant", new Coordinate(100, 414), new Size(btnWidth, btnHeight), button -> {
            System.out.println("Plant");
        });

        gui.addButton("Draw", new Coordinate(200, 460), new Size(btnWidth, btnHeight), button -> {
            System.out.println("Draw");
        });

        gui.addButton("Trade", new Coordinate(500, 600), new Size(btnWidth, btnHeight), button -> {
            System.out.println("Restart Game");
        });

        gui.addButton("Clear", new Coordinate(500, 650), new Size(btnWidth, btnHeight), button -> {
            System.out.println("Clear Trade Offer");
        });

        gui.addButton("Plant", new Coordinate(250, 414), new Size(btnWidth, btnHeight), button -> {
            System.out.println("Restart Game");
        });

        gui.addButton("Turn", new Coordinate(300, 460), new Size(btnWidth, btnHeight), button -> {
            System.out.println("Restart Game");
            updateCards();
        });

        gui.addButton("Plant", new Coordinate(400, 414), new Size(btnWidth, btnHeight), button -> {
            System.out.println("Restart Game");
        });

        // buttons for second field image
        gui.addButton("Harvest", new Coordinate(650, 750), new Size(btnWidth, btnHeight), button -> {
            System.out.println("Harvest from field 0");
        });

        gui.addButton("Harvest", new Coordinate(800, 750), new Size(btnWidth, btnHeight), button -> {
            System.out.println("Harvest from field 1");
        });

        gui.addButton("Harvest", new Coordinate(950, 750), new Size(btnWidth, btnHeight), button -> {
            System.out.println("Harvest from field 2");
        });

        gui.addButton("Plant", new Coordinate(650, 414), new Size(btnWidth, btnHeight), button -> {
            System.out.println("Plant");
        });

        gui.addButton("Draw", new Coordinate(750, 460), new Size(btnWidth, btnHeight), button -> {
            System.out.println("Draw");
        });

        gui.addButton("Trade", new Coordinate(1050, 600), new Size(btnWidth, btnHeight), button -> {
            System.out.println("Restart Game");
        });

        gui.addButton("Clear", new Coordinate(1050, 650), new Size(btnWidth, btnHeight), button -> {
            System.out.println("Clear Trade Offer");
        });

        gui.addButton("Plant", new Coordinate(800, 414), new Size(btnWidth, btnHeight), button -> {
            System.out.println("Restart Game");
        });

        gui.addButton("Turn", new Coordinate(850, 460), new Size(btnWidth, btnHeight), button -> {
            System.out.println("Restart Game");
        });

        gui.addButton("Plant", new Coordinate(950, 414), new Size(btnWidth, btnHeight), button -> {
            System.out.println("Restart Game");
        });

        // buttons for third field image
        gui.addButton("Harvest", new Coordinate(1200, 750), new Size(btnWidth, btnHeight), button -> {
            System.out.println("Harvest from field 0");
        });

        gui.addButton("Harvest", new Coordinate(1350, 750), new Size(btnWidth, btnHeight), button -> {
            System.out.println("Harvest from field 1");
        });

        gui.addButton("Harvest", new Coordinate(1500, 750), new Size(btnWidth, btnHeight), button -> {
            System.out.println("Harvest from field 2");
        });

        gui.addButton("Plant", new Coordinate(1200, 414), new Size(btnWidth, btnHeight), button -> {
            System.out.println("Plant");
        });

        gui.addButton("Draw", new Coordinate(1300, 460), new Size(btnWidth, btnHeight), button -> {
            System.out.println("Draw");
        });

        gui.addButton("Trade", new Coordinate(1600, 600), new Size(btnWidth, btnHeight), button -> {
            System.out.println("Restart Game");
        });

        gui.addButton("Clear", new Coordinate(1600, 650), new Size(btnWidth, btnHeight), button -> {
            System.out.println("Clear Trade Offer");
        });

        gui.addButton("Plant", new Coordinate(1350, 414), new Size(btnWidth, btnHeight), button -> {
            System.out.println("Restart Game");
        });

        gui.addButton("Turn", new Coordinate(1400, 460), new Size(btnWidth, btnHeight), button -> {
            System.out.println("Restart Game");
        });

        gui.addButton("Plant", new Coordinate(1500, 414), new Size(btnWidth, btnHeight), button -> {
            System.out.println("Restart Game");
        });
    }

    private void updateCards(){
//        field1Lbl.updateLabel("new value");
//        field2Lbl.updateLabel("new value");
//        field3Lbl.updateLabel("new value");

//        player1DollarEarned.updateLabel("Dollar Earned: " + 0);
//        currentPhaseLbl.updateLabel("Current Phase: " + "Planting");
//        drawPileLbl.updateLabel("DrawPile Count: " + 0);
//        discardPileLbl.updateLabel("DiscardPile Count: " + 0);

        //Update Piles
//        refreshCompartment(player1Field1, new String[]{"AUGEN_BOHNE", "GARTEN_BOHNE"}, new Coordinate(52, 630));
//        refreshCompartment(player1Field2, new String[]{"AUGEN_BOHNE", "GARTEN_BOHNE"}, new Coordinate(327, 27));
//        refreshCompartment(player1Field3, new String[]{"AUGEN_BOHNE", "GARTEN_BOHNE"}, new Coordinate(474, 27));

        refreshCompartment(player1HandPile, players.get(0).getHand().stream()
                .map(card -> card.getBeanType().getName())
                .collect(Collectors.toList()).toArray(new String[0]), new Coordinate(50, 309));
//        refreshCompartment(tradeOfferPile, new String[]{"AUGEN_BOHNE", "GARTEN_BOHNE"}, new Coordinate(405, 309));
//        refreshCompartment(turnOverPile, new String[]{"AUGEN_BOHNE", "GARTEN_BOHNE"}, new Coordinate(10, 462));
//        refreshCompartment(tradedPile, new String[]{"AUGEN_BOHNE", "GARTEN_BOHNE"}, new Coordinate(405, 462));
//
//        player1Field1.distributeVertical(gui.getCardObjectsInCompartment(player1Field1));
//        player1Field2.distributeVertical(gui.getCardObjectsInCompartment(player1Field2));
//        player1Field3.distributeVertical(gui.getCardObjectsInCompartment(player1Field3));
//
//        player1HandPile.distributeHorizontal(gui.getCardObjectsInCompartment(player1HandPile));
//        //tradeOfferPile.distributeHorizontal(gui.getCardObjectsInCompartment(tradeOfferPile));
//        turnOverPile.distributeHorizontal(gui.getCardObjectsInCompartment(turnOverPile));
//        tradedPile.distributeHorizontal(gui.getCardObjectsInCompartment(tradedPile));
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
