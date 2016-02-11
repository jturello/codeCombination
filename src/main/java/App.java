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



    // get("/", (request, response) -> {
    //   HashMap model = new HashMap();
    //
    //   model.put("simpleHeading", "Simple Input Form");
    //   model.put("template", "templates/simple-form.vtl");
    //   return new ModelAndView(model, layout);
    //    }, new VelocityTemplateEngine());
    //
    // get("/result-simple", (request, response) -> {
    //   HashMap model = new HashMap();
    //   model.put("template", "templates/simple-form.vtl");
    //   String simpleInput = request.queryParams("userInput");
    //
    //   model.put("simpleHeading", "Result Below:");
    //   model.put("simpleInput", simpleInput);
    //   return new ModelAndView(model, layout);
    //    }, new VelocityTemplateEngine());
    //
    //
    // get("/greeting-form", (request, response) -> {
    //   HashMap model = new HashMap();
    //
    //   model.put("template", "templates/greeting-form.vtl" );
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    //
    //
    // get("/greeting_card", (request, response) -> {
    //   HashMap model = new HashMap();
    //   String recipient = request.queryParams("recipient");
    //   String sender = request.queryParams("sender");
    //
    //   model.put("recipient", recipient);
    //   model.put("sender", sender);
    //   model.put("template", "templates/greeting_card.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    //
    //
    // get("/leap-year", (request, response) -> {
    //   HashMap model = new HashMap();
    //
    //   model.put("simpleHeading", "Leap-year Input Form");
    //   model.put("template", "templates/simple-form.vtl");
    //   return new ModelAndView(model, layout);
    //    }, new VelocityTemplateEngine());
    //
    //
    // get("/result-leap", (request, response) -> {
    //   HashMap model = new HashMap();
    //   String yearInput = request.queryParams("userInput");
    //
    //   model.put("simpleHeading", "Leap-year Result Below:");
    //   model.put("yearInput", yearInput);
    //   model.put("template", "templates/simple-form.vtl");
    //   return new ModelAndView(model, layout);
    //    }, new VelocityTemplateEngine());

  }

  public String returnCoins(String inputStr) {
    StringBuilder answerBuilder = new StringBuilder();
    Integer inputInt = Integer.parseInt(inputStr);
    int[] coinArray = {100, 50, 25, 10, 5, 1};

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
      }

    String answer = answerBuilder.toString();
    return answer;

  }

}
