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
				//����ǲ��еĻ� ��Ҫ�������һ�����������ҵ���һ�غϵ�һ��Ͷ�����÷�������������ȥ��һ�λ���ķ���(�磺5/ ��Ϊ������жϣ���5/ֻ����10�֡���ô��Ҫ��ȥ�ϴεķ���....)
				String tempnextmark = formatCharToString(markCharArray[i+1]);
				mark = mark - formatMark(formatCharToString(markCharArray[i-1])) +  BOW_TEN_MARK + formatMark(tempnextmark);
				flowingCount ++ ;
			}else if(isStrike(tempMark)){//����Ǵ����Ļ���Ҫ����������������ķ���
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
		//�ж���һ�λ�������
		if( isSpare(tempNextTwoMark)  ){// �ж�������Ϊ�������
			extraMark  = BOW_TEN_MARK ;
		}else if ( isStrike(tempNextOneMark) && isNumber(tempNextTwoMark) ) {//�ж���һ��ΪX�����
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
	 * char����ת��
	 */
	private String formatCharToString(char mark){
		return String.valueOf(mark) ;
	}
	
	
	/**
	 * �ж��Ƿ���������
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
	 * �ж��Ƿ��ǲ���С����
	 */
	private boolean isSpare(String mark){
		if(mark.equals("/")){
			return true;
		}
		return false;
	}
	
	
	/**
	 * �ж�X���������Ƿ�÷�
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
