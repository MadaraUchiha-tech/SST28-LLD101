abstract class Gate {
    int gateNumber;
    GateType type;

    public Gate(int gateNumber, GateType type) {
        this.gateNumber = gateNumber;
        this.type = type;
    }
}

class EntryGate extends Gate {
    public EntryGate(int num) {
        super(num, GateType.ENTRY);
    }
}

class ExitGate extends Gate {
    public ExitGate(int num) {
        super(num, GateType.EXIT);
    }
}