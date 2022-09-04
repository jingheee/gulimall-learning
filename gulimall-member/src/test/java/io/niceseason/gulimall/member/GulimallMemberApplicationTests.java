package io.niceseason.gulimall.member;

import io.niceseason.gulimall.member.service.MemberService;
import io.niceseason.gulimall.member.vo.MemberRegisterVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GulimallMemberApplicationTests {

    @Autowired
    private MemberService memberService;

    @Test
    void contextLoads() {
        MemberRegisterVo memberRegisterVo = new MemberRegisterVo().setPassword("test").setPhone("114514123456").setUserName("test");
        memberService.register(memberRegisterVo);
    }

}
