import java.util.*;

public class Moves
{
    public int source, through, dest;

    public Moves(int source, int through, int dest)
    {
        this.source = source;
        this.through = through;
        this.dest = dest;
    }

    @Override
    public String toString()
    {
        return "(" + source + ", " + through + ", " + dest + ")";
    }

    public Moves flip()
    {
        return new Moves(dest, through, source);
    }
}