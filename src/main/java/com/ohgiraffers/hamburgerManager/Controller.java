package com.ohgiraffers.hamburgerManager;

import com.ohgiraffers.hamburgerManage.View.setView;
import com.ohgiraffers.mapper.HamburgerMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.Scanner;

import static com.ohgiraffers.common.Template.getSqlSession;
import static com.ohgiraffers.hamburgerManager.Member.member1;
import static com.ohgiraffers.hamburgerManager.payView.burgername;

public class Controller {
    private HamburgerMapper hamburgerMapper;

    setView SETVIEW = new setView();

    Member member = new Member();
    Scanner sc = new Scanner(System.in);
    String choose;
    int setResult = 0;

    public void mainMenu() {
        payView payview = new payView();
        String query = "";

        do {
            System.out.println("============================================");
            System.out.println("🍔🍟🍔🍟 롯데리아에 오신것을 환영합니다 🍔🍟🍔🍟");
            System.out.println(" ========= 1. 🍔 단품 메뉴 선택 🍔 =========");
            System.out.println(" ========= 2. 🍟 세트 메뉴 선택 🍹 =========");
            System.out.println(" ========= 9. ⛔  프로그램 종료 ⛔ =========");
            System.out.println("============================================");
            System.out.print("원하시는 메뉴 번호를 입력하세요 : ");
            choose = sc.nextLine();

            switch (choose) {
                case "1":
                    SqlSession sqlSession = getSqlSession();
                    member.chooseListSingle();
                    hamburgerMapper = sqlSession.getMapper(HamburgerMapper.class);
                    member1.setCode(hamburgerMapper.selectOrderCode());
                    System.out.println(member1.toString());
                    hamburgerMapper.insertOrderBurger(member1);

                    if (burgername != null) {
                        System.out.println("주문 list에 선택하신 버거를 추가하였습니다.");

                    } else {
                        System.out.println("주문 list에 선택하신 버거의 추가를 실패하였습니다.");
                    }
                    break;

                case "2":
                    sqlSession = getSqlSession();
                    member.chooseListSet();
                    SETVIEW.burgurviewset();
                    SETVIEW.drinkview();
                    SETVIEW.sideview();
                    System.out.println(SETVIEW.setInformation());
                    payview.setMemberPay();


                    hamburgerMapper = sqlSession.getMapper(HamburgerMapper.class);
//
                    hamburgerMapper.insertOrderList(member1);

                    sqlSession.commit();

                    member1.setCode(hamburgerMapper.selectOrderCode());

                    System.out.println(member1.toString());

                    int result = hamburgerMapper.insertOrderSet(member1);

                    sqlSession.commit();


                    sqlSession.close();




//




                    if (result >0 ) {
                        System.out.println("주문 list에 선택하신 세트를 추가하였습니다.");

                    } else {
                        System.out.println("주문 list에 선택하신 세트의 추가를 실패하였습니다.");
                    }
                    break;

                case "9": System.out.println("⛔ 프로그램 종료 ⛔"); break;
                default: System.out.println("❗ 잘못된 번호를 입력하셨습니다, 처음으로 돌아갑니다 ❗"); return;
            }

        } while (!choose.equals("9"));
    }
}
