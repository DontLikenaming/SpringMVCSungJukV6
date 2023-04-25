package dontlikenaming.spring4.sungjukv6.controller;


import dontlikenaming.spring4.sungjukv6.service.SungJukV6Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SungJukController {

    private SungJukV6Service sjsrv;

    @Autowired
    public SungJukController(SungJukV6Service sjsrv) {
        this.sjsrv = sjsrv;
    }

    /*@RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {

        // sungjuklist.jsp에 성적 조회 결과 데이터를 넘김
        model.addAttribute("sjs",sjsrv.readSungJuk());

        return "sungjuklist";
    }
*/

    @GetMapping(value = "/list")
    public ModelAndView list() {

        ModelAndView mav = new ModelAndView();
        mav.addObject("sjs", sjsrv.readSungJuk());
        mav.setViewName("sungjuklist");

        return mav;
    }
}
