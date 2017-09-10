import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;

public class QuickFindUF
{
    private int[] id;
    private int count;

    public QuickFindUF(int N)
    {
        count = N;
        id = new int[N];
        for(int i = 0; i < N; i++)
        {
            id[i] = i;
        }
    }

    public int count()
    {
        return count;
    }

    public boolean connected(int p, int q)
    {
        return find(p) == find(q);
    }

    public int find(int p)
    {
        return id[p];
    }

    public void union(int p, int q)
    {
        int pID = find(p);
        int qID = find(q);

        if(pID == qID)
        {
            return;
        }

        for(int i = 0; i < id.length; i++)
        {
            if(id[i] == pID)
            {
                id[i] = qID;
            }
        }
        count--;
    }

    public static void main(String[] args)
    {
        In fileInput = new In("tinyUF.txt");
        int N = fileInput.readInt();
        QuickFindUF uf = new QuickFindUF(N);
        while(!fileInput.isEmpty())
        {
            int p = fileInput.readInt();
            int q = fileInput.readInt();
            StdOut.println(p + " " + q);
            if(uf.connected(p, q))
            {
                continue;
            }
            uf.union(p, q);
        }
        StdOut.println(uf.count() + " components");
    }


}
