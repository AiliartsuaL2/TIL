package item15.member;

// 구현체는 내부 패키지에서만 접근하도록 설정
class DefaultMemberService implements MemberService{

    // 해당 클래스에서만 사용되는 interface의 경우, private static으로 중첩시켜 사용하자.
    MemberRepository memberRepository;
    @Override
    public void joinMember(String id) {
        Member joinMember = memberRepository.findById(id);
        System.out.println("회원가입이 완료되었습니다.");
    }

    private static interface MemberRepository {
        Member findById(String id);
    }
}
