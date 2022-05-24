package com.mile.collection.management.soap.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.mile.collection.management.soap.bottomUp.Question;
import com.mile.collection.management.soap.repository.AnswerRepository;
import com.mile.collection.management.soap.repository.CategoryRepository;

public class QuestionRowMapper implements RowMapper<Question> {

	@Autowired CategoryRepository categoryRepository;
	@Autowired AnswerRepository answerRepo;
	@Override
	public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		//BASIC LOADING
		Question question = new Question();
		question.setId(rs.getLong("id"));
		question.setValue(rs.getString("val"));
		question.setAnswers(new HashSet<>());
		question.setCategories(new HashSet<>());
		return question;
	}

}
