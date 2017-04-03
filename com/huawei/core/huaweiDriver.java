package com.huawei.core;
import java.io.IOException;
import com.filetool.util.myUtil;
import com.huawei.core.InitParams.serverRange;
import com.huawei.domain.graphInfo;
public class huaweiDriver {
public long beginTime=0;
	public String[] driver(String[]content) {
		//用户存放最终的结果
		String[] results=null;
		beginTime=System.currentTimeMillis();
		graphInfo gi=new graphInfo();
		gi.parse(content);
		//创建随机服务
		graphSearch gs=new graphSearch();
		//参数初始化
		InitParams ip=new InitParams();
		ip.initByNetworkScope(gi.consumeNum,gi.ls.size(),gi.vertexs);
		gs.init(gi);
		//将对象初始状态保存
		byte[] gsByte =null;
		try {
			gsByte=myUtil.objToByte(gs);
		} catch (IOException e1) {
			System.out.println("序列化出错...");
		}
		randomServer randomS=new randomServersByBandwith(gs);
		randomS.createRandomServer();
		int h=1000;
		minCostInfo mci=new minCostInfo();
		//是否超时
		serverRange serverParams=ip.sr;
		try {
			for(int i=0;i<ip.iteratorCount;i++){
			for(int j=serverParams.start;j<=serverParams.end;j=j+serverParams.step){
				if(isEnd()){
					throw new Exception("定时结束...");
				}
				try {
					gs=myUtil.byteToObj(gsByte,graphSearch.class);
				} catch (Exception e) {
					System.out.println("不能使用序列化...");
					gs=new graphSearch();
				}
				//判断是否结束
				if(isEnd()){
					throw new Exception("定时结束...");
				}
				//核心程序
				gs.run(randomS,mci,j);
				}
			}
		} catch (Exception e) {
			System.out.println("超时了,准备最后的清理工作..");
		}
		finally{
		results=mci.outputStringForMaxFlowPath();
		return results;
	}
		}
	/**
	 * 定时器结束测试
	 * @param beginTime
	 * @return
	 */
	public  boolean isEnd(){
		long endTime=System.currentTimeMillis();
		long times=endTime-beginTime;
		if(times>=1000*80){
			return true;
		}
	    return false;
}
//public static void main(String[]args){
//	huaweiDriver huawei=new huaweiDriver();
//	huawei.driver("");
//}
}
