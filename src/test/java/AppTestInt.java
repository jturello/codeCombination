import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTestInt extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void initialRootPageLoad() {
      goTo("http://localhost:4567/coinReturn");
      assertThat(pageSource()).contains("Hello there");
    }

  @Test
  public void initialRootPageLoad_text_result_notDisplayed() {
      goTo("http://localhost:4567/coinReturn");
      assertThat(pageSource()).doesNotContain("The result is:");
    }

  @Test
  public void validOutputDisplays() {
      goTo("http://localhost:4567/coinReturn");
      fill("#userInput").with("25");
      submit(".btn");
      System.out.println(pageSource());
      assertThat(pageSource()).contains("1 Quarter");
    }

} // END OF CLASS AppTestInt
