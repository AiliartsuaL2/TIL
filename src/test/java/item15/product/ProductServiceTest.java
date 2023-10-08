package item15.product;

import section4.item15.member.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import section4.item15.product.ProductService;

import static org.junit.jupiter.api.Assertions.*;

// 모킹을 사용해서 모킹을 함
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock // memberService 가짜 객체를 만들어줌
    MemberService memberService;
    @Test
    void orderTest(){
        // 가짜 객체가 아니면 memberService에 null이 들어감
        ProductService productService = new ProductService(memberService);
        assertNotNull(productService);
        // memberService가 private이라 접근이 불가능
        // package-private으로 설정해서 test용으로 접근 권한을 변경.
        // test 패키지는 동일한 패키지이기 때문에
        // 혹은 private으로 설정 후 getter을 달아줘도 됨
        assertNotNull(productService.memberService);
    }
}