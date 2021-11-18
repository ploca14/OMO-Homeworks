package cz.cvut.k36.omo.hw.hw04;

import java.util.Optional;

public class Homework4 extends MessageVisitor {
    public Homework4(Peer peer) {
        super(peer);
    }

    @Override
    public boolean visitHaveMessage(HaveMessage message) {
        if (this.peer.peers2BlocksMap.containsKey(message.getSender())) {
            this.peer.peers2BlocksMap.get(message.getSender())[message.getBlockIndex()] = true;
        } else {
            boolean[] data = new boolean[this.peer.totalBlocksCount];
            data[message.getBlockIndex()] = true;
            this.peer.peers2BlocksMap.put(message.getSender(), data);

        }
        return false;
    }

    @Override
    public boolean visitRequestMessage(RequestMessage message) {
        if (this.peer.data[message.getBlockIndex()] != null) {
            message.getSender().piece(this.peer, message.getBlockIndex(), this.peer.data[message.getBlockIndex()]);
        }
        return false;
    }

    @Override
    public boolean visitPieceMessage(PieceMessage message) {
        this.peer.data[message.getBlockIndex()] = message.getData();
        this.peer.downloadedBlocksCount++;
        this.peer.peers2BlocksMap.keySet().forEach(peer -> peer.have(this.peer, message.getBlockIndex()));
        return this.peer.downloadedBlocksCount == this.peer.totalBlocksCount;
    }

    @Override
    public boolean visitIdleMessage(IdleMessage message) {
        Optional<Integer> rarestBlockIndex = Optional.empty();
        Optional<Long> ratestBlockFrequency = Optional.empty();
        Optional<PeerInterface> owner = Optional.empty();

        for (int i = 0; i < peer.totalBlocksCount; i++) {
            if (this.peer.data[i] == null) {
                int finalI = i;
                long frequency = this.peer.peers2BlocksMap.values().stream().filter(blocks -> blocks[finalI]).count();
                if (frequency > 0) {
                    if (!rarestBlockIndex.isPresent()) {
                        rarestBlockIndex = Optional.of(i);
                        ratestBlockFrequency = Optional.of(frequency);
                    } else if (frequency < ratestBlockFrequency.get()) {
                        rarestBlockIndex = Optional.of(i);
                        ratestBlockFrequency = Optional.of(frequency);
                        owner = Optional.ofNullable(this.peer.peers2BlocksMap.entrySet().stream()
                            .filter(entry -> entry.getValue()[finalI]).findFirst().get().getKey());
                    }
                }
            }
        }

        if (rarestBlockIndex.isPresent() && owner.isPresent()) {
            owner.get().request(this.peer, rarestBlockIndex.get());
        }

        return false;
    }
}