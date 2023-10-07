package item15.product;

import item15.member.MemberService;

public class ProductService {

    // 권장하지 않는 코드
    // 배열을 상수로 선언하면 외부에서 수정 할 수 있기 때문에 권장하지 않음
    public static final String[] NAMES = new String[10];

    // 빈 등록을 할 때에는 외부에서는 인터페이스를 통해서만 주입시킴.
    // DefaultMemberService라는 Product 입장에서는 알 필요가 없기 때문에
    MemberService memberService;
    boolean onSale;

    // protected 부터는 공개 API라고 봐야함, 상속시키는경우 해당 멤버에 접근 가능하기 때문
    protected int saleRate;
    public void order(){
        memberService.joinMember("abc");
    }
    public ProductService(MemberService memberService){
        // null을 방어하는 조금 더 안전한 코드
        if(memberService == null)
            throw new IllegalArgumentException("MemberService should not be null");
        this.memberService = memberService;
    }


}
