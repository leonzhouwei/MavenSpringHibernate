package hello;

import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.servlet.ModelAndView;  
  
@Controller  
public class EchoController {  

    @RequestMapping("/echo")  
    public ModelAndView echo() {  
        System.out.println("oops: in EchoController.echo() now");
        ModelAndView mav = new ModelAndView();  
        mav.setViewName("echo");  
        mav.addObject("message", "Hello World!");  
        return mav;  
    }

}  