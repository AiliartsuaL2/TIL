package com.example.studyspringmvc.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되어있지 않아 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 *
 * 동시성 문제란?
 * - 동일한 자원에 대해 여러 스레드가 동시에 접근하면서 발생하는 문제,,
 * - 공유하는 동일한 자원이 있는 경우, 타이밍적인 부분에서 할당을 같은 변수에 하면 원하는 결과를 얻지 못할 수 있음
 * - 데이터를 변경 할 때만 발생하고, 읽기만 한다면 발생하지 않는다.
 *
 * Thread Local을 사용해서 동시성 문제 해결 가능,,
 * - 해당 쓰레드에만 접근 할 수 있도록 해주는 개인 저장소,, 같은 느김
 * - 동시에 접근하는 자원의 타입을 ThreadLocal로 변경 후 기존 타입을 제네릭 안에 넣어줌,
 * - 반드시 new ThreadLocal로 생성하여 할당해줌
 * - 쓰레드가 사용이 끝난 후에는 반드시 remove로 값을 제거해야 함
 *      - 사용자가 요청 후 응답을 받으면서 쓰레드를 쓰레드 풀에서 꺼내와 쓰레드풀에 다시 반납하기 때문에 쓰레드가 죽지 않음 >> 따라서 쓰레드 로컬도 살아있음
 *      - 쓰레드 로컬을 종료해주지 않으면 다음번에 해당 쓰레드를 참조하는 다른 사용자가 해당 쓰레드 로컬을 조회시 이전 사용자 값이 나옴
 */
public class MemberRepository {
    private Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository(); // 싱글톤

    public static MemberRepository getInstance(){
        return instance;
    }
    private MemberRepository(){
    }
    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }
    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }
    public void clearStore(){
        store.clear();
    }

}
