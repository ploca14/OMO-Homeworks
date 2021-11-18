package cz.cvut.k36.omo.hw.hw04;

import java.util.Map;
    import java.util.Queue;
    import java.util.concurrent.LinkedBlockingQueue;

public class IdleMessage extends Message {
    public IdleMessage(PeerInterface sender) {
        super(sender);
    }

    @Override
    public boolean accept(MessageVisitor visitor) {
        return visitor.visitIdleMessage(this);
    }
}