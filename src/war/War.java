package war;

import java.util.ArrayList;
import java.util.Scanner;

public class War {

    public static void main(String[] args) {
        //basic game model is created but now advanced changes need to be made like war condition and the winner counter and the loop setting
        ArrayList<Card> playerCollectorDeck = new ArrayList<Card>();
        ArrayList<Card> compCollectorDeck = new ArrayList<Card>();

        Distributor dis = new Distributor();
        Scanner sc = new Scanner(System.in);
        int randomNumComp = (int) (Math.random() * dis.getCompDeck().size());

        System.out.print("Player 1: ");
        System.out.println(dis.getPlayerDeck());

        System.out.print("Enter any card number: ");
        int index = sc.nextInt();
        Card playerCard = dis.getPlayerDeck().get(index);
        Card computerCard = dis.getCompDeck().get(randomNumComp);

        while (!dis.getPlayerDeck().isEmpty()) {
            System.out.println(dis.getPlayerDeck().get(index));
            playerCard = dis.getPlayerDeck().get(index);
            computerCard = dis.getCompDeck().get(randomNumComp);

            System.out.println("And computer's card is: " + dis.getCompDeck().get(randomNumComp));
            if (playerCard.getValue() > computerCard.getValue()) {
                //randomNumComp--;
                System.out.println("Player 1 Won!!\n");

                playerCollectorDeck.add(computerCard);
                playerCollectorDeck.add(playerCard);
                dis.getCompDeck().remove(computerCard);
                dis.getPlayerDeck().remove(playerCard);
            } else if (playerCard.getValue() == computerCard.getValue()) {
                while (playerCard.getValue() == computerCard.getValue()) {
                    System.out.println("-------------------------------------");
                    System.out.println("Computer and Player having same value");
                    System.out.println("War is Declared. ");
                    System.out.println("-------------------------------------");
                    Card[] tempPlayerArry = new Card[4];
                    Card[] tempCompArry = new Card[4];
                    for (int i = 0; i < 4; i++) {
                        tempPlayerArry[i] = dis.getPlayerDeck().get(0);
                        tempCompArry[i] = dis.getCompDeck().get(0);
                        dis.getCompDeck().remove(0);
                        dis.getPlayerDeck().remove(0);
                    }
                    System.out.print("Enter any card number: ");
                    index = sc.nextInt();
                    playerCard = dis.getPlayerDeck().get(index);
                    computerCard = dis.getCompDeck().get(index);
                    if (playerCard.getValue() > computerCard.getValue()) {
                        System.out.println("Player 1 Won!!\n");

                        playerCollectorDeck.add(computerCard);
                        playerCollectorDeck.add(playerCard);
                        dis.getCompDeck().remove(computerCard);
                        dis.getPlayerDeck().remove(playerCard);
                        for (int i = 0; i < 4; i++) {
                            playerCollectorDeck.add(tempPlayerArry[i]);
                            playerCollectorDeck.add(tempCompArry[i]);
                        }
                    } else {
                        System.out.println("The computer won\n");
                        compCollectorDeck.add(computerCard);
                        compCollectorDeck.add(playerCard);
                        dis.getCompDeck().remove(computerCard);
                        dis.getPlayerDeck().remove(playerCard);
                        for (int i = 0; i < 4; i++) {
                            compCollectorDeck.add(tempPlayerArry[i]);
                            compCollectorDeck.add(tempCompArry[i]);
                        }
                    }

                }

            } else {
                //randomNumComp--;
                System.out.println("The computer won\n");
                compCollectorDeck.add(computerCard);
                compCollectorDeck.add(playerCard);
                dis.getCompDeck().remove(computerCard);
                dis.getPlayerDeck().remove(playerCard);
            }

            if (dis.getPlayerDeck().isEmpty()) {
                break;
            } else {
                System.out.print("Player 1: ");
                System.out.println(dis.getPlayerDeck());
            }

            System.out.print("Enter any card number: ");
            index = sc.nextInt();
            randomNumComp = (int) (Math.random() * dis.getCompDeck().size());

        }

        if (playerCollectorDeck.size() > compCollectorDeck.size()) {
            System.out.println("---------------------------------");
            System.out.println("Congratulations !! ");
            System.out.println("Player 1 Won the Game.");
            System.out.println("---------------------------------");

        } else {
            System.out.println("---------------------------------");
            System.out.println("The computer won the game.");
            System.out.println("---------------------------------");
        }
    }

}
