package dragon.me.chameleonAPI.math;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAccessor;
import java.util.Objects;

@Getter @Setter
public class Timestamp {

    private long time;

    public Timestamp(long time){
        this.time = time;
    }

    public boolean isBefore(Timestamp timestamp){
        return  timestamp.getTime() < System.currentTimeMillis();
    }

    public boolean isAfter(Timestamp timestamp){
        return  timestamp.getTime() < System.currentTimeMillis();

    }

    public  String toReadableFormat(){
        // Format the timestamp to be readable by humans
        LocalDateTime time = LocalDateTime.from(Instant.ofEpochMilli(this.time));

        return  time.getMonth().name() + " " + time.getDayOfMonth() + " at " + time.getHour()+":"+time.getMinute()+":"+time.getSecond();
    }
    public static Timestamp from(){
        return  new Timestamp(System.currentTimeMillis());
    }



}
