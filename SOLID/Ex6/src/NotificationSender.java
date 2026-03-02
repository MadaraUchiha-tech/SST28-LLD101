public abstract class NotificationSender {
    protected final AuditLog audit;
    protected NotificationSender(AuditLog audit) { this.audit = audit; }
//      Base contract:
//      Accept a non-null Notification.
//      Do not throw for channel errors; log them instead.
    public abstract void send(Notification n);
}
