package main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ResponseController {
    private static BaseResponse baseResponseMain;

    @RequestMapping(value = {"/personList"}, method = RequestMethod.GET)
    public String personList(Model model) {
        model.addAttribute("baseResponseMain", baseResponseMain);

        return "personList";
    }


    @RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
    public String getInfo(Model model) {
        /*LocalDate birthDate = LocalDate.of(Integer.parseInt(birthday.split("-")[0]), Integer.parseInt(birthday.split("-")[1]), Integer.parseInt(birthday.split("-")[2]));
        LocalDate currentDate = LocalDate.now();
        BaseResponse baseResponse = new BaseResponse(name, Period.between(birthDate, currentDate).getYears());*/
        HelloWorldRequest helloWorldRequest = new HelloWorldRequest();
        model.addAttribute("helloWorldRequest", helloWorldRequest);
        return "index";
    }

    @RequestMapping(value = {"/index", "/"}, method = RequestMethod.POST)
    public String savePerson(Model model, @ModelAttribute("helloWorldRequest") HelloWorldRequest helloWorldRequest) {
        String name = helloWorldRequest.getName();
        int age = helloWorldRequest.getAge();
        baseResponseMain = new BaseResponse(name, age);

        return "redirect:/personList";
    }
}
