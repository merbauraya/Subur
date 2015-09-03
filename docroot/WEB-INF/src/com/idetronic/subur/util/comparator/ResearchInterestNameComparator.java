package com.idetronic.subur.util.comparator;

import com.idetronic.subur.model.ResearchInterest;

public class ResearchInterestNameComparator {
	public ResearchInterestNameComparator() {
		this(true, true);
	}

	public ResearchInterestNameComparator(boolean ascending, boolean caseSensitive) {
		_ascending = ascending;
		_caseSensitive = caseSensitive;
	}

	
	public int compare(ResearchInterest ri1, ResearchInterest ri2) {
		String name1 = ri1.getResearchInterestName();//  assetTag1.getName();
		String name2 = ri1.getResearchInterestName();

		int value = 0;

		if (_caseSensitive) {
			value = name1.compareTo(name2);
		}
		else {
			value = name1.compareToIgnoreCase(name2);
		}

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	private boolean _ascending;
	private boolean _caseSensitive;

}
