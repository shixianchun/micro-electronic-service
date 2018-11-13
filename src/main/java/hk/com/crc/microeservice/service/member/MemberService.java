package hk.com.crc.microeservice.service.member;

import hk.com.crc.microeservice.mapper.member.MemberMapper;
import hk.com.crc.microeservice.model.member.Member;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
public class MemberService {

    @Autowired
    private MemberMapper memberMapper;

    public List<Member> getPageList(Member member) {
        PageHelper.offsetPage(member.getOffset(), member.getLimit());
        //PageHelper.orderBy(CamelCaseUtil.toUnderlineName(member.getSort())+" "+member.getOrder());
        return memberMapper.select(member);
    }

    public Integer getCount(Example example){
        return memberMapper.selectCountByExample(example);
    }

    public Member getMember(Member member){
        return memberMapper.selectOne(member);
    }

    public Member findByUsername(String username) {
        return memberMapper.selectByUsername(username);
    }

    public void insert(Member member){
        memberMapper.insert(member);
    }
}
