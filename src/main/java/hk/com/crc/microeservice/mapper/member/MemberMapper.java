package hk.com.crc.microeservice.mapper.member;

import hk.com.crc.microeservice.model.member.Member;
import hk.com.crc.microeservice.core.CustomerMapper;
import org.springframework.stereotype.Service;


@Service
public interface MemberMapper extends CustomerMapper<Member> {
    Member selectByUsername(String username);
}
