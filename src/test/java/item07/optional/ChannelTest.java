package item07.optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

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