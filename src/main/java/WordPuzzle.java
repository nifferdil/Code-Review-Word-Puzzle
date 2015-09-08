import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;


public class WordPuzzle {
  public static void main(String[] args) {

    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/detector", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/detector.vtl");

      String userInputtedWord = request.queryParams("word");
      String puzzleWord = replaceVowels(userInputtedWord);
      model.put("puzzleWord", puzzleWord);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }

  public static String replaceVowels(String word) {

    char[] wordChar = word.toCharArray();

    for (int i = 0; i < word.length(); i++) {
      if ("AEIOUaeiou".contains(String.valueOf(wordChar[i]))){
        wordChar[i] = '-';
      }
    }
        
    String output = new String(wordChar);
    return output;
  }
}
