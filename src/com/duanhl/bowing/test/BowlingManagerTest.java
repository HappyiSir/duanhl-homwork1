package com.duanhl.bowing.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.duanhl.bowing.realize.BowlingManager;

public class BowlingManagerTest {
	
	BowlingManager bowlingManager = new BowlingManager();

	
	/**
	 * ������ʱ����߷�Ϊ300
	 * */
	@Test
	public void  strike_all_shout_retrun_300() {
		int mark = bowlingManager.calculationBowlingMark("XXXXXXXXXXXX");
		assertEquals(mark, 300);
	}
	
	/**
	 * ȫ��û�л��е�ʱ�� ����Ϊ0
	 * */
	@Test
	public void  no_strike_all_shout_retrun_0() {
		int mark = bowlingManager.calculationBowlingMark("00000000000000000000");
		assertEquals(mark, 0);
	}
	
	/**
	 * ÿ�ζ�����һ�Σ�����20��
	 * */
	@Test
	public void  everytime_strike_1_shout_retrun_20() {
		int mark = bowlingManager.calculationBowlingMark("11111111111111111111");
		assertEquals(mark, 20);
	}
	
	/**
	 * ÿ�ζ�����һ�Σ�����30��
	 * */
	@Test
	public void  everytime_strike_1or2_shout_retrun_30() {
		int mark = bowlingManager.calculationBowlingMark("12121212121212121212");
		assertEquals(mark, 30);
	}
	
	/**
	 * ÿ�ζ�Ϊ5��������150�� 
	 * */
	@Test
	public void  everytime_5Spare_shout_retrun_155() {
		int mark = bowlingManager.calculationBowlingMark("5/5/5/5/5/5/5/5/5/5/5");
		assertEquals(mark, 150);
	}
	
	/**
	 * ��һ��Ϊ����������Ϊ�� ����155
	 * */
	@Test
	public void  once_X_other_time_5Spare_shout_retrun_160() {
		int mark = bowlingManager.calculationBowlingMark("X5/5/5/5/5/5/5/5/5/5");
		assertEquals(mark, 155);
	}
	
	/**
	 * ��һ��Ϊ�������ڶ���ҲΪ����������Ϊ�� ����165
	 * */
	@Test
	public void  spare_shout_retrun_165() {
		int mark = bowlingManager.calculationBowlingMark("XX5/5/5/5/5/5/5/5/5");
		assertEquals(mark, 165);
	}
	
	/**
	 * ��һ��Ϊ�������ڶ���ҲΪ����������Ϊ�� ����180
	 * */
	@Test
	public void  spare_shout_retrun_180() {
		int mark = bowlingManager.calculationBowlingMark("XXX5/5/5/5/5/5/5/5");
		assertEquals(mark, 180);
	}

	
	/**
	 * ��һ��Ϊ�������ڶ���ҲΪ����������Ϊ�������һ�غ�Ϊ������ ����190
	 * */
	@Test
	public void  spare_shout_retrun_190() {
		int mark = bowlingManager.calculationBowlingMark("XXX5/5/5/5/5/5/X5/");
		assertEquals(mark, 190);
	}
	
	/**
	 * ��һ��Ϊ�������ڶ���ҲΪ����������Ϊ�������һ�غ�Ϊ������ ����180
	 * */
	@Test
	public void  spare_shout_retrun_200() {
		int mark = bowlingManager.calculationBowlingMark("XXX5/5/5/5/5/5/XXX");
		assertEquals(mark, 200);
	}
	
	
	/**
	 * ������1�� ����180
	 * */
	@Test
	public void  spare_shout_retrun_191() {
		int mark = bowlingManager.calculationBowlingMark("XXX5/5/X125/5/XXX");
		assertEquals(mark, 191);
	}
	
	
	/**
	 * ������2�� ����175
	 * */
	@Test
	public void  spare_shout_retrun_175() {
		int mark = bowlingManager.calculationBowlingMark("XXX5/5/X125/5/4/X");
		assertEquals(mark, 175);
	}
	
}
