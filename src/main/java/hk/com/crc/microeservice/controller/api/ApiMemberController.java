package hk.com.crc.microeservice.controller.api;

import hk.com.crc.microeservice.model.member.Member;
import hk.com.crc.microeservice.service.member.MemberService;
import hk.com.crc.microeservice.util.ReturnUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/member")
public class ApiMemberController {

    protected  Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelMap index(Member member){

       List<Member> members=memberService.getPageList(member);

       return ReturnUtil.Success("获取用户信息成功",members,null);


    }

}
