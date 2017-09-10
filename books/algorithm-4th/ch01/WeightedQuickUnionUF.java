import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class WeightedQuickUnionUF
{
    private int[] id;   // parent link (site indexed)
    private int[] sz;   // size of component for roots (site indexed)
    private int count;  // number of components

    public WeightedQuickUnionUF(int N)
    {
        count = N;
        id = new int[N];
        for(int i = 0; i < N; i++)
        {
            id[i] = i;
        }
        sz = new int[N];
        for(int i = 0; i < N; i++)
        {
            sz[i] = 1;
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
        while(p != id[p])
        {
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q)
    {
        int i = find(p);
        int j = find(q);
        if(i == j)
        {
            return;
        }

        // Maker smaller root point to larger one
        if(sz[i] < sz[j])
        {
            id[i] = j;
            sz[j] += sz[i];
        }
        else
        {
            id[j] = i;
            sz[i] += sz[j];
        }

        count--;
    }

    public static void main(String[] args)
    {
        In fileInput = new In("largeUF.txt");
        int N = fileInput.readInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
        while(!fileInput.isEmpty())
        {
            int p = fileInput.readInt();
            int q = fileInput.readInt();
            // StdOut.println(p + " " + q);
            if(uf.connected(p, q))
            {
                continue;
            }
            uf.union(p, q);
        }
        StdOut.println(uf.count() + " components");
    }
}
