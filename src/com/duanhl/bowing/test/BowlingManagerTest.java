package com.duanhl.bowing.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.duanhl.bowing.realize.BowlingManager;

public class BowlingManagerTest {
	
	BowlingManager bowlingManager = new BowlingManager();

	
	/**
	 * 大满的时候最高分为300
	 * */
	@Test
	public void  strike_all_shout_retrun_300() {
		int mark = bowlingManager.calculationBowlingMark("XXXXXXXXXXXX");
		assertEquals(mark, 300);
	}
	
	/**
	 * 全部没有击中的时候 返回为0
	 * */
	@Test
	public void  no_strike_all_shout_retrun_0() {
		int mark = bowlingManager.calculationBowlingMark("00000000000000000000");
		assertEquals(mark, 0);
	}
	
	/**
	 * 每次都击中一次，返回20分
	 * */
	@Test
	public void  everytime_strike_1_shout_retrun_20() {
		int mark = bowlingManager.calculationBowlingMark("11111111111111111111");
		assertEquals(mark, 20);
	}
	
	/**
	 * 每次都击中一次，返回30分
	 * */
	@Test
	public void  everytime_strike_1or2_shout_retrun_30() {
		int mark = bowlingManager.calculationBowlingMark("12121212121212121212");
		assertEquals(mark, 30);
	}
	
	/**
	 * 每次都为5补，返回150分 
	 * */
	@Test
	public void  everytime_5Spare_shout_retrun_155() {
		int mark = bowlingManager.calculationBowlingMark("5/5/5/5/5/5/5/5/5/5/5");
		assertEquals(mark, 150);
	}
	
	/**
	 * 第一次为大满，其他为补 返回155
	 * */
	@Test
	public void  once_X_other_time_5Spare_shout_retrun_160() {
		int mark = bowlingManager.calculationBowlingMark("X5/5/5/5/5/5/5/5/5/5");
		assertEquals(mark, 155);
	}
	
	/**
	 * 第一次为大满，第二次也为大满，其他为补 返回165
	 * */
	@Test
	public void  spare_shout_retrun_165() {
		int mark = bowlingManager.calculationBowlingMark("XX5/5/5/5/5/5/5/5/5");
		assertEquals(mark, 165);
	}
	
	/**
	 * 第一次为大满，第二次也为大满，其他为补 返回180
	 * */
	@Test
	public void  spare_shout_retrun_180() {
		int mark = bowlingManager.calculationBowlingMark("XXX5/5/5/5/5/5/5/5");
		assertEquals(mark, 180);
	}

	
	/**
	 * 第一次为大满，第二次也为大满，其他为补，最后一回合为大满， 返回190
	 * */
	@Test
	public void  spare_shout_retrun_190() {
		int mark = bowlingManager.calculationBowlingMark("XXX5/5/5/5/5/5/X5/");
		assertEquals(mark, 190);
	}
	
	/**
	 * 第一次为大满，第二次也为大满，其他为补，最后一回合为大满， 返回180
	 * */
	@Test
	public void  spare_shout_retrun_200() {
		int mark = bowlingManager.calculationBowlingMark("XXX5/5/5/5/5/5/XXX");
		assertEquals(mark, 200);
	}
	
	
	/**
	 * 混合完成1， 返回180
	 * */
	@Test
	public void  spare_shout_retrun_191() {
		int mark = bowlingManager.calculationBowlingMark("XXX5/5/X125/5/XXX");
		assertEquals(mark, 191);
	}
	
	
	/**
	 * 混合完成2， 返回175
	 * */
	@Test
	public void  spare_shout_retrun_175() {
		int mark = bowlingManager.calculationBowlingMark("XXX5/5/X125/5/4/X");
		assertEquals(mark, 175);
	}
	
}
