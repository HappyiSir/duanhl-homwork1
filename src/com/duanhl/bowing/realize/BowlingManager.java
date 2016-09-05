package com.duanhl.bowing.realize;

public class BowlingManager {
	
	private static final int FLOWING_COUNT = 20;
	private static final int BOW_TEN_MARK = 10;

	public int calculationBowlingMark(String markArry){
		
		char[] markCharArray = markArry.toCharArray();
		
		int flowingCount = 0;

		int mark = 0;
		for (int i = 0; i < markCharArray.length; i++) {
			
			if(flowingCount >=FLOWING_COUNT ){
				break;
			}
			
			String tempMark = formatCharToString(markCharArray[i]) ;
			System.out.print(tempMark);
			if(isNumber(tempMark)){
				mark = mark + formatMark(tempMark);
				flowingCount ++ ;
			}else if(isSpare(tempMark))  {
				//如果是补中的话 需要向后找下一个数，既是找到下一回合第一次投掷所得分数加起来并减去上一次击打的分数(如：5/ 因为是逐个判断，而5/只能算10分。那么需要减去上次的分数....)
				String tempnextmark = formatCharToString(markCharArray[i+1]);
				mark = mark - formatMark(formatCharToString(markCharArray[i-1])) +  BOW_TEN_MARK + formatMark(tempnextmark);
				flowingCount ++ ;
			}else if(isStrike(tempMark)){//如果是大满的话需要计算下两次所击打的分数
				flowingCount = flowingCount + 2 ;
				String tempNextOneMark  = formatCharToString(markCharArray[i+1]);
				String tempNextTwoMark  = formatCharToString(markCharArray[i+2]);
				int extraMark = calculationExtraMark(tempNextOneMark,tempNextTwoMark);
				mark = mark + BOW_TEN_MARK + extraMark;
			}
			
		}
		return mark;
	}

	/*
	 * 
	 */
	private int calculationExtraMark(String tempNextOneMark,
			String tempNextTwoMark) {
		int extraMark = 0;
		//判断下一次击打的情况
		if( isSpare(tempNextTwoMark)  ){// 判断下两次为补的情况
			extraMark  = BOW_TEN_MARK ;
		}else if ( isStrike(tempNextOneMark) && isNumber(tempNextTwoMark) ) {//判断下一次为X的情况
			extraMark  = BOW_TEN_MARK +  formatMark(tempNextTwoMark) ;
		}else{
			extraMark  = formatMark(tempNextOneMark) + formatMark(tempNextTwoMark);
		}
		return extraMark;
	}
	
	/*
	 * 
	 */
	private boolean isStrike(String tempMark) {
		if(tempMark.equals("X")){
			return true;
		}
		return false;
	}


	/**
	 * char类型转换
	 */
	private String formatCharToString(char mark){
		return String.valueOf(mark) ;
	}
	
	
	/**
	 * 判断是否是是数字
	 */
	private boolean isNumber(String mark){
		try {
			Integer.parseInt(mark);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 判断是否是补（小满）
	 */
	private boolean isSpare(String mark){
		if(mark.equals("/")){
			return true;
		}
		return false;
	}
	
	
	/**
	 * 判断X（大满）是否得分
	 */
	public int formatMark(String mark){
		
		if(isNumber(mark)){
			return Integer.parseInt(mark);
		}
		
		if("X".equals(mark)){
			return BOW_TEN_MARK;
		}
		
		return 0;
	}

	
}
