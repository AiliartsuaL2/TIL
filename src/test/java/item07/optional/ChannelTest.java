package item07.optional;

import org.junit.jupiter.api.Test;
import section2.item07.optional.Channel;
import section2.item07.optional.MembersShip;

import java.util.Optional;

class ChannelTest {

    @Test
    void npe() {
        //given
        Channel channel = new Channel();
        //when
        Optional<MembersShip> membersShip = channel.defaultMemberShip();
         //then
        membersShip.ifPresent(MembersShip::hello);
        
    }
}