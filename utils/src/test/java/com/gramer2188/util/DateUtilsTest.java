package com.gramer2188.util;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.joda.time.DateTime;
import org.junit.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
public class DateUtilsTest {

	@Test
	public void monthString() {
		DateTime date = new DateTime(2013, 1, 1, 0, 0);
		assertThat(date.getMonthOfYear() + "¿ù", is("1¿ù")); 
	}
	
	@Test
	public void betweenTimeStampAndDate() {
		Date d = new Date();
		Timestamp t = new Timestamp(d.getTime());
		
		Set<Date> dates = Sets.newHashSet();
		dates.add(t);
		
		assertTrue(dates.contains(d));
		assertTrue(d.equals(t));
		assertFalse(t.equals(d));		
	}
	
	@Test
	public void testFilteredDateMapByGuava() {
		Map<Date, Boolean> dateMap = Maps.newHashMap();
		dateMap.put(create(2013, 1), true);
		dateMap.put(create(2013, 2), false);
		
		Map<Date, Boolean> filteredMap = Maps.filterValues(dateMap, new Predicate<Boolean>() {

			public boolean apply(Boolean input) {
				return input;
			}
		});
		
		Set<Date> keySet = filteredMap.keySet();
		Timestamp t = new Timestamp(create(2013, 1).getTime());
		assertTrue(keySet.contains(new Date(t.getTime())));
	}
	
	private Date create(int year, int month) {
		return new DateTime(year, month, 1, 0, 0, 0).toDate();
	}
	
}
