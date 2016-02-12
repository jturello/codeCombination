import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;


public class App {

  private static HashMap<Integer, String> coins = new HashMap();
  static
  {
    coins.put(100, "Silver Dollar");
    coins.put(50, "Half Dollar");
    coins.put(25, "Quarter");
    coins.put(10, "Dime");
    coins.put(5, "Nickel");
    coins.put(1, "Penny");
  }

  // String answer = new String();

  public static void main( String[] args ) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/coinReturn", (request, response) -> {
      HashMap model = new HashMap();
      String coinInputString = request.queryParams("userInput");

      model.put("simpleHeading", "Hello there, find out how much change you have." );
      model.put("template", "templates/simple-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/result", (request, response) -> {
      HashMap model = new HashMap();
      String coinInputString = request.queryParams("userInput");
      String stringOutput = returnCoins(coinInputString);

      model.put("simpleOutput", stringOutput);
      model.put("template", "templates/simple-form.vtl");
      return new ModelAndView(model , layout);
    }, new VelocityTemplateEngine());

  }

  public static String returnCoins(String inputStr) {

    StringBuilder answerBuilder = new StringBuilder();

    try {
      Integer inputInt = Integer.parseInt(inputStr);
      int[] coinArray = {100, 50, 25, 10, 5, 1};

      if (inputInt < 1) {
        return "Invalid entry. Please enter positive integers only!";
      }

      for(int i = 0; i < coinArray.length; i++){
        if(inputInt == 0) {break;}
        Integer count = 0;

        while(inputInt >= coinArray[i]) {
          count += 1;
          inputInt -= coinArray[i];
        }

        if (count==1){
          answerBuilder.append(count + " " + coins.get(coinArray[i]));
          } else if (count > 1 && i < 5 ) {
            answerBuilder.append(count + " " + coins.get(coinArray[i]) + "s");
            } else if ( i == 5 ) {
              answerBuilder.append(count + " " + "Pennies");
        }

        if (count > 0){
          if ((inputInt > 0) && (inputInt >= coinArray[i + 1]) && (inputInt % coinArray[i + 1] == 0) ) {
            answerBuilder.append(", and ");
          } else if ((inputInt > 0) /* && (inputInt >= coinArray[i + 1/) */ ){
            answerBuilder.append(", ");
            } else {
              }
          }
        } // END OF FOR LOOP

      String answer = answerBuilder.toString();
      return answer;

    } catch(NumberFormatException e) {
      return "Error - Received NumberFormatException " + e.getMessage();
    }

  } // END METHOD coinReturn

}
