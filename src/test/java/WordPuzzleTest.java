import org.fluentlenium.adapter.FluentTest;
import static org.junit.Assert.*;
import org.junit.*;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;


public class WordPuzzleTest extends FluentTest {

  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
       public static ServerRule server = new ServerRule();

  @Test
      public void replaceVowels_returnADashSymbolForAVowel_bed() {
         WordPuzzle app = new WordPuzzle();
         String expValue = "b-d";
         assertEquals(expValue, app.replaceVowels("bed"));
      }

  @Test
      public void replaceVowels_changeAllVowelsToDashes_aeiou(){
         WordPuzzle app = new WordPuzzle();
         String expValue = "- j-st c-n't w--t t- g- t- b-d";
         assertEquals(expValue, app.replaceVowels("I just can't wait to go to bed"));
      }

  @Test
       public void rootTest() {
         goTo("http://localhost:4567/");
         assertThat(pageSource()).contains("Word Puzzle");
       }

   @Test
       public void puzzleDisplay() {
         goTo("http://localhost:4567/");
         fill("#word").with("bed");
         submit(".btn");
         assertThat(pageSource()).contains("b-d");
      }
}
