package member.controller;

import member.dto.MemberDto;
import member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/")
    public String main(){return "main";}

    @GetMapping("/save")
    public String save(){return "save";}

    @GetMapping("/view")
    public String update(){return "view";}

    @GetMapping("/update")
    public String delete(){return "update";}

    @GetMapping("/getlist")
    public void getlist(HttpServletResponse response){}

    @GetMapping("/get")
    public void get(HttpServletResponse response , @RequestParam("mno") int mno){}

    @PostMapping("/save")
    @ResponseBody // 비동기 처리 할 때 사용됌
    public Integer save(MemberDto memberDto){return memberService.save(memberDto);}

    @PutMapping("/update")
    @ResponseBody // 비동기 처리 할 때 사용됌
    public boolean update(MemberDto memberDto){return memberService.update(memberDto);}

    @DeleteMapping("/delete")
    @ResponseBody
    public boolean delete(@RequestParam("mno") int mno){return memberService.delete(mno);}


}
