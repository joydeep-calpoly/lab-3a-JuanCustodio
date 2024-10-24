package lab_3a;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

class MovieTicketTestCases {
	
	@Test
	void testcomputePrice_Seniors(){
		MovieTicketPriceCalculator calcu = new MovieTicketPriceCalculator(
				LocalTime.of(12, 0), LocalTime.of(14, 0), 10, 70);
		
		int price = calcu.computePrice(LocalTime.of(15, 0), 70);
		assertEquals(2700 - 400, price);
	}
	
    @Test
    void testComputePrice_Child() {
        MovieTicketPriceCalculator calculator = new MovieTicketPriceCalculator(
                LocalTime.of(12, 0), LocalTime.of(15, 0), 12, 65);
        
        
        int price = calculator.computePrice(LocalTime.of(18, 0), 10);
        assertEquals(2700 - 300, price);
    }
        
    @Test
    void testComputePrice_ChildMatinee() {
        MovieTicketPriceCalculator calculator = new MovieTicketPriceCalculator(
                LocalTime.of(14, 0), LocalTime.of(17, 0), 12, 65);
        
       
        int price = calculator.computePrice(LocalTime.of(15, 0), 10);
        assertEquals(2400 - 300, price);
    }

    @Test
    void testComputePrice_SeniorMatinee() {
        MovieTicketPriceCalculator calculator = new MovieTicketPriceCalculator(
                LocalTime.of(14, 0), LocalTime.of(17, 0), 12, 65);
 
        int price = calculator.computePrice(LocalTime.of(15, 0), 70);
        assertEquals(2400 - 400, price);
    }
    
    
    @Test
    void testComputePrice_Adult() {
        MovieTicketPriceCalculator calculator = new MovieTicketPriceCalculator(
                LocalTime.of(14, 0), LocalTime.of(17, 0), 12, 65);
        
    
        int price = calculator.computePrice(LocalTime.of(18, 0), 30);
        assertEquals(2700, price);
    }
    
    @Test
    void testComputePrice_Matinee() {
        MovieTicketPriceCalculator calculator = new MovieTicketPriceCalculator(
                LocalTime.of(14, 0), LocalTime.of(17, 0), 12, 65);
        
        int price = calculator.computePrice(LocalTime.of(15, 0), 30);
        assertEquals(2400, price);
    }
    
    @Test
    void testComputePrice_MatineePriceForAdult() {
        MovieTicketPriceCalculator calculator = new MovieTicketPriceCalculator(
                LocalTime.of(14, 0), LocalTime.of(17, 0), 12, 65);
        
        int price = calculator.computePrice(LocalTime.of(15, 0), 30);
        assertEquals(2400, price);
    }
    
    @Test
    void testInvalidMatineeTimeRange() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new MovieTicketPriceCalculator(LocalTime.of(17, 0), LocalTime.of(14, 0), 12, 65);
        });
        assertEquals("matinee start time cannot come after end time", thrown.getMessage());
    }

   

}
