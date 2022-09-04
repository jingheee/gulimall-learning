package io.niceseason.gulimall.member.vo;

import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
public class MemberRegisterVo {
    private String userName;

    private String password;

    private String phone;
}
