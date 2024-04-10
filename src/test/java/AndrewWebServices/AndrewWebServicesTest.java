package AndrewWebServices;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class AndrewWebServicesTest {
    Database database;
    Database fakeDatabase;
    RecSys recommender;
    RecSys stubRecommender;
    PromoService promoService;
    AndrewWebServices andrewWebService;
    AndrewWebServices fakeAndrewWebService;

    @Before
    public void setUp() {
        // You need to use some mock objects here
        //database = new Database(); // We probably don't want to access our real database...
        fakeDatabase = new FakeDatabase();
        //recommender = new RecSys();
        stubRecommender = new StubRecSys("Animal House");
        promoService = new PromoService();
        andrewWebService = new AndrewWebServices(fakeDatabase, stubRecommender, promoService);
    }

    @Test
    public void testLogIn() {
        // This is taking way too long to test
        assertTrue(andrewWebService.logIn("Scotty", 17214));
    }

    @Test
    public void testGetRecommendation() {
        // This is taking way too long to test
        assertEquals("Animal House", andrewWebService.getRecommendation("Scotty"));
    }

    @Test
    public void testSendEmail() {
        // How should we test sendEmail() when it doesn't have a return value?
        // Hint: is there something from Mockito that seems useful here?
        AndrewWebServices ourMock = mock(AndrewWebServices.class);
        ourMock.sendPromoEmail("ruiqiy@andrew.cmu.edu");
        verify(ourMock).sendPromoEmail("ruiqiy@andrew.cmu.edu");
    }

    @Test
    public void testNoSendEmail() {
        // How should we test that no email has been sent in certain situations (like right after logging in)?
        // Hint: is there something from Mockito that seems useful here?
        AndrewWebServices ourMock = mock(AndrewWebServices.class);
        verify(ourMock, never()).sendPromoEmail(anyString());
    }
}
