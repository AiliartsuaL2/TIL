package item07.optional;


import java.util.Optional;

public class Channel {
    private int numOfSubscribers;

    public Optional<MembersShip> defaultMemberShip(){
        if(this.numOfSubscribers < 2000){
            return Optional.empty();
        }else{
            return Optional.of(new MembersShip());
        }
    }
}
