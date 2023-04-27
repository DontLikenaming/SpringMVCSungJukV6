package dontlikenaming.spring4.sungjukv6.controller;


import dontlikenaming.spring4.sungjukv6.model.SungJukVO;
import dontlikenaming.spring4.sungjukv6.service.SungJukV6Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    // 성적 리스트 처리
    @GetMapping(value = "/list")
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("sjs", sjsrv.readSungJuk());
        mav.setViewName("sungjuklist");

        return mav;
    }


    // 성적 입력폼 표시
    @GetMapping(value = "/add")
    public String add(){
        return "sungjuk";
    }

    // 성적 입력 처리
    @PostMapping(value = "/add")
    public ModelAndView addok(SungJukVO sj){
        ModelAndView mv = new ModelAndView();
        String view = "sungjukfail";
        if(sjsrv.newSungJuk(sj)) {
            view = "sungjukok";
            mv.addObject("sj", sj);
        }

        mv.setViewName(view);

        return mv;
    }


    // 성적 상세 조회 처리
    @GetMapping(value = "/view")
    public ModelAndView listOne(@RequestParam int sjno){
        ModelAndView mav = new ModelAndView();
        String view = "sungjukfail";
        SungJukVO sj = sjsrv.readOneSungJuk(sjno);

        if(sj!=null) {
            view = "sungjukview";
            mav.addObject("sj", sj);
        }

        mav.setViewName(view);

        return mav;
    }


    // 성적 수정


    // 성적 삭제폼 표시
    @GetMapping(value = "/remove")
    public String delete(int sjno){
        sjsrv.removeSungJuk(sjno);

        // forward  : 서버에서 내부로 /list를 호출함
        // redirect : 클라이언트에게 /list를 서버에 요청하도록 지시
        return "redirect:/list";
    }


    // 성적 수정
    @GetMapping(value = "/modify")
    public ModelAndView modify(@RequestParam int sjno){
        ModelAndView mv = new ModelAndView();

        mv.addObject("sj", sjsrv.readOneSungJuk(sjno));
        mv.setViewName("sungjukmod");

        return mv;
    }

    // 성적 수정
    @PostMapping(value = "/modify")
    public String modifyok(SungJukVO sj){
        String view = "sungjukfail";
        if(sjsrv.modifySungJuk(sj)) view = "redirect:/view?sjno="+sj.getSjno();

        return view;
    }


}
