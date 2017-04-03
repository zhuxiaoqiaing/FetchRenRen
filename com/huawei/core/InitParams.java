package com.huawei.core;

public class InitParams {
//消费者数目
public int consumeNumber;
//链路数
public int linkedNumber;
//节点数
public int nodesNumber;
//对服务器方案，进行迭代次数
public int iteratorCount;
//服务器选择配置
public class serverRange{
	public serverRange(int start, int end, int step) {
		super();
		this.start = start;
		this.end = end;
		this.step = step;
	}
	public int start;
	public int end;
	public int step;
}
public serverRange sr;

/**
 * 用户设置初始参数
 * @param consumeNumber,消费者数量
 * @param linkedNumber,链路数
 * @param nodesNumber,节点数
 */
public void initByNetworkScope(int consumeNumber,int linkedNumber,int nodesNumber){
	this.consumeNumber=consumeNumber;
	this.linkedNumber=linkedNumber;
	this.nodesNumber=nodesNumber;
	if(nodesNumber<100){
		this.sr=new serverRange(4,consumeNumber,1);
		iteratorCount=100000;
	}
	else if(nodesNumber<=200){
		this.sr=new serverRange(6,consumeNumber,1);
		iteratorCount=100000;
	}
	else if(nodesNumber>=200&&nodesNumber<=500){
		this.sr=new serverRange(8,consumeNumber,1);
		iteratorCount=100000;
	}
	else{
		this.sr=new serverRange(10,Math.max(Math.min(consumeNumber/3,40),30),2);
		iteratorCount=100000;
	}
}
}
