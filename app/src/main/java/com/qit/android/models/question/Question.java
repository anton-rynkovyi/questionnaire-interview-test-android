package com.qit.android.models.question;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.qit.android.models.answer.Answer;
import com.qit.android.models.answer.Variant;
import com.qit.android.models.quiz.Quiz;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Question implements Serializable {

	private Long id;
	private Boolean isNecessary = false;
	private String text;
	private Long quizId;
	private String questionType;

	private List<Variant> variants;
	private List<Answer> answers;

	public Question() {
		variants = new ArrayList<>();
		answers = new ArrayList<>();
	}

	public void addAnswerVariant(Variant variant) {
		variants.add(variant);
	}

	public void removeAnswerVariant(Variant variant) {
		variants.remove(variant);
	}

	public void removeAnswerVariant(int position) {
		variants.remove(position);
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getNecessary() {
		return isNecessary;
	}

	public void setNecessary(Boolean necessary) {
		isNecessary = necessary;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getQuizId() {
		return quizId;
	}

	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public List<Variant> getVariants() {
		return variants;
	}

	public void setVariants(List<Variant> variants) {
		this.variants = variants;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}


}
