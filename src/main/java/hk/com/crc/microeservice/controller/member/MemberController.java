package hk.com.crc.microeservice.controller.member;

import hk.com.crc.microeservice.model.member.Member;
import hk.com.crc.microeservice.service.member.MemberService;
import hk.com.crc.microeservice.util.DateUtil;
import hk.com.crc.microeservice.util.ReturnUtil;
import hk.com.crc.microeservice.util.UuidUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import javax.validation.Valid;

/**
 *
 */
@RestController
@RequestMapping("/member")
public class MemberController {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MemberService memberService;

    /**
     * 处理登录操作
     *
     * @param member
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public ModelMap doReg(@Valid Member member, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ReturnUtil.Error("用户名或密码为空", null, null);
        }
        try {
            Example example = new Example(Member.class);
            example.createCriteria().andCondition("account = ", member.getAccount());
            Integer userCount = memberService.getCount(example);
            if (userCount > 0) {
                return ReturnUtil.Error("用户名已存在", null, null);
            }
            if (StringUtils.isEmpty(member.getPassword())) {
                return ReturnUtil.Error("密码不能为空", null, null);
            }
            String Id = UuidUtil.getUUID();
            member.setUid(Id);
            member.setPassword(member.getPassword());
            member.setState(1);
            member.setCreatedAt(DateUtil.getCurrentTime());
            member.setUpdatedAt(DateUtil.getCurrentTime());
            memberService.insert(member);
            return ReturnUtil.Success("操作成功", null, null);
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnUtil.Error("操作失败", null, null);
        }
    }

    /**
     * 退出
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {

        return "1111";

    }

}
