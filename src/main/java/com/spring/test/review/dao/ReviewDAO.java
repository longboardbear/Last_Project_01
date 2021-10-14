package com.spring.test.review.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.spring.test.review.vo.Criteria1;

public interface ReviewDAO {
	public List List(Criteria1 cri, int member_NO) throws DataAccessException;
	public int listCount(int member_NO) throws DataAccessException;
	public int insertNewReview(Map<String, Object> reviewMap);
	public void deleteReview(int review_NO);
	public List myPageReview(int member_NO);
}
