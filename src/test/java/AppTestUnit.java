// Unit Tests
import org.junit.*;
import static org.junit.Assert.*;

public class AppTestUnit {

  @Test
  public void getCoinCombo_forUserInput25cents_returnOneQuarter() {
    App testApp = new App();
    String change = testApp.returnCoins("25");
    assertEquals("1 Quarter", change);
  }

  @Test
  public void getCoinCombo_forUserInput300_returnThreeQuarters() {
    App testApp = new App();
    String change = testApp.returnCoins("300");
    assertEquals("3 Silver Dollars", change);
  }

  @Test
  public void getCoinCombo_forUserInput4_returnFourPennies() {
    App testApp = new App();
    String change = testApp.returnCoins("4");
    assertEquals("4 Pennies", change);
  }

  @Test
  public void getCoinCombo_forUserInput256_return256words() {
    App testApp = new App();
    String change = testApp.returnCoins("256");
    assertEquals("2 Silver Dollars, 1 Half Dollar, 1 Nickel, and 1 Penny", change);
  }

  @Test
  public void getCoinCombo_forUserInputLessThanOne_returnInvalidEntryMessage() {
    App testApp = new App();
    String change = testApp.returnCoins("0");
    assertEquals("Invalid entry. Please enter positive integers only!", change);
  }

}
