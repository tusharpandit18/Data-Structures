import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;


class Interval {
	int startTime;
	int endTime;

	Interval(int start,int end)
	{
		this.endTime=end;
		this.startTime=start;
	}
}

class checkMerge
{

	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		
		if(intervals.size() == 0)
			return intervals;
		if(intervals.size() == 1)
			return intervals;

		// Sort the intervals based on their start times
		Collections.sort(intervals, new SortList());

		Interval first = intervals.get(0);
		int start = first.startTime;
		int end = first.endTime;
		int count=0;
		ArrayList<Interval> result = new ArrayList<Interval>();

		for(int i = 1; i < intervals.size(); i++){
			Interval current = intervals.get(i);
			if(current.startTime <= end){
				end = Math.max(current.endTime, end);
				count++;
			}else{
				result.add(new Interval(start, end));
				start = current.startTime;
				end = current.endTime;
			}

		}

		result.add(new Interval(start, end));
		System.out.println("We will need "+count+ " rooms");
		return result;
	}
	
	public void moveZeroes(int[] a) {
      
        for(int i=0;i<a.length;i++)
        {
            for(int j=i+1;j<a.length;j++)
            {
                if(a[i]==0 && a[j]!=0)
                {
                    int temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                    break;
                }
                else if(a[i]==0 && a[j]==0)
                {
                    continue;
                }
            }
        }
        
        for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
    }

	


}

class SortList implements Comparator
{

	@Override
	public int compare(Object o1, Object o2) {
		Interval i1=(Interval)o1;
		Interval i2=(Interval)o2;
		return i1.startTime - i2.startTime ;
	}

}

public class MergingIntervals {

	public static void main(String[] args)
	{
		ArrayList<Interval> list=new ArrayList<>();
		list.add(new Interval(1,4));
		list.add(new Interval(5,6));
		list.add(new Interval(8,9));
		list.add(new Interval(2,6));
		checkMerge obj=new checkMerge();
		ArrayList<Interval> result= obj.merge(list);
		System.out.println("Merged Intervals :");
		for(Interval i: result)
		{
			System.out.println(i.startTime +" "+ i.endTime);
		}
		
	}
}