import java.util.ArrayList;

public class ConcreteStrategy<T> implements Strategy<T>{



    public String calculateHeader(ArrayList<String> header) {
        String head=" ";
        for (String s:header)
            {head+=" "+s;}
            return head;
    }


    public String calculateRow(T t, int headerlength) {

        Food f=(Food) t;
        String output="  ";
        String name=f.getName();
        String cals=((f.getCarbs()*4)+(f.getFat()*9)+(f.getProtein()*4))+" cal";
        int freespace=headerlength-name.length()-cals.length()-1;

        output+=name;
        for (int i=0; i<freespace;i++)
            {output+= " ";}

        output+=cals;



        return output;
    }
}
