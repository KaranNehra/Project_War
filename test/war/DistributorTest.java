/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package war;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author karan
 */
public class DistributorTest {

    public DistributorTest() {
    }

    @Test
    public void testGetCompDeckGood() {
        System.out.println("testGetCompDeckGood");
        Distributor instance = new Distributor();
        instance.setDistributor(new ArrayList<Card>()); // Set the distributor as an empty list
        List<Card> distributor = instance.getDistributor();
        int numCards = Math.min(distributor.size(), 26); // Get the minimum of distributor size and 26
        List<Card> expResult = distributor.subList(0, numCards); // Set expected value as the first numCards in the distributor
        List<Card> result = instance.getCompDeck().subList(0, numCards); // Get the actual result
        // Compare the expected value with the actual result
        assertEquals(expResult, result);
    }

    @Test
    public void testGetCompDeckBoundary() {
        System.out.println("testGetCompDeckBoundary");
        Distributor instance = new Distributor();
        ArrayList<Card> distributor = new ArrayList<Card>();
        distributor.add(new Card(Card.Suit.HEARTS, Card.Rank.ACE)); // Add one card to the distributor
        instance.setDistributor(distributor); // Set the distributor with only one card
        ArrayList<Card> expResult = new ArrayList<Card>(); // Set expected value as an empty list
        ArrayList<Card> result = new ArrayList<Card>();
        // Compare the expected value with the actual result
        assertEquals(expResult, result);
    }
    @Test
    public void testGetCompDeckBad() {
        System.out.println("testGetCompDeckBad");
        Distributor instance = new Distributor();
        ArrayList<Card> expResult = new ArrayList<Card>(); // Set an expected value
        ArrayList<Card> result = instance.getCompDeck();
        // Compare the expected value with the actual result
        assertNotEquals(expResult, result);
    }

    @Test
    public void testPlayerDeckBad() {
        System.out.println("testPlayerDeckBad");
        Distributor instance = new Distributor();
        ArrayList<Card> expResult = new ArrayList<Card>(); // Set an expected value
        ArrayList<Card> result = instance.getPlayerDeck();
        // Compare the expected value with the actual result
        assertNotEquals(expResult, result);
    }
    @Test
    public void testPlayerDeckGood() {
    System.out.println("testPlayerDeckGood");
    Distributor instance = new Distributor();
    instance.playerDeck(); // Call the playerDeck() method
    ArrayList<Card> expResult = instance.getPlayerDeck();
    ArrayList<Card> result = instance.getPlayerDeck();
    // Compare the expected value with the actual result
    assertEquals(expResult, result);
}

@Test
public void testPlayerDeckBoundary() {
    System.out.println("testPlayerDeckBoundary");
    Distributor instance = new Distributor();
    ArrayList<Card> distributor = new ArrayList<Card>();
    // Add 52 cards to the distributor to represent a complete deck
    for (Card.Suit suit : Card.Suit.values()) {
        for (Card.Rank rank : Card.Rank.values()) {
            distributor.add(new Card(suit, rank));
        }
    }
    instance.setDistributor(distributor); // Set the distributor with a complete deck
    ArrayList<Card> playerDeck = instance.getPlayerDeck(); // Call the playerDeck() method and store the result in a local variable
    // Assert the expected behavior of the playerDeck() method
    assertEquals(26, playerDeck.size()); // Expect the playerDeck() to have 26 cards after calling the method
}

@Test
public void testSetDistributorGood() {
    System.out.println("testSetDistributorGood");
    Distributor instance = new Distributor();
    ArrayList<Card> distributor = new ArrayList<Card>();
    distributor.add(new Card(Card.Suit.HEARTS, Card.Rank.ACE));
    distributor.add(new Card(Card.Suit.DIAMONDS, Card.Rank.TEN));
    distributor.add(new Card(Card.Suit.CLUBS, Card.Rank.FIVE));
    distributor.add(new Card(Card.Suit.SPADES, Card.Rank.KING));
    instance.setDistributor(distributor); // Set the distributor
    ArrayList<Card> expResult = distributor; // Set expected value as the distributor
    ArrayList<Card> result = instance.getDistributor(); // Get the actual result
    // Compare the expected value with the actual result
    assertEquals(expResult, result);
}
@Test
public void testSetDistributorBad() {
    System.out.println("testSetDistributorBad");
    ArrayList<Card> expResult = new ArrayList<Card>(); // Set an expected value
    Distributor instance = new Distributor();
    instance.setDistributor(expResult); // Call the setDistributor() method with the expected value
    ArrayList<Card> result = instance.getDistributor();
    // Compare the expected value with the actual result
    assertEquals(expResult, result);
}

@Test
public void testSetDistributorBoundary() {
    System.out.println("testSetDistributorBoundary");
    Distributor instance = new Distributor();
    ArrayList<Card> distributor = new ArrayList<Card>();
    distributor.add(new Card(Card.Suit.HEARTS, Card.Rank.ACE)); // Add one card to the distributor
    instance.setDistributor(distributor); // Set the distributor with only one card
    ArrayList<Card> expResult = distributor; // Set expected value as the distributor with one card
    ArrayList<Card> result = instance.getDistributor(); // Get the actual result
    // Compare the expected value with the actual result
    assertEquals(expResult, result);
}


}
