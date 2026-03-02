public abstract class Exporter {
//    	The ExportRequest (req) must not be null.
//      On success, the exporter returns a non-null ExportResult.
//	    If export cannot be completed, a RuntimeException may be thrown.
//      Callers must handle all thrown exceptions uniformly as export failures.

    public abstract ExportResult export(ExportRequest req);
    protected void validateRequest(ExportRequest req) {
        if (req == null) {
            throw new IllegalArgumentException("ExportRequest cannot be null");
        }
    }
}