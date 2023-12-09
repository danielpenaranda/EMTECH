package PROYECTO.EMTECH.Controller;

/**
 *
 * @author HUAWEI PC
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {
    
    @RequestMapping("/")
    public String page(Model model) {
        return "index";
    }
    
}
