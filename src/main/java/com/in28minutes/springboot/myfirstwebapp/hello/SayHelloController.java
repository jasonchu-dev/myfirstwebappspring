package com.in28minutes.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//use annotation for component. this is keyword is component specific for ui/requests
//used to indicate a component that handles requests
@Controller
public class SayHelloController {
	
	//creating methods that handle requests

	// use annotation to invoke method when url is invoked
	@RequestMapping("say-hello")
	// will return whatever is in method to browser, otherwise there will be errors
	// on page
	@ResponseBody
	public String sayHello() {
		return "Hello! What are you learning today?";
	}

	// use annotation to invoke method when url is invoked
	@RequestMapping("say-hello-html")
	// will return whatever is in method to browser, otherwise there will be errors
	// on page
	@ResponseBody
	public String sayHelloHtml() {
		// can use a couple ways to return string or html code
		// recommended to not use +/append because of inefficiency
		// first way: use string buffer

//		StringBuffer sb = new StringBuffer();
//		sb.append("<html>");
//		sb.append("<head>");
//		sb.append("<title> My first HTML Page</title>");
//		sb.append("</head>");
//		sb.append("<body>");
//		sb.append("My first html page with body");
//		sb.append("</body>");
//		sb.append("</html>");

		// ---------------------------------------------//

//		sb.append("<html><head><title> My first HTML Page</title></head><body>My first html page with body</body></html>");

		// ---------------------------------------------//

//		sb.append(
//				"<html>"
//				+ "<head>"
//				+ "<title> "
//				+ "My first HTML Page"
//				+ "</title>"
//				+ "</head>"
//				+ "<body>"
//				+ "My first html page with body"
//				+ "</body>"
//				+ "</html>"
//				);
//		
//		return sb.toString();

		// second way: returnt the html string itself

//		return "<html>"
//				+ "   <head>\r\n"
//				+ "      <title> My first HTML Page</title>\r\n"
//				+ "   </head>\r\n"
//				+ "   <body>My first html page with body</body>\r\n"
//				+ "</html>";

		// ---------------------------------------------//

//		return """
//				<html>
//			   		<head>
//			      		<title> My first HTML Page</title>
//			   		</head>
//			   			<body>My first html page with body</body>
//				</html>
//			""";

		// ---------------------------------------------//

//		return "<html><head><title> My first HTML Page</title></head><body>My first html page with body</body></html>";

		// recommended ways

//		StringBuffer sb = new StringBuffer();

//		sb.append("""
//				<html>
//			   		<head>
//			      		<title> My first HTML Page</title>
//			   		</head>
//			   			<body>My first html page with body</body>
//				</html>
//			""");
//		
//		return sb.toString();

		// ---------------------------------------------//

//		return """
//				<html>
//			   		<head>
//			      		<title> My first HTML Page</title>
//			   		</head>
//			   			<body>My first html page with body</body>
//				</html>
//			""";

		StringBuffer sb = new StringBuffer();

		sb.append("""
					<html>
				   		<head>
				      		<title> afesgrdhfhgm</title>
				   		</head>
				   		<body
				   			My first html page with body
				   		</body>
					</html>
				""");

		return sb.toString();

	}
	
	@RequestMapping("say-hello-jsp")
	//html code can be several lines so use view technology JSP(java/jarkarta server pages)
	//stored in src/main/resources/META-INF/resources/WEB-INF/jsp/
	//jsp files can also be called view files
	
	//@ResponseBody is taken out. in order to use jsp do following
	
	//go to application.properties and add these lines

//	spring.mvc.view.prefix=/WEB-INF/jsp/
//	spring.mvc.view.suffix=.jsp
	
	//go to pom.xml and add dependency then reload app
	
//	<dependency>
//		<groupId>org.apache.tomcat.embed</groupId>
//		<artifactId>tomcat-embed-jasper</artifactId>
//		<scope>provided</scope>
//	</dependency>
	
	//this is so the return statement pulls name of jsp/view file
	
	public String sayHelloJsp() {
		return "sayHello";
	}

}
