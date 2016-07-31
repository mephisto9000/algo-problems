package hackerMissile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
	
	public class MissileX
	{
		public int frequency;
		public int lastTime ;
		public int time;
		public boolean used = false;
	}
	
	//Comparator c = new Comparator
	
	List<MissileX> missiles; 
	
	public void calc() throws IOException
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input4.txt"));
		
		int n = Integer.parseInt(br.readLine());
		
		
		int lastTime = -1;
		
		missiles = new ArrayList<MissileX>();
		
		for (int i = 0; i < n; i++)
		{
			String[] vals = br.readLine().split(" ");
			
			int time = Integer.parseInt(vals[0]);
			int freq = Integer.parseInt(vals[1]);
			 
			MissileX mx = new MissileX();
			
			mx.frequency = freq;
			mx.time = time;
			
			missiles.add(mx);
						
		}
		
		int intercepts = 0;
		for (int i = 0; i < missiles.size(); i++)
		{
			//if (misss)
			MissileX mx = missiles.get(i);
			if (mx.used == false)
			{
				intercepts++;
				cascadeKill(missiles, i, i+1, missiles.size()-1);
				mx.used = true;
				//interp
			}
		}
		
		//return missileQueue.size();
		System.out.println(intercepts);
		
		
		
	}
	
	
	public boolean cascadeKill(List<MissileX> missiles, int idx, int startIdx, int endIdx)
	{
		MissileX ma = missiles.get(idx);
		
		//idx++;
		idx = startIdx;
		while (idx <= endIdx)
		{
			MissileX mb = missiles.get(idx);
			
			if (mb.used == false && isCompatible(ma, mb))
			{
				mb.used = true;
				
				ma = mb;
			}
					
					
			idx++;
		}
		
		return true;
		
		/*MissileX missileA = missiles.get(idx);
		
		//if ()
		
		if (startIdx == endIdx)
		{
			MissileX missileB = missiles.get(startIdx);
			if (isCompatible(missileA, missileB))
				return true;
			else
				return false;
			
		}
		
		int middleIdx = (endIdx - startIdx) / 2 + startIdx;
		
		//if ()
		
		MissileX missileB = missiles.get(middleIdx);
		
		
		boolean middleOk = false;
		if ( Math.abs(missileB.frequency - missileA.time) <= missileB.time - missileA.time )
			middleOk = true; */
			
	}
	
	boolean isCompatible(MissileX missileA, MissileX missileB)
	{
		if (missileA.time == missileB.time && missileA.frequency == missileB.frequency)
			return true;
		
		if ( Math.abs(missileB.frequency - missileA.frequency) <= Math.abs(missileB.time - missileA.time ))
			return true;
		else
			return false;
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Solution sol = new Solution();
		sol.calc();
	}

}
