package com.tim.spring.data;

public class Pagination
{
	private int pageSize;
	private int currentPage;
	private int totalResults;
	private int totalPages;

	public int getPageSize()
	{
		return pageSize;
	}

	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}

	public int getCurrentPage()
	{
		return currentPage;
	}

	public void setCurrentPage(int currentPage)
	{
		this.currentPage = currentPage;
	}

	public int getTotalResults()
	{
		return totalResults;
	}

	public void setTotalResults(int totalResults)
	{
		this.totalResults = totalResults;
	}

	public int getTotalPages()
	{
		if (pageSize == 0)
		{
			return 0;
		}
		int totalTemp = totalResults % pageSize;
		int totalTemp2 = totalResults / pageSize;
		totalPages = totalTemp == 0 ? totalTemp2 : (totalTemp2 + 1);
		return totalPages;
	}
}
