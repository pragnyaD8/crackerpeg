import java.util.Iterator;

public class StepIterators implements Iterator<Moves>
{
    private Moves[] moves;
    private Moves   reversed;
    private int    i;

    public StepIterators(Moves[] moves)
    {
        this.moves = moves;
        this.i     = 0;
    }

    @Override
    public boolean hasNext()
    {
        boolean out =  i < moves.length || (i == moves.length && reversed != null);
        return out;
    }

    @Override
    public Moves next()
    {
        if (reversed != null)
        {
            Moves result = reversed;
            reversed = null;
            return result;
        }
        Moves m = moves[i++];
        reversed = m.flip();
        return m;
    }
}