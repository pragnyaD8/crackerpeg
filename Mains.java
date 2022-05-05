import java.util.*;

public class Mains
{
    static void go()
    {
        for (int i = 0; i < 5; i++)
        {
            System.out.println("=== " + i + " ===");
            Boards b = new Boards(i);
            replay(initzlize(b), b);
            System.out.println();
        }
    }
    static LinkedList<Moves> initzlize(Boards b)
    {
        ArrayList<LinkedList<Moves>> out = new ArrayList<LinkedList<Moves>>();
        compute(b, out, 1);
        if (out.size() == 0)
            return null;
        return out.get(0);
    }

    static StepLists steps()
    {
        return new StepLists();
    }

    static ArrayList<LinkedList<Moves>> compute(Boards b)
    {
        ArrayList<LinkedList<Moves>> out = new ArrayList<LinkedList<Moves>>();
        compute(b, out, 0);
        return out;
    }



    static void compute(Boards b, ArrayList<LinkedList<Moves>> solutions, int count)
    {
        if (b.pegCount == 1)
        {
            solutions.add(new LinkedList<Moves>());
            return;
        }
        for (Moves m : steps())
        {
            Boards boardAfter = b.moves(m);
            if (boardAfter == null) continue;
            ArrayList<LinkedList<Moves>> tailSolutions = new ArrayList<LinkedList<Moves>>();
            compute(boardAfter, tailSolutions, count);
            for (LinkedList<Moves> solution : tailSolutions)
            {
                solution.add(0, m);
                solutions.add(solution);

                if (solutions.size() == count)
                    return;
            }
        }
    }

    static void printBoard(Boards b)
    {
        System.out.print("(" + b.pegCount + ", [");
        for (int i = 0; i < b.cells.length; i++)
            System.out.print(i < b.cells.length-1 ? b.cells[i] + ", " : b.cells[i] + "])");
        System.out.println();
    }

    static void show(Boards b)
    {
        int[][] lines = { {4,0,0}, {3,1,2}, {2,3,5}, {1,6,9}, {0,10,14} };
        for (int[] l : lines)
        {
            int spaces = l[0];
            int begin  = l[1];
            int end    = l[2];

            String space = new String();
            for (int i = 0; i < spaces; i++)
                space += " ";

            System.out.print(space);
            for (int i = begin; i <= end; i++)
                System.out.print(b.cells[i] == 0 ? ". " : "x ");

            System.out.println();
        }

        System.out.println();
    }

    static void replay(List<Moves> moves, Boards b)
    {
        show(b);
        for (Moves m : moves)
        {
            b = b.moves(m);
            show(b);
        }
    }


    public static void main(String[] args)
    {
        go();
    }
}