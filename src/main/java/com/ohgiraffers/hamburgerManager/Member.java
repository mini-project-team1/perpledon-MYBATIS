package com.ohgiraffers.hamburgerManager;

import com.ohgiraffers.hamburgerManage.Dto.memberDTO;
import com.ohgiraffers.hamburgerManage.View.burgerView;
import com.ohgiraffers.hamburgerManage.View.setView;
import com.ohgiraffers.mapper.HamburgerMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.ohgiraffers.common.Template.getSqlSession;

public class Member {
    public static String name;
    public static memberDTO member1 = new memberDTO();

    burgerView burgerView = new burgerView();
    setView setView = new setView();
    Scanner sc = new Scanner(System.in);
    List<memberDTO> memberList = new ArrayList<>();
    private HamburgerMapper hamburgerMapper;

    public void chooseListSingle() {

        SqlSession sqlSession = getSqlSession();

        hamburgerMapper = sqlSession.getMapper(HamburgerMapper.class);
        System.out.println("=================================");
        System.out.println("단품 메뉴를 선택하셨습니다. 먼저 회원 인증을 시작합니다.");
        System.out.print("이름을 입력해주세요 : ");
        String mName = sc.nextLine();
        this.name = mName;
        System.out.print("핸드폰 번호를 입력해주세요 : ");
        String mPhone = sc.nextLine();
        System.out.println("=================================");

        member1 = hamburgerMapper.selectOrderMember(mName);
        sqlSession.commit();


        if (member1 != null) {
            System.out.println("회원인증에 성공하였습니다.");
            burgerView.burgurview();
        } else if (member1 == null) {
            System.out.println("❗ 일치하는 멤버가 없습니다. ❗");
            System.out.println("=================================");
            System.out.println("회원 가입을 시작합니다. ");
            System.out.print("이름을 입력해주세요 : ");
            mName = sc.nextLine();
            System.out.print("핸드폰 번호를 입력해주세요 : ");
            mPhone = sc.nextLine();
            System.out.println("=================================");
            memberDTO temporaryMember = new memberDTO(mName, mPhone);
            int result = hamburgerMapper.insertOrderMember(temporaryMember);
            member1 = temporaryMember;
            sqlSession.commit();

            if (result > 0) {
                System.out.println("신규 회원 등록에 성공하셨습니다.");
                sqlSession.commit();
                burgerView.burgurview();

            } else {
                System.out.println("신규 회원 등록에 실패하셨습니다. 다시 가입 진행해주세요.");
                sqlSession.rollback();
                chooseListSingle();
            }
        }
        sqlSession.close();

    }


    public void chooseListSet() {
        SqlSession sqlSession = getSqlSession();

        hamburgerMapper = sqlSession.getMapper(HamburgerMapper.class);
        System.out.println("=================================");
        System.out.println("세트 메뉴를 선택하셨습니다. 먼저 회원 인증을 시작합니다.");
        System.out.print("이름을 입력해주세요 : ");
        String mName = sc.nextLine();
        this.name = mName;
        System.out.print("핸드폰 번호를 입력해주세요 : ");
        String mPhone = sc.nextLine();
        System.out.println("=================================");

        member1 = hamburgerMapper.selectOrderMember(mName);
        sqlSession.commit();


        if (member1 != null) {
            System.out.println("회원인증에 성공하였습니다.");
        } else if (member1 == null) {
            System.out.println("❗ 일치하는 멤버가 없습니다. ❗");
            System.out.println("=================================");
            System.out.println("회원 가입을 시작합니다. ");
            System.out.print("이름을 입력해주세요 : ");
            mName = sc.nextLine();
            System.out.print("핸드폰 번호를 입력해주세요 : ");
            mPhone = sc.nextLine();
            System.out.println("=================================");
            memberDTO temporaryMember = new memberDTO(mName, mPhone);
            int result = hamburgerMapper.insertOrderMember(temporaryMember);
            member1 = temporaryMember;
            sqlSession.commit();

            if (result > 0) {
                System.out.println("신규 회원 등록에 성공하셨습니다.");
                sqlSession.commit();

            } else {
                System.out.println("신규 회원 등록에 실패하셨습니다. 다시 가입 진행해주세요.");
                sqlSession.rollback();
                chooseListSingle();
            }
        }
        sqlSession.close();

    }

}