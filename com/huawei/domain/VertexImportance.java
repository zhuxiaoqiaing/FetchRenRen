package com.huawei.domain;
import java.util.Comparator;
/**
 * 用来评估节点的重要性
 * @author cristo
 *
 */
public class VertexImportance implements Comparable<Object>{
//节点号
public int vertexId=0;
//与节点相关的链路上的总带宽
public int allbandwith=0;
//该节点的度
public int degree=0;

public int getAllbandwith() {
	return allbandwith;
}

public void setAllbandwith(int allbandwith) {
	this.allbandwith = allbandwith;
}
public int getDegree() {
	return degree;
}
public void setDegree(int degree) {
	this.degree = degree;
}
@Override
public int compareTo(Object o) {
	if(o == null) {  
	    return 1;  
	}  
	VertexImportance vio=(VertexImportance)o;
	if(this.degree!=vio.degree){
		return this.allbandwith-vio.allbandwith;
	}
	return 0;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + allbandwith;
	result = prime * result + degree;
	return result;
}

public int getVertexId() {
	return vertexId;
}

public void setVertexId(int vertexId) {
	this.vertexId = vertexId;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	VertexImportance other = (VertexImportance) obj;
	if (allbandwith != other.allbandwith)
		return false;
	if (degree != other.degree)
		return false;
	return true;
}

}
