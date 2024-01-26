package com.ohgiraffers.mapper;

import com.ohgiraffers.hamburgerManage.Dto.memberDTO;

public interface HamburgerMapper {

   memberDTO selectOrderMember(String name);
    
    int insertOrderMember(memberDTO member);

    int insertOrderList(memberDTO member);

    int selectOrderCode();

    int insertOrderBurger(memberDTO member);

    int insertOrderSet(memberDTO member);

}
