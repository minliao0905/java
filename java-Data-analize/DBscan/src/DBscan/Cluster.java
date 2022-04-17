package DBscan;

import java.util.ArrayList;

public class Cluster {
	private ArrayList<double[]> cluster = null;

	public ArrayList<double[]> getCluster() {
		return cluster;
	}

	public void setCluster(ArrayList<double[]> cluster) {
		this.cluster = cluster;
	}
	public void addItem(double[] newdata) {
		cluster.add(newdata);
	}
	
	public String toString() {
		String rs = null;
	 for(int i=0;i<cluster.size();i++) {
		 rs += cluster.toString() + "  ";
	 }
	 return rs;
	}
}
