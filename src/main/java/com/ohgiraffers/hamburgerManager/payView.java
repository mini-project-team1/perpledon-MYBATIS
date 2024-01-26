package com.ohgiraffers.hamburgerManager;

import com.ohgiraffers.mapper.HamburgerMapper;
import org.apache.ibatis.session.SqlSession;

import static com.ohgiraffers.common.Template.getSqlSession;
import static com.ohgiraffers.hamburgerManager.Member.member1;
import static com.ohgiraffers.hamburgerManager.Pay.price;

public class payView {


    public static String burgername = "";
    private HamburgerMapper hamburgerMapper;

    public void singleMemberPay() {
        SqlSession sqlSession = getSqlSession();
        hamburgerMapper = sqlSession.getMapper(HamburgerMapper.class);


        int coupon = (int) (Math.random() * 6 + 5);
        int finalPrice = (Pay.price/100 * (100 - coupon));

        member1.setCoupon(coupon);
        member1.setPrice(price);
        member1.setFinalPrice(finalPrice);
        member1.setHamburgerName(burgername);


        int result = hamburgerMapper.insertOrderList(member1);

        System.out.println(result);
        System.out.println(member1.toString());
        sqlSession.commit();
        sqlSession.close();
        if (result > 0) {
            System.out.println("단품 주문 등록에 성공하셨습니다.");

            System.out.println("--------------------------------------------------------------------------");
            System.out.println("⭐ 1주년 오픈 이벤트로 5% ~ 10% 회원 전용 랜덤 쿠폰 적용되었습니다. ⭐");
            System.out.println("이벤트 쿠폰 " + coupon+ " % 쿠폰 할인 적용되어 총 금액은 " +finalPrice + "원 입니다.");
            price = 0;

            System.out.println("최종 결제 완료되었습니다. 👌😁");
            System.out.println("--------------------------------------------------------------------------");

        } else {
            System.out.println("단품 주문 등록에 실패하셨습니다.");
        }
    }

    public void setMemberPay() {

        SqlSession sqlSession = getSqlSession();

        hamburgerMapper = sqlSession.getMapper(HamburgerMapper.class);

        member1.setPrice(price);

        int coupon = (int) (Math.random() * 6 + 5);
        member1.setCoupon(coupon);


        int finalPrice = (Pay.price/100 * (100 - coupon));
        member1.setFinalPrice(finalPrice-1000);


        int result = hamburgerMapper.insertOrderList(member1);

        if (result > 0) {
            System.out.println("세트 주문 등록에 성공하셨습니다.");

            System.out.println("--------------------------------------------------------------------------");
            System.out.println("⭐ 1주년 오픈 이벤트로 5% ~ 10% 회원 전용 랜덤 쿠폰 적용되었습니다. ⭐");
            System.out.println("이벤트 쿠폰 " +coupon+ " % 쿠폰 할인 적용되어 " + finalPrice + " 원 입니다.");
            System.out.println("🙌 세트 할인 1000원이 적용되었습니다. 🙌");
            System.out.println("총 금액은 " +(finalPrice-1000)+ "원 입니다.");
            price=0;
            finalPrice=0;
            System.out.println("최종 결제 완료되었습니다. 👌😁");
            System.out.println("--------------------------------------------------------------------------");

        } else {
            System.out.println("세트 주문 등록에 실패하셨습니다.");
        }
    }
}

