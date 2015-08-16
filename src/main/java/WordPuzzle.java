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

        //word variable userInputtedWord
        // grab which word is entered in the form
            String userInputtedWord = request.queryParams("word");
            String puzzleWord = replaceVowels(userInputtedWord);
            model.put("puzzleWord", puzzleWord);
            return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());
}

public static String replaceVowels(String word) {

        // break the word up

         char[] wordChar = word.toCharArray();

        // loop through the array of letters

        for (int i = 0; i < word.length(); i++) {
            if ("AEIOUaeiou".contains(String.valueOf(wordChar[i]))){
            wordChar[i] = '-';
            }
       }

        // print out new word with dashes instead of vowels

        String output = new String(wordChar);
            return output;
    }
}



        // code that didn't quite work

        /*String[] letters = word.split("");
        for (int i = 0; i < letters.length; i++)
        for (String eachLetter: letters) {
        String letter = letters[i].tolowerCase();
        if word contains vowels, replace them with dashes
        if (eachLetter == "a" || eachLetter == "e" || eachLetter == "i" || eachLetter == "o" || eachLetter == "u")

              //String[] letterPuzzle = letters.replace(letters[i], "-");
               //letters[i] = letters[i].replace(letters[i], "-");
               eachLetter.replace("a", "-");
               eachLetter.replace("e", "-");
               eachLetter.replace("i", "-");
               eachLetter.replace("o", "-");
               eachLetter.replace("u", "-");
               letters[i] = "-";

        String newWord = addDashes.replace( vowels.getKey();, '-' ); */
