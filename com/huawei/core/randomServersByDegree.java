package com.huawei.core;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.huawei.domain.Vdegree;
import com.huawei.domain.graph;
/**
 * 服务器
 * @author cristo
 *
 */
public class randomServersByDegree extends randomServer{
public randomServersByDegree(graphSearch gs){
super(gs);
}
/**
 * 度超过3才加入到待选部分
 */
public void createRandomServerbyDegree() {
	for(int i=0;i<gs.g.vertexNum;i++){
		int i_degree=gs.g.getDegree(i);
		if(i_degree>=2)
			servers.add(i);
}
	serverNumber=servers.size();
	//System.out.println("serverNumber"+serverNumber);
}
@Override
public void createRandomServer(int... number) {
	if(number.length>=1)
	serverNumber=number[0];
	createRandomServerbyDegree();
}
}
