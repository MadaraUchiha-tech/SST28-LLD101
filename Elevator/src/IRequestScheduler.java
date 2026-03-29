interface IRequestScheduler {
    void addRequest(Request request);
    Request getNextRequest(int currentFloor, LiftState state);
}