package Lists.SinglyLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Length<T> {
    T data;
    Length<T> next;
    
    public Length(T data) {
        this.data = data;
    }
    
}

public class LengthOfLinkedList 
{

    public static int length(Length<Integer> head)
    {
        int count = 0;

        if(head == null)
        {
            return count;
        }
        
        
        while(head.data != -1)
        {
            if(head.next == null){
                count++;
                return count;
            }
            else
            {
                count++;
            }
            head = head.next;
        }
        return count;
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static Length<Integer> takeInput() throws IOException 
    {
        Length<Integer> head = null, tail = null;

        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        while(i < datas.length && !datas[i].equals("-1")) 
        {
            int data = Integer.parseInt(datas[i]);
            Length<Integer> newNode = new Length<Integer>(data);
            if(head == null) 
            {
                head = newNode;
                tail = newNode;
            }
            else 
            {
                tail.next = newNode;
                tail = newNode;
            }
            i += 1;
        }
        return head;
    }
    
    public static void print(Length<Integer> head)
    {
        while(head != null)
        {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException 
    {
        int t = 1;//Integer.parseInt(br.readLine().trim());

        while (t > 0) 
        {
            
            Length<Integer> head = takeInput();    
            System.out.println(LengthOfLinkedList.length(head));
            System.out.println();

            t -= 1;
        }
    }
    
}
