package jm.edu.utech.fruitbasketmone.controllers;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jm.edu.utech.fruitbasketmone.viewmodels.LoginViewModel;

@RestController
@RequestMapping("api/auth")
public class AuthController {
	public AuthController() {
		System.out.println("AuthController called");
		//initialize repositories/database/service class instances
	}
	// Go to : http://localhost:8090/api/auth/hello
	@GetMapping("/hello")
	public String hello() {
		return "Hello Gilroy";
	}
	
	// http://localhost:8090/api/auth/sayhello
	    //      ?firstName=Junior&lastName=Samuels
	@GetMapping("/sayhello")
	public String sayHello(
		@RequestParam("firstName") String firstName,
		@RequestParam("lastName") java.util.Optional<String> surName
	) {
		return String.format("Hello %s %s", firstName, surName);
	}
	
	//TODO: Can you create an endpoint at api/auth/add5
	 //   that accepts a number and returns the number + 5
	
   //Goto : http://localhost:8090/api/auth/user/Junior
   @GetMapping("/user/{username}")
   public LoginViewModel getUser(
		   @PathVariable("username") String username
	) {
	   LoginViewModel data = 
		 new LoginViewModel(username,"never send user password");
	   return data;
   }
   
   /**
    * 
    *  Try the following jquery code
    $.ajax({
    url : 'http://localhost:8090/api/auth/login',
    type: 'POST',
    data: JSON.stringify({
          username:"Tom",
          passsword:"Oliver"
    }),
    contentType:'application/json',
    success:function(response){
        console.log("Successful, data:",response);
    },
    error:function(error){
        console.log("Request unsuccessful");
        console.error(error)
    }
})
    * */
   @PostMapping("/login")
   public String login(
		   @RequestBody LoginViewModel credentials
	) {
	   return String.format("Fake-Token-%s-%s",
	     credentials.getUsername(),credentials.getPassword());
   } 
   
}
