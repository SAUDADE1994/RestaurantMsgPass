package commInfra;

public class MemFIFO<R> extends MemObject<R> {

    /**
     * Number of Objects.
     */

    private int n;

    /**
     * Pointer to the first empty location.
     */

    private int inPnt;

    /**
     * Pointer to the first occupied location.
     */

    private int outPnt;

    /**
     * Signaling FIFO empty state.
     */

    private boolean empty;

    /**
     * FIFO instantiation.
     * The instantiation only takes place if the memory exists.
     * Otherwise, an error is reported.
     *
     * @param storage memory to be used
     * @throws MemException when the memory does not exist
     */

    public MemFIFO(R[] storage) throws MemException {
        super(storage);
        inPnt = outPnt = 0;
        empty = true;
    }

    /**
     * FIFO insertion.
     * A parametric object is written into it.
     * If the FIFO is full, an error is reported.
     *
     * @param val parametric object to be written
     * @throws MemException when the FIFO is full
     */

    @Override
    public void write(R val) throws MemException {
        if (!full()) {
            mem[inPnt] = val;
            inPnt = (inPnt + 1) % mem.length;
            empty = false;
            n++;
        } else throw new MemException("Tried to write into a full fifo queue!");
    }

    /**
     * FIFO retrieval.
     * A parametric object is read from it.
     * If the FIFO is empty, an error is reported.
     *
     * @return first parametric object that was written
     * @throws MemException when the FIFO is empty
     */

    @Override
    public R read() throws MemException {
        R val;

        if (!empty) {
            val = mem[outPnt];
            outPnt = (outPnt + 1) % mem.length;
            empty = (inPnt == outPnt);
            n--;
        } else throw new MemException("Trying to read from empty fifo!");
        return val;
    }

    /**
     * Test FIFO current full status.
     *
     * @return true, if FIFO is full -
     * false, otherwise
     */

    public boolean full() {
        return !((inPnt != outPnt) || empty);
    }

    /**
     * Get the current number of objects.
     *
     * @return n integer
     */

    public int getN() {
        return n;
    }

    public boolean isEmpty() {
        return empty;
    }
}